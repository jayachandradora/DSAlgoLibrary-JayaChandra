package problems;

public class GCDTest {

	public static void main(String[] args) {

		System.out.println(findGCD(10, 15));
	}

	private static int findGCD(int number1, int number2) {
		// base case
		if (number2 == 0)
			return number1;

		return findGCD(number2, number1 % number2);
	}

}
