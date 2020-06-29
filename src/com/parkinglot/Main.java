package com.parkinglot;

import com.parkinglot.Model.Car;
import com.parkinglot.enums.Command;
import com.parkinglot.role.ParkingLot;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        ParkingLot parkinglot = null;

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String arr[] = str.split(" ");
            Command command = Command.getCommand(arr[0]);

            switch (command) {
                case CREATE:
                    parkinglot = ParkingLot.createParkingSlots(arr[1]);
                    System.out.println("Created a parking lot with " + arr[1] + " slots");
                    break;

                case PARK:
                    Car car = new Car(arr[1], arr[2]);
                    System.out.println(parkinglot.park(car));
                    break;

                case LEAVE:
                    System.out.println(parkinglot.unPark(arr[1]));
                    break;

                case STATUS:
                    System.out.println(parkinglot.getStatus());
                    break;

                case REGNUMS_FROM_COLOR:
                    System.out.println(parkinglot.getRegistrationsByColor(arr[1]));
                    break;

                case SLOTNUMS_FROM_COLOR:
                    System.out.println(parkinglot.getSlotsByColor(arr[1]));
                    break;

                case SLOTNUM_FROM_REGNUM:
                    System.out.println(parkinglot.getSlotByRegNumber(arr[1]));
                    break;

                default:
                    System.out.println("Enter correct value");
                    break;

            }
        }
    }
}
