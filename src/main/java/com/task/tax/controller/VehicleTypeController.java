package com.task.tax.controller;


import com.task.tax.model.VehicleType;
import com.task.tax.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle-types")
public class VehicleTypeController {
    @Autowired
    private VehicleTypeService vehicleTypeService;

    @GetMapping
    public List<VehicleType> getAllVehicleTypes() {
        return vehicleTypeService.getAllVehicleTypes();
    }

    @GetMapping("/{id}")
    public VehicleType getVehicleTypeById(@PathVariable Long id) {
        return vehicleTypeService.getVehicleTypeById(id);
    }

    @PostMapping
    public VehicleType createVehicleType(@RequestBody VehicleType vehicleType) {
        return vehicleTypeService.saveVehicleType(vehicleType);
    }

    @PutMapping("/{id}")
    public VehicleType updateVehicleType(@PathVariable Long id, @RequestBody VehicleType vehicleType) {
        VehicleType existingVehicleType = vehicleTypeService.getVehicleTypeById(id);
        if (existingVehicleType != null) {
            existingVehicleType.setName(vehicleType.getName());
            existingVehicleType.setFree(vehicleType.isFree());
            return vehicleTypeService.saveVehicleType(existingVehicleType);
        } else {
            return null;
        }
    }
    @DeleteMapping("/{id}")
    public void deleteVehicleType(@PathVariable Long id) {
        vehicleTypeService.deleteVehicleType(id);
    }
}
