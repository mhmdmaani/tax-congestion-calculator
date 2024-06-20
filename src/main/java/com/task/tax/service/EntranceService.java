package com.task.tax.service;

import com.task.tax.model.Entrance;
import com.task.tax.repository.EntranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EntranceService {

    @Autowired
    private EntranceRepository entranceRepository;

    public List<Entrance> getAllEntrances() {
        return entranceRepository.findAll();
    }

    public Entrance getEntranceById(Long id) {
        return entranceRepository.findById(id).orElse(null);
    }

    public Entrance saveEntrance(Entrance entrance) {
        return entranceRepository.save(entrance);
    }

    public void deleteEntrance(Long id) {
        entranceRepository.deleteById(id);
    }

    public List<Entrance> getEntrancesByCarId(Long carId) {
        return entranceRepository.findByCarId(carId);
    }
}
