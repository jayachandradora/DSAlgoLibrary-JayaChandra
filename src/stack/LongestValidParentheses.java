package stack;

import java.util.Stack;

public class LongestValidParentheses {

	public static void main(String[] args) {

		String s = ")()())";
		System.out.println(longestValidParentheses(s));
	}

	public static int longestValidParentheses(String s) {
		if (s == null || s.length() == 0)
			return 0;

		int n = s.length();
		Stack<Integer> st = new Stack<>();
		st.push(-1);
		int res = 0;

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '(')
				st.push(i);
			else {
				st.pop();

				if (!st.isEmpty())
					res = Math.max(res, i - st.peek());
				else
					st.push(i);
			}
		}
		return res;
	}
}
