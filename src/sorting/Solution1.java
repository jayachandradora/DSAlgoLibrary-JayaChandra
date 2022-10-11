package sorting;

public class Solution1 {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 1;

		rotate(arr, k);
	}

	public static void rotate(int[] nums, int k) {
		k = k % nums.length;
		int count = 0;
		for (int start = 0; count < nums.length; start++) {
			int current = start;
			int prev = nums[start];
			do {
				int next = (current + k) % nums.length;
				int temp = nums[next];
				nums[next] = prev;
				prev = temp;
				current = next;
				count++;
			} while (start != current);
		}
		for (int j = 0; j < nums.length; j++) {
			System.out.println("element is " + nums[j]);
		}
	}
}
