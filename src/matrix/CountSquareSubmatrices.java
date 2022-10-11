package matrix;

public class CountSquareSubmatrices {

	public static void main(String[] args) {

		int[][] matrix = { { 0, 1, 1, 1 }, 
						   { 1, 1, 1, 1 }, 
						   { 0, 1, 1, 1 } };
		
		System.out.println(countSquares(matrix));
	}

	static int countSquares(int[][] matrix) {

		int res = 0;
		int[][] dp = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix[0].length; i++) {
			res += matrix[0][i];
			dp[0][i] = matrix[0][i];
		}

		for (int i = 1; i < matrix.length; i++) {
			res += matrix[i][0];
			dp[i][0] = matrix[i][0];
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {

				if (matrix[i][j] == 0)
					continue;

				dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				res += dp[i][j];
			}
		}
		return res;
	}

}
