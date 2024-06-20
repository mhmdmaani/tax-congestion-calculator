package com.task.tax.repository;

import com.task.tax.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleTypeRepository  extends JpaRepository<VehicleType,Long> {
}
