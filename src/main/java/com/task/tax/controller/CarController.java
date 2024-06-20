package com.task.tax.controller;


import com.task.tax.model.Car;
import com.task.tax.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Car> getCarById(@PathVariable Long id) {
        return carService.getById(id);
    }

    @GetMapping("/regNumber/{regNumber}")
    public Optional<Car> getCarByRegNumber(@PathVariable String regNumber) {
        return carService.getByRegNumber(regNumber);
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car car) {
        Optional<Car> existingCarOpt = carService.getById(id);
        if (existingCarOpt.isPresent()) {
            Car existingCar = existingCarOpt.get();
            existingCar.setRegNumber(car.getRegNumber());
            existingCar.setVehicleType(car.getVehicleType());
            return carService.saveCar(existingCar);
        } else {
            return null; // Or throw an exception
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }
}
