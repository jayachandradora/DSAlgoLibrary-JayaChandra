package ds.tree;

public class SortedRotatedArrayCheckHere {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 4, 4, 4, 5, 6, 7, 8, 9 };
		System.out.println(findTarget(arr, 4));

		int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int []nums = {4,5,6,7,0,1,2};
		int target = 0;
		
		System.out.println(search(nums, target));
		
	}

	public static int search(int[] nums, int target) {

		if (nums == null || nums.length == 0)
			return -1;

		int left = 0, right = nums.length - 1;

		while (left <= right) {
			
			int mid = left + (right - left) / 2;

			if (nums[mid] == target)
				return mid;

			// bug - 2 => trick to ensure an ordered half;
			if (nums[mid] < nums[right]) {
				
				if (nums[mid] < target && target <= nums[right])
					left = mid + 1;
				else
					right = mid - 1;
				
			} else if (nums[mid] > nums[right]) {
				
				if (nums[left] <= target && target < nums[mid])
					right = mid - 1;
				else
					left = mid + 1;
				
			} else
				return -1; // the last iteration since nums[m] == nums[r] => m == r since no duplicates;
		}
		return -1;
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

	static int findTarget(int arr[], int target) {

		int start = 0;
		int end = arr.length - 1;
		int res = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] == target) {
				res = mid;
				start = mid + 1;
			} else if (arr[mid] < target)
				start = mid + 1;
			else
				end = mid - 1;
		}

		return res;
	}
	
	public int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length-1);
    }
    
    public int binarySearch(int[] nums, int start, int end) {
        if(start == end) return start;
        int mid = start + (end - start)/2;
        if(nums[mid] > nums[mid+1]) {
            return binarySearch(nums, start, mid);
        } else {
            return binarySearch(nums, mid+1, end);
        }
    }

}
