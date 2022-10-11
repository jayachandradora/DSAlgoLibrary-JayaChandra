package arrays;

public class BinarySearch {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 8, 9, 10, 23, 45 };
		/* System.out.println(binarySearch(arr, 10)); */

		System.out.println(" index " + binarySearch(arr, 8));
		int arr1[] = { 1, 2, 3, 4, 5, 6 };
		System.out.println("input araay");
		for (int i : arr1)
			System.out.print(i + " , ");

		System.out.println();
		System.out.println("Rotated array");
		for (int i : rotateRight(arr1, 3))
			System.out.print(i + " , ");
	}

	static int binarySearch(int arr[], int target) {
		int start = 0, end = arr.length - 1, mid = 0;

		if (arr.length == 0)
			return -1;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (arr[mid] == target)
				return mid;
			else if (arr[mid] > target)
				start = mid + 1;
			else
				start = mid - 1;
		}
		return -1;

	}

	// https://www.youtube.com/watch?v=ggLGjf_XiNQ
	int findPivot(int arr[], int size) {

		if (arr[0] <= arr[size - 1])
			return 0;

		int start = 0, end = size - 1, mid = 0;
		while (start <= end) {
			mid = (start + end) / 2;

			/*
			 * if(mid+1>arr[mid]) return
			 */
		}
		return 1;
	}

	public static int[] rotateRight(int[] array, int numRotation) {

		if (array == null) {
			return null;
		}

		if (array.length == 0) {
			return new int[0];
		}

		if (array.length == 1) {
			return new int[] { array[0] };
		}

		int[] newArray = new int[array.length];

		int effectiveRotation = numRotation % array.length;

		System.out.println("Effective Rotation " + effectiveRotation);

		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[(array.length - effectiveRotation + i) % array.length];
		}

		return newArray;
	}

}
