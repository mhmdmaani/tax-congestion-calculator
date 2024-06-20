package com.task.tax.DTO;

import com.task.tax.model.Car;

public class TaxResponse extends Car {
    private double tax;

    public TaxResponse(Car car, double tax) {
        super(car.getId(), car.getRegNumber(), car.getVehicleType());
        this.tax = tax;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}
