package intv.str_arr;

import java.util.Arrays;

//https://www.techiedelight.com/maximum-sum-circular-subarray/
public class LargestSumCircularSubarray {

	// Function to find contiguous sub-array with the largest sum in given set of integers
	public static int kadane(int[] A) {
		int max_so_far = 0;
		int max_ending_here = 0;

		for (int value : A) {
			// update maximum sum of sub-array "ending" at index i (by adding
			// current element to maximum sum ending at previous index i-1)
			max_ending_here = max_ending_here + value;

			// if maximum sum is negative, set it to 0 (which represents
			// an empty sub-array)
			max_ending_here = Integer.max(max_ending_here, 0);

			// update result if current sub-array sum is found to be greater
			max_so_far = Integer.max(max_so_far, max_ending_here);
		}

		return max_so_far;
	}

	// Function to find maximum sum circular subarray in a given array
	public static int KadaneCircular(int[] A) {
		// negate all elements of the array
		Arrays.setAll(A, i -> -A[i]);

		// run Kadane's algorithm on modified array
		int negMaxSum = kadane(A);

		// restore the array
		Arrays.setAll(A, i -> -A[i]);

		/*
		 * return maximum of
		 * 1. sum returned by Kadane's algorithm on original array.
		 * 2. sum returned by Kadane's algorithm on modified array + sum of all elements of the array.
		 */

		return Integer.max(kadane(A), Arrays.stream(A).sum() + negMaxSum);
	}

	public static void main(String[] args) {
		int[] A = { 2, 1, -5, 4, -3, 1, -3, 4, -1 };

		System.out.println("The sum of subarray with the largest sum is " + KadaneCircular(A));
	}
}
