package arrays;

//https://www.youtube.com/watch?v=muDPTDrpS28
public class JumpGame {

	//Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
	//Output: 3 (1-> 3 -> 8 -> 9)
	//Input:  arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
	//Output: 10
	public static void main(String[] args) {

		int nums[] = { 2, 3, 1, 1, 4 };
		System.out.println(canJump(nums));
		
		System.out.println(minimumJumps(nums));
	}

	static boolean canJump(int[] nums) {
		int len = nums.length;
		int max = 0;
		for (int i = 0; i <= max; i++) {
			max = Math.max(max, i + nums[i]);
			if (max >= len - 1)
				return true;
		}
		return false;
	}

	static boolean canJump1(int[] nums) {

		int n = nums.length;
		int reachable = 0;
		for (int i = 0; i < n; i++) {
			if (reachable < i)
				return false;
			reachable = Math.max(reachable, i + nums[i]);
		}
		return true;
	}

	static int minimumJumps(int nums[]) {
		int noOfJump = 0;
		int e = 0;
		int max = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			max = Math.max(max, i + nums[i]);
			if (i == e) {
				noOfJump++;
				e = max;
			}
		}
		return noOfJump;
	}
}
