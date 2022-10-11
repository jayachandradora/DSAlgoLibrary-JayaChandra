package intv.matrix;

public class IsMatrixSymetric {

	public static void main(String[] args) {

		int matrix[][] = { { 1, 3, 5 }, 
						   { 3, 2, 4 }, 
						   { 5, 4, 1 } }; 
		
		int N = matrix.length;
		System.out.println(isSymetric(matrix, N));
	}

	static boolean isSymetric(int matrix[][], int N) {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (matrix[i][j] != matrix[j][i])
					return false;

		return true;
	}

}
