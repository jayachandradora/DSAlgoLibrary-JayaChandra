package matrix;

public class MaxAreaOfIsland {

	public static void main(String[] args) {

		int grid[][] = { { 1, 1, 0, 0, 0 }, 
						 { 1, 1, 0, 0, 0 }, 
						 { 0, 0, 0, 1, 1 }, 
						 { 0, 0, 0, 1, 1 } };
		
		System.out.println(maxAreaOfIsland(grid));
	}

	public static int maxAreaOfIsland(int[][] grid) {
		int maxArea = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				maxArea = Math.max(maxArea, dfs(grid, i, j));
			}
		}
		return maxArea;
	}

	private static int dfs(int[][] grid, int x, int y) {

		if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0)
			return 0;

		grid[x][y] = 0;

		return 1 + dfs(grid, x - 1, y) + 
				   dfs(grid, x + 1, y) + 
				   dfs(grid, x, y - 1) + 
				   dfs(grid, x, y + 1);
	}

}
