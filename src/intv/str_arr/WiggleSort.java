package intv.str_arr;

public class WiggleSort {

	public static void main(String[] args) {

	}

	// Input: nums = [3,5,2,1,6,4]
	// Output: One possible answer is [3,5,1,6,2,4]
	public void wiggleSort(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}

		for (int i = 1; i < nums.length; i++) {
			if (i % 2 == 1) {
				if (nums[i - 1] > nums[i]) {
					swap(nums, i - 1, i);
				}
			} else {
				if (nums[i - 1] < nums[i]) {
					swap(nums, i - 1, i);
				}
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
}
