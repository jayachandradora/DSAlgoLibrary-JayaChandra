package matrix;

import java.util.Arrays;

public class MatrixMedian {

	public static void main(String[] args) {
		int r = 3, c = 3;
		int m[][] = { { 1, 3, 5 }, 
					  { 2, 6, 9 }, 
					  { 3, 6, 9 } };

		System.out.println("Median is " + binaryMedian(m, r, c));
	}

	static int binaryMedian(int m[][], int r, int c) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < r; i++) {
			// Finding the minimum element
			if (m[i][0] < min)
				min = m[i][0];

			// Finding the maximum element
			if (m[i][c - 1] > max)
				max = m[i][c - 1];
		}

		int desired = (r * c + 1) / 2;
		while (min < max) {
			int mid = min + (max - min) / 2;
			int place = 0;
			int get = 0;

			// Find count of elements smaller than mid
			for (int i = 0; i < r; ++i) {
				get = Arrays.binarySearch(m[i], mid);
				if (get < 0)
					get = Math.abs(get) - 1;
				else {
					while (get < m[i].length && m[i][get] == mid)
						get += 1;
				}
				place = place + get;
			}

			if (place < desired)
				min = mid + 1;
			else
				max = mid;
		}
		return min;
	}
}
