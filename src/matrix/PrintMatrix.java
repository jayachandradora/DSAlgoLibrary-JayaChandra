package matrix;

public class PrintMatrix {

	public static void main(String[] args) {
		
		int arr[][] = { {1,2,3,4},
						{4,5,6,7},
						{8,9,10,11}};
		
		int row = arr.length;
		int col = arr[0].length-1;
		
		for(int i =0; i<col; i++) {
			int k = i+1;
			if(k % 2 == 0)
				for(int j=0; j<=row; j++) {
					System.out.print( arr[i][row-j] + " ");
				}
			else
				for(int j=0; j<=row; j++) {
					System.out.print( arr[i][j] + " ");
				}
			System.out.println();
		}
	}

}
