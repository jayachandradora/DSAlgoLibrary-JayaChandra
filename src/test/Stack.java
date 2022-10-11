package test;

public class Stack {

	int arr[];
	int capacity = 0;
	int top = -1;

	public Stack(int capacity) {
		this.capacity = capacity;
		int top = -1;
	}

	void push(int val) {
		arr[top] = val;
		top = top + 1;
	}

	int pop() {
		if (!isEmpty()) {
			int temp = arr[top];
			top -= 1;
			return temp;
		}
		return -1;
	}

	int peek() {
		if (!isEmpty())
			return arr[top];

		return -1;
	}

	int size() {
		return arr.length;
	}

	boolean overFlow() {
		return top >= capacity ? true : false;
	}

	boolean isEmpty() {
		return top == -1;
	}

}
