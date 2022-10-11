package test1;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/* home work 
https://leetcode.com/submissions/detail/427454072/ : Valid Parenthesis
https://leetcode.com/submissions/detail/497171316/
https://leetcode.com/problems/132-pattern/
https://leetcode.com/problems/daily-temperatures
*/
public class Calculator {

	public static void main(String[] args) {
		calculate("1 + 1");
		
		System.out.println(checkValidString("((()*)"));
	}

	public static boolean checkValidString(String s) {

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

	public String removeKdigits(String num, int k) {
		int digits = num.length() - k;
		if (num.length() <= k)
			return "0";
		int top = -1, start = 0;
		char[] st = num.toCharArray();
		for (int i = 0; i < st.length; i++) {
			while (top >= 0 && st[top] > st[i] && k > 0) {
				top--;
				k--;
			}
			st[++top] = st[i];
		}
		while (start <= top && st[start] == '0')
			start++;

		if (start > top)
			return "0";

		return new String(st, start, digits - start);
	}

	public static int calculate(String s) {

		int sign = 1;
		int sum = 0;
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') { // digit
				int num = 0;
				while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					num = num * 10 + s.charAt(i) - '0';
					i++;
				}
				sum += num * sign;
				i--;
			} else if (s.charAt(i) == '+') { // '+'
				sign = 1;
			} else if (s.charAt(i) == '-') { // '-'
				sign = -1;
			} else if (s.charAt(i) == '(') { // '('
				st.push(sum);
				st.push(sign);
				sum = 0;
				sign = 1;
			} else if (s.charAt(i) == ')') { // ')'
				sum = st.pop() * sum;
				sum += st.pop();
			}
		}
		return sum;
	}
}
