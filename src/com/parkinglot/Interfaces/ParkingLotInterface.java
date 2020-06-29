package com.parkinglot.Interfaces;

public interface ParkingLotInterface {

    public String park(Vehicle vehicle);
    public String unPark(String slotNumber);
    public String getStatus();
    public String getRegistrationsByColor(String color);
    public String getSlotsByColor(String color);
    public String getSlotByRegNumber(String registrationNumber);
}

