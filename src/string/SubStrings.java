package string;

import java.util.Stack;

public class SubStrings {

	public static void main(String[] args) {

		String str = "abcd";
		for (int i = 0; i < str.length(); i++)
			for (int j = i + 1; j <= str.length(); j++)
				System.out.print(str.substring(i, j) + ", "); //All Possible substrings
		
		System.out.println(reverseParentheses("(u(love)i)"));
	}
	
	
	static String reverseParentheses(String s) {

		Stack<StringBuilder> st = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for (char c : s.toCharArray()) {

			if (c == '(') {

				st.push(sb);
				sb = new StringBuilder();

			} else if (c == ')') {

				String str = sb.reverse().toString();
				sb = st.pop();
				sb.append(str);

			} else
				sb.append(c);
		}
		return sb.toString();
	}
}
