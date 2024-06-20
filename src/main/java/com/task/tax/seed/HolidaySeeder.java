package com.task.tax.seed;


import com.task.tax.model.Holiday;
import com.task.tax.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Component
@Order(1)
public class HolidaySeeder implements CommandLineRunner {
    @Autowired
    private HolidayRepository holidayRepository;


    @Override
    public void run(String... args) {
        if (holidayRepository.count() == 0) {
            List<LocalDate> publicHolidays = Arrays.asList(
                    LocalDate.of(2013, 1, 1),
                    LocalDate.of(2013, 3, 28), LocalDate.of(2013, 3, 29),
                    LocalDate.of(2013, 4, 1), LocalDate.of(2013, 4, 30),
                    LocalDate.of(2013, 5, 1), LocalDate.of(2013, 5, 8), LocalDate.of(2013, 5, 9),
                    LocalDate.of(2013, 6, 5), LocalDate.of(2013, 6, 6), LocalDate.of(2013, 6, 21),
                    LocalDate.of(2013, 11, 1),
                    LocalDate.of(2013, 12, 24), LocalDate.of(2013, 12, 25), LocalDate.of(2013, 12, 26), LocalDate.of(2013, 12, 31)
            );

            // Generate all dates in July
            List<LocalDate> julyDates = Stream.iterate(LocalDate.of(2013, 7, 1), date -> date.plusDays(1))
                    .limit(31)
                    .toList();

            // Generate all Saturdays and Sundays in 2013
            List<LocalDate> weekends = Stream.iterate(LocalDate.of(2013, 1, 1), date -> date.plusDays(1))
                    .limit(LocalDate.of(2013, 12, 31).toEpochDay() - LocalDate.of(2013, 1, 1).toEpochDay() + 1)
                    .filter(date -> date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY)
                    .toList();

            // Combine public holidays, July dates, and weekends
            List<Holiday> holidays = Stream.of(publicHolidays.stream(), julyDates.stream(), weekends.stream())
                    .flatMap(stream -> stream)
                    .distinct() // Ensure no duplicates
                    .map(date -> {
                        Holiday holiday = new Holiday();
                        holiday.setDate(date);
                        return holiday;
                    })
                    .toList();

            holidayRepository.saveAll(holidays);
        }
    }
};
