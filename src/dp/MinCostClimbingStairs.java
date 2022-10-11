package dp;

public class MinCostClimbingStairs {

	public static void main(String[] args) {

		int cost[] = { 10, 15, 20 };
		System.out.println("Climb stairs " + minCostClimbingStairs1(cost));
		
	}

	static int minCostClimbingStairs1(int[] cost) {
		int[] dp = new int[cost.length + 1];
		for (int i = 2; i <= cost.length; i++)
			dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
		return dp[cost.length];
	}

	public int minCostClimbingStairs(int[] cost) {
		int a = 0, b, min = 0;
		for (int c : cost) {
			b = a;
			a = c + min;
			min = Math.min(a, b);
		}
		return min;
	}
}
