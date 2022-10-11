package designpattern;

public class MergeTwoSortedArray {

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 4, 5, 7 };
		int n1 = arr1.length;

		int[] arr2 = { 2, 4, 6, 8 };
		int n2 = arr2.length;

		int len = n1 + n2;
		int[] arr3 = new int[len];
		int i = 0, j = 0, k = 0;

		while (i < n1 && j < n2) {
			if (arr1[i] < arr2[j]) {
				arr3[k++] = arr1[i++];
			} else
				arr3[k++] = arr2[j++];
		}

		// Store remaining elements of first array
		while (i < n1)
			arr3[k++] = arr1[i++];

		// Store remaining elements of second array
		while (j < n2)
			arr3[k++] = arr2[j++];

		for (int l : arr3)
			System.out.print("  " + l);
		
		int[] arr4 = { 1, 3, 4, 5, 7,2,4,5,4 };
		System.out.println("With out duplicate " + removeDuplicatesNaive(arr4));
	}
	
	public static int removeDuplicatesNaive(int[] A) {
		if (A.length < 2)
			return A.length;
	 
		int j = 0;
		int i = 1;
	 
		while (i < A.length) {
			if (A[i] == A[j]) {
				i++;
			} else {
				j++;
				A[j] = A[i];
				i++;
			}
		}
	 
		return j + 1;
	}
}
