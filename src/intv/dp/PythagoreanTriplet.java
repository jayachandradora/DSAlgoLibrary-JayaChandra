package intv.dp;

import java.util.Arrays;

//Given an array of integers, write a function that returns true if there is a triplet (a, b, c)
//that satisfies a2 + b2 = c2.
public class PythagoreanTriplet {

	static boolean isTriplet(int ar[], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					int x = ar[i] * ar[i], y = ar[j] * ar[j], z = ar[k] * ar[k];

					if (x == y + z || y == x + z || z == x + y)
						return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int ar[] = { 3, 1, 4, 6, 5 };
		int ar_size = ar.length;
		if (isTriplet(ar, ar_size) == true)
			System.out.println("Yes");
		else
			System.out.println("No");
		System.out.println(isTripletWithSorting(ar, ar_size));
	}

	static boolean isTripletWithSorting(int arr[], int n) {
		// Square array elements
		for (int i = 0; i < n; i++)
			arr[i] = arr[i] * arr[i];

		Arrays.sort(arr);

		// Now fix one element one by one and find the other two elements
		for (int i = n - 1; i >= 2; i--) {
			int l = 0;
			int r = i - 1; 
			while (l < r) {
				if (arr[l] + arr[r] == arr[i])
					return true;

				// Else either move 'l' or 'r'
				if (arr[l] + arr[r] < arr[i])
					l++;
				else
					r--;
			}
		}
		return false;
	}
}
