package java8;

import java.util.Arrays;

public class Test11 {

	public static void main(String[] args) {
		System.out.println(orderlyQueue("baaca", 1));
		System.out.println(maxRepeating("ababc", "ab"));

		int arr[] = { 1, 2, 3 };
		System.out.println(shiftLetters("abc", arr));
		
	}

	public static String shiftLetters(String str, int arr[]) {
		int shift = 0;
		char ch[] = str.toCharArray();

		for (int i = str.length() - 1; i >= 0; i--) {
			shift = (shift + arr[i]) % 26;
			ch[i] = (char) ((ch[i] - 'a' + shift) % 26 + 'a');
		}

		return new String(ch);
	}

	public static String orderlyQueue(String s, int k) {

		if (k == 0)
			return s;
		else if (k > 1) {

			char[] charS = s.toCharArray();
			Arrays.sort(charS);
			return new String(charS);

		} else if (k == 1) {

			String ans = s;
			for (int i = 1; i < s.length(); i++) {
				String reorderedStr = s.substring(i) + s.substring(0, i);
				if (ans.compareTo(reorderedStr) > 0) {
					ans = reorderedStr;
				}
			}

			return ans;
		}
		return s;

	}

	public static int maxRepeating(String sequence, String word) {

		if (sequence.equals(word))
			return 1;

		int count = 0;
		StringBuilder sb = new StringBuilder(word);
		while (true) {
			if (sequence.indexOf(sb.toString()) != -1) {
				count++;
				sb.append(word);
			} else
				break;
		}
		return count;
	}
}
