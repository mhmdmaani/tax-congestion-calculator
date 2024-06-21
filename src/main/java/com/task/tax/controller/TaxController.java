package com.task.tax.controller;


import com.task.tax.DTO.TaxResponse;
import com.task.tax.model.Car;
import com.task.tax.model.City;
import com.task.tax.model.Holiday;
import com.task.tax.model.TollPrice;
import com.task.tax.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tax")
public class TaxController {

    @Autowired
    private CongestionTaxCalculator taxService;

    @Autowired
    private CarService carService;

    @Autowired
    private HolidayService holidayService;

    @Autowired
     private TollPriceService tollPriceService;

    @Autowired
    CityService cityService;

     @GetMapping("/calculate/{carId}")
    public TaxResponse calculateTax(@PathVariable Long carId) {
        Optional<Car> car = carService.getById(carId);
        if (car.isEmpty()) {
            throw  new RuntimeException("Car not found");
        }
         List <Holiday> holidays = holidayService.getAll();
        List<TollPrice> tollPrices = tollPriceService.getAllTollPrices();

        return new TaxResponse(car.get(),taxService.calculateTax(null,car.get().getVehicleType(), car.get().getEntrances(), holidays, tollPrices).doubleValue());
     }

     @GetMapping("calculate/all")
    public List<TaxResponse> getAllCarsTaxes() {
         List<Car> cars = carService.getAll();
          List <Holiday> holidays = holidayService.getAll();
          List<TollPrice> tollPrices = tollPriceService.getAllTollPrices();
          return cars.stream().map(car -> new TaxResponse(car,taxService.calculateTax(null,car.getVehicleType(), car.getEntrances(), holidays, tollPrices).doubleValue())).toList();
    }



    @GetMapping("/city/{cityId}/{carId}")
    public TaxResponse calculateTaxInCity(@PathVariable Long carId, @PathVariable Long cityId) {
        Optional<Car> car = carService.getById(carId);
        if (car.isEmpty()) {
            throw  new RuntimeException("Car not found");
        }
        List <Holiday> holidays = holidayService.getAll();
        City city = cityService.getCity(cityId);
        List<TollPrice> tollPrices = city.getTollPrices();
        return new TaxResponse(car.get(),taxService.calculateTax(null,car.get().getVehicleType(), car.get().getEntrances(), holidays, tollPrices).doubleValue());
    }

    @GetMapping("city/all/{cityId}")
    public List<TaxResponse> getAllCarsTaxesInCity(@PathVariable Long cityId) {
        List<Car> cars = carService.getAll();
        List <Holiday> holidays = holidayService.getAll();
        City city = cityService.getCity(cityId);
        List<TollPrice> tollPrices = city.getTollPrices();
        return cars.stream().map(car -> new TaxResponse(car,taxService.calculateTax(city.getDailyLimit(),car.getVehicleType(), car.getEntrances(), holidays, tollPrices).doubleValue())).toList();
    }


}