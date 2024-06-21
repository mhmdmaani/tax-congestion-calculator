package com.task.tax.model;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal dailyLimit;

    @OneToMany(mappedBy = "city")
    private List<TollPrice> tollPrices;

    public City() {}

    public City(Long id, String name, BigDecimal dailyLimit) {
        this.id = id;
        this.name = name;
        this.dailyLimit = dailyLimit;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getDailyLimit() {
        return dailyLimit;
    }

    public void setDailyLimit(BigDecimal dailyLimit) {
        this.dailyLimit = dailyLimit;
    }

    public List<TollPrice> getTollPrices() {
        return tollPrices;
    }

    public void setTollPrices(List<TollPrice> tollPrices) {
        this.tollPrices = tollPrices;
    }


}
