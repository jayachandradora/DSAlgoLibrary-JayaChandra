package intv.matrix;

import java.util.Stack;

public class SearchMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1,  3,  5,  7 }, 
				           { 10, 11, 16, 20 }, 
				           { 23, 30, 34, 60 } };
		int target = 3;

		System.out.println(searchMatrix(matrix, target));

		int[] arr = { 2, 6, 4, 8, 10, 9, 15 };
		System.out.println(new SearchMatrix().findUnsortedSubarray(arr));

	}

	public static boolean searchMatrix(int[][] matrix, int target) {

		int n = matrix[0].length;
		int start = 0;
		int end = matrix.length * n - 1;
		int mid;

		while (start <= end) {

			mid = (start + end) / 2;

			if (matrix[mid / n][mid % n] == target)
				return true;

			if (target > matrix[mid / n][mid % n])
				start = mid + 1;

			else
				end = mid - 1;
		}

		return false;
	}

	public int findUnsortedSubarray(int[] nums) {

		int n = nums.length, beg = -1, end = -2, min = nums[n - 1], max = nums[0];

		for (int i = 1; i < n; i++) {
			
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[n - 1 - i]);

			if (nums[i] < max)
				end = i;

			if (nums[n - 1 - i] > min)
				beg = n - 1 - i;
		}

		return end - beg + 1;
	}
}
