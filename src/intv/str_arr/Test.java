package intv.str_arr;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		int arr[] = { -1, 2, 9};
		int k = 2;
		System.out.println(subarraySumDivisibleByK(arr, k));
	}

	static int subarraySumDivisibleByK(int arr[], int k) {
		int num = 0;

		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			int rem = sum % k;
			
			if(rem < 0)
				rem = rem + k;
			
			if (map.containsKey(rem)) {
				num = num + map.get(rem);
			}
			map.put(rem, map.getOrDefault(rem, 0) + 1);
		}

		return num;
	}

}
