package test;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String args[]) {

		Test t = new Test();
		int nums[] = { 1, 2, 3 };
		System.out.println(subarraySum(nums, 3));

		int arr[] = { 100, 10, 1 };
		System.out.println(maxAscendingSum(arr));

		int nums1[] = { 1, 2, 3, 2, 1 };
		int nums2[] = { 3, 2, 1, 4, 7 };
		
		String s1 = "jayacd";
		String s2 = "jayamd";

		char X[] = s1.toCharArray();
		char Y[] = s2.toCharArray();

		int m = X.length;
		int n = Y.length;
		System.out.println(t.findLength(nums, nums));
	}

	public int findLength(int[] nums1, int[] nums2) {

		return lcs(nums1, nums2, nums1.length, nums2.length, 0);
	}

	public int lcs(int[] nums1, int[] nums2, int m, int n, int count) {

		if (m == 0 || n == 0)
			return count;

		if (nums1[m - 1] == nums2[n - 1])
			count = lcs(nums1, nums2, m - 1, n - 1, count + 1);
		else
			count = Math.max(count, Math.max(lcs(nums1, nums2, m, n-1, 0), lcs(nums1, nums2, m-1, n, 0)));

		return count;
	}
	
	static int lcsubstring_rec(char[] X, char[] Y, int m, int n, int count) {
		
		if (m == 0 || n == 0)
			return count;
		
		if (X[m - 1] == Y[n - 1])
			count = lcsubstring_rec(X, Y, m - 1, n - 1, count + 1);
		else
			count = Math.max(count, Math.max(lcsubstring_rec(X, Y, m, n - 1, 0), lcsubstring_rec(X, Y, m - 1, n, 0)));
		
		return count;
	}

	static int maxAscendingSum(int[] nums) {
		int max = nums[0];
		int sum = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1])
				sum = sum + nums[i];
			else
				sum = nums[i];

			max = Math.max(max, sum);
		}
		return max;
	}

	// https://leetcode.com/problems/subarray-sum-equals-k/
	static int subarraySum(int[] nums, int k) {
		int result = 0;
		int sum = 0;
		Map<Integer, Integer> preSumMap = new HashMap<>();
		preSumMap.put(0, 1);

		for (int i = 0; i < nums.length; i++) {

			sum = sum + nums[i];

			if (preSumMap.containsKey(sum - k))
				result += preSumMap.get(sum - k);

			preSumMap.put(sum, preSumMap.getOrDefault(sum, 0) + 1);
		}

		return result;
	}

	// https://leetcode.com/problems/maximum-subarray/
	public int maxSubArray(int[] nums) {
		int sum = 0, max = 0;
		int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];

			if (sum < 0)
				sum = 0;
			else
				max = Math.max(sum, max);
		}

		return max;

	}
}