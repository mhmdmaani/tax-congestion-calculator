package com.task.tax.controller;


import com.task.tax.model.Entrance;
import com.task.tax.service.EntranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrances")

public class EntranceController {
    @Autowired
    private EntranceService entranceService;

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
    public Entrance createEntrance(@RequestBody Entrance entrance) {
        return entranceService.saveEntrance(entrance);
    }

    @PutMapping("/{id}")
    public Entrance updateEntrance(@PathVariable Long id, @RequestBody Entrance entrance) {
        Entrance existingEntrance = entranceService.getEntranceById(id);
        if (existingEntrance != null) {
            existingEntrance.setCar(entrance.getCar());
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
