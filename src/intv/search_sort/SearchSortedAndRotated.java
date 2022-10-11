package intv.search_sort;

public class SearchSortedAndRotated {

	public static void main(String[] args) {
		int arr[] = {  6, 7, 8, 9, 10, 1, 2 };
		System.out.println(searchInRotatedArray(arr, arr.length, 9));
	}

	static int searchInRotatedArray(int arr[], int n, int key) {

		int pivot = findPivot(arr, 0, n - 1);

		// If we didn't find a pivot, then array is not rotated at all
		if (pivot == -1)
			return binarySearch(arr, 0, n - 1, key);

		// Found pivot compare with pivot then search in two subarrays around pivot
		if (arr[pivot] == key)
			return pivot;
		if (arr[0] <= key)
			return binarySearch(arr, 0, pivot - 1, key);

		return binarySearch(arr, pivot + 1, n - 1, key);
	}

	static int binarySearch(int[] arr, int low, int high, int key) {

		if (high < low) 
            return -1; 
  
        /* low + (high - low)/2; */
        int mid = (low + high) / 2; 
        if (key == arr[mid]) 
            return mid; 
        if (key > arr[mid]) 
            return binarySearch(arr, (mid + 1), high, key); 
        return binarySearch(arr, low, (mid - 1), key); 
	}

	static int findPivot(int arr[], int low, int high) {

		if (high < low)
			return -1;
		if (high == low)
			return low;

		int mid = (low + high) / 2;

		if (mid < high && arr[mid] > arr[mid + 1])
			return mid;

		if (mid > low && arr[mid] < arr[mid - 1])
			return (mid - 1);

		if (arr[low] >= arr[mid])
			return findPivot(arr, low, mid - 1);

		return findPivot(arr, mid + 1, high);
	}
}
