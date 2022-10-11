package intv.dp;

public class CountPalindromicSubstrings {

	int max = Integer.MIN_VALUE;
	public static void main(String[] args) {
		CountPalindromicSubstrings cs = new CountPalindromicSubstrings();
		System.out.println(cs.countSubstrings("aaa"));
	}

	public int countSubstrings(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++)
			count += countPalindrome(str, i, i) + countPalindrome(str, i, i + 1);
		System.out.println(max);
		return count;
	}

	private int countPalindrome(String str, int l, int r) {
		int count = 0;

		while (l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
			
			System.out.println(str.substring(l, r+1)); // print all palindromic string
			max = Math.max(r+1 - l, max); // longest palindromic string
			l--;
			r++;
			count++;
		}
		return count;
	}

}
