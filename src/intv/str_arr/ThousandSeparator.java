package intv.str_arr;

public class ThousandSeparator {

	public static void main(String[] args) {

		System.out.println(thousandSeparator(12345));
	}

	public static String thousandSeparator(int n) {

		String num = Integer.toString(n);
		StringBuilder sb = new StringBuilder();

		for (int i = num.length(); i > 0; i -= 3) {

			if (sb.length() > 0)
				sb.insert(0, ".");

			sb.insert(0, num.substring(Math.max(0, i - 3), i));
		}
		return sb.toString();
	}

	public static String thousandSeparator1(int n) {

		String number = new StringBuilder("" + n).reverse().toString();
		StringBuilder res = new StringBuilder();

		for (int i = 0; i < number.length(); ++i) {
			if (i % 3 == 0 && i != 0)
				res.append('.');

			res.append(number.charAt(i));
		}

		return res.reverse().toString();
	}

}
