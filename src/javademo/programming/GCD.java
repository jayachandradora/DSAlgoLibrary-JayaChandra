package javademo.programming;

interface A{
	default void display(){
		System.out.println("Hie");
	}
	
	static void show(){
		System.out.println("Show");
	}
}
public class GCD implements A {

	public static void main(String[] args) {

		System.out.println(gcd2(20, 4));

		System.out.println(disp(20, 4));

		System.out.println(gcdWithoutRecursion(20, 4));
		
		A.show();
		
		A a = new GCD();
		a.display();

	}
	
	// with recursion
	static int gcd(int a, int b) {
		if (a == 0 && b == 0)
			return a;
		if (a == b)
			return a;
		if (a > b)
			return gcd(a - b, b);
		else
			return gcd(a, b - a);
	}

	// 2nd recursion

	static int gcd2(int a, int b) {
		if (a == 0)
			return b;
		return gcd2(b % a, a);
	}

	static int disp(int a, int b) {
		return a % b;
	}

	static int findGCD(int arr[], int n) {
		int result = arr[0];
		for (int i = 1; i < n; i++)
			result = gcd(arr[i], result);

		return result;
	}

	//todo
	static int gcdWithoutRecursion(int a, int b) {

		int gcd = 0;
		while (a == 0) {

			if (a == 0) {
				gcd = b;
				break;
			} else {
				b = b % a;
				if (b > a) {
					int temp = a;
					a = b;
					b = temp;
				}
			}
		}

		return gcd;
	}
}
