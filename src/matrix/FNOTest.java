package matrix;

public class FNOTest {

	public static void main(String[] args) {

		//int arr[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };

		int arr[][] = { { 10, 20, 30 }, 
					   { 15, 25, 35 }, 
					   { 27, 29, 37}, 
					   { 32, 33, 39} };

		System.out.println("Row " + arr.length);
		System.out.println("Colomn " + arr[0].length);

		int[][] test = new int[4][3];
		int row = test.length;
		int col = test[0].length;

		System.out.println(row);
		System.out.println(col);
	}
}
