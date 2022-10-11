package designpattern;

import java.util.HashSet;
import java.util.Set;

public class XOR {

	static int countTriplets(int a[], int n) {
		
		Set<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < n; i++)
			s.add(a[i]);

		int count = 0;

		// traverse for all i, j pairs such that j>i
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int xr = a[i] ^ a[j];
				// if xr of two numbers is present, then increase the count
				if (s.contains(xr) && xr != a[i] && xr != a[j]){
					System.out.print(xr + " ");
					count++;
				}
			}
			
		}
		// returns answer
		return count / 3;
	}

	public static void main(String[] args) {
		int a[] = {1, 3, 5, 10, 14, 15};
		int n = a.length;
		System.out.print(countTriplets(a, n));
	}

}
