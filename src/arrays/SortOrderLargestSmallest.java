package arrays;

import java.util.Arrays;

public class SortOrderLargestSmallest {

	public static void main(String[] args) {

		int arr[] = {5, 8, 1, 4, 2, 9, 3, 7, 6};
		Arrays.sort(arr);
		
		for(int i : arr )
			System.out.print(i + " ");
		
		System.out.println("Greater and smaller");
		
		int temp, k =-1;
		for(int j =0; j<arr.length/2; ){
			k = k+2;
			temp = arr[k];
			arr[k] = arr[arr.length-1-j];
			arr[arr.length-1-j] = temp;
			j++;
			
			/*if(arr[arr.length-1]< arr[k]){
				temp = arr[k];
				arr[k] = arr[arr.length-1];
				arr[arr.length-1] = temp;
			}*/
		}
		for(int l : arr )
			System.out.print(l + " ");
	}

}
