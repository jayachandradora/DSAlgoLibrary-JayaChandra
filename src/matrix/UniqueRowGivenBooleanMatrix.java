package matrix;

import java.util.HashSet;

public class UniqueRowGivenBooleanMatrix {

	public static void main(String[] args) {

		int arr1[][] = { { 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 1 }, { 1, 1, 1, 0, 0 } };

		printUniqueRowGivenBooleanMatrix(arr1, 4, 5);

	}

	static void printUniqueRowGivenBooleanMatrix(int arr[][], int row, int col) {
		HashSet<String> set = new HashSet<String>();

		for (int i = 0; i < row; i++) {
			String s = "";

			for (int j = 0; j < col; j++)
				s += String.valueOf(arr[i][j]) + " ";

			if (!set.contains(s)) {
				set.add(s);
				System.out.println(s);
			}
		}
	}

}
