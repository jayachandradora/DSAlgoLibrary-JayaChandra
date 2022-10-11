package matrix;

public class PrintBoundaries {

	public static void main(String[] args) {

		int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };

		int m = a.length;
		int n = a[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0)
					System.out.print(a[i][j] + " ");
				else if (j == 0)
					System.out.print(a[i][j] + " ");
				else if (i == m - 1)
					System.out.print(a[i][j] + " ");
				else if (j == n - 1)
					System.out.print(a[i][j] + " ");
				else
					System.out.print("  ");
			}
			System.out.println("");
		}

		System.out.println("=======");

		printBoundary(a, m, n);
		
		System.out.println("Print boundary Values " + printBoundarySum(a, m, n));
	}

	// best Approach
	static void printBoundary(int a[][], int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0)
					System.out.print(a[i][j] + " ");
				else if (i == m - 1 || j == n - 1)
					System.out.print(a[i][j] + " ");
				else
					System.out.print("  ");
			}
			System.out.println("");
		}
	}

	static int printBoundarySum(int a[][], int m, int n) {
		int sum = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0)
					sum += a[i][j] ;
				else if (i == m - 1 || j == n - 1)
					sum += a[i][j] ;
			}
		}
		return sum;
	}
}
