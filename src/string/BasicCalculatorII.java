package string;

import java.util.Stack;

public class BasicCalculatorII {

	public static void main(String[] args) {
		String s = " 3*5+6-10/2/2*4 ";
		System.out.println(calculate(s));
	}

	public static int calculate(String s) {
		Stack<Integer> st = new Stack<>();

		char prevSign = '+';
		int no = 0;
		for (int i = 0; i < s.length(); i++) {
			
			char c = s.charAt(i);
			if (Character.isDigit(c)) 
				no = no * 10 + (c - '0');

			if (isOperator(c) || i == s.length() - 1) {
				if (prevSign == '+') {
					st.push(no);
				} else if (prevSign == '-') {
					st.push(-no);
				} else if (prevSign == '*') {
					int top = st.pop();
					st.push(top * no);

				} else if (prevSign == '/') {
					int top = st.pop();
					st.push(top / no);
				}
				no = 0;
				prevSign = c;
			}
		}

		int res = 0;
		while (!st.empty()) { // 1+2+3+4
			res += st.pop();
		}
		return res;
	}

	private static boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '/' || c == '*';
	}

}
