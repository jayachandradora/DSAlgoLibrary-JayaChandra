package intv.str_arr;

public class LargestContiguousSubArray {

	public static void main(String[] args) {
		LargestContiguousSubArray large = new LargestContiguousSubArray();
		int arr[] = { 1, 56, 58, 57, 90, 92, 94, 93, 91, 45 };
		int n = arr.length;
		System.out.println("Length of the longest contiguous subarray is " + large.findLength(arr, n));
	}

	int findLength(int arr[], int n) {
		int max_len = 1; 
		for (int i = 0; i < n - 1; i++) {
			// Initialize min and max for all subarrays starting with i
			int mn = arr[i], mx = arr[i];

			// Consider all subarrays starting with i and ending with j
			for (int j = i + 1; j < n; j++) {
				mn = min(mn, arr[j]);
				mx = max(mx, arr[j]);

				// If current subarray has all contiguous elements
				if ((mx - mn) == j - i)
					max_len = max(max_len, mx - mn + 1);
			}
		}
		return max_len; // Return result
	}

	int min(int x, int y) {
		return (x < y) ? x : y;
	}

	int max(int x, int y) {
		return (x > y) ? x : y;
	}
}
