package dp;

import java.util.Arrays;

public class MaximumLengthofPairChain {

	public static void main(String[] args) {

		int pairs[][] = { { 1, 2 }, 
						  { 2, 3 }, 
						  { 3, 4 } 
						};
		System.out.println(findLongestChain(pairs));
	}

	static int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

		int[] dp = new int[pairs.length];
		Arrays.fill(dp, 1);

		for (int i = 1; i < pairs.length; ++i) {
			for (int j = 0; j < i; ++j) {
				if (pairs[i][0] > pairs[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		return dp[dp.length - 1];
	}
}
