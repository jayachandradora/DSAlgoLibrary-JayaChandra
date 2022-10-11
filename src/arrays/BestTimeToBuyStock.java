package arrays;

public class BestTimeToBuyStock {

	// best-time-to-buy-and-sell-stock
	public static void main(String[] args) {

		int prices[] = { 7, 1, 9, 3, 6, 4 };

		int profit = 0;
		int min1 = Integer.MAX_VALUE;

		for (int i = 0; i < prices.length; i++) {
			profit = Math.max(profit, prices[i] - min1);
			min1 = Math.min(prices[i], min1);
		}
		System.out.println(profit);
	}

	// best-time-to-buy-and-sell-stock-ii
	public static int maxProfit(int[] prices) {
		int maxprofit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1])
				maxprofit += prices[i] - prices[i - 1];
		}
		return maxprofit;
	}

	public int maxProfit111(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;

		int n = prices.length;
		int profit = 0;

		// scan from left
		// left[i] keeps the max profit from 0 to i
		int[] left = new int[n];
		int min = prices[0];

		for (int i = 1; i < n; i++) {
			left[i] = Math.max(left[i - 1], prices[i] - min);
			min = Math.min(min, prices[i]);
		}

		// scan from right
		// right[i] keeps the max profit from i to n - 1
		int[] right = new int[n];
		int max = prices[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], max - prices[i]);
			max = Math.max(max, prices[i]);

			profit = Math.max(profit, left[i] + right[i]);
		}

		return profit;
	}
}
