package dp;

import java.util.Arrays;

public class ShortestSupperSubSequence {

	// Soln: formula - str1.length + str2.length -LCS. return this length.
	public static void main(String[] args) {

		String str1 = "geek", str2 = "eke";
		int n = str1.length(), m = str2.length();
		char x[] = str1.toCharArray();
		char y[] = str2.toCharArray();

		int dp[][] = new int[n + 1][m + 1];

		for (int d[] : dp)
			Arrays.fill(d, -1);

		int supperSequence = n + m - lcs(x, y, n, m, dp);
		System.out.println("Supper Sub Sequece lenght " + supperSequence);
		
		//2nd example
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m1 = X.length;
		int n1 = Y.length;
		
		int lcs = lcs(X, Y, m1, n1);
		
		int lengthOfShortestSupersequece = m1 + n1 - lcs;
		System.out.println(lengthOfShortestSupersequece);
	}

	static int lcs(char x[], char y[], int n, int m, int dp[][]) {

		if (n == 0 || m == 0)
			return 0;

		if (dp[n][m] != -1)
			return dp[m][n];

		if (x[n - 1] == y[m - 1])
			return dp[n][m] = lcs(x, y, n - 1, m - 1, dp) + 1;
		else
			return dp[n][m] = Math.max(lcs(x, y, n - 1, m, dp), lcs(x, y, n, m - 1, dp));
	}
	
	static int lcs(char[] X, char[] Y, int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		if (X[m - 1] == Y[n - 1]) {
			return 1 + lcs(X, Y, m - 1, n - 1);
		}else
			return Math.max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n));
	}

}
