package matrix;

public class CountNegativeNumbers {

	public static void main(String[] args) {

		int grid[][] = { { 4, 3, 2, -1 }, 
						 { 3, 2, 1, -1 }, 
						 { 1, 1, -1, -2 }, 
						 { -1, -1, -2, -3 } };
		int count = 0;

		for (int d[] : grid)
			for (int i : d) {
				if (i < 0)
					count++;
			}

		System.out.println(count);
	}

}
