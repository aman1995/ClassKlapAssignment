package com.parkinglot.Model;

import com.parkinglot.Interfaces.Vehicle;

public class Ticket {
    private Integer slot;
    private Vehicle vehicle;

    public Ticket(Integer slot, Vehicle vehicle) {
        super();
        this.slot = slot;
        this.vehicle = vehicle;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


}
