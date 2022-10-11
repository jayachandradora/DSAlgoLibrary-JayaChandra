package mcm;

public class MatrixChainMultiplicationRecursive {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 3, 4, 3 };
		int n = arr.length;
		System.out.println("Minimum number of multiplications is " + solve(arr, 1, n - 1));
	}

	static int solve(int arr[], int i, int j) {

		int min = Integer.MAX_VALUE;
		
		if (i == j)
			return 0;
		
		for (int k = i; k < j; k++) {
			int temp = solve(arr, i, k) + solve(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];

			min = Math.min(temp, min);
		}
		return min;
	}
}
