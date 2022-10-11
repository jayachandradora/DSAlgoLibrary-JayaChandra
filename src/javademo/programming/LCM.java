package javademo.programming;

public class LCM {

	public static void main(String[] args) {

		System.out.println(lcm(5, 10));
		int arr[] = { 20, 10, 30 };
		System.out.println(lcm(arr));

	}

	static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	static int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	static int lcm(int arr[]) {
		int result = 1;
		for (int i : arr)
			result = result * i;
		System.out.println(result);
		return result / gcd(arr);
	}

	static int gcd(int arr[]) {
		int result = arr[0];
		for (int i : arr) {
			result = gcd(i, result);
		}
		return result;
	}

}
