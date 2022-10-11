package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {

	public static List<List<Integer>> subsetsIterative(int[] nums) {
		 List<List<Integer>> res = new ArrayList<>();
	        res.add(new ArrayList<>());
	        
	        for (int num : nums){
	            List<List<Integer>> tempListOfSubsets = new ArrayList<>();
	            for(List<Integer> subset : res){
	                List<Integer> copied = new ArrayList<>(subset);
	                copied.add(num);
	                tempListOfSubsets.add(copied);
	            }
	            res.addAll(tempListOfSubsets);
	        }
	        return res;
	}

	public static void main(String[] args) {
		Subsets obj = new Subsets();
		int nums[] = { 1, 2, 2 };
		
		System.out.println();
		//System.out.println(obj.subsets3(nums));
		System.out.println("subset2 " + obj.subsets2Iterative(nums));
		//System.out.println("subset2 " + obj.subsets2(nums));

		
		int num[] = {1, 2, 3};
		//System.out.println(subsets(num));
	}
	
	public static List<List<Integer>> subsets2Iterative(int[] nums) {
		Set<List<Integer>> res = new HashSet<>();
	        res.add(new ArrayList<>());
	        
	        for (int num : nums){
	            List<List<Integer>> curr = new ArrayList<>();
	            for(List<Integer> subset : res){
	                List<Integer> copied = new ArrayList<>(subset);
	                copied.add(num);
	                curr.add(copied);
	            }
	            res.addAll(curr);
	        }
	        return new ArrayList<>(res);
	}


	// https://www.youtube.com/watch?v=i8Lay6smOWs&ab_channel=NareshGupta
	static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		for (int num : nums) {
			int size = result.size();
			for (int i = 0; i < size; i++) {
				List<Integer> subset = new ArrayList<>(result.get(i));
				subset.add(num);
				result.add(subset);
			}
		}

		return result;
	}

	public List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		dfs(nums, 0, new ArrayList<>(), result);
		return result;
	}

	private void dfs(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
		result.add(new ArrayList<>(current));
		for (int i = start; i < nums.length; i++) {
			current.add(nums[i]);
			dfs(nums, i + 1, current, result);
			current.remove(current.size() - 1);
		}
	}

	// https://www.youtube.com/watch?v=taIvqOIT3cM&ab_channel=codebix
	public List<List<Integer>> subsets3(int nums[]) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> curr = new ArrayList<Integer>();
		if (nums.length == 0)
			return result;

		bt(nums, 0, curr, result);
		return result;
	}

	private void bt(int[] nums, int i, List<Integer> curr, List<List<Integer>> result) {
		if (i == nums.length) {
			result.add(new ArrayList<Integer>(curr));
			return;
		}
		curr.add(nums[i]);
		bt(nums, i + 1, curr, result);
		curr.remove(curr.size() - 1);
		bt(nums, i + 1, curr, result);
	}

}
