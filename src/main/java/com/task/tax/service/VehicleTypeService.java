package com.task.tax.service;


import com.task.tax.model.VehicleType;
import com.task.tax.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleTypeService {
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    public List<VehicleType> getAllVehicleTypes() {
        return vehicleTypeRepository.findAll();
    }

    public VehicleType getVehicleTypeById(Long id) {
        return vehicleTypeRepository.findById(id).orElse(null);
    }

    public VehicleType saveVehicleType(VehicleType vehicleType) {
        return vehicleTypeRepository.save(vehicleType);
    }

    public void deleteVehicleType(Long id) {
        vehicleTypeRepository.deleteById(id);
    }
}
