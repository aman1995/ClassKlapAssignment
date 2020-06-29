import com.parkinglot.Model.Car;
import com.parkinglot.role.ParkingLot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


import org.junit.After;


public class ParkingLotTest {

    private ParkingLot parkingLot = ParkingLot.createParkingSlots("2");
    private Car car;

    @Before
    public void init() {
        car = new Car("KA-01-HH-1234", "White");
        parkingLot.park(car);
    }

    @After
    public void destroy(){
        parkingLot.unPark("1");
        parkingLot.unPark("2");
    }

    @Test
    public void successfully_parked() {
        car = new Car("KA-01-HH-1235", "Black");
        assertEquals("Allocated slot number: 2" , parkingLot.park(car) );
    }
    @Test
    public void error_when_size_exceeds() {

        car = new Car("KA-01-HH-1236", "White");
        parkingLot.park(car);
        car = new Car("KA-01-HH-1235", "Black");
        assertEquals("Sorry, parking lot is full" , parkingLot.park(car));
    }

    @Test
    public void should_unPark_successfully() {
        assertEquals("Slot number 1 is free" , parkingLot.unPark("1") );
    }

    @Test
    public void status_should_send_proper_result() {
        car = new Car("KA-01-HH-1235", "Black");
        parkingLot.park(car);

        StringBuilder response = new StringBuilder();
        response.append("Slot_No." + "Registration_No" + "\t" + "Color" + "\n");
        response.append(1 + "\t" + "KA-01-HH-1234" + "\t" + "White" + "\n");
        response.append(2 + "\t" + "KA-01-HH-1235" + "\t" + "Black" + "\n");

        assertEquals(response.toString() , parkingLot.getStatus() );
    }

    @Test
    public void registration_number_of_all_vehilcles_for_a_given_color() {
        car = new Car("KA-01-HH-1235", "White");
        parkingLot.park(car);
        assertEquals("KA-01-HH-1234, KA-01-HH-1235" , parkingLot.getRegistrationsByColor("White") );
    }

    @Test
    public void slot_number_of_vehicle_for_a_given_registartion_number() {
        car = new Car("KA-01-HH-1238", "Black");
        parkingLot.park(car);
        assertEquals("2" , parkingLot.getSlotByRegNumber("KA-01-HH-1238") );
    }

    @Test
    public void error_message_for_not_available_registartion_number() {
        assertEquals("Not found" , parkingLot.getSlotByRegNumber("KA-01-HH-1235") );
    }

}
