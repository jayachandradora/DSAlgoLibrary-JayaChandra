package matrix;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=TmweBVEL0I0
public class SpiralMatrix {

	public static void main(String[] args) {

		int arr[][] = { { 10, 20, 30, 40 }, 
						{ 15, 25, 35, 45 }, 
						{ 27, 29, 37, 48 }, 
						{ 32, 33, 39, 50 } };
		int m = 4;
		int n = 4;

		printSpiralMatrix(m, n, arr);
		System.out.println(spiralOrder(arr));
	}

	/* JD Look at these values before start coding .... don't see video
 	k - starting row index
    m - ending row index
    l - starting column index
    n - ending column index
    i - iterator
    */
	static void printSpiralMatrix(int m, int n, int arr[][]) {
		
		int i = 0, k = 0, l = 0;
		int last_row = m - 1, last_column = n - 1;

		while (k <= last_row && l <= last_column) {
			
			// Print the first row from the remaining rows
			for (i = l; i <= last_column; i++)
				System.out.print(arr[k][i] + " ");
			k++;
			
			System.out.println();
			
			//Print the last column from the remaining columns
			for (i = k; i <= last_row; i++)
				System.out.print(arr[i][last_column] + " ");
			last_column--;
			
			System.out.println();
			
			//Print the last row from the remaining rows
			if(k <= last_row) {
				for(i = last_column; i >= l; i--)
					System.out.print(arr[last_row][i] + " ");
				last_row --;
			}
			
			System.out.println();
			// Print the first column from the remaining columns */
			if(l<= last_row) {
				for(i =last_row;i>=k; i--)
					System.out.print(arr[i][l] + " ");
				l++;
			}
			System.out.println();
		}
	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
        
		if (matrix == null || matrix.length == 0) 
        	return new ArrayList<>();
        
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;
        List<Integer> ret = new ArrayList<>();
        
        while (left <= right && top <= bottom) {
           
        	for (int i = left; i <= right; ++i) 
            	ret.add(matrix[top][i]);
            
            for (int i = ++top; i <= bottom; ++i) 
            	ret.add(matrix[i][right]);
            
            // bug - 1 => avoid duplicates collected;
            if (top > bottom) 
            	break;
            
            for (int i = --right; i >= left; --i) 
            	ret.add(matrix[bottom][i]);
            
            if (left > right) 
            	break;
            
            for (int i = --bottom; i >= top; --i) 
            	ret.add(matrix[i][left]);
            
            left++;
        }
        return ret;
    }


}
