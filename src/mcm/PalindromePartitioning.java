package mcm;

import java.util.Arrays;

public class PalindromePartitioning {

	
	public static void main(String[] args) {
		String str = "leet";
		int n = str.length() - 1;
		int m = 10;
		int dp[][] = new int[100][100];
		for(int d[] : dp)
			Arrays.fill(d, -1);
		
		System.out.println(isPalindrome(str, 0, n));
		System.out.println("Minimum number of PalindromePartitioning is " + solve(str, 0, n));
		System.out.println("Minimum number of PalindromePartitioning dp is " + solve_dp(str, 0, n, dp));

	}

	static int solve(String str, int i, int j) {

		int min = Integer.MAX_VALUE;

		if (i == j)
			return 0;

		if (isPalindrome(str, i, j))
			return 0;

		for (int k = i; k < j; k++) {
			int temp = solve(str, i, k) + solve(str, k + 1, j) + 1;

			min = Math.min(temp, min);
		}
		return min;
	}

	static int solve_dp(String str, int i, int j, int [][] dp) {

		int min = Integer.MAX_VALUE;

		if (i == j)
			return 0;

		if(dp[i][j] != -1)
			return dp[i][j];
		
		if (isPalindrome(str, i, j))
			return 0;

		for (int k = i; k < j; k++) {
			int tempL = 0;
			int tempR = 0;
			int tempRes = 0;
			
			if(dp[i][k] != -1)
				tempL = dp[i][k];
			else
				tempL = solve_dp(str, i, k, dp);
			
			if(dp[k+1][j] != -1)
				tempR = dp[k+1][j];
			else
				tempR = solve_dp(str, k + 1, j, dp);
			
			tempRes = tempL + tempR +1;

			min = Math.min(tempRes, min);
		}
		return dp[i][j] = min;
	}
	static boolean isPalindrome(String str, int i, int j) {

		while (i < j) {
			if (str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

}
