package intv.str_arr;

public class CountAllPalindromes {

	public static void main(String[] args) {
		System.out.println(numberOfPalindromeBruteForce("abc"));
		System.out.println(countSubstrings("abc"));
	}

	static int countSubstrings(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			count += countPalindrome(s, i, i) + countPalindrome(s, i, i + 1);
		}
		return count;
	}
	static int countPalindrome(String str, int l, int r) {
		int count = 0;
		while (l >= 0 && r <str.length() && str.charAt(l) == str.charAt(r)) {
				l--;
				r++;
				count++;
		}
		return count;
	}
	public static int numberOfPalindromeBruteForce(String s) {

		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++)
				if (isPalindrome(s.substring(i, j)))
					count++;
		}
		return count;
	}

	static boolean isPalindrome(String str) {
		int l = 0, r = str.length() - 1;

		while (l < r) {
			if (l <= r && str.charAt(l) == str.charAt(r)) {
				l++;
				r--;
			}
			return false;
		}
		return l >= r;
	}
}
