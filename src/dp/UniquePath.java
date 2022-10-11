package dp;

public class UniquePath {

	public static void main(String[] args) {

		System.out.println(uniquePathsMemoization(3, 3));

		System.out.println(numberOfPaths(3, 3));
	}

	static long numberOfPaths(int m, int n) {
		if (m <= 0 || n <= 0)
			return 0;

		return countUniquePaths(m - 1, n - 1);
	}

	static public int countUniquePaths(int i, int j) {

		if (i < 0 || j < 0)
			return 0;

		else if (i == 0 && j == 0)
			return 1;

		else
			return countUniquePaths(i - 1, j) + countUniquePaths(i, j - 1);
	}

	static int uniquePathsMemoization(int m, int n) {
		int[][] cache = new int[m][n];
		return uniquePathsHelper(m - 1, n - 1, cache);
	}

	static int uniquePathsHelper(int m, int n, int[][] cache) {
		if (m == 0 || n == 0)
			return 1;

		if (cache[m][n] > 0) {
			return cache[m][n];
		}
		cache[m][n] = uniquePathsHelper(m - 1, n, cache) + uniquePathsHelper(m, n - 1, cache);
		return cache[m][n];
	}

	private static int uniquePathsTabulation(int m, int n) {
		int[][] grid = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					grid[i][j] = 1;
				} else {
					grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
				}
			}
		}
		return grid[m - 1][n - 1];
	}
}
