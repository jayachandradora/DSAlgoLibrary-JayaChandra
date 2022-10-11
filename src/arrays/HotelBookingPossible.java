package arrays;

import java.util.ArrayList;
import java.util.Collections;

public class HotelBookingPossible {

	public static void main(String[] args) {

		ArrayList<Integer> arrive = new ArrayList<Integer>();
		arrive.add(1);
		arrive.add(3);
		arrive.add(6);
		
		ArrayList<Integer> depart  = new ArrayList<Integer>();
		depart.add(2);
		depart.add(6);
		depart.add(8);
		
		int K = 1;
		System.out.println(hotel(arrive, depart, K));

	}

	static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {

		Collections.sort(arrive);
		Collections.sort(depart);

		int i = 0;
		int j = 0;

		while (i < arrive.size() && j < depart.size()) {
			if (arrive.get(i) < depart.get(j)) {
				i++;
				K--;
			} else if (arrive.get(i) == depart.get(j)) {
				i++;
				j++;
			} else {
				j++;
				K++;
			}

			if (K < 0)
				return false;
		}
		return true;
	}

}
