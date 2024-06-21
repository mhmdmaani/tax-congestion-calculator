package com.task.tax.seed;


import com.task.tax.model.City;
import com.task.tax.model.TollPrice;
import com.task.tax.repository.CityRepository;
import com.task.tax.repository.TollPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@Component
@Order(3)
public class TollPriceSeeder implements CommandLineRunner {


    @Autowired
    private TollPriceRepository tollPriceRepository;
    @Autowired
    private CityRepository cityRepository;
    @Override
     public void run(String ...args){
        if (tollPriceRepository.count() == 0) {
             City currentCity = cityRepository.findByName("Gothenburg");

            List<TollPrice> tollPrices = Arrays.asList(
                    new TollPrice(null,currentCity, new BigDecimal("8"), LocalTime.of(6, 0), LocalTime.of(6, 29)),
                    new TollPrice(null,currentCity, new BigDecimal("13"), LocalTime.of(6, 30), LocalTime.of(6, 59)),
                    new TollPrice(null,currentCity, new BigDecimal("18"), LocalTime.of(7, 0), LocalTime.of(7, 59)),
                    new TollPrice(null,currentCity, new BigDecimal("13"), LocalTime.of(8, 0), LocalTime.of(8, 29)),
                    new TollPrice(null,currentCity, new BigDecimal("8"), LocalTime.of(8, 30), LocalTime.of(14, 59)),
                    new TollPrice(null,currentCity, new BigDecimal("13"), LocalTime.of(15, 0), LocalTime.of(15, 29)),
                    new TollPrice(null,currentCity, new BigDecimal("18"), LocalTime.of(15, 30), LocalTime.of(16, 59)),
                    new TollPrice(null,currentCity, new BigDecimal("13"), LocalTime.of(17, 0), LocalTime.of(17, 59)),
                    new TollPrice(null,currentCity, new BigDecimal("8"), LocalTime.of(18, 0), LocalTime.of(18, 29)),
                    new TollPrice(null,currentCity, new BigDecimal("0"), LocalTime.of(18, 30), LocalTime.of(5, 59))
            );
            tollPriceRepository.saveAll(tollPrices);
        }
    }
}
