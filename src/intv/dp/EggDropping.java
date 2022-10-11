package intv.dp;

import java.util.Arrays;

public class EggDropping {

	public static void main(String[] args) {

		int e = 5, f = 25;
		System.out.print("Minimum number of " + "trials in worst case with " + e + " eggs and " + f + " floors is "
				+ eggDrop(e, f));

		int dp[][] = new int[e + 1][f + 1];
		for (int d[] : dp)
			Arrays.fill(d, -1);

		long start = System.nanoTime();
		System.out.println(" eggDropMemoization " + eggDropMemoization(e, f, dp));
		long totalTime = System.nanoTime() - start;
		System.out.println("eggDropMemoization Total Time taken " + totalTime);
		
		int dp1[][] = new int[e + 1][f + 1];
		for (int d[] : dp1)
			Arrays.fill(d, -1);
		
		long start1 = System.nanoTime();
		System.out.println(" eggDropMemoizationAndOptimization " + eggDropMemoizationAndOptimization(e, f, dp));
		long totalTime1 = System.nanoTime() - start1;
		System.out.println("eggDropMemoizationAndOptimization Total Time taken " + totalTime1);
	}

	static int eggDrop(int e, int f) {

		if (f == 0 || f == 1)
			return f;

		if (e == 1)
			return f;

		int min = Integer.MAX_VALUE;
		for (int k = 1; k <= f; k++) {
			int temp = 1 + Math.max(eggDrop(e - 1, k - 1), eggDrop(e, f - k));
			min = Math.min(temp, min);
		}

		return min;
	}

	static int eggDropMemoization(int e, int f, int dp[][]) {

		if (dp[e][f] != -1)
			return dp[e][f];

		if (f == 0 || f == 1)
			return f;

		if (e == 1)
			return f;

		int min = Integer.MAX_VALUE;
		for (int k = 1; k <= f; k++) {
			int temp = 1 + Math.max(eggDropMemoization(e - 1, k - 1, dp), eggDropMemoization(e, f - k, dp));
			min = Math.min(temp, min);
		}

		return dp[e][f] = min;
	}

	static int eggDropMemoizationAndOptimization(int e, int f, int dp[][]) {

		if (f == 0 || f == 1)
			return f;

		if (e == 1)
			return f;

		int min = Integer.MAX_VALUE;
		for (int k = 1; k <= f; k++) {

			int low = 0;
			int heigh = 0;

			if (dp[e - 1][k - 1] != -1)
				low = dp[e - 1][k - 1];
			else
				low = eggDropMemoizationAndOptimization(e - 1, k - 1, dp);

			if (dp[e][f - k] != -1)
				heigh = dp[e][f - k];
			else
				heigh = eggDropMemoizationAndOptimization(e - 1, f - k, dp);

			int temp = 1 + Math.max(low, heigh);
			
			min = Math.min(temp, min);
		}

		return dp[e][f] = min;
	}

	// soln
	public int calculate(int eggs, int floors) {

		int T[][] = new int[eggs + 1][floors + 1];
		int c = 0;
		for (int i = 0; i <= floors; i++) {
			T[1][i] = i;
		}

		for (int e = 2; e <= eggs; e++) {
			for (int f = 1; f <= floors; f++) {
				T[e][f] = Integer.MAX_VALUE;
				for (int k = 1; k <= f; k++) {
					c = 1 + Math.max(T[e - 1][k - 1], T[e][f - k]);
					if (c < T[e][f]) {
						T[e][f] = c;
					}
				}
			}
		}
		return T[eggs][floors];
	}

	// leet code soln try to understand K eggs N floorsR
	public int superEggDrop(int K, int N) {

		int[][] dp = new int[N + 1][K + 1];
		int m = 0;
		while (dp[m][K] < N) {
			++m;
			for (int k = 1; k <= K; ++k)
				dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1;
		}
		return m;
	}

}
