package intv.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TripletSum {

	public static boolean tripletExists(int[] A, int n, int sum, int count) {
		if (count == 3 && sum == 0)
			return true;

		if (count == 3 || n == 0 || sum < 0)
			return false;

		return tripletExists(A, n - 1, sum - A[n - 1], count + 1) || tripletExists(A, n - 1, sum, count);
	}

	public static void main(String[] args) {
		int[] A = { 2, 7, 4, 0, 9, 5, 1, 3 };
		int sum = 6;

		TripletSum ts = new TripletSum();
		System.out.println(ts.threeSum(A));

		if (tripletExists(A, A.length, sum, 0))
			System.out.print("Triplet Exists");
		else
			System.out.print("Triplet Don't Exist");

		System.out.println();
		find3Numbers(A, A.length, sum);
	}

	public List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> res = new HashSet<>();
		if (nums.length == 0)
			return new ArrayList<>(res);
		
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			
			int j = i + 1;
			int k = nums.length - 1;
			
			while (j < k) {
				
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0)
					res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
				else if (sum > 0)
					k--;
				else if (sum < 0)
					j++;
			}
		}
		return new ArrayList<>(res);
	}

	static boolean find3Numbers(int A[], int arr_size, int sum) { // TC: O(N^2), SC : O(N).

		int l, r;
		Arrays.parallelSort(A);

		for (int i = 0; i < arr_size - 2; i++) {

			l = i + 1;
			r = arr_size - 1;
			while (l < r) {
				if (A[i] + A[l] + A[r] == sum) {
					System.out.print("Triplet is " + A[i] + ", " + A[l] + ", " + A[r]);
					return true;
				} else if (A[i] + A[l] + A[r] < sum)
					l++;
				else
					r--;
			}
		}
		return false;
	}

	public static void printAllTriplets(int[] arr, int sum) {
		Arrays.sort(arr);

		for (int i = 0; i <= arr.length - 3; i++) {
			int k = sum - arr[i];
			int low = i + 1;
			int high = arr.length - 1;

			while (low < high) {
				if (arr[low] + arr[high] < k) {
					low++;
				} else if (arr[low] + arr[high] > k) {
					high--;
				} else {
					System.out.println("(" + arr[i] + ", " + arr[low] + ", " + arr[high] + ")");
					low++;
					high--;
				}
			}
		}
	}

	List<List<Integer>> res = new ArrayList<List<Integer>>();
	Map<String, Integer> hm = new HashMap<>();

	public List<List<Integer>> threeSum1(int[] nums) {

		if (nums.length < 3) {
			return res;
		}
		Arrays.sort(nums);
		List<Integer> temp = new ArrayList<>();
		solve(nums, 0, temp, 0);
		return res;
	}

	public void solve(int[] arr, int i, List<Integer> temp, int sum) {

		if (temp.size() == 3) {
			if (sum == 0 && !res.contains(temp))
				res.add(new ArrayList(temp));

			return;
		}

		if (i == arr.length) {
			return;
		}

		String key = i + "-" + temp + "-" + sum;
		if (hm.containsKey(key))
			return;

		temp.add(arr[i]);
		solve(arr, i + 1, temp, sum + arr[i]);
		temp.remove(temp.size() - 1);
		solve(arr, i + 1, temp, sum);

		hm.put(key, 1);
		return;
	}

}
