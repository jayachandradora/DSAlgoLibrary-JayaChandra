package dp;

//TargeTSum same as CountNumberSubsetGivenDifference problem
// Refer this class CountNumberSubsetGivenDifference
public class TargetSum {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 1 };
		int S = 3;
		int sumOfArr = 0;
		for (int in : nums)
			sumOfArr += in;

		// Find the Equation here: here S1 and S2 means S1 is set of +ve numbers and S2
		// means -ve numbers
		// Equation1 : S1 + S2 = sumOfArray
		// Equation2 : S1 - S2 = diff (diff is nothing but S given in the input in the
		// question)
		// Sum of 2 equation : 2S1 = sumOffArr + diff or S1 = (sumOffArr + diff)/2
		// Here 2S1 is nothing but subsetSum

		int sumOfSbuset1 = (S + sumOfArr) / 2;
		System.out.println("Count TargetSum " + subsetSumAditya(nums, nums.length, sumOfSbuset1));
		System.out.println("findTargetSumWays " + findTargetSumWays(nums, S)); // findTargetSumWays 5
	}

	public static int subsetSumAditya(int arr[], int n, int sum) {

		if (sum == 0)
			return 1;

		if (n == 0 && sum != 0)
			return 0;

		if (arr[n - 1] > sum)
			return subsetSumAditya(arr, n - 1, sum);

		return subsetSumAditya(arr, n - 1, sum - arr[n - 1]) + subsetSumAditya(arr, n - 1, sum);
	}

	static int count1 = 0;

	public static int findTargetSumWays(int[] nums, int target) {
		calculate(nums, 0, 0, target);
		return count1;
	}

	public static void calculate(int[] nums, int i, int sum, int target) {
		if (i == nums.length) {
			if (sum == target)
				count1++;
		} else {
			calculate(nums, i + 1, sum + nums[i], target);
			calculate(nums, i + 1, sum - nums[i], target);
		}
	}

}
