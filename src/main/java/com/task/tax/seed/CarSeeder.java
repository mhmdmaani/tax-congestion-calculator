package com.task.tax.seed;
import com.task.tax.model.Car;
import com.task.tax.model.VehicleType;
import com.task.tax.repository.CarRepository;
import com.task.tax.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Order(4)
public class CarSeeder implements CommandLineRunner {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    @Override
    public void run(String... args){
        List<VehicleType> vehicleTypes = vehicleTypeRepository.findAll();

        List<Car> cars = Arrays.asList(
                new Car(null,"ABC123", vehicleTypes.get(0)),
                new Car(null,"DEF456", vehicleTypes.get(1)),
                new Car(null,"GHI789", vehicleTypes.get(2)),
                new Car(null,"JKL012", vehicleTypes.get(3)),
                new Car(null,"MNO345", vehicleTypes.get(4)),
                new Car(null,"PQR678", vehicleTypes.get(5))
        );

        carRepository.saveAll(cars);
    }
}
