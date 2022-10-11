package dp;

/* Java program for Memoized version */
public class Fibonacci {

	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();

		System.out.println("Fibonacci number is" + " " + f.fib(5));
	}

	public int fib(int n) {
		int dp[] = new int[n + 1];
		return rec(dp, n);
	}

	public int rec(int dp[], int n) {
		if (n <= 1)
			return n;

		if (dp[n] != 0)
			return dp[n];

		dp[n] = rec(dp, n - 1) + rec(dp, n - 2);
		return dp[n];
	}

}
