package com.task.tax.repository;

import com.task.tax.model.TollPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;
import java.util.Optional;

public interface TollPriceRepository extends JpaRepository<TollPrice,Long> {
    Optional<TollPrice> findByFromTimeLessThanEqualAndToTimeGreaterThanEqual(LocalTime fromTime, LocalTime toTime);
}
