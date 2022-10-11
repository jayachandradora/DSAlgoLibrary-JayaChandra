package intv.matrix;

public class MinimumPathSum {

	public static void main(String[] args) {

		int grid[][] = { { 1, 3, 1 }, 
						 { 1, 5, 1 }, 
						 { 4, 2, 1 } };
		System.out.println(minPathSum(grid));
		
        System.out.print(minCost(grid, 2, 2));

	}

	static int minPathSum(int[][] grid) {

		    if (grid.length == 0 || grid[0].length == 0) {
	            return 0;
	        }
	        
	        // Process first row
	        for (int j = 1; j < grid[0].length; j++) {
	            grid[0][j] += grid[0][j - 1];
	        }
	        
	        // Process first colomn
	        for (int i = 1; i < grid.length; i++) {
	            grid[i][0] += grid[i - 1][0];
	        }
	        
	        // Process other elements
	        for (int i = 1; i < grid.length; i++) {
	            for (int j = 1; j < grid[0].length; j++) {
	                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
	            }
	        }
	        
	        return grid[grid.length - 1][grid[0].length - 1];

	}
	
	 static int min(int x, int y, int z) {
	        if (x < y)
	            return (x < z) ? x : z;
	        else
	            return (y < z) ? y : z;
	 }
	     
	    /* Returns cost of minimum cost path from (0,0) to (m, n) in mat[R][C]*/
	 static int minCost(int cost[][], int m, int n){
	        if (n < 0 || m < 0)
	            return Integer.MAX_VALUE;
	        else if (m == 0 && n == 0)
	            return cost[m][n];
	        else
	            return cost[m][n] +
	                min( minCost(cost, m-1, n-1),
	                     minCost(cost, m-1, n),
	                     minCost(cost, m, n-1) );
	}
	                          

}
