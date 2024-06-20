package com.task.tax.repository;

import com.task.tax.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findByRegNumber(String regNumber);

}