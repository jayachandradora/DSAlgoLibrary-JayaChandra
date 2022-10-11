package intv.heap;

public class ClosestPairSum {

	public static void main(String[] args) {

		int arr[] = { 10, 22, 28, 29, 30, 40 }, x = 54;
		closestSumDiff(arr, x);
	}

	static void closestSumDiff(int arr[], int x) {

		int low = 0, high = arr.length - 1, num1 = 0, num2 = 0, diff = Integer.MAX_VALUE;
		while (low < high) {
			int smalest = Math.abs(x - (arr[low] + arr[high]));
			if (smalest < diff) {
				num1 = arr[low];
				num2 = arr[high];
				diff = smalest;
				low++;
			} else {
				high--;
			}
		}

		System.out.println("Two Pair numbers are " + num1 + " " + num2);
	}

}
