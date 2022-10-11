package dp;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {

	public static void main(String[] args) {

		Map<Integer, Integer> cache = new HashMap<>();
		cache.put(0, 1);
		cache.put(1, 1);
		// System.out.println(climbStairs(4, cache));
		System.out.println(climbStairs1(4));
		System.out.println(" Rec : " + climbStairsRec(4));
	}

	static int climbStairs(int n, Map<Integer, Integer> cache) {
		if (cache.containsKey(n))
			return cache.get(n);
		if (n <= 2)
			return n;
		int res = climbStairs(n - 1, cache) + climbStairs(n - 2, cache);
		cache.put(n, res);
		return res;
	}

	static int climbStairs1(int n) {
		int dp[] = new int[n + 1];

		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1;

		for (int i = 3; i <= n; i++)
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

		return dp[n];
	}

	static int climbStairsRec(int n) {
		if (n <= 2)
			return n;

		return climbStairsRec(n - 1) + climbStairsRec(n - 2);

	}
}
