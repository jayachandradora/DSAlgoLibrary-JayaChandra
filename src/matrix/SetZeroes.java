package matrix;

public class SetZeroes {

	public static void main(String[] args) {

		int matrix[][] = { {0,1,1},
		                   {1,0,1},
		                   {1,1,1}
		                 };
		setZeroes(matrix);
		for(int d[] : matrix) {
			for(int res : d)
				System.out.print(res + " ");
			System.out.println();
		}
	}

	static void setZeroes(int[][] matrix) {
        boolean isFirstColHasZero = false;
        int R = matrix.length;
		int C = matrix[0].length;
		
        for(int i = 0; i < R; i++){
            if(matrix[i][0] == 0) 
			    isFirstColHasZero = true;
            
            // If an element is zero, we set the first element of the corresponding row and column to 0
            for(int j = 1; j < C; j++){
                if(matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
            }
        }
        
        // Iterate over the array once again and update the elements using the first row and first column.
        for(int i = R - 1; i >= 0; i--) {
            for(int j = C - 1; j >= 1; j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            
            // See if the first column needs to be set to zero as well
            if(isFirstColHasZero) 
			    matrix[i][0] = 0;
        }
	}

}
