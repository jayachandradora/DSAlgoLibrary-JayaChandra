package intv.dp;

public class LCS {

	public static void main(String[] args) {

		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		char st1[] = str1.toCharArray();
		char st2[] = str2.toCharArray();
		
		System.out.println(lcs(st1, st2, st1.length, st2.length));

	}

	static int lcs(char[] X, char[] Y, int n, int m) {

		if (m == 0 || n == 0)
			return 0;
		if (X[n - 1] == Y[m - 1])
			return 1 + lcs(X, Y, n - 1, m - 1);
		else
			return Math.max(lcs(X, Y, n - 1, m), lcs(X, Y, n, m - 1));
	}

}
