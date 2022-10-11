package intv.search_sort;

public class Test {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 6, 7, 8, 9 };
		int end = arr.length - 1;
		int key = 10;
		System.out.println(bst(arr, 0, end, key));

		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		rotate(nums, k);

		for (int in : nums)
			System.out.print(in + " ");
	}

	public static void rotate(int[] nums, int k) {

		int n = nums.length;
		k %= n;

		reverse(nums, n - k, n - 1);
		reverse(nums, 0, n - 1);
		reverse(nums, k, n - 1);

	}

	public static void reverse(int nums[], int l, int r) {

		while (l <= r) {
			int temp = nums[l];
			nums[l] = nums[r];
			nums[r] = temp;
			l++;
			r--;
		}
	}

	static int bst(int arr[], int start, int end, int key) {

		if (end < start)
			return -1;

		int mid = (start + end) / 2;
		if (arr[mid] == key)
			return mid;
		if (arr[mid] < key)
			return bst(arr, mid + 1, end, key);
		else if (arr[mid] > key)
			return bst(arr, start, mid - 1, key);

		return -1;
	}

}
