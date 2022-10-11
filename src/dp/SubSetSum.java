package dp;

public class SubSetSum {

	public static void main(String[] args) {
		int arr[] = { 2, 4, 1 };
		int sum = 3;
		System.out.println("SubSetSum : " + subsetSum(arr, arr.length, sum)); // SubSetSum : true

		boolean dps[][] = new boolean[arr.length + 1][sum + 1];
		System.out.println("SubSetSum DP: " + subsetSumDP(arr, arr.length, sum, dps)); // SubSetSum : true

		System.out.println("SubSetSum DP Top down: " + subsetSumTopDown(arr, sum)); // SubSetSum : true
	}

	public static boolean subsetSum(int arr[], int n, int sum) {

		if (sum == 0)
			return true;

		if (n == 0 && sum != 0)
			return false;

		if (arr[n - 1] > sum)
			return subsetSum(arr, n - 1, sum);

		return subsetSum(arr, n - 1, sum - arr[n - 1]) || subsetSum(arr, n - 1, sum);
	}

	public static boolean subsetSumDP(int arr[], int n, int sum, boolean dp[][]) {
		if (sum == 0)
			return true;

		if (n == 0 && sum != 0)
			return false;

		if (dp[n][sum] != false)
			return dp[n][sum];

		if (arr[n - 1] > sum)
			return dp[n][sum] = subsetSumDP(arr, n - 1, sum, dp);

		return dp[n][sum] = subsetSumDP(arr, n - 1, sum - arr[n - 1], dp) || subsetSumDP(arr, n - 1, sum, dp);
	}

	public static boolean subsetSumTopDown(int[] A, int sum) {
		int n = A.length;

		boolean[][] T = new boolean[n + 1][sum + 1];

		if (A.length == 0 && sum > 0)
			return false;

		if (sum == 0)
			return true;

		for (int i = 0; i <= n; i++)
			T[i][0] = true;

		for (int i = 1; i <= n; i++) {// consider all sum from 1 to sum
			for (int j = 1; j <= sum; j++) {
				if (A[i - 1] > j)
					T[i][j] = T[i - 1][j];
				else
					T[i][j] = T[i - 1][j] || T[i - 1][j - A[i - 1]];
			}
		}
		return T[n][sum];
	}
}
