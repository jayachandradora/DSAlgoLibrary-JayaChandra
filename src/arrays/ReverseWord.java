package arrays;

public class ReverseWord {

	public static void main(String[] args) {

		String str = "I am          jaya Chandra";

		// System.out.println(strReverse(str));

		System.out.println(reverseWords(str));
	}

	static String reverseWords(String str) {
		if (str != null) {
			String st[] = str.split(" +");
			StringBuilder sb = new StringBuilder();
			StringBuilder res = new StringBuilder();
			for (String s : st) {
				res.append(new StringBuilder(s).reverse()).append(" ");
			}
			return res.toString().trim();
		}

		return str;
	}

	static String strReverse(String str) {

		String[] st = str.split(" +");

		StringBuilder strb = new StringBuilder();
		for (int i = 0; i < st.length / 2; i++) {
			String temp = st[st.length - 1 - i];
			st[st.length - 1 - i] = st[i];
			st[i] = temp;
		}

		for (String s : st) {
			strb.append(s);
			strb.append(" ");
		}

		return strb.toString();
	}

}
