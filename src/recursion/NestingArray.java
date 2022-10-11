package recursion;

public class NestingArray {

	public static void main(String[] args) {

		int[] nums = { 5, 4, 0, 3, 1, 6, 2 };
		NestingArray na = new NestingArray();
		System.out.println(na.arrayNesting(nums));
	}

	public int arrayNesting(int[] nums) {

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0)
				continue;
			max = Math.max(max, calculate(nums, i));
		}

		return max;
	}

	private int calculate(int[] nums, int i) {

		if (i == nums.length || nums[i] < 0)
			return 0;

		int nextValue = nums[i];
		nums[i] = Integer.MIN_VALUE;

		return 1 + calculate(nums, nextValue);
	}

}
