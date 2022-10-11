package arrays;

public class PrimeNumber {

	public static void main(String[] args) {

		System.out.println(isPrime(37));

		int max2 = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
		int temp = 0;
		int arr[] = { 3, 5, 7, 9, 15, 18, 19 };
		for (int in : arr) {
			if (isPrime(in)) {
				max = Math.max(max, in);
				//if(in <max) TODO
			}
		}
		System.out.println(max);
	}

	static boolean isPrime(int n) {
		// check if n is a multiple of 2
		if (n % 2 == 0)
			return false;
		// if not, then just check the odds
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
