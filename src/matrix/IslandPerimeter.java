package matrix;

public class IslandPerimeter {
	int count = 0;

	public static void main(String[] args) {
		int grid[][] = { { 0, 1, 0, 0 }, 
						 { 1, 1, 1, 0 }, 
						 { 0, 1, 0, 0 }, 
						 { 1, 1, 0, 0 } };

		IslandPerimeter isp = new IslandPerimeter();
		System.out.println(isp.islandPerimeter(grid));
	}

	public int islandPerimeter(int[][] grid) {
		count = 0;
		for (int i = 0; i < grid.length; i++) { //Step 1 -- find the cell with 1
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					dfs(grid, i, j); // Step2 -- do dfs call to calculate perimitter
					break;
				}
			}
		}
		return count;
	}

	private void dfs(int[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) { // Step-3 permitter/count ++ for water(0) area or outside grid(less then zero). 
			count++;
			return;
		}
		if (grid[i][j] == -1) //Step-4 if cell is -1 then simply return it
			return;

		grid[i][j] = -1; //Step-5 fill -1 to the cell for avoiding to calculate same cell again 

		dfs(grid, i + 1, j); // Recursion of dfs call with all 4 directions
		dfs(grid, i - 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i, j - 1);
	}
}
