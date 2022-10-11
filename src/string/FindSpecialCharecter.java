package string;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindSpecialCharecter {

	public static void main(String[] args) {

		String specialCharStr = "adfasd#$112%";
		findSpecialCharecter(specialCharStr);

		String intString = "hello12hhh90";
		removeIntegersFromString(intString);

		String spaceStr = "hello jaya    Chandra dora";
		removeSpaceFromString(spaceStr);

		String specialChrStr = "jaay#$chandra123)(";
		removeSpecialCharFromString(specialChrStr);

		String fullStr = "asdfasdfasdXasdffasd";
		char ch = 'a';
		removeCharFromString(fullStr, ch);

		findTwoStringAnagram("abc", "cbk");

		isPalindrome("abba");
		replaceSpecialCharcter("asdfaHasdfasdH");

		splitStringWithWords("Jaya chandra dora ");
	}

	static void splitStringWithWords(String str) {
		str = str.trim();
		String[] str1 = str.split(" ");
		for (String str0 : str1)
			System.out.println(" hello " +new StringBuffer(str0).reverse().toString());

		// System.out.println(str0);

	}

	static void replaceSpecialCharcter(String str) {
		String replaceStr = str.replace("H", "_");
		System.out.println("Replace String " + replaceStr);

	}

	static void removeCharFromString(String str, char ch) {
		System.out.print("Remove charecter from String ");
		int index = str.indexOf("X");

		String str1 = str.substring(0, index) + str.substring(index + 1);
		System.out.print(str1);

		System.out.println();
	}

	static void removeSpecialCharFromString(String str) {

		System.out.print("Print String with our Special Charecter:  ");
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetterOrDigit(str.charAt(i)))
				System.out.print(str.charAt(i));
		}
		System.out.println();
	}

	static void removeSpaceFromString(String str) {

		System.out.print("With out Space String: ");
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isSpaceChar(str.charAt(i))) {
				System.out.print(str.charAt(i));
				count++;
			}
		}
		System.out.println("Total charecter " + count);
		System.out.println();

	}

	static void removeIntegersFromString(String str) {

		System.out.print("Remove Integers from String: ");
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i)))
				System.out.print(str.charAt(i));
		}
		System.out.println();
	}

	static void findSpecialCharecter(String str) {
		Pattern p = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(str);

		int count = 0;
		while (m.find()) {
			count = count + 1;
			System.out.println("Position " + m.start() + " : " + str.charAt(m.start()));
		}
		System.out.println("Total Special Charecter " + count);
	}

	static void findTwoStringAnagram(String str, String str1) {

		if (str.length() != str1.length())
			System.out.println("Its not an Anagram");
		else {
			char[] st = str.toCharArray();
			char[] st1 = str1.toCharArray();

			Arrays.sort(st);
			Arrays.sort(st1);
			boolean eq = Arrays.equals(st, st1);

			if (eq)
				System.out.println("Anagram");
			else
				System.out.println("Not an Anagram");
		}
	}

	static void isPalindrome(String str) {

		String reverseStr = new StringBuffer(str).reverse().toString();
		if (str.compareTo(reverseStr) == 0)
			System.out.println("Its a Palindrome String");
		else
			System.out.println("Its not a Palindrome String");
	}
}
