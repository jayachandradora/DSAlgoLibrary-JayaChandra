package stack;

import java.util.HashMap;
import java.util.Stack;

public class ValidParanthesis {

	public static void main(String[] args) {

		String str = "{{()}[]}";
		System.out.println("Valid " + isValid(str));

		System.out.println("CheckValidString " +checkValidString("(*))")); // 678. Valid Parenthesis String
		System.out.println("ScoreOfParentheses " + scoreOfParentheses("(()(()))")); // 856. Score of Parentheses

		System.out.println("LongestValidParentheses " + longestValidParentheses(")()())")); // 32. Longest Valid Parentheses

		System.out.println("RemoveOuterParentheses " + removeOuterParentheses("(()())(())")); // Output: ()()() Input: "()()" Output: ""

	}

	static String removeOuterParentheses(String S) {
		StringBuilder sb = new StringBuilder();
		int sum = 0, start = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '(')
				sum = sum + 1;
			else if (--sum == 0) {
				sb.append(S.substring(start + 1, i));
				start = i + 1;
			}
		}
		return sb.toString();
	}

	static int scoreOfParentheses(String S) {

		Stack<Integer> stack = new Stack<>();
		int cur = 0;
		for (char c : S.toCharArray()) {
			if (c == '(') {
				stack.push(cur);
				cur = 0;
			} else {
				cur = stack.pop() + Math.max(cur * 2, 1);
			}
		}
		return cur;
	}

	static boolean checkValidString(String s) {
		int l = 0, h = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				l++;
				h++;
			} else if (c == ')') {
				h--;
				if (l > 0)
					l--;
			} else {
				h++;
				if (l > 0)
					l--;
			}
			if (h < 0)
				return false;// this garentee that '(' is not less than ')'
		}
		return l == 0;
	}

	public static boolean isValid(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');

		Stack<Character> stack = new Stack<Character>();

		//for (int i = 0; i < s.length(); i++) {
			//char curr = s.charAt(i);
		for(char curr : s.toCharArray()) {

			if (map.keySet().contains(curr)) {
				stack.push(curr);
			} else if (map.values().contains(curr)) {
				if (!stack.empty() && map.get(stack.peek()) == curr) {
					stack.pop();
				} else {
					return false;
				}
			}
		}

		return stack.empty();
	}

	public static boolean isValid1(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}

	static int longestValidParentheses(String str) { //)()())
		int n = str.length();

		// Create a stack and push -1 as initial index to it. 
		Stack<Integer> stk = new Stack<>();
		stk.push(-1);

		int result = 0;

		for (int i = 0; i < n; i++) {
			// If opening bracket, push index of it
			if (str.charAt(i) == '(')
				stk.push(i);
			else { // If closing bracket, i.e.,str[i] = ')'

				// Pop the previous opening bracket's index
				stk.pop();

		// Check if this length formed with base of current valid substring is more than max so far
				if (!stk.empty())
					result = Math.max(result, i - stk.peek());

	   // If stack is empty. push current index as base for next valid substring (if any)
				else
					stk.push(i);
			}
		}
		return result;
	}

	public int minAddToMakeValid(String S) {

		int count = 0, bal = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '(')
				bal = bal + 1;
			else
				bal = bal - 1;

			if (bal == -1) {
				count = count + 1;
				bal = bal + 1;
			}
		}

		return count + bal;
	}
}