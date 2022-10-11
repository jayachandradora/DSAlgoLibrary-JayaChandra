package dp;

public class LongestCommonSubString {

	public static void main(String[] args) {

		String s1 = "jayacd";
		String s2 = "jayamd";

		char X[] = s1.toCharArray();
		char Y[] = s2.toCharArray();

		int m = X.length;
		int n = Y.length;

		System.out.println("lcsubStringTopDown : " + lcsubStringTopDown(X, Y, m, n));
		System.out.println("lcsubstring_rec " + lcsubstring_rec(X, Y, m, n, 0));
		
	}

	static int lcsubStringTopDown(char X[], char Y[], int m, int n) {

		int t[][] = new int[m + 1][n + 1];
		int result = 0;
		for (int i = 0; i <= m; i++)
			for (int j = 0; j <= n; j++) {
				
				if (i == 0 || j == 0)
					t[i][j] = 0;
		
				else if (X[i - 1] == Y[j - 1]) {
					
					t[i][j] = t[i - 1][j - 1] + 1;
					result = max(result, t[i][j]);
					
				} else
					t[i][j] = 0;
			}
		return result;
	}

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	static int lcsubstring_rec(char[] X, char[] Y, int m, int n, int count) {
		if (m == 0 || n == 0)
			return count;
		if (X[m - 1] == Y[n - 1])
			count = lcsubstring_rec(X, Y, m - 1, n - 1, count + 1);
		else
			count = max(count, max(lcsubstring_rec(X, Y, m, n - 1, 0), lcsubstring_rec(X, Y, m - 1, n, 0)));
		
		return count;
	}

}
