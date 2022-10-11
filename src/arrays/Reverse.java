package arrays;

import java.util.Arrays;

public class Reverse {

	public static void main(String[] args) {

		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		int[] arr = {10,11,13,20,25,33};
		
		int arrLength = numbers.length;
		
		reverseArrayWithRecursion(numbers, 0, arrLength-1);
		printArray(numbers);
		
		reverseArraySimpleManner(arr);
		printArray(arr);
		

	}

	static void reverseArrayWithRecursion(int arr[], int start, int end){
		int temp;
		if(start>=end)
			return;
		else{
			temp = arr[end];
			arr[end] = arr[start];
			arr[start] = temp;
			reverseArrayWithRecursion(arr, start+1, end-1);
		}
	}
	
	//simpe array reverse
	static void reverseArraySimpleManner(int arr[]){
		int temp;
		for(int i=0; i<arr.length/2; i++){
			temp = arr[arr.length -1 -i];
			arr[arr.length-1 -i] = arr[i];
			arr[i] = temp;
		}
		System.out.print("Print Reverse Arry: ");
	}
	
	static void printArray(int arr[] ){
		for(int i=0; i<arr.length;i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
	}
	static void check2EqualArrays(int[] arr1, int[] arr2) {
		System.out.println(Arrays.equals(arr1, arr2));
	}
	
	//Its not working
	static void arraysContainsValue(int[] arr, int val) {
		System.out.println(Arrays.asList(arr).contains(new Integer(val)));
	}

	public static int removeDuplicateElements(int arr[], int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int[] temp = new int[n];
		int j = 0;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				temp[j++] = arr[i];
			}
		}
		temp[j++] = arr[n - 1];
		// Changing original array
		for (int i = 0; i < j; i++) {
			arr[i] = temp[i];
		}
		return j;
	}

}
