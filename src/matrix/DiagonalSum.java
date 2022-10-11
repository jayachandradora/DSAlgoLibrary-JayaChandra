package matrix;

public class DiagonalSum {

	public static void main(String[] args) {

		int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };

		int m = a.length;
		int n = a[0].length;

		int pdSum = 0;
		int sdSum = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					pdSum += a[i][j];

				if (i + j == n - 1)
					sdSum += a[i][j];
			}
		}
		System.out.println("Primary Diagnoal " + pdSum + " Secondary diagnoal Sum " + sdSum);
	}

	static void printDiagonalSums(int[][] mat, int n) {
		int principal = 0, secondary = 0;
		for (int i = 0; i < n; i++) {
			principal += mat[i][i];
			secondary += mat[i][n - i - 1];
		}

		System.out.println("Principal Diagonal:" + principal);
		System.out.println("Secondary Diagonal:" + secondary);
	}
}
