package dp;

import java.util.Stack;

public class OracleTest {

	// https://leetcode.com/problems/license-key-formatting/
	public static void main(String[] args) {
		System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
		Stack st = new Stack();
		st.push(4);
		st.push("Jaya");
		
		System.out.println(st.pop()+ " ,  " + st.pop());
		

	}

	public static String groupCharcater(String str1, int k) {

		StringBuilder str = new StringBuilder();
		int digitLen = 0;

		for (char ch : str1.toCharArray())
			if (Character.isLetterOrDigit(ch))
				digitLen += 1;

		int rem = digitLen % k;
		int i = 0;

		for (char ch1 : str1.toCharArray()) {

			if (rem != 0) {
				if (Character.isLetterOrDigit(ch1))
					str.append(ch1);
				rem--;
				if (rem == 0)
					str.append('-');
			} else {
				if (Character.isLetterOrDigit(ch1)) {
					str.append(ch1);

					if (i == k - 1) {
						str.append('-');
						i = 0;
					}
					i++;
				}
			}
		}

		return str.toString().toUpperCase();
	}

	static String licenseKeyFormatting(String s, int k) {
		StringBuilder res = new StringBuilder();
		for (int i = s.length() - 1, rem = k + 1; i >= 0; i--) {
			if (s.charAt(i) == '-')
				continue;
			if (--rem == 0) {
				res.append("-");
				rem = k;
			}
			res.append(s.charAt(i));
		}
		return res.reverse().toString().toUpperCase();
	}
	
	//try to understand this problem  https://leetcode.com/problems/cherry-pickup-ii/
}
