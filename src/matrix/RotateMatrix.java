package matrix;

/*
{1, 2, 3}, 
{4, 5, 6}, 
{7, 8, 9}

[1, 4, 7], 
[2, 5, 8],    // Step 1
[3, 6, 9]
 
[7, 4, 1],    // Step 2
[8, 5, 2], 
[9, 6, 3] */
public class RotateMatrix {
	public static void rotate(int[][] mx) {
		for (int i = 0; i < mx.length; ++i) {
			for (int j = i + 1; j < mx[0].length; ++j) { // i+` not the whole
				int tmp = mx[i][j];
				mx[i][j] = mx[j][i];
				mx[j][i] = tmp;
			}
		}
		for (int i = 0; i < mx.length; ++i) {
			int l = 0, r = mx.length - 1;
			while (l < r) {
				int tmp = mx[i][r];
				mx[i][r--] = mx[i][l];
				mx[i][l++] = tmp;
			}
		}

	}
	
	public static void main(String[] args) {

		// int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(a);
		// Print rotated matrix
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++)
				System.out.print(a[i][j] + " ");
			System.out.print("\n");
		}
	}

	public static void rotate1(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;
		
		int n = matrix.length;
		
		for (int i = 0; i < n / 2; ++i) {
			for (int j = i; j < n - i - 1; ++j) {
				int t = matrix[i][j];
				matrix[i][j] = matrix[n - j - 1][i];
				matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
				matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = t;
			}
		}
	}

}
