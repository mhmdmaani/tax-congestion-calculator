package com.task.tax.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String regNumber;

    @ManyToOne
    private VehicleType vehicleType;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("entranceDateTime ASC")
    @JsonManagedReference
    private Set<Entrance> entrances;

    public Car() {
    }

    public Car(Long id, String regNumber, VehicleType vehicleType) {
        this.id = id;
        this.regNumber = regNumber;
        this.vehicleType = vehicleType;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public  Set<Entrance> getEntrances(){
        return this.entrances;
    }

    public void setEntrances(Set<Entrance> entrances){
        this.entrances = entrances;
    }
}
