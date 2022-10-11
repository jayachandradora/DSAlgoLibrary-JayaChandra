package intv.dp;

import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 101, 2, 3, 100, 4, 5 };
		int n = arr.length;
		System.out.println("Sum of maximum sum " + "increasing subsequence is " + maxSumIS(arr, n));
	}

	static int maxSumIS(int arr[], int n) {
		int i, j, max = 0;
		int msis[] = new int[n];

		/* Initialize msis values for all indexes */
		for (i = 0; i < n; i++)
			msis[i] = arr[i];
		
		/* Compute maximum sum values in bottom up manner */
		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i])
					msis[i] = msis[j] + arr[i];

		/* Pick maximum of all msis values */
		for (i = 0; i < n; i++)
			if (max < msis[i])
				max = msis[i];

		return max;
	}
	//This is Longest Increasing Subsequence length
	public static int lisLength(int[] a) {

		int[] lis = new int[a.length];

		Arrays.fill(lis, 1);
		int maxLisLength = 1;

		for (int i = 1; i < lis.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j] && 1 + lis[j] > lis[i]) {
					lis[i] = lis[j] + 1;

					maxLisLength = Math.max(maxLisLength, lis[i]);
				}
			}
		}
		return maxLisLength;
	}
}
