package arrays;

class RotateArray {
	/* Function to left rotate arr[] of siz n by d */
	void leftRotate(int arr[], int d, int n) {
		
		int i, j, k, temp;
		int gcd = gcd(d, n);
		System.out.println(" GCD " + gcd);
		
		for (i = 0; i < gcd; i++) {
			/* move i-th values of blocks */
			temp = arr[i];
			j = i;
			while (1 != 0) {
				k = j + d;
				if (k >= n)
					k = k - n;
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
	}

	/* UTILITY FUNCTIONS */

	/* function to print an array */
	void printArray(int arr[], int size) {
		int i;
		for (i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
	}

	/* Fuction to get gcd of a and b */
	int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		RotateArray rotate = new RotateArray();
		int arr[] = { 1, 2, 3, 4 };
		//rotate.leftRotate(arr, 2, 4);
		//rotate.printArray(arr, 7);
		
		int s = 2 / 3;

		System.out.println(" print " + 2 % 7);

	}
}