package com.task.tax.seed;

import com.task.tax.model.City;
import com.task.tax.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
@Order(1)
public class CitySeeder implements CommandLineRunner {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public void run(String... args) {
        if(cityRepository.count()==0){
            City city = new City();
            city.setName("Gothenburg");
            city.setDailyLimit(new BigDecimal(60));
            cityRepository.save(city);

            city = new City();
            city.setName("Stockholm");
            city.setDailyLimit(new BigDecimal(70));
            cityRepository.save(city);

            city = new City();
            city.setName("Malmo");
            city.setDailyLimit(new BigDecimal(50));
            cityRepository.save(city);
        }
    }

}
