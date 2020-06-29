package com.parkinglot.Model;

import com.parkinglot.Interfaces.Vehicle;

public class Car implements Vehicle {

    private String registrationNumber;
    private String color;

    public Car(String registrationNumber, String color) {
        super();
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    @Override
    public String getRegistartionNumber() {
        return this.registrationNumber;
    }

    @Override
    public String getColor() {

        return this.color;
    }
}

