package matrix;

public class ClosedIsland {

	public static void main(String[] args) {
		int grid[][] = {{1,1,1,1,1,1,1,0},
						{1,0,0,0,0,1,1,0},
						{1,0,1,0,1,1,1,0},
						{1,0,0,0,0,1,0,1},
						{1,1,1,1,1,1,1,0}};
		ClosedIsland ci = new ClosedIsland();
		System.out.println(ci.closedIsland(grid));
	}

	public int closedIsland(int[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if ((i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1) && grid[i][j] == 0) {
					dfs(grid, i, j, -1);
				}
			}
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					dfs(grid, i, j, 2);
					count++;
				}
			}
		}
		return count;
	}

	void dfs(int[][] g, int i, int j, int c) {
		if (i < 0 || i == g.length || j < 0 || j == g[0].length || g[i][j] != 0)
			return;
		g[i][j] = c;
		dfs(g, i - 1, j, c);
		dfs(g, i, j - 1, c);
		dfs(g, i + 1, j, c);
		dfs(g, i, j + 1, c);
	}
}
