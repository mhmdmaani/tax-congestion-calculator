package com.task.tax.service;

import com.task.tax.model.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CongestionTaxCalculator {

    private static final BigDecimal DAILY_LIMIT = new BigDecimal(60);

    public BigDecimal calculateTax(VehicleType vehicleType, Set<Entrance> entrances, List<Holiday> holidays, List<TollPrice> tollPrices) {

        if (vehicleType.isFree()) return BigDecimal.ZERO;
        Map<LocalDate, List<LocalTime>> groupedSortedEntrancesDates = groupAndSortEntrancesByDate(new HashSet<>(entrances));

        BigDecimal totalFee = BigDecimal.ZERO;
        for (Map.Entry<LocalDate, List<LocalTime>> entry : groupedSortedEntrancesDates.entrySet()) {
            if (isTollFreeDate(entry.getKey().atStartOfDay(), holidays)) {
                continue;
            }
            totalFee = totalFee.add(calculateTollFeeForDay(entry.getValue(), tollPrices));
        }
        return totalFee;
    }

    private BigDecimal getTollFee(LocalTime currentTime, List<TollPrice> pricesList) {
        return pricesList.stream()
                .filter(price -> !currentTime.isBefore(price.getFromTime()) && !currentTime.isAfter(price.getToTime()))
                .map(TollPrice::getPrice)
                .findFirst()
                .orElse(BigDecimal.ZERO);
    }

    private boolean isTollFreeDate(LocalDateTime date, List<Holiday> holidays) {
        if (date.getDayOfWeek().getValue() >= 6) return true; // Saturday and Sunday
        if (date.getMonthValue() == 7) return true; // July
        for (Holiday holiday : holidays) {
            if (holiday.getDate().isEqual(date.toLocalDate())) {
                return true;
            }
        }
        return false;
    }

    private Map<LocalDate, List<LocalTime>> groupAndSortEntrancesByDate(Set<Entrance> entrances) {
        return entrances.stream()
                .map(Entrance::getEntranceDateTime)
                .collect(Collectors.groupingBy(
                        LocalDateTime::toLocalDate,
                        Collectors.mapping(LocalDateTime::toLocalTime, Collectors.toList())
                ))
                .entrySet().stream()
                .peek(entry -> entry.getValue().sort(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private BigDecimal calculateTollFeeForDay(List<LocalTime> times, List<TollPrice> pricesList) {
        BigDecimal totalFee = BigDecimal.ZERO;
        LocalTime intervalStart = times.getFirst();
        BigDecimal maxFeeInInterval = getTollFee(intervalStart, pricesList);

        for (LocalTime time : times) {
            BigDecimal currentFee = getTollFee(time, pricesList);
            long minutes = ChronoUnit.MINUTES.between(intervalStart, time);
            if (minutes <= 60) {
                maxFeeInInterval = maxFeeInInterval.max(currentFee);
            } else {
                totalFee = totalFee.add(maxFeeInInterval);
                intervalStart = time;
                maxFeeInInterval = currentFee;
            }
        }
        totalFee = totalFee.add(maxFeeInInterval);
        return totalFee.min(DAILY_LIMIT);
    }
}