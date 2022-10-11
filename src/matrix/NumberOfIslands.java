package matrix;

public class NumberOfIslands {

	public static void main(String[] args) {

		char grid[][] = {{'1','1','0','0','0'},
				 		 {'1','1','0','0','0'},
				 		 {'0','0','1','0','0'},
				 		 {'0','0','0','1','1'}};
		
		NumberOfIslands numIsLand = new NumberOfIslands();
		System.out.println(numIsLand.numIslands(grid));
	}
	
	public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					dfsFill(grid, i, j);
					count++;
				}
			}
		return count;
	}

	private void dfsFill(char[][] grid, int i, int j) {
		if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
			grid[i][j] = '0'; //Fill all 0's in place of 1's based on this condition grid[i][j] == '1'
			dfsFill(grid, i + 1, j);// DOWN
			dfsFill(grid, i - 1, j);// UP
			dfsFill(grid, i, j + 1);// Right
			dfsFill(grid, i, j - 1);// LEFT
		}
	}
}
