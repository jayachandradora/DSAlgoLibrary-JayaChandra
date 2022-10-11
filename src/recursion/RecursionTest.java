package recursion;

import java.util.HashMap;
import java.util.Map;

public class RecursionTest {

	private static Map<Integer, Integer> memo = new HashMap<>();
	
	private static int memoArray[] = 	new int[51];

	public static void main(String[] args) {

		System.out.println("sumNumbers : " + sumNumbers(5));
		System.out.println("fib : " + fibMemo(50));
		printNumbers(7, 1);
		
	}

	public static int sumNumbers(int n) {
		if (n <= 0)
			return 0;
		if (n <= 2)
			return 1;
		int res = 0;
		res += n + sumNumbers(n - 1);
		return res;
	}

	public static int fib(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;

		if (memo.containsKey(n)) {
			System.out.println("Memo " + memo.get(n));
			return memo.get(n);
		}

		int res = 0;

		res = fib(n - 1) + fib(n - 2);
		memo.put(n, res);
		
		return res;
	}
	
	public static int fibMemo(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;

		if (memoArray[n] !=0) 
			return memoArray[n];

		memoArray[n] = fib(n - 1) + fib(n - 2);
		
		return memoArray[n];
	}
	
	static void printNumbers(int n, int i) {
		System.out.print(i + " ");
		if(i == n)
			return;
		printNumbers(n, i+1);
	}

}
