package stack;

import java.util.Stack;

public class AreaOfRectangle {

	public static void main(String[] args) {

		int heights[] = {2,1,5,6,2,3};
		System.out.println("Area : " + histogram(heights));
	}

	private static int histogram(int[] heights) {
		if (heights == null || heights.length == 0)
			return 0;

		int len = heights.length;
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;

		for (int i = 0; i <= len; i++) { // The loop continues until one position to the end of the array
			int h = (i == len ? 0 : heights[i]);

			if (stack.isEmpty() || h >= heights[stack.peek()]) // when the current is >= peek of stack, push
				stack.push(i);
			else { // calculate area for each pop until you find value <= current
				int top = stack.pop();
				maxArea = Math.max(maxArea, heights[top] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
				i--; // so that you can do processing of the same element again, to eliminate while loop
			}
		}
		return maxArea;
	}

}
