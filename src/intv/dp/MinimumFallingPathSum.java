package intv.dp;

//https://www.youtube.com/watch?v=Xr_LRdr9IPQ
public class MinimumFallingPathSum {

	public static void main(String[] args) {

		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(minFallingPathSum(arr));
	}

	static int minFallingPathSum(int arr[][]) {
		int n = arr.length;
		int m = arr[0].length;

		int[][] dp = new int[n][m];
		for (int i = 0; i < m; i++) {
			dp[n - 1][i] = arr[n - 1][i]; // initialize last row 1st step
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				dp[i][j] = arr[i][j];
				int mn = dp[i + 1][j]; // initialize the down cell 2nd step

				if (j + 1 < m) // down right cell 3rd step
					mn = Math.min(mn, dp[i + 1][j + 1]);
				if (j - 1 >= 0) 
					mn = Math.min(mn, dp[i + 1][j - 1]); //down left cell 4th step

				dp[i][j] = dp[i][j] + mn;
			}
		}

		int res = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++)
			res = Math.min(dp[0][i], res); // 5th step for final result of 1st row

		return res;
	}

}
