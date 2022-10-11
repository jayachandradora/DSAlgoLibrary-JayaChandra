package intv.str_arr;

public class SecondMissingNumber {

	static void findTwoMissingNumbers(int arr[], int n) {
		boolean[] mark = new boolean[n + 1];
		for (int i = 0; i < n - 2; i++)
			mark[arr[i]] = true;

		System.out.println("Two Missing Numbers are");
		for (int i = 1; i <= n; i++)
			if (!mark[i])
				System.out.print(i + " ");

		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 6 };

		int n = 2 + arr.length;

		findTwoMissingNumbers(arr, n);
	}

	static void findTwoMissingNumbers1(int arr[], int n) {
		int sum = (n * (n + 1)) / 2 - getSum(arr, n - 2);

		int avg = (sum / 2);

		int sumSmallerHalf = 0, sumGreaterHalf = 0;
		for (int i = 0; i < n - 2; i++) {
			if (arr[i] <= avg)
				sumSmallerHalf += arr[i];
			else
				sumGreaterHalf += arr[i];
		}

		System.out.println("Two Missing " + "Numbers are");
		int totalSmallerHalf = (avg * (avg + 1)) / 2;
		System.out.println(totalSmallerHalf - sumSmallerHalf);

		System.out.println(((n * (n + 1)) / 2 - totalSmallerHalf) - sumGreaterHalf);
	}

	static int getSum(int arr[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];
		return sum;
	}
}
