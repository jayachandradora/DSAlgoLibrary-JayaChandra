package intv.dp;

import java.util.Arrays;

public class LIS {

	public static void main(String[] args) {

		int numsSol[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(lengthOfLISSol(numsSol));
		
		int a[] = { 1, 3, 4, 2, 6, 5, 9, 7 };
		System.out.println(LIS.lisLength(a));

		int nums[] = { 3, 10, 2, 1, 20 };
		System.out.println(lengthOfLIS(nums));

		int dp[][] = new int[nums.length][nums.length];

		int len = nums.length - 1;
		System.out.println("JD Solution " + LIS(nums, len - 1, len, dp));
		// Explore this link
		// https://www.educative.io/edpresso/the-longest-increasing-subsequence-problem
	}

	public static int lengthOfLISSol(int[] nums) {
		int dp[] = new int[nums.length];
		if (nums.length <= 1)
			return nums.length;

		Arrays.fill(dp, 1);
		int max = -1;

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	// JD's Wrong solution please explore.. TODO
	public static int LIS(int arr[], int n, int len, int dp[][]) {

		if (len == 0 || n == -1)
			return 0;

		if (len == 1)
			return 1;

		if (dp[n][len] != 0)
			return dp[n][len];

		if (arr[len] > arr[n])
			return dp[n][len] = LIS(arr, n, len - 1, dp) + 1;

		return dp[n][len] = Math.max(LIS(arr, n - 1, len, dp), LIS(arr, n, len - 1, dp));
	}

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

	// https://www.youtube.com/watch?v=SHFyIAnjj90
	public static int lengthOfLIS(int[] nums) {
		int dp[][] = new int[nums.length][nums.length];
		return LisTopDown(-1, 0, nums, dp);
	}

	private static int LisRec(int prev, int curr, int nums[]) {
		if (curr == nums.length)
			return 0;

		int op1 = 0;
		if (prev == -1 || nums[prev] < nums[curr])
			op1 = 1 + LisRec(curr, curr + 1, nums);

		int op2 = LisRec(prev, curr + 1, nums);

		return Math.max(op1, op2);
	}

	private static int LisTopDown(int prev, int curr, int nums[], int dp[][]) {
		if (curr == nums.length)
			return 0;

		if (prev != -1 && dp[prev][curr] != 0)
			return dp[prev][curr];

		int op1 = 0;
		if (prev == -1 || nums[prev] < nums[curr]) {
			op1 = 1 + LisTopDown(curr, curr + 1, nums, dp);
		}
		int op2 = LisTopDown(prev, curr + 1, nums, dp);

		if (prev != -1)
			dp[prev][curr] = Math.max(op1, op2);

		return Math.max(op1, op2);
	}

}
