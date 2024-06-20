package com.task.tax.service;

import com.task.tax.model.Car;
import com.task.tax.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAll(){
        return carRepository.findAll();
    }
    public Optional<Car> getById(Long id){
        return carRepository.findById(id);
    }

    public Optional<Car> getByRegNumber(String regNumber){
        return carRepository.findByRegNumber(regNumber);
    }

    public Car saveCar(Car car){
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        Optional<Car> car = carRepository.findById(id);
        car.ifPresent(carRepository::delete);
    }
}
