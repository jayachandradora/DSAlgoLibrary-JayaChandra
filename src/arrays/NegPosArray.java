package arrays;

public class NegPosArray {
	// The main function that rearranges elements of given
	// array. It puts positive elements at even indexes (0,
	// 2, ..) and negative numbers at odd indexes (1, 3, ..).
	static void rearrange(int arr[], int n) {
		// The following few lines are similar to partition
		// process of QuickSort. The idea is to consider 0
		// as pivot and divide the array around it.
		int i = -1, temp = 0;
		for (int j = 0; j < n; j++) {
			if (arr[j] < 0) {
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// Now all positi and negative numbers at
		// the beginning of array. Initialize indexes for starting point
		// of positive and negative numbers to be swappedve numbers are at end
		int pos = i + 1, neg = 0;

		// Increment the negative index by 2 and positive index by 1, i.e.,
		// swap every alternate negative number with next positive number
		while (pos < n && neg < pos && arr[neg] < 0) {
			temp = arr[neg];
			arr[neg] = arr[pos];
			arr[pos] = temp;
			pos++;
			neg += 2;
		}
		for(int a : arr)
			System.out.println(a);
	}

	/* Driver function to check for above functions */
	public static void main(String[] args) {
		int arr[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
		int n = arr.length;
		rearrange(arr, n);
		System.out.println("Array after rearranging: ");
	}
}
