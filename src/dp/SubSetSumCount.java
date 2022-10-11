package dp;

public class SubSetSumCount {

	public static void main(String[] args) {
		int arr1[] = { 2, 3, 5, 6, 8, 10 };
		int sum1 = 10;
		System.out.println("subset_count dp : " + subset_count_dp(arr1, sum1, arr1.length)); // subset_count dp : 3
		
		int arr[] = {1,1,1,1,1}, sum =3;
		System.out.println("subset_count Rec " + subset_count(arr, sum, arr.length));
		
		System.out.println("countSubsetSumTopDown " + countSubsetSumTopDown(arr, sum));
	}

	static int subset_count(int arr[], int sum, int n) {
		if (sum == 0)
			return 1;
		if (n == 0)
			return 0;
		else {
			if (arr[n - 1] > sum)
				return subset_count(arr, sum, n - 1);
			else {
				return subset_count(arr, sum, n - 1) + subset_count(arr, sum - arr[n - 1], n - 1);
			}
		}
	}

	static int count[][] = new int[7][11];

	static int subset_count_dp(int arr[], int sum, int n) {
		if (sum == 0)
			return 1;
		if (n == 0)
			return 0;
		if (count[n][sum] != 0)
			return count[n][sum];

		else {
			if (arr[n - 1] > sum)
				return subset_count_dp(arr, sum, n - 1);
			else {
				return count[n][sum] = subset_count_dp(arr, sum, n - 1) + subset_count_dp(arr, sum - arr[n - 1], n - 1);
			}
		}
	}
	
	public static int countSubsetSumTopDown(int[] A, int sum) {
		int n = A.length;

		int[][] T = new int[n + 1][sum + 1];

		if (A.length == 0 && sum > 0)
			return 0;

		if (sum == 0)
			return 1;

		for (int i = 0; i <= n; i++)
			T[i][0] = 1;

		for (int i = 1; i <= n; i++) {// consider all sum from 1 to sum
			for (int j = 1; j <= sum; j++) {
				if (A[i - 1] > j)
					T[i][j] = T[i - 1][j];
				else
					T[i][j] = T[i - 1][j] + T[i - 1][j - A[i - 1]];
			}
		}
		return T[n][sum];
	}
}
