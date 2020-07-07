package com.parkinglot.Model;

import com.parkinglot.Interfaces.Vehicle;

import java.time.LocalTime;

public class Ticket {
    private LocalTime entryTime;
    private LocalTime departureTime;
    private int totalPrice;
    public Ticket(LocalTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
