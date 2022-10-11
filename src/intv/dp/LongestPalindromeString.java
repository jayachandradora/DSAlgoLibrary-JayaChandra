package intv.dp;

import java.util.Arrays;

//https://www.youtube.com/watch?v=Msghl9189X4
public class LongestPalindromeString {

	public static void main(String[] args) {
		String str = "bbdbb";

		System.out.println(LongestPalindromeString.lpSubstring(str, 0, str.length() - 1));

		Integer[][] arr = new Integer[str.length()][str.length()];
		System.out.println(LongestPalindromeString.lpSubStringTopDown(str, 0, str.length() - 1, arr));

		System.out.println(longestPalindrome("babad"));
		System.out.println("length of palindrome " + longestPalindrome1(str));
	}

	//https://www.youtube.com/watch?v=AKIHWGumagI&ab_channel=PrakashShukla
	public static String longestPalindrome1(String s) {

		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {

			int len1 = expandFromCenter(s, i, i + 1);
			int len2 = expandFromCenter(s, i, i);
			int len = Math.max(len1, len2);

			if (end - start < len) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}

		return s.substring(start, end + 1);
	}

	public static int expandFromCenter(String s, int i, int j) {
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i--;
			j++;
		}
		return j - i - 1;
	}

	public static int lpSubstring(String str, int start, int end) {
		if (start > end) {
			return 0;
		}

		if (start == end) {
			return 1;
		}

		if (str.charAt(start) == str.charAt(end)) {
			int lpsRemainingString = end - start - 1;

			if (lpsRemainingString == lpSubstring(str, start + 1, end - 1))
				return 2 + lpsRemainingString;

		}
		return Math.max(lpSubstring(str, start + 1, end), lpSubstring(str, start, end - 1));
	}

	public static int lpSubStringTopDown(String str, int start, int end, Integer[][] arr) {
		if (start > end) {
			return 0;
		}

		if (start == end) {
			return 1;
		}

		if (arr[start][end] == null) {
			if (str.charAt(start) == str.charAt(end)) {
				int lpsRemainingString = end - start - 1;

				if (lpsRemainingString == lpSubStringTopDown(str, start + 1, end - 1, arr)) {
					arr[start][end] = 2 + lpsRemainingString;
					return arr[start][end];
				}

			}
			arr[start][end] = Math.max(lpSubStringTopDown(str, start, end - 1, arr),
					lpSubStringTopDown(str, start + 1, end, arr));
		}

		return arr[start][end];
	}

	// https://www.youtube.com/watch?v=UflHuQj6MVA : Mast explanation
	static String longestPalindrome(String input) {

		if (input.isEmpty()) {
			return "";
		}

		int n = input.length();
		int longestSoFar = 0, startIndex = 0, endIndex = 0;
		boolean[][] palindrom = new boolean[n][n];

		for (int j = 0; j < n; j++) {

			palindrom[j][j] = true; // All Single Character is palindrome.

			for (int i = 0; i < j; i++) {
				if (input.charAt(i) == input.charAt(j) && (j - i <= 2 || palindrom[i + 1][j - 1])) {
					// check boundary character i, j and i+1, j-1 then its palindrome.

					palindrom[i][j] = true; // middle string is palindrome

					if (j - i + 1 > longestSoFar) {

						longestSoFar = j - i + 1;
						startIndex = i;
						endIndex = j;

					}
				}
			}
		}

		return input.substring(startIndex, endIndex + 1);
	}
}
