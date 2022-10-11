package intv.str_arr;

import java.util.Stack;

//https://www.youtube.com/watch?v=2H9gMIIGyvY
public class ValidParenthesisString {

	public static void main(String[] args) {

		System.out.println(checkValidString1("((*))"));
	}

	static boolean checkValidString(String s) {

		if (s.length() == 0)
			return true;

		int balance = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')')
				balance--;
			else
				balance++;

			if (balance < 0)
				return false;
		}

		balance = 0;
		for (int i = s.length() - 1; i >= 0; --i) {
			if (s.charAt(i) == '(')
				balance--;
			else
				balance++;

			if (balance < 0)
				return false;
		}

		return true;
	}

	static boolean checkValidString1(String s) {
		Stack<Integer> leftStack = new Stack<>();
		Stack<Integer> starStack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				leftStack.push(i);
			} else if (s.charAt(i) == ')') {
				if (!leftStack.isEmpty()) {
					leftStack.pop();
				} else if (!starStack.isEmpty()) {
					starStack.pop();
				} else {
					return false;
				}
			} else {
				starStack.push(i);
			}
		}
		while (!leftStack.isEmpty() && !starStack.isEmpty()) {
			int li = leftStack.pop();
			int si = starStack.pop();
			if (si < li) {
				return false;
			}
		}
		if (!leftStack.isEmpty()) {
			return false;
		}
		return true;
	}
}
