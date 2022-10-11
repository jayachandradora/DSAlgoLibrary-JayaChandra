package matrix;

public class DiagonalMatrix {

	public static void main(String[] args) {
		int arr[][] = { { 10, 20, 30, 40 }, 
						{ 15, 25, 35, 45 }, 
						{ 27, 29, 37, 48 }, 
						{ 32, 33, 39, 50 } };

		int n = 4, m = 4;

		printDiagonalMatrix(arr, m, n);
		printElements(arr);
	}
	
	static void printElements(int arr[][]) {
		int row = arr.length;
		for(int i=0; i<row; i++)
			System.out.println(arr[i][i]);
		
		for(int i = 0; i<row; i++)
			System.out.println(arr[row-i-1][i]);
	}

	// https://www.youtube.com/watch?v=T8ErAYobcbc
	static void printDiagonalMatrix(int arr[][], int m, int n) {

		int i = 0, j = 0;
		for (int k = 0; k <= m - 1; k++) {
			i = k;
			j = 0;
			while (i >= 0) {
				System.out.print(arr[i][j] + " ");
				i = i - 1;
				j = j + 1;
			}
			System.out.println();
		}

		for (int k = 1; k <= n - 1; k++) {
			i = m - 1;
			j = k;

			while (j <= n - 1) {
				System.out.print(arr[i][j] + " ");
				i = i - 1;
				j = j + 1;
			}
			System.out.println();
		}
	}

}
