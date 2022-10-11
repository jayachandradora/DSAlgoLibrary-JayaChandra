package intv.matrix;

//https://www.geeksforgeeks.org/saddle-point-matrix/
public class SaddlePoint {

	// OUTPUT ROW MINIMA COLUMN MAXIMA 
	static void findSaddlePoint(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			int rowMin = matrix[i][0];
			int colIndex = 0;
			boolean saddlePoint = true;

			// Finding the smallest element in ith row
			for (int j = 1; j < matrix[i].length; j++) {
				if (matrix[i][j] < rowMin) {
					rowMin = matrix[i][j];
					colIndex = j;
				}
			}

			// Checking rowMin is also the largest element in its column
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[j][colIndex] > rowMin) {
					saddlePoint = false;
					break;
				}
			}
			if (saddlePoint) {
				System.out.println("Saddle Point is : " + rowMin);
			}
		}
	}

	public static void main(String[] args) {

		int[][] matrix = {{6, 3, 1, 5}, 
				  		  {9, 7, 8, 10},
				  		  {2, 4, 5, 8}};
		findSaddlePoint(matrix);
	}

}
