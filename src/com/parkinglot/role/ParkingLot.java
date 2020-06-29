package com.parkinglot.role;

import com.parkinglot.Interfaces.ParkingLotInterface;
import com.parkinglot.Interfaces.Vehicle;
import com.parkinglot.Model.Ticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Aman
 *
 */
public final class ParkingLot implements ParkingLotInterface {

    private final Map<String, Ticket> regNumberToTicketMap;
    private final Map<Integer, Ticket> slotToTicketMap;
    private final Map<String, List<Ticket>> colorToTicketMap;
    private final Set<Integer> availableSlots;
    private final Set<Integer> occupiedSlots;
    private static ParkingLot parkingLot;

    private ParkingLot(String size) {

        availableSlots = new TreeSet<>();
        occupiedSlots = new TreeSet<>();
        regNumberToTicketMap = new HashMap<>();
        colorToTicketMap = new HashMap<>();
        slotToTicketMap = new HashMap<>();

        fillAvailableSlots(size, availableSlots);
    }

    public static ParkingLot createParkingSlots(String slotSize) {
        if(parkingLot == null){
            parkingLot = new ParkingLot(slotSize);
            return parkingLot;
        }
        return parkingLot;
    }

    @Override
    public String park(Vehicle vehicle) {

        String res ="";
        if (availableSlots.isEmpty())
            res= "Sorry, parking lot is full";

        else {
            Integer nearestSlot = ((TreeSet<Integer>) availableSlots).pollFirst();
            Ticket ticket = new Ticket(nearestSlot, vehicle);
            setAllMaps(ticket);
            res = "Allocated slot number: " + nearestSlot;
        }
        return res;
    }

    @Override
    public String unPark(String slotInString) {

        String res="";
        if (availableSlots.contains(Integer.valueOf(slotInString)))
            res = "Parking Slot "+slotInString+" is already Empty";
        else{
            removeFromMaps(slotInString);
            res = "Slot number " + slotInString + " is free";
        }
        return res;
    }

    @Override
    public String getSlotByRegNumber(String regNumber) {

        String res="";
        Ticket ticket = regNumberToTicketMap.get(regNumber);

        if (null != ticket) {
            Integer slot = ticket.getSlot();
            res = String.valueOf(slot);
        }
        else res = "Not found";
        return res;
    }

    @Override
    public String getRegistrationsByColor(String color) {

        List<Ticket> tickets = colorToTicketMap.get(color);
        StringBuilder sb = new StringBuilder();

        for (Ticket ticket : tickets){
            sb.append(ticket.getVehicle().getRegistartionNumber() + ", ");
        }

        return sb.substring(0, sb.lastIndexOf(",")).toString();
    }

    @Override
    public String getSlotsByColor(String color) {

        List<Ticket> tickets = colorToTicketMap.get(color);
        StringBuilder sb = new StringBuilder();

        for (Ticket ticket : tickets){
            Integer slot = ticket.getSlot();
            sb.append(slot + ", ");
        }
        return sb.substring(0, sb.lastIndexOf(",")).toString();
    }

    @Override
    public String getStatus() {

        StringBuilder sb = new StringBuilder();
        sb.append("Slot_No." + "Registration_No" + "\t" + "Color" + "\n");

        for (Integer filledslot : occupiedSlots) {
            Vehicle vehicle = slotToTicketMap.get(filledslot).getVehicle();
            sb.append(filledslot + "\t" + vehicle.getRegistartionNumber() + "\t" + vehicle.getColor() + "\n");
        }
        return sb.toString();
    }

    /**
     * Filling the available tree set during instantiation
     * @param size
     * @param availableSlots
     */
    private void fillAvailableSlots(String size, Set<Integer> availableSlots) {
        Integer sizeInInteger = Integer.valueOf(size);
        for (int i = 1; i <= sizeInInteger; i++)
            availableSlots.add(i);
    }

    /**
     * Configuring all maps
     * @param ticket
     */
    public void setAllMaps(Ticket ticket) {

        Integer slot = ticket.getSlot();
        Vehicle vehicle = ticket.getVehicle();

        occupiedSlots.add(slot);
        availableSlots.remove(slot);
        regNumberToTicketMap.put(vehicle.getRegistartionNumber(), ticket);
        slotToTicketMap.put(slot, ticket);

        List<Ticket> tickets = colorToTicketMap.get(vehicle.getColor());
        if (null == tickets)
            tickets = new ArrayList<>();

        tickets.add(ticket);
        colorToTicketMap.put(vehicle.getColor(), tickets);
    }

    /**
     * Removing the slot from all maps
     * @param slotInString
     */
    private void removeFromMaps(String slotInString) {

        Integer slot = Integer.parseInt(slotInString);
        Ticket ticket = slotToTicketMap.get(slot);

        occupiedSlots.remove(slot);
        availableSlots.add(slot);
        regNumberToTicketMap.remove(ticket.getVehicle().getRegistartionNumber());
        slotToTicketMap.remove(ticket.getSlot());

        List<Ticket> tickets = colorToTicketMap.get(ticket.getVehicle().getColor());
        tickets.remove(ticket);
    }


}
