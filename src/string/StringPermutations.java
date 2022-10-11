package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutations {

	int counter = 0;
	static List<List<Integer>> res = new ArrayList<>();

	public static void main(String[] args) {
		String str = "xyz";
		// StringPermutations sp = new StringPermutations();
		// sp.permute(str, 0, str.length() - 1);
		// System.out.println(sp.counter);

		printPermutation(str, "");
		System.out.println(isAnagram("anagram", "nagaram"));
	}

	public static boolean isAnagram(String s, String t) {

		if (s.length() != t.length())
			return false;

		char sChar[] = s.toCharArray();
		char tChar[] = t.toCharArray();

		Arrays.sort(sChar);
		Arrays.sort(tChar);
		return Arrays.equals(sChar, tChar);
	}

	// https://www.youtube.com/watch?v=bRs6E_SL2Tk&ab_channel=ApnaCollege
	public static void printPermutation(String str, String permStr) {
		if (str.length() == 0) {
			System.out.println(permStr);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			char curr = str.charAt(i);
			String newStr = str.substring(0, i) + str.substring(i + 1);
			printPermutation(newStr, permStr + curr);
		}
	}

	void permute(String str, int l, int r) {
		if (l == r) {
			counter++;
			System.out.println(str);
		} else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	String swap(String str, int l, int r) {
		char temp;
		char ch[] = str.toCharArray();
		temp = ch[l];
		ch[l] = ch[r];
		ch[r] = temp;
		str = String.valueOf(ch);
		return str;
	}
}
