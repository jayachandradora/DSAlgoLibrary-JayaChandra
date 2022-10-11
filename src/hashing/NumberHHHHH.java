package hashing;

import java.math.BigInteger;

public class NumberHHHHH {

	public static void main(String[] args) {

		int num1 = 4;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= num1; i++)
			sb.append(binary(i));

		long num = Long.parseLong(sb.toString());

		System.out.println(sb.toString());
		System.out.println(FindBigNum(num));
		
		
		String binaryString = sb.toString();
		try {
			String st = Integer.toBinaryString(4);
			System.out.println(" Binary string " + st);
			BigInteger bigNumber = new BigInteger(binaryString, 2);
			System.out.println("BigNumber is: " + bigNumber);
		} catch (NumberFormatException ne) {
			System.out.println("Binary input is invalid");
			ne.printStackTrace();
		}
	}

	static String binary(int n) {

		String x = "";
		while (n > 0) {
			int a = n % 2;
			x = a + x;
			n = n / 2;
		}

		return x;
	}

	static long FindBigNum(long n) {
		String str = Long.toString(n);
		char[] numbers = str.toCharArray();
		int result = 0;
		for (int i = numbers.length - 1; i >= 0; i--)
			if (numbers[i] == '1')
				result += Math.pow(2, (numbers.length - i - 1));
		return Long.valueOf(result);
	}
}