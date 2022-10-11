package stack;

import java.util.Stack;

public class BasicCalculator {

	public static void main(String[] args) {
		System.out.println(calculate("21-1 + 2"));
		System.out.println(calculateII("3+5 / 2"));

	}

	// calculator with digit, +, -, '(', ')'
	public static int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int result = 0, sign = 1;
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (c == ' ')
				continue;
			if (Character.isDigit(c)) {
				int number = Character.getNumericValue(c);
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					number = number * 10 + Character.getNumericValue(s.charAt(i + 1));
					i++;
				}
				result += sign * number;
			} else if (c == '+')
				sign = 1;
			else if (c == '-')
				sign = -1;
			else if (c == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			} else if (c == ')') {
				int prevSign = stack.pop();
				int prevRes = stack.pop();
				result = prevSign * result + prevRes;
			}
		}

		return result;
	}

	// digit, +, -, /, *
	public static int calculateII(String s) {
		int len;
		
		if (s == null || (len = s.length()) == 0)
			return 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		int num = 0;
		char sign = '+';
		
		for (int i = 0; i < len; i++) {
			
			if (Character.isDigit(s.charAt(i))) {
				num = num * 10 + s.charAt(i) - '0';
			}
			
			if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
				
				if (sign == '-') {
					stack.push(-num);
				}
				if (sign == '+') {
					stack.push(num);
				}
				if (sign == '*') {
					stack.push(stack.pop() * num);
				}
				if (sign == '/') {
					stack.push(stack.pop() / num);
				}
				
				sign = s.charAt(i);
				num = 0;
				
			}
		}

		int re = 0;
		for (int i : stack) {
			re += i;
		}
		return re;
	}
}
