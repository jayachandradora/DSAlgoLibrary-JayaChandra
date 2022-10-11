package intv.low.level.design;

import java.util.Date;
import java.util.List;
import java.util.Map;

public abstract class ParkingLot {
	List<ParkingFloor> parkingFloors;
	List<Entrance> entrances;
	List<Exit> exits;

	Address address; 

	String parkingLotName;

	public abstract boolean isParkingSpaceAvailableForVehicle(Vehicle vehicle);
	public abstract boolean updateParkingAttndant(ParkingAttendant parkingAttendant, int gateId);
}

class ParkingFloor {
	
	int levelId;
	List<ParkingSpace> parkingSpaces;

	ParkingDisplayBoard parkingDisplayBoard;

}

class Gate {

	int gateId;
	ParkingAttendant parkingAttendant;

}

abstract class Entrance extends Gate {

	public abstract ParkingTicket getParkingTicket(Vehicle vehicle);

}

abstract class Exit extends Gate {

	public abstract ParkingTicket payForParking(ParkingTicket parkingTicket, PaymentType paymentType);

}


class Address1 {

	String country;
	String state;
	String city;
	String street;
	String pinCode; //ZipCode
}

class ParkingSpace {
	
	int spaceId;
	boolean isFree;
	double costPerHour;
	Vehicle vehicle;
	ParkingSpaceType parkingSpaceType;

}

abstract class ParkingDisplayBoard {

	Map<ParkingSpaceType, Integer> freeSpotsAvailableMap;

	public abstract void updateFreeSpotsAvailable(ParkingSpaceType parkingSpaceType, int spaces);

}


class Account1 {

	String name;
	String email;
	String password;
	String empId;
	Address address;

}

abstract class Admin1 extends Account {

	public abstract boolean addParkingFloor(ParkingLot parkingLot, ParkingFloor floor);
	public abstract boolean addParkingSpace(ParkingFloor floor, ParkingSpace parkingSpace);
	public abstract boolean addParkingDisplayBoard(ParkingFloor floor, ParkingDisplayBoard parkingDisplayBoard);


}

abstract class ParkingAttendant extends Account {

	Payment paymentService;

	public abstract boolean processVehicleEntry(Vehicle vehicle);
	public abstract PaymentInfo processPayment(ParkingTicket parkingTicket, PaymentType paymentType);

}

class Vehicle {
	
	String licenseNumber;
	VehicleType vehicleType;
	ParkingTicket parkingTicket;
	PaymentInfo paymentInfo;

}

abstract class ParkingTicket {
	
	int ticketId;
	int levelId;
	int spaceId;
	Date vehicleEntryDateTime;
	Date vehicleExitDateTime;
	ParkingSpaceType parkingSpaceType;
	double totalCost;
	ParkingTicketStatus parkingTicketStatus;

	public abstract void updateTotalCost();
	public abstract void updateVehicleExitTime(Date vehicleExitDateTime);

} 

enum PaymentType {

	CASH, CEDIT_CARD, DEBIT_CARD, UPI;
}

enum ParkingSpaceType {
	
	BIKE_PARKING, CAR_PARKING, TRUCK_PARKING

}

abstract class Payment {

	public abstract PaymentInfo makePayment(ParkingTicket parkingTicket, PaymentType paymentType);
}

class PaymentInfo {

	double amount;
	Date paymentDate;
	int transactionId;
	ParkingTicket parkingTicket;
	PaymentStatus paymentStatus;

}

enum VehicleType {
	
	BIKE, CAR, TRUCK;
}

 enum ParkingTicketStatus {
	
	PAID, ACTIVE;
}

 enum PaymentStatus {

	UNPAID, PENDING, COMPLETED, DECLINED, CANCELLED, REFUNDED;

}
/**
 
 Requirements Stack Parking Lot
 ==============================
 
1. There should be multiple floors in the Parking Lot.
2. There should be multiple gates in the Parking Lot.
3. There should be a parking attendant at each gate.
4. The entry gates should process parking ticket.
5. The exit gate should process payment on an hourly basis.
6. The parking lot should have parking facility for different types of vehicles.
7. There should be display boards at each floor showing the details of vacant spots on the floor.


https://www.youtube.com/watch?v=V9NEOLpt3tg&list=PL12BCqE-Lp650Cg6FZW7SoZwN8Rw1WJI7&index=9&ab_channel=SoumyajitBhattacharyay
*/