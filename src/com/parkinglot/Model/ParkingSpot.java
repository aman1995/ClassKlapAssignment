package com.parkinglot.Model;

public class ParkingSpot {

    Ticket ticket;
    String parkingLotId;
    String type;
    String regNumber;
    int slot;

    public ParkingSpot(int slot, Ticket ticket, String type, String regNumber) {
        this.slot = slot;
        this.ticket=ticket;
        this.type=type;
        this.regNumber = regNumber;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }
}
