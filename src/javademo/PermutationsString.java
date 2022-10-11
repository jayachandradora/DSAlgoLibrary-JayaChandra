package javademo;

//GFG 2nd solution
public class PermutationsString {

	public static void main(String[] args) {
		String str = "abc";
		permutions(str, 0, str.length() - 1);
	}

	private static void permutions(String str, int l, int r) {
		if (l == r) {
			System.out.println(str + " ");
			return;
		}
		for (int i = l; i <= r; i++) {
			str = swap(str, l, i);
			permutions(str, l + 1, r);
			str = swap(str, l, i);
		}
	}

	private static String swap(String str, int l, int i) {

		char ch[] = str.toCharArray();
		char temp = ch[l];
		ch[l] = ch[i];
		ch[i] = temp;
		return new String(ch);
	}
}
