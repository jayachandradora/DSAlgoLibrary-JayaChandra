package arrays;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

	public static void main(String[] args) {

		/*int arr[] = { 4, 1, 2, 1, 2 };
		Map<Integer, Integer> map = new HashMap<>();

		for (int in : arr)
			map.put(in, map.getOrDefault(in, 0) + 1);

		for (int in : map.keySet())
			if (map.get(in) == 1)
				System.out.println("Single Number " + in);*/

		int arr1[] = { 4, 4, 2, 1, 2, 3, 3 };

		System.out.println(singleNumber(arr1));
		System.out.println(and(3, 5));
	}

	static int singleNumber(int arr[]) {

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum ^ arr[i];
		}

		return sum;
	}

	
	static int and(int a , int b) {
		return a | b;
	}
}
