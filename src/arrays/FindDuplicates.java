package arrays;

public class FindDuplicates {

	public static void main(String[] args) {
		int nums[] = { 1, 3, 4, 2, 2 };
		System.out.println(findDuplicate(nums));
		
		int nums1[] = {1,3,4,2,2};
		System.out.println(removeDuplicates(nums1));
		
		int nums2[] = {1,3,4,2,2};
		System.out.println(findDuplicateWithoutModifyingArray(nums2));
	}

	static int removeDuplicates(int[] nums) {

		int i = 0;

		for (int n : nums)
			if (i < 2 || n > nums[i - 2])
				nums[i++] = n;

		return i;
	}

	static int findDuplicate(int[] nums) {

		for (int i = 0; i < nums.length; ++i) {
			if (nums[Math.abs(nums[i]) - 1] >= 0)
				nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
			else
				return Math.abs(nums[i]);
		}
		return 0;
	}

	// You must solve the problem without modifying the array nums and uses only
	// constant extra space. arr = 1,3,4,2,2
	static int findDuplicateWithoutModifyingArray(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int slow = nums[0];
		int fast = nums[0];
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		fast = nums[0];
		while (fast != slow) {
			fast = nums[fast];
			slow = nums[slow];
		}
		return fast;
	}

}

//https://www.youtube.com/watch?v=dfIqLxAf-8s&ab_channel=TECHDOSE