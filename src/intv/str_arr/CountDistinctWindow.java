package intv.str_arr;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctWindow {
	static void countDistinct(int arr[], int k) {

		Map<Integer, Integer> hM = new HashMap<Integer, Integer>();
		for (int i = 0; i < k; i++)
			hM.put(arr[i], hM.getOrDefault(arr[i], 0) + 1);

		System.out.println(hM.size());//print 1st distinct number

		for (int i = k; i < arr.length; i++) {
			// Remove first element of previous window If there was only one occurrence
			if (hM.get(arr[i - k]) == 1)
				hM.remove(arr[i - k]);
			else // reduce count of the removed element
				hM.put(arr[i - k], hM.get(arr[i - k]) - 1);

			// Add new element of current window
			hM.put(arr[i], hM.getOrDefault(arr[i], 0) + 1);
			System.out.println(hM.size());
		}
	}

	// Driver method
	public static void main(String arg[]) {
		int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
		int k = 4;
		countDistinct(arr, k);
	}
}
