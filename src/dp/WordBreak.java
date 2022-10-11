package dp;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	private static Set<String> dictionary = new HashSet<>();

	public static void main(String[] args) {

		String s = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		System.out.println(wordBreak(s, dict));

		// 2nd solution
		String temp_dictionary[] = { "mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i",
				"like", "ice", "cream" };

		for (String temp : temp_dictionary) {
			dictionary.add(temp);
		}

		// sample input cases
		System.out.println(wordBreak("ilikesamsung"));
		System.out.println(wordBreak("iiiiiiii"));
		System.out.println(wordBreak(""));
		System.out.println(wordBreak("ilikelikeimangoiii"));
		System.out.println(wordBreak("samsungandmango"));
		System.out.println(wordBreak("samsungandmangok"));
	}

	static boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0)
			return false;

		int n = s.length();

		// dp[i] represents whether s[0...i] can be formed by dict
		boolean[] dp = new boolean[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				String sub = s.substring(j, i + 1);

				if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[n - 1];
	}

	static boolean wordBreak(String word) {
		int size = word.length();

		// base case
		if (size == 0)
			return true;

		// else check for all words
		for (int i = 1; i <= size; i++) {
			if (dictionary.contains(word.substring(0, i)) && wordBreak(word.substring(i, size)))
				return true;
		}

		// if all cases failed then return false
		return false;
	}
}
