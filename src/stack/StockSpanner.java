package stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanner {

	public static void main(String args[]) {
		int price[] = { 100, 80, 60, 70, 60, 75, 85 }; 
        int n = price.length; 
        int S[] = new int[n]; 
  
        calculateSpan(price, n, S); 
        System.out.print(Arrays.toString(S)); 
	}

	static void calculateSpan(int price[], int n, int S[]) {
		Stack<Integer> st = new Stack<>();
		st.push(0);
		S[0] = 1;
		for (int i = 1; i < n; i++) {
			while (!st.empty() && price[st.peek()] <= price[i])
				st.pop();

			S[i] = (st.empty()) ? (i + 1) : (i - st.peek());
			st.push(i);
		}
	}

}
