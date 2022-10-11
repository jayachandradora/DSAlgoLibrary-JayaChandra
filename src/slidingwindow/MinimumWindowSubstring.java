package slidingwindow;

public class MinimumWindowSubstring {

	public static void main(String[] args) {

		String S = "ADOBECODEBANC", T = "ABC";
		System.out.println(minWindow(S, T));

	}

	public static String minWindow(String s, String t) {
		int[] count = new int[128];
		for (char c : t.toCharArray())
			count[c]++;

		int min = s.length() + 1, i = 0, j = 0, remain = t.length();

		String res = "";
		while (i < s.length()) {
			if (--count[s.charAt(i++)] >= 0)
				remain--;
			while (remain == 0) {
				if (i - j < min) {
					min = i - j;
					res = s.substring(j, i);
				}
				if (++count[s.charAt(j++)] > 0)
					remain++;
				;
			}
		}
		return res;
	}
}
