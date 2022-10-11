package intv.dp;

public class LPS {

	public static void main(String[] args) {
		String seq = "aacecaaa";
		System.out.println(shortestPalindrome(seq));
	}

	public static String shortestPalindrome(String s) {
		
		String r = new StringBuilder(s).reverse().toString();
		
		int[] lps = getLPS(s + '|' + r);
		return r.substring(0, r.length() - lps[lps.length - 1]) + s;
	}

	// KMP get longest prefix and suffix count
	static int[] getLPS(String s) {
		int[] lps = new int[s.length()];
		int i = 1, len = 0;

		while (i < s.length()) {
			if (s.charAt(i) == s.charAt(len))
				lps[i++] = ++len;
			else if (len == 0)
				lps[i++] = 0;
			else
				len = lps[len - 1];
		}

		return lps;
	}
}
