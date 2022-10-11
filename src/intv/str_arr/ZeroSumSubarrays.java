package intv.str_arr;

import java.util.ArrayList;
import java.util.HashMap;

//https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/
public class ZeroSumSubarrays {
	static ArrayList<Pair> findSubArrays(int[] arr, int n) {

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		ArrayList<Pair> out = new ArrayList<>();
		int sum = 0;

		for (int i = 0; i < n; i++) {
			// add current element to sum
			sum += arr[i];

			// if sum is 0, we found a subarray
			if (sum == 0)
				out.add(new Pair(0, i));

			ArrayList<Integer> al = new ArrayList<>();

			// If sum already exists in the map there exists at-least one subarray ending at
			// index i with 0 sum
			if (map.containsKey(sum)) {
				// map[sum] stores starting index of all subarrays
				al = map.get(sum);
				for (int it = 0; it < al.size(); it++) {
					out.add(new Pair(al.get(it) + 1, i));
				}
			}
			al.add(i);
			map.put(sum, al);
		}
		return out;
	}

	// Utility function to print all subarrays with sum 0
	static void print(ArrayList<Pair> out) {
		for (int i = 0; i < out.size(); i++) {
			Pair p = out.get(i);
			System.out.println("Subarray found from Index " + p.first + " to " + p.second);
		}
	}

	// Driver code
	public static void main(String args[]) {
		int[] arr = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
		int n = arr.length;

		ArrayList<Pair> out = findSubArrays(arr, n);

		if (out.size() == 0)
			System.out.println("No subarray exists");
		else
			print(out);
	}
}

class Pair {
	int first, second;

	Pair(int a, int b) {
		first = a;
		second = b;
	}
}
