package com.task.tax.repository;

import com.task.tax.model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayRepository extends JpaRepository<Holiday,Long> {
}