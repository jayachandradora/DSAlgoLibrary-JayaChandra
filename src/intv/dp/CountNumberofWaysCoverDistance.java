package intv.dp;

public class CountNumberofWaysCoverDistance {

	static int printCountDP(int dist) {
		int[] count = new int[dist + 1];

		// Initialize base values. There is one way to
		// cover 0 and 1 distances and two ways to cover 2 distance
		count[0] = 1;
		count[1] = 1;
		count[2] = 2;

		// Fill the count array in bottom up manner
		for (int i = 3; i <= dist; i++)
			count[i] = count[i - 1] + count[i - 2] + count[i - 3];

		return count[dist];
	}

	public static void main(String[] args) {
		int dist = 4;
		System.out.println(printCountDP(dist));
		int dp[] = new int[dist + 1];
		System.out.println(countWays(dist, dp));
	}

	static int countWays(int n, int dp[]) {
		if (n == 0)
			return 1;
		
		if (n < 0)
			return 0;
		
		if (dp[n] != 0)
			return dp[n];
		
		dp[n] = countWays(n - 1, dp) + countWays(n - 2, dp) + countWays(n - 3, dp);
		
		// = num;
		return dp[n];
	}
}
