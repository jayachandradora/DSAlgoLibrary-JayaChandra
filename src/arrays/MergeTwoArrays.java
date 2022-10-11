package arrays;

public class MergeTwoArrays {

	public static void main(String[] args) {

		int arr[] = { 1, 3, 4, 6, 7 };
		int arr1[] = { 2, 5, 8 };
		int size = arr.length + arr1.length;
		int arr2[] = new int[size];
		int i = 0, j = 0, k = 0;

		while (i < arr.length && j < arr1.length) {
			if (arr[i] < arr1[j]) {
				arr2[k] = arr[i];
				i++;
			} else {
				arr2[k] = arr1[j];
				j++;
			}
			k++;
		}

		while (i < arr.length) {
			arr2[k] = arr[i];
			k++;
			i++;
		}
		while (j < arr1.length) {
			arr2[k] = arr1[j];
			k++;
			j++;
		}

		for (int o : arr2)
			System.out.println(o);

		reverseSizeGroup();
	
	}

	static void reverseSizeGroup() {
		
		int arr[] = {1,2,3,4,5,6,7,8};
		int k= 3;
		for (int i = 0; i < arr.length; i += k) {
			int left = i;

			// to handle case when k is not multiple
			// of n
			int right = Math.min(i + k - 1, arr.length - 1);
			int temp;

			// reverse the sub-array [left, right]
			while (left < right) {
				temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left += 1;
				right -= 1;
			}
		}
		
		for (int l : arr)
			System.out.print(l);
	}
}
