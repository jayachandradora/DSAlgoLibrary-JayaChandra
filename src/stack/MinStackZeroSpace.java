package stack;

import java.util.Stack;

public class MinStackZeroSpace {

	int minElement = 0;
	Stack<Integer> st = new Stack<Integer>();

	int getMin() {
		if (st.size() == 0)
			return -1;
		else
			return minElement;
	}

	void push(int val) {
		if (st.size() == 0) {
			st.push(val);
			minElement = val;
		} else {
			if (val >= minElement) {
				st.push(val);
			} else if (val < minElement) {
				st.push(2 * val - minElement);
				minElement = val;
			}
		}

	}

	void pop() {
		if (st.isEmpty())
			return;
		else if (st.peek() < minElement) {
			minElement = 2 * minElement - st.peek();
			st.pop();
		}
	}

	int top() {
		if (st.size() == 0)
			return -1;
		else if (st.peek() > minElement)
			return st.peek();
		else if (st.peek() < minElement)
			return minElement;
		return 0;
	}

	public static void main(String[] args) {

	}

}
