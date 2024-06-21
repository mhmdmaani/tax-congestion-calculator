package com.task.tax.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
public class TollPrice {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private BigDecimal price;
     private LocalTime fromTime;
     private LocalTime toTime;


     @ManyToOne
     private City city;

     public TollPrice(){
     }

    public TollPrice(Long id,City city, BigDecimal price, LocalTime fromTime, LocalTime toTime) {
        this.id = id;
        this.price = price;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.city = city;
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


    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
