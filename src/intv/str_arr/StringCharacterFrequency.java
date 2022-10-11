package intv.str_arr;

public class StringCharacterFrequency {

	static final int charLen = 26;

	static void charFrequency(String str) {

		int[] freq = new int[charLen];

		for (int i = 0; i < str.length(); i++)
			freq[str.charAt(i) - 'a']++;

		for (int i = 0; i < str.length(); i++) {

			if (freq[str.charAt(i) - 'a'] != 0) {

				System.out.print(str.charAt(i));
				System.out.print(freq[str.charAt(i) - 'a']);

				freq[str.charAt(i) - 'a'] = 0;
			}
		}
	}

	public static void main(String args[]) {
		String str = "geeksforgeeks";
		charFrequency(str);
	}
}
