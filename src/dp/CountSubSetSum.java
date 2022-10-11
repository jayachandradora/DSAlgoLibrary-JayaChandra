package dp;

public class CountSubSetSum {

	public static void main(String[] args) {
		int arr[] = { 2, 4, 1 };
		int sum = 3;

		int dps[][] = new int[arr.length + 1][sum + 1];
		System.out.println("SubSetSum DP: " + countSubsetSumDP(arr, arr.length, sum, dps)); // SubSetSum : true

		System.out.println("SubSetSum DP Top down: " + countSubsetSumTopDown(arr, sum)); // SubSetSum : true

		int nums[] = {4,3,2,3,5,2,1};
		int sum1 = 5;
		System.out.println("Count subset sum " + countSubsetSum(nums, nums.length, sum1));
	}

	public static int countSubsetSum(int arr[], int n, int sum) {

		if (sum == 0)
			return 1;

		if (n == 0 && sum != 0)
			return 0;

		if (arr[n - 1] > sum)
			return countSubsetSum(arr, n - 1, sum);

		return countSubsetSum(arr, n - 1, sum - arr[n - 1]) + countSubsetSum(arr, n - 1, sum);
	}

	public static int countSubsetSumDP(int arr[], int n, int sum, int dp[][]) {
		if (sum == 0)
			return 1;

		if (n == 0 && sum != 0)
			return 0;

		if (dp[n][sum] != 0)
			return 1;

		if (arr[n - 1] > sum)
			return dp[n][sum] = countSubsetSumDP(arr, n - 1, sum, dp);

		return dp[n][sum] = countSubsetSumDP(arr, n - 1, sum - arr[n - 1], dp) + countSubsetSumDP(arr, n - 1, sum, dp);
	}

	public static int countSubsetSumTopDown(int[] A, int sum) {
		int n = A.length;

		int[][] dp = new int[n + 1][sum + 1];

		if (A.length == 0 && sum > 0)
			return 0;

		if (sum == 0)
			return 1;

		for (int i = 0; i <= n; i++)
			dp[i][0] = 1;

		for (int i = 1; i <= n; i++) {// consider all sum from 1 to sum
			for (int j = 1; j <= sum; j++) {
				if (A[i - 1] > j)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - A[i - 1]];
			}
		}
		return dp[n][sum];
	}

	//Another approach // https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x-using-recursion/
	static int subsetSum(int arr[], int n, int i, int sum, int count) {
		if (i == n) { //all the value checked

			if (sum == 0) 
				count++;
			
			return count;
		}

		count = subsetSum(arr, n, i + 1, sum - arr[i], count);
		count = subsetSum(arr, n, i + 1, sum, count);
		return count;
	}
}
