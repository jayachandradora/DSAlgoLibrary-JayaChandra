package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TestJP {


	public static void main(String[] args) {
		
		
		
		int arr[] = { 1, 2, 2, 0, 10, 2, 0, 10, 22, 8 };
		
		
		Map<Integer, Integer> freq = new TreeMap<>();
		for (int i : arr) 
			freq.put(i, freq.getOrDefault(i, 0) + 1);

		int i = 0;
		for (Entry<Integer, Integer> entry : freq.entrySet()) {
			int value = entry.getValue();
			while (value-- > 0) {
				arr[i++] = entry.getKey();
			}
		}

		System.out.println(Arrays.toString(arr));
		
		int arr1[] = { 1, 2, 2, 0, 10, 2, 0, 10, 22, 8 };
		System.out.println(Arrays.toString(customSort(arr1)));
	}

	public static final int RANGE = 100;
	public static int[] customSort(int[] arr) {
		int[] freq = new int[RANGE];
		for (int i : arr) 
			freq[i]++;

		int k = 0;
		for (int i = 0; i < RANGE; i++) {
			while (freq[i]-- > 0) {
				arr[k++] = i;
			}
		}
		
		return arr;
	}
}

class SingleTon {
	private static SingleTon getInstance = null;

	private SingleTon() {
	}

	public static SingleTon getInstance() {

		if (getInstance == null) {
			synchronized (SingleTon.class) {
				if (getInstance == null)
					getInstance = new SingleTon();
			}
		}
		return getInstance;

		// "JayaChandra".substring("");
	}

	// select empid, disticnt sal from employee order by sal desc where rownum = 2;

}
