package dp;

class EqualSubsetSumPartition {
	static boolean isSubsetSum(int arr[], int n, int sum, boolean dp[][]) {
		if (sum == 0)
			return true;
		if (n == 0 && sum != 0)
			return false;
		
		if(dp[n][sum] == true)
			return dp[n][sum];

		if (arr[n - 1] > sum)
			return isSubsetSum(arr, n - 1, sum, dp);

		return isSubsetSum(arr, n - 1, sum, dp) || isSubsetSum(arr, n - 1, sum - arr[n - 1], dp);
	}

	static boolean findPartition(int arr[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];

		if (sum % 2 != 0)
			return false;

		boolean dp[][] = new boolean[n +1][sum/2 + 1];
		return isSubsetSum(arr, n, sum / 2, dp);
	}

	public static void main(String[] args) {

		int arr[] = { 1, 5, 5, 11};
		int n = arr.length;
		
		if (findPartition(arr, n) == true)
			System.out.println("Can be divided into two " + "subsets of equal sum");
		else
			System.out.println("Can not be divided into " + "two subsets of equal sum");
	}
}
