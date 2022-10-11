package arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Test22 {

	public static void main(String[] args) {

		int nums[] = { 4, 5, 6, 7, 8, 1, 2, 3 };
		System.out.println(search(nums, 2));

		int arr[] = { 1, 2, 4 }, arr1[] = { 2, 4, 5 };
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

	}

	static int bst(int nums[], int target) {

		int n = nums.length;
		int start = 0, end = n;
		int mid = 0;

		while (start <= end) {

			mid = (start + end) / 2;

			if (nums[mid] == target)
				return mid;

			else if (nums[mid] < target)
				start = mid + 1;

			else
				end = mid - 1;
		}
		return -1;
	}

	static int search(int nums[], int target) {

		int n = nums.length;
		int left = 0;
		int right = n - 1;
		int mid;

		// Iterative binary search
		while (left <= right) {
			mid = (left + right) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] >= nums[left]) { // check left half
				if (target <= nums[mid] && target >= nums[left]) // target is present in the left half
					right = mid - 1;
				else // not present left then mid +1 .. target is present in 2nd half
					left = mid + 1;
			} else {
				if (target >= nums[mid] && target <= nums[right])
					left = mid + 1;
				else
					right = mid - 1;
			}
		}
		return -1;
	}
}
