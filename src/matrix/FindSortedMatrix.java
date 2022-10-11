package matrix;

public class FindSortedMatrix {

	public static void main(String[] args) {

		int arr[][] = { { 10, 20, 30, 40 }, 
						{ 15, 25, 35, 45 }, 
						{ 27, 29, 37, 48 }, 
						{ 32, 33, 39, 50 } };

		searchNumberInSortedMatrix(arr, 37, arr.length);

		int arr1[][] = { { -3, -2, -1, 1 }, 
						 { -2, 2, 3, 4 }, 
						 { 4, 5, 7, 8 } };
		
		int j = arr1.length;
		int i = 0, count = 0;
		
		while (j >= 0 && i < j) {
			if (arr1[i][j] < 0) {
		
				i--;
			}else 
				j--;
		}
		System.out.println(count);

	}

	static void searchNumberInSortedMatrix(int arr[][], int x, int n) {
		int i = 0, j = n - 1;

		boolean flag = false;
		while (i < n && j >= 0) {
			if (x == arr[i][j]) {
				flag = true;
				break;
			} else if (x < arr[i][j])
				j--;
			else
				i++;
		}

		if (flag == true)
			System.out.println("Found");
		else
			System.out.println("Not Found");
	}

}
