package intv.str_arr;

public class MaximumSumSubArray {

	public static void main(String[] args) {
		int A[] = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(A));
	}

	// Dynamic Programming Time complexity: O(n) space Complexity: O(n)
	public static int maxSubArray(int[] A) {
		int[] dp = new int[A.length]; // dp[i] is the maximum subarray ending with A[i];
		int maxSum = dp[0] = A[0];

		for (int i = 1; i < A.length; i++) {
			dp[i] = Math.max(A[i], dp[i - 1] + A[i]);
			maxSum = Math.max(maxSum, dp[i]);
		}
		return maxSum;
	}
}
