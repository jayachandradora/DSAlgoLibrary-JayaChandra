package arrays;

public class ReverseArry {

	/* Function to left rotate arr[] of size n by d */
	//O(N*d)
	static void leftRotate(int arr[], int d) {
		int n = arr.length;
		rvereseArray(arr, 0, d - 1);
		rvereseArray(arr, d, n - 1);
		rvereseArray(arr, 0, n - 1);
	}

	/* Function to reverse arr[] from index start to end */
	//Time Coplexity O(n)
	static void rvereseArray(int arr[], int start, int end) {
		int temp;
		while (start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	
	
	/* Function to reverse arr[] from start to end Using recursion*/
    static void rvereseArrayRecursively(int arr[], int start, int end)
    {
        int temp;
        if (start >= end)
            return;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        rvereseArray(arr, start+1, end-1);
    }

	/* function to print an array */
	static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		//leftRotate(arr, 2); // Rotate array by 2
		rvereseArray(arr, 0, arr.length - 1);
		//rvereseArrayRecursively(arr, 0, arr.length-1);
		printArray(arr);
	}
}
