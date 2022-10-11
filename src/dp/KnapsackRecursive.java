
package dp;

import java.util.Arrays;

public class KnapsackRecursive {

	public static void main(String[] args) {

		int val[] = { 60, 100, 120 };
		int wt[] = { 10, 20, 30 };
		int W = 50;
		System.out.println("0-1 Knapsack max weight : " + knapsackRecursive(val, wt, W, val.length));

		int dp2[][] = new int[val.length + 1][W + 1];

		for (int d[] : dp2)
			Arrays.fill(d, -1);

		System.out.println("0-1 Knapsack max weight DP: " + knapsackDP(val, wt, W, val.length, dp2));

		int val1[] = { 2, 4, 5 };
		int wt1[] = { 1, 3, 2 };
		int W1 = 4;
		System.out.println("0-1 Knapsack max weight Top Down: " + knapSackTopDown1(W1, wt1, val1, val1.length)); // OutPut
																													// 7
	}

	public static int knapsackRecursive(int iVal[], int iWt[], int bgWeight, int n) {
		if (n == 0 || bgWeight == 0)
			return 0;

		if (iWt[n - 1] > bgWeight)
			return knapsackRecursive(iVal, iWt, bgWeight, n - 1);
		else
			return Math.max(iVal[n - 1] + knapsackRecursive(iVal, iWt, bgWeight - iWt[n - 1], n - 1),
					knapsackRecursive(iVal, iWt, bgWeight, n - 1));
	}

	static int knapSackTopDown1(int W, int wt[], int val[], int n) {
		int i, j;
		int dp[][] = new int[n + 1][W + 1];

		for (i = 0; i <= n; i++) {
			for (j = 0; j <= W; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
			}
		}

		for (i = 1; i <= n; i++) {
			for (j = 1; j <= W; j++) {
				if (wt[i - 1] > j)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
			}
		}
		return dp[n][W];
	}

	public static int knapsackDP(int iVal[], int iWt[], int bgWeight, int n, int dp[][]) {
		if (n == 0 || bgWeight == 0)
			return 0;

		if (dp[n][bgWeight] != -1)
			return dp[n][bgWeight];

		if (iWt[n - 1] > bgWeight)
			return dp[n][bgWeight] = knapsackDP(iVal, iWt, bgWeight, n - 1, dp);
		else
			return dp[n][bgWeight] = Math.max(iVal[n - 1] + knapsackDP(iVal, iWt, bgWeight - iWt[n - 1], n - 1, dp),
					knapsackDP(iVal, iWt, bgWeight, n - 1, dp));
	}

	static int knapSackTopDown(int W, int wt[], int val[], int n) {
		int i, j;
		int t[][] = new int[n + 1][W + 1];

		for (i = 0; i <= n; i++) {
			for (j = 0; j <= W; j++) {
				if (i == 0 || j == 0)
					t[i][j] = 0;
				else if (wt[i - 1] >= j)
					t[i][j] = t[i - 1][j];
				else
					t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);

			}
		}
		return t[n][W];
	}

}
