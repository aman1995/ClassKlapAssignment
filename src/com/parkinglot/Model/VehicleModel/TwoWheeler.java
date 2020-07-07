package com.parkinglot.Model.VehicleModel;

import com.parkinglot.Interfaces.Vehicle;

public class TwoWheeler implements Vehicle {
    private String registrationNumber;

    public TwoWheeler(String registrationNumber) {
        super();
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String getRegistartionNumber() {
        return this.registrationNumber;
    }
}
