package intv.str_arr;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {

		int nums[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(happyNumber(20));
		System.out.println(maxSubArray(nums));

		int arr[] = { 1, 12, -5, -6, 50, 3 };
		System.out.println(findMaxAverage(arr, 4));
		
	}
	
	static boolean happyNumber(int num) {
		Set<Integer> seen = new HashSet<Integer>();
		while (!seen.contains(num)) {

			seen.add(num);
			int sum = 0;
			while (num > 0) {
				sum += (num % 10) * (num % 10);
				num = num / 10;
			}
			num = sum;
		}
		return seen.contains(1);
	}

	// The idea is to keep adding each integer to the sequence until the sum drops
	// below 0. If sum is negative, then we should reset the sequence.
	static int maxSubArray(int[] A) {
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;

		for (int n : A) {
			sum = Math.max(n, sum + n);
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}

	static double findMaxAverage(int[] nums, int k) {
		double sum = 0;

		for (int i = 0; i < k; i++)
			sum += nums[i];

		double res = sum;

		for (int i = k; i < nums.length; i++) {
			sum += nums[i] - nums[i - k];
			res = Math.max(res, sum);
		}
		return res / k;
	}

	
}
