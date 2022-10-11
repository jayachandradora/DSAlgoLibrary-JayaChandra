package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://www.youtube.com/watch?v=yFfv03AE_vA&ab_channel=NareshGupta
public class CombinationSum {

	public static void main(String[] args) {
		int nums[] = {10,1,2,7,6,1,5 };
		int target = 8;

		CombinationSum cs = new CombinationSum();
		for (List<Integer> list : cs.combinationSumII(nums, target))
			System.out.print(list + " ");

	}

	public List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();

		backtrac(nums, 0, target, new ArrayList<Integer>(), result);
		return result;
	}

	private void backtrac(int[] nums, int start, int target, List<Integer> list, List<List<Integer>> result) {
		if (target < 0)
			return;
		if (target == 0)
			result.add(new ArrayList<>(list));

		for (int i = start; i < nums.length; i++) {
			list.add(nums[i]);
			backtrac(nums, i, target - nums[i], list, result);
			list.remove(list.size() - 1);
		}
	}

	public List<List<Integer>> combinationSumII(int[] nums, int target) {
		Set<List<Integer>> result = new HashSet<>();
		Arrays.sort(nums);
		backtracII(nums, 0, target, new ArrayList<Integer>(), result);
		return new ArrayList<>(result);
	}

	private void backtracII(int[] nums, int start, int target, List<Integer> list, Set<List<Integer>> result) {
		if (target < 0)
			return;
		if (target == 0)
			result.add(new ArrayList<>(list));

		for (int i = start; i < nums.length; i++) {
			list.add(nums[i]);
			backtracII(nums, i + 1, target - nums[i], list, result);
			list.remove(list.size() - 1);
		}
	}

}
