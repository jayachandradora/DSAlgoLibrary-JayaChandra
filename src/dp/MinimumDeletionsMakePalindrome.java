package dp;

public class MinimumDeletionsMakePalindrome {

	public static void main(String[] args) {

		String str1 = "AGGTAB";
		String str2 = new StringBuilder(str1).reverse().toString();
		int n=str1.length(), m = str2.length();
		char x[] = str1.toCharArray();
		char y[] = str2.toCharArray();
		
		int length = str1.length() - lcs(x, y, n, m) ;
		System.out.println("Minimum number of deletions to make a string palindrome  : " + length);
	}

	static int lcs(char x[], char y[], int n, int m) {

		if (n == 0 || m == 0)
			return 0;

		if (x[n - 1] == y[m - 1])
			return lcs(x, y, n - 1, m - 1) + 1;
		else
			return Math.max(lcs(x, y, n - 1, m), lcs(x, y, n, m - 1));
	}
}
