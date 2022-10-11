package dp;

public class LongestPalindromicSubsequence {

	// Soln: use one input string from given problem and get second string reversing
	// of given input string then use LCS and return the length.
	public static void main(String[] args) {

		// String str1 = "GEEKSFORGEEKS";
		String str1 = "AGGTAB";
		String str2 = new StringBuilder(str1).reverse().toString();
		int n = str1.length(), m = str2.length();
		char x[] = str1.toCharArray();
		char y[] = str2.toCharArray();

		System.out.println(" Longest Palindromic Subsequence " + lcs(x, y, n, m));

		
		String str3 = "ac";
		String str4 = new StringBuilder(str3).reverse().toString();
		int n1 = str3.length(), m1 = str4.length();
		char x1[] = str3.toCharArray();
		char y1[] = str4.toCharArray();
		int strPalindromLength = lcsSubString(x1, y1, n1, m1, 0);

		//https://leetcode.com/problems/longest-palindromic-substring/
		System.out.println(" Longest Palindromic substring length " + strPalindromLength);
		for (int i = 0; i < str1.length(); i++) {
			String st = str3.substring(i, strPalindromLength + i);
			if (isPalindrom(st)) {
				System.out.println(st);
				break;
			}
		}

		System.out.println(isPalindrom("aabaaa"));
	}

	static int lcs(char x[], char y[], int n, int m) {

		if (n == 0 || m == 0)
			return 0;

		if (x[n - 1] == y[m - 1])
			return lcs(x, y, n - 1, m - 1) + 1;
		else
			return Math.max(lcs(x, y, n - 1, m), lcs(x, y, n, m - 1));
	}

	static int lcsSubString(char x[], char y[], int n, int m, int count) {

		if (n == 0 || m == 0)
			return 0;

		if (x[n - 1] == y[m - 1])
			count = lcsSubString(x, y, n - 1, m - 1, count + 1);
		else
			count = Math.max(count, Math.max(lcsSubString(x, y, n - 1, m, 0), lcsSubString(x, y, n, m - 1, 0)));

		return count;
	}

	static boolean isPalindrom(String str) {

		int len = str.length();
		for (int i = 0; i < len / 2; i++)
			if (str.charAt(i) != str.charAt(len - 1 - i))
				return false;

		return true;
	}
}
