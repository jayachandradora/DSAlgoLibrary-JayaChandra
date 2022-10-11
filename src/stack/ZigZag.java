package stack;

import java.util.Arrays;

public class ZigZag {

	public static void main(String[] args) {

		jdZigzag();
		System.out.println();

		zigZag();
		for (int in : arr)
			System.out.print(in + " ");

	}

	static void jdZigzag() {
		int arr[] = { -2, 1, -3, 4, -1, 2, -9, -7,-6 ,-5,1, -5, 4 };
		Arrays.sort(arr);
		int j = 0, k = 0;

		for (int in : arr)
			if (in < 0)
				j++;
			else
				break;

		if (j == 0)
			return;

		k = j;
		for (int i = 0; i < Math.abs(arr.length - j); i += 2) {
			int temp = arr[k];
			arr[k] = arr[i];
			arr[i] = temp;
			k++;
		}

		for (int in : arr)
			System.out.print(in + " ");
	}

	static int arr[] = new int[] { 4, -3, -7, -99, 6, 8,90,-2, 1 };

	static void zigZag() {

		boolean flag = true;
		int temp = 0;

		for (int i = 0; i <= arr.length - 2; i++) {
			if (flag) {
				if (arr[i] > arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			} else {
				if (arr[i] < arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			flag = !flag;
		}
	}

}