package arrays;

import java.util.Arrays;
import java.util.Collections;

public class Find3LargestElements {

	public static void main(String[] args) {

		Integer arr[] = { 1, 4, 2, 3, 6, 8, 5 };
		Arrays.sort(arr, Collections.reverseOrder());

		for (int i = 0; i < 3; i++)
			System.out.print(arr[i] + " ");

		// OR

		int first = Integer.MIN_VALUE;
		int sec = Integer.MIN_VALUE;
		int third = Integer.MIN_VALUE;

		for (int i : arr) {
			if (first < i) {
				third = sec;
				sec = first;
				first = i;
			} else if (sec < i) {
				third = sec;
				sec = i;
			} else if (third < i) {
				third = i;
			}

		}

		System.out.println(first + " " + sec + " " + third);

		fib(10);

		int a = 'a';
		int b = 'b';
		System.out.println("ASCII Value " + a + " " + b);
		System.out.println(fib1(9));
		System.out.println(sortStr("jayaChandra".toLowerCase()));
		System.out.println("Anagran " + anagram("LISTEN".toLowerCase(), "SILENT".toLowerCase()));

		System.out.println("factorial " + fact(2));
		System.out.println("Number reverse " + reverseNumber(123));
		int arr1[] = { 14, 0, 5, 2, 0, 3, 0 };
		for (int i : separateZeros(arr1))
			System.out.print(i + " ");
	}

// 0, 1, 1, 2, 3,5
	static void fib(int n) {
		int no1 = 0;
		int no2 = 1;
		int temp = 0;

		if (n < 2) {
			System.out.print(no1 + " " + no2);
			return;
		} else
			System.out.print(no1 + " " + no2);

		for (int i = 2; i < n; i++) {

			temp = no2;
			no2 = no1 + no2;
			no1 = temp;
			System.out.print(" " + no2 + " ");
		}

	}

	static int fib1(int n) {
		if (n < 2)
			return n;

		int res = fib1(n - 1) + fib1(n - 2);
		return res;
	}

	static final int MAX_CHAR = 26;

	static String sortStr(String str) {
		int ch[] = new int[MAX_CHAR];

		for (char i : str.toCharArray()) {
			ch[i - 'a']++;
		}

		StringBuilder st = new StringBuilder();

		for (int i = 0; i < 26; i++)
			for (int j = 0; j < ch[i]; j++)
				st.append((char) (i + 'a'));

		return st.toString();
	}

	static boolean anagram(String str, String str2) {

		if (str.length() != str2.length())
			return false;

		int ch[] = new int[26];

		for (char i : str.toCharArray())
			ch[i - 'a']++;

		for (char i : str2.toCharArray())
			ch[i - 'a']--;

		for (int i : ch)
			if (i != 0)
				return false;

		return true;
	}

	static int fact(int n) {
		if (n < 2)
			return n;

		return n * fact(n - 1);
	}

	static int reverseNumber(int no) {
		int rev = 0;
		int carry = 0;

		if (no < 10)
			return no;

		while (no != 0) {
			carry = no % 10;
			no = no / 10;
			rev = rev * 10 + carry;
		}
		return rev;
	}

	static boolean isalphabet(char ch) {

		if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
			return true;
		else
			return false;
	}

	// 14, 0, 5, 2, 0, 3, 0
	static int[] separateZeros(int arr[]) {
		int idx = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				int temp = arr[idx];
				arr[idx] = arr[i];
				arr[i] = temp;
				idx++;
			}
		}
		return arr;
	}

}
