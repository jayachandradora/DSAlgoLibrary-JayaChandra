package sorting;

public class Solution {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5 };
		int k = 2;
		rotate(arr, k);
	}

	public static void rotate(int[] nums, int k) {
		int[] a = new int[nums.length];
		
		for (int i = 0; i < nums.length; i++) {
			a[(i + k) % nums.length] = nums[i];
		}
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = a[i];
		}
		
		for (int j = 0; j < nums.length; j++) {
			System.out.println("element is " + nums[j]);

		}
	}
}
