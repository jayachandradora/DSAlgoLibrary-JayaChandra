package matrix;

import java.util.Arrays;
import java.util.Stack;

public class MatrixArray {

	public static void main(String[] args) {

		int arr[][] = new int[4][4];
		for (int d[] : arr)
			Arrays.fill(d, -1);

		for (int d[] : arr) {
			System.out.println();
			for (int i : d)
				System.out.print(i + " ");
		}
	}

	public int maximalRectangle(char[][] m) {
		if (m.length == 0)
			return 0;
		int[] h = new int[m[0].length];
		int res = 0;
		for (char[] r : m) {
			for (int i = 0; i < r.length; i++) {
				if (r[i] == '0')
					h[i] = 0;
				else
					h[i] += 1;
			}
			res = Math.max(res, largestRectangleArea(h));
		}
		return res;
	}

	public int largestRectangleArea(int[] h) {
		Stack<Integer> s = new Stack<>();
		int idx = 0, res = 0;
		while (idx <= h.length) {
			if (idx < h.length && (s.isEmpty() || h[idx] >= h[s.peek()])) {
				s.push(idx++);
			} else {
				if (s.isEmpty() && idx == h.length)
					break;
				int t = s.pop();
				res = Math.max(res, h[t] * (s.isEmpty() ? idx : idx - s.peek() - 1));
			}
		}
		return res;
	}

}
