package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CoinChainCount {

	/*
	 * Input: coins = [1, 2, 5], amount = 11 Output: 3 Explanation: 11 = 5 + 5 + 1
	 */
	public static void main(String[] args) {
		int coins[] = { };
		int sum = 1;

		System.out.println("coinChangeProblem : " + coinChangeProblem(coins, sum));

		CoinChainCount ch = new CoinChainCount();
		System.out.println(ch.change2(sum, coins));
	}

	int min = Integer.MAX_VALUE;
	public int change2(int amount, int[] coins) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		List<Integer> list = new ArrayList<>();
		helper(amount, coins, 0, hm, list);
		return min;
	}

	private int helper(int amount, int[] coins, int index, HashMap<String, Integer> hm, List<Integer> list) {
		if (amount == 0) {
			min = Math.min(min, list.size());
			return 1;
		}
		if (amount < 0 || index == coins.length) 
			return 0;
		
		String key = amount + "codebix" + index;
		if (hm.containsKey(key))
			return hm.get(key);
		
		int result = 0;
		for (int i = index; i < coins.length; i++) {
			
			if (amount >= coins[i]) {
				list.add(coins[i]);
				result += helper(amount - coins[i], coins, i, hm, list);
				list.remove(list.size() -1);
			}
		}
		
		hm.put(key, result);
		return result;
	}

	static int coinChangeProblem(int[] coins, int sum) {

		int totalCoins = coins.length;
		double[][] arr = new double[totalCoins + 1][sum + 1]; // subproblems' solutions

		for (int j = 0; j <= sum; j++)
			arr[0][j] = Double.POSITIVE_INFINITY; // Initialising first row with +ve infinity

		for (int i = 1; i <= totalCoins; i++) // Initialising first column with 0
			arr[i][0] = 0;

		// Implementing the recursive solution
		for (int i = 1; i <= totalCoins; i++) {
			for (int j = 1; j <= sum; j++) {
				if (coins[i - 1] <= j)
					arr[i][j] = Math.min(1 + arr[i][j - coins[i - 1]], arr[i - 1][j]);
				else
					arr[i][j] = arr[i - 1][j];
			}
		}

		return (int) arr[totalCoins][sum];
	}
}
