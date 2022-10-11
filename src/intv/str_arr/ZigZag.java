package intv.str_arr;
//https://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/
public class ZigZag {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 7, 8, 6, 2, 1 };
		zigZag(arr);
		System.out.println();
		for (int i : swapInPair(arr))
			System.out.print( i + " ");
	}

	public static void zigZag(int[] arr) {
		boolean flag = false; // less

		for (int i = 0; i < arr.length - 1; i++) {

			if (flag && arr[i] < arr[i + 1]) {

				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;

			} else if (!flag && arr[i] > arr[i + 1]) {

				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}

			flag = !flag;
		}

		for (int i : arr)
			System.out.print(i + " ");
	}

	static int[] swapInPair(int arr[]) {

		for (int i = 0; i < arr.length - 1; i = i + 2) {
			int temp = arr[i];
			arr[i] = arr[i + 1];
			arr[i + 1] = temp;
		}

		return arr;

	}
	
}
