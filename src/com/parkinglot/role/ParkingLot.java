package com.parkinglot.role;

import com.parkinglot.Interfaces.ParkingLotInterface;
import com.parkinglot.Interfaces.Vehicle;
import com.parkinglot.Model.ParkingSpot;
import com.parkinglot.Model.Ticket;
import com.parkinglot.Model.VehicleModel.HatchBackCar;
import com.parkinglot.Model.VehicleModel.SUVCar;
import com.parkinglot.Model.VehicleModel.TwoWheeler;

import java.util.*;

/**
 * @author Aman
 *
 */
public final class ParkingLot implements ParkingLotInterface {



    private static ParkingLot parkingLot;
    private List<ParkingSpot> parkingSpot;
    private  HashMap<String, ParkingSpot> regNumberToParkingSpotMap;
    private  HashSet<Integer> slots2Wheeler;
    private  HashSet<Integer> slots4Wheeler;
    private  final int total2wheelers;
    private  final int total4wheelers;
    private  int cur2wheelers;
    private  int cur4wheelers;


    private ParkingLot(String name,String total2wheelers, String total4wheelers) {

        cur2wheelers = 0;
        cur4wheelers = 0;
        regNumberToParkingSpotMap = new HashMap<>();
        slots2Wheeler = new HashSet<>();
        slots4Wheeler = new HashSet<>();
        this.total2wheelers = Integer.parseInt(total2wheelers);
        this.total4wheelers = Integer.parseInt(total4wheelers);

    }

    public static ParkingLot createParkingSlots(String name, String total2wheelers, String total4wheelers) {
        if(parkingLot == null){
            parkingLot = new ParkingLot(name,total2wheelers,total4wheelers);
            return parkingLot;
        }
        return parkingLot;
    }

    @Override
    public String park(Vehicle vehicle) {

        String res="";
        Ticket ticket;
        ParkingSpot parkingSpot;
        if(vehicle instanceof SUVCar || vehicle instanceof HatchBackCar) {
            if (cur4wheelers == total4wheelers)
                return "Sorry, parking lot for 4 wheeler full";

            else{
                 int slot = getFreeSlot(vehicle);
                 ticket = new Ticket(java.time.LocalTime.now());
                 parkingSpot = new ParkingSpot(slot,ticket,"4wheeler",vehicle.getRegistartionNumber());
                 slots4Wheeler.add(slot);
                 regNumberToParkingSpotMap.put(vehicle.getRegistartionNumber() , parkingSpot);
                 cur4wheelers++;
                 res =  "Parked Successfully at slot " + slot;
            }
        }
        else if(vehicle instanceof TwoWheeler) {
            if (cur2wheelers == total2wheelers)
                return "Sorry, parking lot for 2 wheeler full";

            else{
                int slot = getFreeSlot(vehicle);
                ticket = new Ticket(java.time.LocalTime.now());
                parkingSpot = new ParkingSpot(slot,ticket,"4wheeler",vehicle.getRegistartionNumber());
                slots2Wheeler.add(slot);
                regNumberToParkingSpotMap.put(vehicle.getRegistartionNumber() , parkingSpot);
                cur2wheelers++;
                res =  "Parked Successfully at slot " + slot;

            }
        }
        return res;
    }

    @Override
    public Ticket unPark(String regNumber) {
        ParkingSpot parkingSpot;
        parkingSpot = regNumberToParkingSpotMap.get(regNumber);
        if(parkingSpot.getType().equals("2wheeler")) {
            cur2wheelers--;
            slots2Wheeler.remove(parkingSpot.getSlot());
        }
        else if(parkingSpot.getType().equals("4wheeler")) {
            cur4wheelers--;
            slots4Wheeler.remove(parkingSpot.getSlot());
        }

        Ticket ticket = parkingSpot.getTicket();
        ticket.setDepartureTime(java.time.LocalTime.now());
        ticket.setTotalPrice(100);
        return ticket;
    }

    private int getFreeSlot(Vehicle vehicle) {

        int i=0;
        if(vehicle instanceof SUVCar || vehicle instanceof HatchBackCar) {
            for( i=0;i<slots4Wheeler.size();i++) {
                if (!slots4Wheeler.contains(i))
                    return i;
            }
        }
        else if(vehicle instanceof TwoWheeler){
            for( i=0;i<slots2Wheeler.size();i++){
                if(!slots4Wheeler.contains(i))
                    return i;
            }
        }
        return i;
    }



}
