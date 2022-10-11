package arrays;

import java.util.Map;
import java.util.Map.Entry;

public class MaxProfit {

	public static int maxProfit(int[] prices) {

		int profit =0;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<prices.length; i++){
            min = Math.min(prices[i], min);
            profit = Math.max(profit, prices[i]-min);
        }
        
        return profit;
	}

	public static int maxProfit2(int[] prices) {
		int maxprofit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1])
				maxprofit += prices[i] - prices[i - 1];
		}
		return maxprofit;
	}

	public static int maxProfit3(int[] prices) {
		
		if (prices.length == 0)
			return 0;
		
		int min1 = prices[0], max1 = 0, min2 = Integer.MAX_VALUE, max2 = 0, cur;
		
		for (int i = 1; i < prices.length; i++) {
			cur = prices[i];
			min1 = Math.min(min1, cur);
			max1 = Math.max(max1, cur - min1);
			min2 = Math.min(min2, cur - max1);
			max2 = Math.max(max2, cur - min2);
		}
	
		return max2;
	}

	public static void main(String[] args) {

		int prices[] = { 7, 1, 5, 3, 6, 4 };
		System.out.println("MaxProfit : " + maxProfit(prices));

		int prices1[] = { 1, 2, 3, 4, 5 };
		System.out.println("MaxProfit2 : " + maxProfit2(prices1));

		int prices3[] = { 3, 3, 5, 0, 0, 3, 1, 4 };
		System.out.println("MaxProfit3 : " + maxProfit3(prices3));

	}

}
