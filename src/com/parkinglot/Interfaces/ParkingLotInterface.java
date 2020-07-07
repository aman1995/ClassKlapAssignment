package com.parkinglot.Interfaces;

import com.parkinglot.Model.Ticket;

public interface ParkingLotInterface {

    public String park(Vehicle vehicle);
    public Ticket unPark(String slotNumber);


}

