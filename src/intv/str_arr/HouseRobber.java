package intv.str_arr;

//
public class HouseRobber {

	public static void main(String[] args) {

		int nums[] = { 1, 2, 3, 1 };
		HouseRobber hr = new HouseRobber();
		System.out.println(hr.rob(nums));
		System.out.println(hr.rob1(nums));
	}

	public int rob1(int[] nums) {
		int pre = 0, cur = 0;
		for (int num : nums) {
			final int temp = Integer.max(pre + num, cur);
			pre = cur;
			cur = temp;
		}
		return cur;
	}

	private Integer[] dp;

	public int rob(int[] nums) {
		dp = new Integer[nums.length];
		return robFrom(nums, 0);
	}

	private int robFrom(int[] wealth, int currentIndex) {
		if (currentIndex >= wealth.length)
			return 0;
		if (dp[currentIndex] != null)
			return dp[currentIndex];

		int stealCurrent = wealth[currentIndex] + robFrom(wealth, currentIndex + 2);
		int skipCurrent = robFrom(wealth, currentIndex + 1);

		return dp[currentIndex] = Math.max(stealCurrent, skipCurrent);
	}
}
