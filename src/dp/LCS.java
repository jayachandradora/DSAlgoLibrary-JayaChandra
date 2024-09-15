package dp;

import java.util.Arrays;

public class LCS {

	public static void main(String[] args) {
		String s1 = "leetcode";
		String s2 = "etco";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("LCS : length " + lcs(X, Y, m, n)); // LCS : length 4

		int dp[][] = new int[100][100];
		for (int d[] : dp)
			Arrays.fill(d, -1);

		System.out.println("LCM DP : length " + lcs_dp(X, Y, m, n, dp)); // LCM DP : length 4

		for (int d[] : dp)
			for (int i : d)
				if (i != -1)
					System.out.print(" " + i + " ");

		int dp1[][] = new int[100][100];
		for (int d[] : dp1)
			Arrays.fill(d, -1);
		s1 = "abcdxyz";
		s2 = "abzabcd";

		char[] X1 = s1.toCharArray();
		char[] Y1 = s2.toCharArray();
		int m1 = X1.length;
		int n1 = Y1.length;
		System.out.println("lc_substring_dp lenght: " + lc_substring_dp(X1, Y1, m1, n1, dp1));
		
		System.out.println("LCS : length " + lcs_topdown(X, Y, m, n)); // LCS : length 4
		
		String x = "ABCHHHHHH";
		String y = "ABCKKKKKJ";

		char[] x1 = x.toCharArray();
		char[] y1 = y.toCharArray();
		int m11 = x1.length;
		int n11 = y1.length;
		System.out.println("lc_substring_topdown lenght: " + lc_substring_topdown(x1, y1, m11, n11));
	}

	static int lcs(char[] X, char[] Y, int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		if (X[m - 1] == Y[n - 1]) 
			return 1 + lcs(X, Y, m - 1, n - 1);
		else
			return Math.max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n));
	}

	static int lcs_dp(char[] X, char[] Y, int m, int n, int dp[][]) {
		if (m == 0 || n == 0)
			return 0;

		if (dp[n][m] != -1)
			return dp[n][m];

		if (X[m - 1] == Y[n - 1])
			return dp[n][m] = 1 + lcs_dp(X, Y, m - 1, n - 1, dp);
		else
			return dp[n][m] = Math.max(lcs_dp(X, Y, m, n - 1, dp), lcs_dp(X, Y, m - 1, n, dp));
	}
	
	static int lcs_topdown(char[] x, char[] y, int m, int n) {

		int t[][] = new int[m + 1][n + 1];
		int i = 0, j = 0;
		for (i = 0; i < m ; i++) {
			for (j = 0; j < n ; j++) {
				if (i == 0 || j == 0)
					t[i][j] = 0;
			}
		}
		for (i = 1; i < m + 1; i++) {
			for (j = 1; j < n + 1; j++) {
				if (x[i - 1] == y[j - 1])
					t[i][j] = 1 + t[i - 1][j - 1];
				else
					t[i][j] = Math.max(t[i - 1][j], t[i][j-1]);
			}
		}
		return t[m][n];
	}

	static int lc_substring_dp(char[] X, char[] Y, int m, int n, int dp[][]) {
		if (m == 0 || n == 0)
			return 0;

		if (dp[n][m] != -1)
			return dp[n][m];

		if (X[m - 1] == Y[n - 1])
			return dp[n][m] = 1 + lc_substring_dp(X, Y, m - 1, n - 1, dp);
		else
			return dp[m][n] = Math.max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n));
	}

	static int lc_substring_topdown(char[] X, char[] Y, int m, int n) {

		int t[][] = new int[m + 1][n + 1];
		int result = 0;
		for (int i = 0; i <= m; i++)
			for (int j = 0; j <= n; j++) {
				
				if (i == 0 || j == 0)
					t[i][j] = 0;
		
				else if (X[i - 1] == Y[j - 1]) {
					
					t[i][j] = t[i - 1][j - 1] + 1;
					result = Math.max(result, t[i][j]);
					
				} else
					t[i][j] = 0;
			}
		return result;
	}
}
