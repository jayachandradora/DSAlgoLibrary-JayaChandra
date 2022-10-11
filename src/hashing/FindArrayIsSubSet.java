package hashing;

import java.util.HashSet;

public class FindArrayIsSubSet {

	public static boolean isSubsetArray(int arr[], int m, int n, int arr2[]) {

		HashSet hs = new HashSet<>();

		for (int i = 0; i < n; i++)
			if (!hs.contains(arr[i]))
				hs.add(arr[i]);

		for (int i = 0; i < m; i++)
			if (!hs.contains(arr2[i]))
				return false;
		return true;
	}

	public static void main(String[] args) {
		int arr1[] = { 11, 1, 13, 21, 3, 7 };
		int arr2[] = { 11, 3, 7, 1 };

		int m = arr1.length;
		int n = arr2.length;

		if (isSubsetArray(arr1, n, m, arr2))
			System.out.println("arr2 is a subset of arr1");
		else
			System.out.println("arr2 is not a subset of arr1");

	}

}
