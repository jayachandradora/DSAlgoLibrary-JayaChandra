package matrix;

import java.util.HashSet;
import java.util.Set;

//looks like its wrong please correct it 
public class NumerOfDistinctIsland {

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 0, 1, 1 }, 
				         { 1, 0, 0, 0, 0 }, 
				         { 0, 0, 0, 0, 1 }, 
				         { 1, 1, 0, 1, 1 } };
		
		System.out.println(getDistinctCount(grid));
	}

	// time complexity - m*n, space complexity - m*n
	public static int getDistinctCount(int[][] grid) {
		int size = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					size = getArea(grid, i, j);
					set.add(size);
				}
			}
		}
		return set.size();
	}

	private static int getArea(int[][] grid, int i, int j) {
		
		if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] != 1)
			return 0;
		
		grid[i][j] = -1;
		return 1 + getArea(grid, i + 1, j) + 
				   getArea(grid, i - 1, j) + 
				   getArea(grid, i, j + 1) + 
				   getArea(grid, i, j - 1);
	}

}
