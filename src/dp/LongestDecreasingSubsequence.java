package dp;

import java.util.Arrays;
//https://www.techiedelight.com/longest-decreasing-subsequence-problem/
public class LongestDecreasingSubsequence {

	public static int LDS(int[] A, int i, int n, int prev) {
		if (i == n) {
			return 0;
		}

		// case 1: exclude the current element and process the remaining elements
		int excl = LDS(A, i + 1, n, prev);

		// case 2: include the current element if it is smaller than previous element in
		// LDS
		int incl = 0;
		if (A[i] < prev) {
			incl = 1 + LDS(A, i + 1, n, A[i]);
		}

		// return maximum of above two choices
		return Integer.max(incl, excl);
	}

	public static void main(String[] args) {
		int[] A = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

		System.out.println("Length of LDS is " + LDS(A, 0, A.length, Integer.MAX_VALUE));
	}

	public static int LDS(int[] A) {
		// array to store sub-problem solution. L[i] stores the length
		// of the longest decreasing subsequence ends with A[i]
		int[] L = new int[A.length];

		// longest decreasing subsequence ending with A[0] has length 1
		L[0] = 1;

		// start from second element in the array
		for (int i = 1; i < A.length; i++) {
			// do for each element in subarray A[0..i-1]
			for (int j = 0; j < i; j++) {
				// find longest decreasing subsequence that ends with A[j]
				// where A[j] is more than the current element A[i]

				if (A[j] > A[i] && L[j] > L[i]) {
					L[i] = L[j];
				}
			}

			// include A[i] in LDS
			L[i]++;
		}

		// return longest decreasing subsequence (having maximum length)
		return Arrays.stream(L).max().getAsInt();
	}

	static int lds(int arr[], int n) {
		int lds[] = new int[n];
		int i, j, max = 0;

		for (i = 0; i < n; i++)
			lds[i] = 1;

		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i] < arr[j] && lds[i] < lds[j] + 1)
					lds[i] = lds[j] + 1;

		for (i = 0; i < n; i++)
			if (max < lds[i])
				max = lds[i];
		return max;
	}
}
