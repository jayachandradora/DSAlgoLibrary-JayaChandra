package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://www.youtube.com/watch?v=B3U6LExgevE
public class PermutationAndCombination {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3 };
		for (List ls : permutationsApproach1(arr))
			System.out.println(ls);

		char[] s = "ABC".toCharArray();
		permutationsApproach2(s, 0);

		for (List ls1 : combinations(arr))
			System.out.println(ls1);
	}

	public static List<List<Integer>> permutationsApproach1(int[] arr) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		backtrack(list, new ArrayList<>(), arr);
		return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i <= tempList.size(); i++) {
				tempList.add(i, nums[tempList.size()]);
				backtrack(list, tempList, nums);
				tempList.remove(i);
			}
		}
	}

	// Utility function to swap two characters in a character array
	static void swap(char[] ch, int i, int j) {
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
	}

	// https://www.techiedelight.com/generate-permutations-string-java-recursive-iterative/
	// Recursive function to generate all permutations of a String
	static void permutationsApproach2(char[] ch, int currentIndex) {
		if (currentIndex == ch.length - 1) {
			System.out.println(String.valueOf(ch));
		}

		for (int i = currentIndex; i < ch.length; i++) {
			swap(ch, currentIndex, i);
			permutationsApproach2(ch, currentIndex + 1);
			swap(ch, currentIndex, i);
		}
	}

	public static List<List<Integer>> combinations(int arr[]) {

		List<List<Integer>> result = new LinkedList<List<Integer>>();
		combinationsPassed(arr, 0, result, new LinkedList<Integer>());

		return result;
	}

	static void combinationsPassed(int arr[], int i, List<List<Integer>> result, List<Integer> path) {

		if (i == arr.length) {
			result.add(path);
			return;
		}
		List<Integer> pathWithCurrent = new ArrayList<Integer>(path);
		pathWithCurrent.add(arr[i]);

		combinationsPassed(arr, i + 1, result, path);
		combinationsPassed(arr, i + 1, result, pathWithCurrent);
	}
}
