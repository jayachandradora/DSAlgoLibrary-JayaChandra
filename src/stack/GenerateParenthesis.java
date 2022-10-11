package stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public static void main(String[] args) {
		generateParenthesis(3).forEach(str -> System.out.println(str));
	}

	static List<String> generateParenthesis(int n) {// 22. Generate Parentheses
		List<String> ans = new ArrayList<>();
		backtrack(ans, "", 0, 0, n);
		return ans;
	}

	static void backtrack(List<String> ans, String cur, int start, int end, int length) {
		if (cur.length() == length * 2) {
			ans.add(cur);
			return;
		}

		if (start < length)
			backtrack(ans, cur + "(", start + 1, end, length);
		if (end < start)
			backtrack(ans, cur + ")", start, end + 1, length);
	}

}
