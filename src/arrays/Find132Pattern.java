package arrays;

import java.util.Stack;

public class Find132Pattern {

	static boolean find132pattern(int[] nums) {
		Stack<Integer> stk = new Stack<>();
		int midVal = Integer.MIN_VALUE;

		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] < midVal)
				return true;

			while (!stk.isEmpty() && nums[i] > stk.peek())
				midVal = stk.pop();

			stk.push(nums[i]);
		}
		return false;
	}

	static boolean o3Approach(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++)
				for (int k = j + 1; k < n; k++)
					if (nums[i] < nums[k] && nums[k] < nums[j])
						return true;

		}
		return false;
	}

	static boolean o2Approach(int[] nums) {
		int n = nums.length;
		int leftMin = nums[0];
		
		for (int j = 0; j < n; j++) {
			for (int k = j + 1; k < n; k++) {
				if (nums[k] > leftMin && nums[j] > nums[k])
					return true;
			}
			leftMin = Math.min(leftMin, nums[j]);
		}
		return false;

	}

	public static void main(String[] args) {

		int nums[] = { 3, 1, 4, 2 };
		System.out.println(o2Approach(nums));
	}

}
