package com.task.tax.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class TollPrice {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private BigDecimal price;
     private LocalTime fromTime;
     private LocalTime toTime;

     public TollPrice(){
     }

    public TollPrice(Long id, BigDecimal price, LocalTime fromTime, LocalTime toTime) {
        this.id = id;
        this.price = price;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getFromTime() {
        return fromTime;
    }

    public void setFromTime(LocalTime fromTime) {
        this.fromTime = fromTime;
    }

    public LocalTime getToTime() {
        return toTime;
    }

    public void setToTime(LocalTime toTime) {
        this.toTime = toTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
