package dp;

//Count the number of subset with a given difference
//arr={1,1,2,3} diff=1 	 
/*
Basically s1-s2 = diff  equation 1
and s1+s2 = sum   equation 2
This gives 2s1 = sum+diff => s1 = (sum+diff)/2
So, if (sum+diff) is even then only finding s1 is possible.
*/
public class CountNumberSubsetGivenDifference {

	// Same as Target Sum... https://leetcode.com/problems/target-sum/
	public static void main(String[] args) {

		int arr[] = { 1, 1, 2, 3 };
		int diff = 1;

		int sumOfArr = 0;
		for (int in : arr)
			sumOfArr += in;

		int sumOfSbuset1 = (diff + sumOfArr) / 2;
		System.out.println(countSubsetSum(arr, arr.length, sumOfSbuset1));
		System.out.println("countSubSetSubTopDown " + countSubSetSubTopDown(arr, sumOfSbuset1, arr.length));

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

	public static int countSubSetSubTopDown(int arr[], int sum, int n) {
		if (sum == 0)
			return 1;

		if (n == 0)
			return 0;

		int dp[][] = new int[n + 1][sum + 1];

		for (int i = 0; i <= n; i++)
			dp[i][0] = 1;

		for (int i = 1; i <= n; i++)
			for (int j = 0; j <= sum; j++)
				if (arr[i - 1] > j)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];

		return dp[n][sum];
	}
}
