package intv.matrix;

public class LongestIncreasingPath {

	public static void main(String[] args) {
		int[][] matrix = { { 9, 9, 4 }, 
						   { 6, 6, 8 },
						   { 2, 1, 1 } };
		LongestIncreasingPath lisp = new LongestIncreasingPath();
		System.out.println(lisp.longestIncreasingPath(matrix));
	}

	public int longestIncreasingPath(int[][] matrix) {

		if (matrix == null || matrix.length == 0)
			return 0;
		
		int rows = matrix.length, cols = matrix[0].length;
		int[][] dp = new int[rows][cols];
		int res = 0;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (dp[i][j] == 0) {
					dfs(matrix, i, j, dp, Integer.MIN_VALUE);
					res = Math.max(res, dp[i][j]);
				}
			}
		}
		return res;
	}

	public int dfs(int[][] matrix, int i, int j, int[][] dp, int pre) {
		
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= pre)
			return 0;
		
		if (dp[i][j] != 0)
			return dp[i][j];
		
		int l = dfs(matrix, i, j - 1, dp, matrix[i][j]);
		int r = dfs(matrix, i, j + 1, dp, matrix[i][j]);
		int up = dfs(matrix, i - 1, j, dp, matrix[i][j]);
		int down = dfs(matrix, i + 1, j, dp, matrix[i][j]);

		dp[i][j] = Math.max(l, Math.max(Math.max(r, up), down)) + 1;
		return dp[i][j];
	}

}
