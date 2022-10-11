package matrix.vision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//https://leetcode.com/discuss/interview-question/650066/Minimum-Parking-Space
public class MinimalParkingSpaces {

	public static void main(String[] args) {

		int arr[][] = { {0,10},{5,20}};
		System.out.println(minParkingSpaces(arr));
	}

	static int minParkingSpaces(int[][] parkingStartEndTimes) {

		int result = 0;
		int count = 0;
		List<ParkingRecord> parkingRecords = new ArrayList<>();
		
		for (int i = 0; i < parkingStartEndTimes.length; i++) {
			parkingRecords.add(new ParkingRecord(parkingStartEndTimes[i][0], true));
			parkingRecords.add(new ParkingRecord(parkingStartEndTimes[i][1], false));
		}
		
		Collections.sort(parkingRecords, (o1, o2) -> o1.parkingStartEndTimes - o2.parkingStartEndTimes);
		
		for (ParkingRecord pr : parkingRecords) {
			if (pr.arrived) {
				count++;
				result = Math.max(result, count);
			} else {
				count--;
			}
		}
		return result;
	}
}
class ParkingRecord {

	public boolean arrived;
	int parkingStartEndTimes;

	public ParkingRecord() {
	}

	public ParkingRecord(int parkingStartEndTimes, boolean b) {
		this.arrived = b;
		this.parkingStartEndTimes = parkingStartEndTimes;
	}
	
	

}
