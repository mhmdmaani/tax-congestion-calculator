package com.task.tax.seed;

import com.task.tax.model.VehicleType;
import com.task.tax.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
@Order(4)
public class VehicleTypeSeeder implements CommandLineRunner{
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;


    @Override
    public void run(String ...args){
        if (vehicleTypeRepository.count() == 0) {
            List<VehicleType> vehicleTypes = Arrays.asList(
                    new VehicleType(null, "Car", false),
                    new VehicleType(null, "Truck", false),
                    new VehicleType(null, "Bicycle", true),
                    new VehicleType(null,"Emergency vehicles", true),
                    new VehicleType(null,"Busses", true),
                    new VehicleType(null,"Diplomat vehicles", true),
                    new VehicleType(null,"Motorcycles", true),
                    new VehicleType(null,"Military vehicles", true),
                    new VehicleType(null,"Foreign vehicles", true)
            );
            vehicleTypeRepository.saveAll(vehicleTypes);
         }
    }
}
