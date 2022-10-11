package arrays;

public class FindMaximumSumRotateArray {
	static int arr[] = new int[] { 10, 50, 30, 5 };

	// Returns max possible value of i*arr[i]
	static int maxSum() {
		// Find array sum and i*arr[i] with no rotation
		int arrSum = 0; // Stores sum of arr[i]
		int currVal = 0; // Stores sum of i*arr[i]
		for (int i = 0; i < arr.length; i++) {
			arrSum = arrSum + arr[i];
			currVal = currVal + (i * arr[i]);
		}

		// Initialize result as 0 rotation sum
		int maxVal = currVal;

		// Try all rotations one by one and find
		// the maximum rotation sum.
		for (int j = 1; j < arr.length; j++) {
			currVal = currVal + arrSum - arr.length * arr[arr.length - j];
			if (currVal > maxVal)
				maxVal = currVal;
		}

		// Return result
		return maxVal;
	}

	// Driver method to test the above function
	public static void main(String[] args) {
		System.out.println("Max sum is " + maxSum());
	}
}
