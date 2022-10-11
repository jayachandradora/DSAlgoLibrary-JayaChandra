package designpattern;

import java.util.Arrays;

public class TTS {

	// Driver code
	public static void main(String[] args) {

		String str = "aabaa";
		String str1 = "baaaa";

		if (str.length() != str1.length() || !isAnagram(str.toCharArray(), str1.toCharArray()))
			System.out.println("Not an Anagram");
		else
			System.out.println("Its Anagram");
		System.out.println(removeDuplicate(str1));
		
		System.out.println(strstr("GeeksForGeeks", "For"));
		
	}

	static int strstr(String str, String target) {

		int t = 0;
		int len = str.length();
		int i;

		// Iterate from 0 to len - 1
		for (i = 0; i < len; i++) {
			if (t == target.length())
				break;
			if (str.charAt(i) == target.charAt(t))
				t++;
			else
				t = 0;
		}

		return t < target.length() ? -1 : i - t;
	}

	static boolean isAnagram(char[] str, char str1[]) {

		int ch[] = new int[26];
		Arrays.fill(ch, 0);

		for (int i = 0; i < str.length; i++)
			ch[str[i] - 'a']++;

		for (int i = 0; i < str.length; i++)
			ch[str1[i] - 'a']--;

		for (int i = 0; i < 26; i++)
			if (ch[i] != 0)
				return false;

		return true;

	}

	static String removeDuplicate(String str) {
		String st = new String();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (st.indexOf(c) < 0)
				st += c;
		}
		return st;
	}
}
