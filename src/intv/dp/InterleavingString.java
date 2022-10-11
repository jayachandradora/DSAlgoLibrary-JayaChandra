package intv.dp;

import java.util.HashMap;
import java.util.Map;

public class InterleavingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Map<String, Boolean> mem = new HashMap<String, Boolean>();

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		} else if (s3.length() == 0) {
			return true;
		} else if (mem.containsKey(s1 + "#" + s2)) {
			return mem.get(s1 + "#" + s2);
		}

		boolean b = (s1.length() > 0 && s1.charAt(0) == s3.charAt(0))
				? isInterleave(s1.substring(1), s2, s3.substring(1))
				: false;
		if (!b) {
			b = (s2.length() > 0 && s2.charAt(0) == s3.charAt(0)) ? isInterleave(s1, s2.substring(1), s3.substring(1))
					: false;
		}
		mem.put(s1 + "#" + s2, b);
		return b;
	}

	public static boolean isInterleave1(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		
		int[][] saved = new int[s1.length() + 1][s2.length() + 1];
		return isInterleave(s1, s2, s3, 0, 0, 0, saved);
	}

	private static boolean isInterleave(String s1, String s2, String s3, int p1, int p2, int p3, int[][] saved) {
		
		if (saved[p1][p2] == 1)
			return true;
		
		if (saved[p1][p2] == -1)
			return false;
		
		if (p3 == s3.length())
			return true;
		
		boolean result = false;
		
		if (p1 < s1.length() && s1.charAt(p1) == s3.charAt(p3) && isInterleave(s1, s2, s3, p1 + 1, p2, p3 + 1, saved))
			result = true;
		
		if (p2 < s2.length() && s2.charAt(p2) == s3.charAt(p3) && isInterleave(s1, s2, s3, p1, p2 + 1, p3 + 1, saved))
			result = true;
		
		saved[p1][p2] = result ? 1 : -1;
		
		return result;
	}
}
