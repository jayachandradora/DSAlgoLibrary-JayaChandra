package stack;

import java.util.Stack;

public class DailyTemprature {

	public static void main(String[] args) {
		int T[] = { 73, 74, 75, 71, 69, 72, 76, 73 };

		for (int in : dailyTemperatures(T))
			System.out.print(in + " ");
		
	}

	static int[] dailyTemperatures(int[] T) {

		int res[] = new int[T.length];
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < T.length; i++) {
			while (!st.isEmpty() && T[i] > T[st.peek()]) {
				int index = st.pop();
				res[index] =  i - index;
			}
			st.push(i);
		}
		return res;
	}
}
