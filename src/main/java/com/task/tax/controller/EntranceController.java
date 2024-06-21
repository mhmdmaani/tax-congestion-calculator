package com.task.tax.controller;


import com.task.tax.DTO.EntranceInputDTO;
import com.task.tax.model.Car;
import com.task.tax.model.Entrance;
import com.task.tax.service.CarService;
import com.task.tax.service.EntranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entrances")

public class EntranceController {
    @Autowired
    private EntranceService entranceService;
   @Autowired
    private CarService carService;
    @GetMapping
    public List<Entrance> getAllEntrances() {
        return entranceService.getAllEntrances();
    }

    @GetMapping("/{id}")
    public Entrance getEntranceById(@PathVariable Long id) {
        return entranceService.getEntranceById(id);
    }

    @GetMapping("/car/{carId}")
    public List<Entrance> getEntrancesByCarId(@PathVariable Long carId) {
        return entranceService.getEntrancesByCarId(carId);
    }

    @PostMapping
    public Entrance createEntrance(@RequestBody EntranceInputDTO entrance) {
         Optional<Car> car = carService.getById(entrance.getCarId());
         if (car.isPresent()) {
            Entrance newEntrance = new Entrance();
            newEntrance.setCar(car.get());
            newEntrance.setEntranceDateTime(entrance.getEntranceDateTime());
            return entranceService.saveEntrance(newEntrance);
        } else {
            return null; // Or throw an exception
         }
    }

    @PutMapping("/{id}")
    public Entrance updateEntrance(@PathVariable Long id, @RequestBody EntranceInputDTO entrance) {
        Entrance existingEntrance = entranceService.getEntranceById(id);
        Car car = carService.getById(entrance.getCarId()).orElse(null);
        if (existingEntrance != null && car!= null) {
            existingEntrance.setCar(car);
            existingEntrance.setEntranceDateTime(entrance.getEntranceDateTime());
            return entranceService.saveEntrance(existingEntrance);
        } else {
            return null; // Or throw an exception
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEntrance(@PathVariable Long id) {
        entranceService.deleteEntrance(id);
    }
}
