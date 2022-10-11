package backtrack;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=eyCj_u3PoJE
public class GenerateAllBalancedParentheses {

	static List<String> result = new ArrayList<>();

	public static void main(String[] args) {
		solve(1, 1, "", result);
		System.out.println(result);
	}

	public static void solve(int open, int close, String output, List<String> result) {
		
		if (open == 0 && close == 0)
			result.add(output.toString());

		if (open != 0) {
			solve(open - 1, close, output + "(", result);
		}

		if (open < close) {
			solve(open, close - 1, output + ")", result);
		}

		return;
	}

}
