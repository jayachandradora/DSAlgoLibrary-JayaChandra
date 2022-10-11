package ds.hashing;

import java.util.HashSet;

public class ArraySubset {

	public static void main(String[] args) {

		int [] arr1 = {1,2, 4,10,30,7};
		int [] arr2 = {2,4, 30,7};
		
		if(isArray2SubsetOfArray1(arr1, arr2))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	private static boolean isArray2SubsetOfArray1(int[] arr1, int[] arr2) {
		
		HashSet<Integer> hashSet = new HashSet<>();
		for(int i=0; i<arr1.length; i++){
			if(!hashSet.contains(arr1[i]))
				hashSet.add(arr1[i]);
		}
		for(int i=0; i<arr2.length; i++){
			if(!hashSet.contains(arr2[i]))
				return false;
		}
		return true;
	}

}
