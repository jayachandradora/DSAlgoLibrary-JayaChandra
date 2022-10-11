package stack;

import java.util.Stack;

public class TrapRainWater {

	static int trapWater(int[] height) {
		int l = 0;
		int r = height.length - 1;
		int max = 0;

		while (l < r) {
			
			int lh = height[l];
			int rh = height[r];

			int min_h = Math.min(lh, rh);
			max = Math.max(max, min_h * (r - l));

			if (lh < rh)
				l++;
			else
				r--;

		}

		return max;
	}

	// https://www.youtube.com/watch?v=FbGG2qpNp4U&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=9
	// Lengthy but nice one to understand all technique here:
	// https://www.youtube.com/watch?v=C8UjlJZsHBw
	static int trap2New(int[] height) {

		if (height.length == 0)
			return 0;
		int size = height.length;
		int maxL[] = new int[size];
		int maxR[] = new int[size];
		int min[] = new int[size];

		maxL[0] = height[0];
		maxR[size - 1] = height[size - 1];
		int res = 0;

		for (int i = 1; i < size; i++)
			maxL[i] = Math.max(maxL[i - 1], height[i]);

		for (int i = size - 2; i >= 0; i--)
			maxR[i] = Math.max(maxR[i + 1], height[i]);

		for (int i = 0; i < size; i++)
			min[i] = Math.min(maxL[i], maxR[i]);

		for (int i = 0; i < size; i++)
			res += min[i] - height[i];

		return res;

	}

	public static int trap1(int[] height) {

		int left_max = 0, right_max = 0, lo = 0, hi = height.length - 1, result = 0;

		while (lo <= hi) {
			if (height[lo] < height[hi]) {
				if (height[lo] > left_max) {
					left_max = height[lo];
				} else {
					result += left_max - height[lo];
				}

				lo++;
			} else {
				if (height[hi] > right_max) {
					right_max = height[hi];
				} else {
					result += right_max - height[hi];
				}
				hi--;
			}
		}
		return result;
	}

	public static int trap(int[] A) {
		// skip zeros
		int cur = 0;
		while (cur < A.length && A[cur] == 0)
			++cur;

		// check each one
		int vol = 0;
		Stack<Integer> stack = new Stack<Integer>();
		while (cur < A.length) {
			while (!stack.isEmpty() && A[cur] >= A[stack.peek()]) {
				int b = stack.pop();
				if (stack.isEmpty())
					break;
				vol += ((cur - stack.peek() - 1) * (Math.min(A[cur], A[stack.peek()]) - A[b]));
			}
			stack.push(cur);
			++cur;
		}

		return vol;
	}

	public static int rectangle(int[] height) {

		if (height == null || height.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();

		int max = 0;
		int i = 0;

		while (i < height.length) {
			// push index to stack when the current height is larger than the previous one
			if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				// calculate max value when the current height is less than the previous one
				int p = stack.pop();
				int h = height[p];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(h * w, max);
			}

		}

		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = height[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(h * w, max);
		}
		return max;
	}

	public static void main(String[] args) {

		int height[] = { 3, 0, 0, 2, 0, 4 };
		System.out.println(trap2New(height));
		
		int height1[] = {1,8,6,2,5,4,8,3,7};
		System.out.println(trapWater(height1));

	}

}
