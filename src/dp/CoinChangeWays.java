
package dp;

/* Dynamic Programming Java implementation of Coin
Change problem */
import java.util.Arrays;

// Time & Space complexity of this function: O(mn) & O(n)
class CoinChangeWays {
	public static void main(String args[]) {
		int coins[] = { 1, 2, 3 };
		int m = coins.length;
		int amount = 4;
		System.out.println("Rec " + coinChangeRec(coins, 0, amount));

		int dp[][] = new int[m + 1][amount + 1];
		for (int d[] : dp)
			Arrays.fill(d, -1);

		System.out.println("DP " + coinChangeDP(coins, 0, amount, dp));
		System.out.println("TopDown " + coinChangeTopDown(coins, amount));
	}

	static int coinChangeDP(int coins[], int i, int amount, int dp[][]) {

		if (amount == 0)
			return 1;

		if (amount < 0 || i == coins.length)
			return 0;

		if (dp[i][amount] != -1)
			return dp[i][amount];

		return dp[i][amount] = coinChangeDP(coins, i, amount - coins[i], dp) + coinChangeDP(coins, i + 1, amount, dp);
	}

	static int coinChangeRec(int coins[], int i, int amount) {

		if (amount == 0)
			return 1;
		if (amount < 0 || i == coins.length)
			return 0;

		return coinChangeRec(coins, i, amount - coins[i]) + coinChangeRec(coins, i + 1, amount);
	}

	static int coinChangeTopDown(int coins[], int sum) {

		int n = coins.length;
		int T[][] = new int[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) 
			T[i][0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				
				if (coins[i - 1] > j)
					T[i][j] = T[i - 1][j];
				else
					T[i][j] = T[i - 1][j] + T[i][j - coins[i - 1]];
			}
		}
		return T[n][sum];
	}

}
