package intv.str_arr;

public class IncreasingTripletSubSequence {

	public static void main(String[] args) {

		int nums[] = { 20, 100, 10, 12, 5, 13 };
		System.out.println(increasingTriplet1(nums));
	}

	static boolean increasingTriplet(int[] nums) {
		int fast = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;

		for (int num : nums) {
			if (num <= fast) {
				fast = num;
			} else if (num <= second) {
				second = num;
			} else {
				return true;
			}
		}
		return false;
	}

	static boolean increasingTriplet1(int nums[]) {

		int n = nums.length;
		if (n < 3)
			return false;

		int[] leftMin = new int[n];
		leftMin[0] = nums[0];
		
		for (int i = 1; i < n; i++)
			leftMin[i] = Math.min(leftMin[i - 1], nums[i]);

		int[] rightMax = new int[n];
		rightMax[n - 1] = nums[n - 1];
		
		for (int i = n - 2; i >= 0; i--)
			rightMax[i] = Math.max(rightMax[i + 1], nums[i]);

		for (int i = 0; i < n; i++)
			if (leftMin[i] < nums[i] && nums[i] < rightMax[i])
				return true;

		return false;
	}
}
