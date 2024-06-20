package com.task.tax.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Entrance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    private Car car;

    private LocalDateTime entranceDateTime;

    public Entrance() {
    }

    public Entrance(Long id, Car car, LocalDateTime entranceDateTime) {
        this.id = id;
        this.car = car;
        this.entranceDateTime = entranceDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDateTime getEntranceDateTime() {
        return entranceDateTime;
    }

    public void setEntranceDateTime(LocalDateTime entranceDateTime) {
        this.entranceDateTime = entranceDateTime;
    }
}
