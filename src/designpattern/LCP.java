package designpattern;

//https://leetcode.com/articles/longest-common-prefix/
public class LCP {
	static int findMinLength(String arr[], int n) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= (n - 1); i++) {
			if (arr[i].length() < min) {
				min = arr[i].length();
			}
		}
		return min;
	}

	static boolean allContainsPrefix(String arr[], int n, String str, int start, int end) {
		for (int i = 0; i <= (n - 1); i++) {
			String arr_i = arr[i];

			for (int j = start; j <= end; j++)
				if (arr_i.charAt(j) != str.charAt(j))
					return false;
		}
		return true;
	}

	static String commonPrefix(String arr[], int n) {
		int index = findMinLength(arr, n);
		String prefix = "";

		int low = 0, high = index;
		while (low <= high) {
			int mid = (low + high) / 2;

			if (allContainsPrefix(arr, n, arr[0], low, mid)) {
				prefix = prefix + arr[0].substring(low, mid - low + 1);
				low = mid + 1;
			} else // Go for the left part
				high = mid - 1;
		}
		return prefix;
	}

	public static String longestCommonPrefixHor(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++)
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty())
					return "";
			}
		return prefix;
	}

	public static String longestCommonPrefixVer(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (i == strs[j].length() || strs[j].charAt(i) != c)
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}

	// Driver program to test above function
	public static void main(String args[]) {
		String arr[] = { "geeksforgeeks", "geeks", "geeeek", "geezer" };
		int n = arr.length;

		String ans = commonPrefix(arr, n);
		System.out.println("hhh " + longestCommonPrefixHor(arr));

		System.out.println("Ver " + longestCommonPrefixVer(arr));
		if (ans.length() > 0)
			System.out.println("The longest common" + " prefix is " + ans);
		else
			System.out.println("There is no common" + " prefix");
		LCP lcp = new LCP();
		System.out.println("Rec " + lcp.longestCommonPrefix(arr));
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		return longestCommonPrefix(strs, 0, strs.length - 1);
	}

	private String longestCommonPrefix(String[] strs, int l, int r) {
		if (l == r) {
			return strs[l];
		} else {
			int mid = (l + r) / 2;
			String lcpLeft = longestCommonPrefix(strs, l, mid);
			String lcpRight = longestCommonPrefix(strs, mid + 1, r);
			return commonPrefix(lcpLeft, lcpRight);
		}
	}

	String commonPrefix(String left, String right) {
		int min = Math.min(left.length(), right.length());
		for (int i = 0; i < min; i++) {
			if (left.charAt(i) != right.charAt(i))
				return left.substring(0, i);
		}
		return left.substring(0, min);
	}
}
