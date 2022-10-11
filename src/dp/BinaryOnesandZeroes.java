package dp;

//https://leetcode.com/problems/ones-and-zeroes/
public class BinaryOnesandZeroes {

	public static void main(String[] args) {
		String []strs = {"10","0001","111001","1","0"};
		int m = 5, n = 3;
		System.out.println(findMaxForm(strs, m, n));
	}

	static int findMaxForm(String[] strs, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (String s : strs) {
			int[] count = count(s);
			for (int i = m; i >= count[0]; i--)
				for (int j = n; j >= count[1]; j--)
					dp[i][j] = Math.max(1 + dp[i - count[0]][j - count[1]], dp[i][j]);
		}
		return dp[m][n];
	}

	static int[] count(String str) {
		int[] res = new int[2];
		for (int i = 0; i < str.length(); i++)
			res[str.charAt(i) - '0']++;
		return res;
	}
}
