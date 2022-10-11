package intv.str_arr;

import java.util.HashMap;
import java.util.Map;

public class PushZerosToEnd {

	public static void main(String[] args) {
		int arr[] = { 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9 };
		int n = arr.length;
		pushZerosToEnd(arr, n);
		System.out.println("Array after pushing zeros to the back: ");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");

		System.out.println();
		int arr1[] = { 1, 9, 8, 4, 0, 0, 2 };

		for (int i : fastZeorsThenOnces(arr1))
			System.out.print(i + " ");
		
	}

	static void pushZerosToEnd(int[] arr, int n) {

		int counter = 0;
		for (int i = 0; i < n; i++)
			if (arr[i] != 0)
				arr[counter++] = arr[i];

		while (counter < n)
			arr[counter++] = 0;
	}

	// This soln will work all the use cases
	private static int[] fastZeorsThenOnces(int[] arr) {
		int k = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				int temp = arr[i];
				arr[i] = arr[k];
				arr[k] = temp;
				k++;
			}
		}
		return arr;
	}	
}
