package dp;

public class EqualSumPartition {

	public static void main(String[] args) {

		int arr[] = { 1, 5, 11, 5 };
		int totalSum = 0;
		for (int in : arr)
			totalSum += in;
		boolean dp[][] = new boolean[arr.length + 1][totalSum / 2 + 1];
		if (totalSum % 2 != 0)
			System.out.println("false");
		else
			System.out.println(isSubsetSum(arr, totalSum / 2, arr.length, dp));

	}

	static boolean equalSumPartition(int arr[], int sum, int n, boolean dp[][]) {

		if (sum == 0)
			return true;
		if (arr.length == 0 && sum != 0)
			return false;

		if (dp[n][sum] != false)
			return true;

		if (arr[n - 1] > sum)
			return dp[n][sum] = equalSumPartition(arr, sum, n - 1, dp);
		else
			return dp[n][sum] = equalSumPartition(arr, sum - arr[n - 1], n - 1, dp)
					|| equalSumPartition(arr, sum, n - 1, dp);
	}

	
	// Free time correct this 
	public static boolean isSubsetSum(int nums[], int n, int sum, boolean dp[][]) {

		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = true;
				else if (nums[i - 1] >= j)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
			}
		}
		
		return dp[n][sum];
	}
}
