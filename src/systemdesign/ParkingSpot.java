package systemdesign;

import java.util.ArrayList;

public class ParkingSpot {
	private Vehicle vehicle;
	private VehicleSize spotSize;
	private int row;
	private int spotNumber;
	private Level level;

	public ParkingSpot(Level lvl, int r, int n, VehicleSize s) {
		/** STMT */
	}

	public boolean isAvailable() {
		return vehicle == null;
	}

	/* Check if the spot is big enough and is available */
	public boolean canFitVehicle(Vehicle vehicle) {
		/** STMT */
		return true;
	}

	/* Park vehicle in this spot. */
	public boolean park(Vehicle v) {
		/** STMT */
		return true;
	}

	public int getRow() {
		return row;
	}

	public int getSpotNumber() {
		return spotNumber;
	}

	/*
	 * Remove vehicle from spot, and notify level that a new spot is available
	 */
	public void removeVehicle() {
		/** STMT */
	}
}

// Vehicle and its inherited classes.
enum VehicleSize {
	Motorcycle, Compact, Large
}

abstract class Vehicle {
	protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
	protected String licensePlate;
	protected int spotsNeeded;
	protected VehicleSize size;

	public int getSpotsNeeded() {
		return spotsNeeded;
	}

	public VehicleSize getSize() {
		return size;
	}

	/*
	 * Park vehicle in this spot (among others, potentially)
	 */
	public void parkinSpot(ParkingSpot s) {
		parkingSpots.add(s);
	}

	/*
	 * Remove vehicle from spot, and notify spot that it's gone
	 */
	public void clearSpots() {
		/** STMT */
	}

	/*
	 * Checks if the spot is big enough for the vehicle (and is available). This
	 * * compares the SIZE only.It does not check if it has enough spots.
	 */
	public abstract boolean canFitinSpot(ParkingSpot spot);
}

class Bus extends Vehicle {
	public Bus() {
		spotsNeeded = 5;
		size = VehicleSize.Large;
	}

	/*
	 * Checks if the spot is a Large. Doesn't check num of spots
	 */
	public boolean canFitinSpot(ParkingSpot spot) {
		/** STMT */
		return true;
	}
}

class Car extends Vehicle {
	public Car() {
		spotsNeeded = 1;
		size = VehicleSize.Compact;
	}

	/* Checks if the spot is a Compact or a Large. */
	public boolean canFitinSpot(ParkingSpot spot) {
		/** STMT */
		return true;
	}
}

class Motorcycle extends Vehicle {
	public Motorcycle() {
		spotsNeeded = 1;
		size = VehicleSize.Motorcycle;
	}

	public boolean canFitinSpot(ParkingSpot spot) {
		/** STMT */
		return true;
	}
}

class Level {

	/**
Solution: For our purposes right now, we’ll make the following assumptions. 
We made these specific assumptions to add a bit of complexity to the problem 
without adding too much. If you made different assumptions, that’s totally fine.
1) The parking lot has multiple levels. Each level has multiple rows of spots.
2) The parking lot can park motorcycles, cars, and buses.
3) The parking lot has motorcycle spots, compact spots, and large spots.
4) A motorcycle can park in any spot.
5) A car can park in either a single compact spot or a single large spot.
6) A bus can park in five large spots that are consecutive and within the 
same row. It cannot park in small spots.
	 */
}