package dp;

public class MaximumLengthofRepeatedSubarray {

	public static void main(String[] args) {
		int A[] = {1,2,3,2,1};
		int []B= {3,2,1,4,7};
		
		System.out.println(findLength(A, B));
	}

	static int findLength(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		int[][] f = new int[m + 1][n + 1];
		int max = 0;
		for (int i = 1; i <= m; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (A[i - 1] == B[j - 1]) {
					f[i][j] = f[i - 1][j - 1] + 1;
					max = Math.max(max, f[i][j]);
				}
			}
		}
		return max;
	}
}
