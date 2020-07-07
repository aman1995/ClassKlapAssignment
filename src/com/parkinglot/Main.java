package com.parkinglot;

import com.parkinglot.Model.Ticket;
import com.parkinglot.Model.VehicleModel.HatchBackCar;
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

            switch (arr[0]) {
                case "CREATE":
                    parkinglot = ParkingLot.createParkingSlots(arr[1]  ,arr[2] ,arr[3] );
                    System.out.println("Created a parking lot with " + arr[2] + " 2 wheeler slots and " + arr[3] +  " 4 wheeler slots");
                    break;

                case "PARK":
                    HatchBackCar hatchBackCar = new HatchBackCar(arr[1]);
                    System.out.println(parkinglot.park(hatchBackCar));
                    break;

                case "LEAVE":
                    Ticket ticket = parkinglot.unPark(arr[1]);
                    System.out.println("Total Price = " +ticket.getTotalPrice());
                    break;


                default:
                    System.out.println("Enter correct value");
                    break;

            }
        }
    }
}
