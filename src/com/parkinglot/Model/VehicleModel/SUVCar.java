package com.parkinglot.Model.VehicleModel;

import com.parkinglot.Interfaces.Vehicle;

public class SUVCar implements Vehicle {

    private String registrationNumber;

    public SUVCar(String registrationNumber) {
        super();
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String getRegistartionNumber() {
        return this.registrationNumber;
    }

}

