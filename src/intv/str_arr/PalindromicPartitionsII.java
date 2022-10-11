package intv.str_arr;

public class PalindromicPartitionsII {

	public static void main(String[] args) {
		String input = "aabb";

		System.out.println("All possible palindrome" + "partions for " + input + " are :");

		System.out.println(palindromicPartitions(input, 0, input.length() - 1));
	}

	static int palindromicPartitions(String input, int i, int j) {
		if (i >= j)
			return 0;
		
		if (isPalindrome(input, i, j))
			return 0;

		int min = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			
			int temp = 1 + palindromicPartitions(input, i, k) + palindromicPartitions(input, k + 1, j);
			if (temp < min)
				min = temp;
		}

		return min;
	}

	static boolean isPalindrome(String input, int start, int end) {
		while (start < end) {
			if (input.charAt(start++) != input.charAt(end--))
				return false;
		}
		return true;
	}

}
