package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestMain {

	public static void main(String[] args) {

		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<>());
		int nums[] = { 1, 2, 3 };

		for (Integer in : nums) {
			int n = res.size();
			for (int j = 0; j < n; j++) {
				List<Integer> list = new ArrayList<Integer>(res.get(j));
				list.add(in);
				res.add(list);
			}
		}
		System.out.println(res);

	}

	
	public List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> subsets = new ArrayList<>();
		generateSubsets(0, nums, new ArrayList<Integer>(), subsets);
		return subsets;
	}

	public void generateSubsets(int index, int nums[], List<Integer> current, List<List<Integer>> subsets) {

		subsets.add(new ArrayList<Integer>(current));
		for (int i = index; i < nums.length; i++) {
			current.add(nums[i]);
			generateSubsets(i + 1, nums, current, subsets);
			current.remove(current.size() - 1);
		}
	}

	Set<List<Integer>> res = new HashSet<>();

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		bt(nums, 0, new ArrayList<>());
		return new ArrayList<>(res);
	}

	public void bt(int nums[], int start, ArrayList<Integer> curr) {
		if (start > nums.length)
			return;

		res.add(new ArrayList<>(curr));
		for (int i = start; i < nums.length; i++) {
			curr.add(nums[i]);
			bt(nums, i + 1, curr);
			curr.remove(curr.size() - 1);
		}
	}

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> output = new ArrayList<>();
		generateCombination(1, n, new ArrayList(), output, k);
		return output;
	}

	void generateCombination(int start, int n, List<Integer> curr, List<List<Integer>> output, int k) {

		if (curr.size() == k) {
			output.add(new ArrayList(curr));
			return;
		}
		for (int i = start; i <= n; i++) {
			curr.add(i);
			generateCombination(i + 1, n, curr, output, k);
			curr.remove(curr.size() - 1);
		}
	}
}
