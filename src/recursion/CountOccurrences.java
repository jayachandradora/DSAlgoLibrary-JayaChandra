package recursion;

public class CountOccurrences {

	static int countSubstrig(String str1, String str2) {
		int n1 = str1.length();
		int n2 = str2.length();

		// Base Case
		if (n1 == 0 || n1 < n2)
			return 0;

		// Recursive Case, Checking if the first substring matches
		if (str1.substring(0, n2).equals(str2))
			return countSubstrig(str1.substring(n2 - 1), str2) + 1;

		// Otherwise, return the count from the remaining index
		return countSubstrig(str1.substring(n2 - 1), str2);
	}

	static int countNumber(int arr[], int k, int size) {

		if (size == 0)
			return 0;

		if (arr[size] == k)
			return countNumber(arr, k, size - 1) + 1;

		return countNumber(arr, k, size - 1);
	}

	public static void main(String args[]) {
		// String str1 = "ghgeeksforgeeks", str2 = "geeks";
		// System.out.println(countSubstrig(str1, str2));

		String str1 = "hiiikakashiii";
		String str2 = "hiii";
		System.out.println(countSubstrig(str1, str2));

		int arr[] = { 1, 2, 3, 4, 4, 4, 4, 4, 4, 4, 7, 7, 7 }, k = 4, size = arr.length - 1;
		System.out.println(countNumber(arr, k, size));

	}
	
	

}
