package com.parkinglot.Model.VehicleModel;

import com.parkinglot.Interfaces.Vehicle;

public class HatchBackCar implements Vehicle {

    private String registrationNumber;

    public HatchBackCar(String registrationNumber) {
        super();
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String getRegistartionNumber() {
        return this.registrationNumber;
    }


}

