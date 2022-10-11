package hashing;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayToReduced {

	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		int arr[] = { 10, 30, 20 };
		int temp[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
			temp[i] = arr[i];

		Arrays.sort(temp);
		
		for (int i : temp)
			System.out.println(i);
		for (int i : temp)
			hs.add(i);

		int j = 0;
		for (int i=0; i<arr.length; i++){
			//arr[i] = 
			//System.out.println(i);
			
			/// not completed this problem
		}
	}

}
