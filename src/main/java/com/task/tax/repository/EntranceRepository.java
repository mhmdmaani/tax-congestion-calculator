package com.task.tax.repository;

import com.task.tax.model.Entrance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntranceRepository extends JpaRepository<Entrance,Long> {
    List<Entrance> findByCarId(Long carId);
}