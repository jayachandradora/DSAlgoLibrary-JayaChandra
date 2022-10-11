package intv.str_arr;

import java.util.Arrays;

public class IsTripletExistWithSumWithSorting {

	public static void main(String[] args) {
		int arr[] = { 5, 1, 3, 4, 7 };
		int sum = 12, n = arr.length;
		System.out.println(IsTripletExistWithSumWithSorting(arr, n, sum));
		
		System.out.println(find3Numbers(arr, n, sum));
	}

	static int IsTripletExistWithSumWithSorting(int[] arr, int n, int sum) {
		Arrays.sort(arr);
		int ans = 0;

		for (int i = 0; i < n - 2; i++) {
			int j = i + 1, k = n - 1;
			while (j < k) {
				if (arr[i] + arr[j] + arr[k] >= sum)
					k--;
				else {
					ans += (k - j);
					j++;
				}
			}
		}
		return ans;
	}

	static boolean find3Numbers(int A[], int arr_size, int sum) {
		
		int l, r;

		for (int i = 0; i < arr_size - 2; i++) {
			for (int j = i + 1; j < arr_size - 1; j++) {
				for (int k = j + 1; k < arr_size; k++) {
					if (A[i] + A[j] + A[k] == sum) {
						System.out.print("Triplet is " + A[i] + ", " + A[j] + ", " + A[k]);
						return true;
					}
				}
			}
		}
		return false;
	}

}
