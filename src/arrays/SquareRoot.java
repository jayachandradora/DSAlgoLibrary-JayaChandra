package arrays;

public class SquareRoot {

	public static void main(String[] args) {
		System.out.println(mySqrt1(90));

		int nums[] = { 2, 1, 0, 1, 2, 0 };
		sortColors(nums);
		System.out.println(nums);
		
		System.out.println(linearSqrt(81));
	}

	public static int mySqrt1(int x) {

		if (x <= 1)
			return x;

		int left = 1, right = x;

		while (left <= right) {

			int mid = left + (right - left) / 2;

			if (mid * mid == x)
				return mid;
			
			else if (x < mid * mid)
				right = mid - 1;
			
			else
				left = mid + 1;

		}

		return right;
	}

	public static void sortColors(int[] nums) {
		int l = 0, i = 0, r = nums.length - 1;
		while (i <= r) {
			if (nums[i] == 0)
				swap(nums, l++, i++);

			else if (nums[i] == 2)
				swap(nums, i, r--);

			else
				i++;

		}
	}

	private static void swap(int[] nums, int p1, int p2) {
		int temp = nums[p1];
		nums[p1] = nums[p2];
		nums[p2] = temp;
	}

	static int linearSqrt(int x) {

		int y = 0;

		while (y * y <= x)
			y++;

		return y - 1;
	}
}
