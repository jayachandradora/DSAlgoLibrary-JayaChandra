package stack;

public class MinStack {

	static Node top;

	static void push(int val) {
		if (top == null) {
			top = new Node(val, val);
			return;
		}
		Node node = new Node(val, Math.min(val, top.min));
		node.next = top;
		top = node;
		System.out.println("Push --> " + val + " min val " + top.min);
	}

	static void pop() {

		if (top == null)
			return;

		System.out.println("pop " + top.val);
		Node temp = top;
		top = temp.next;
	}

	static int min() {
		if (top == null)
			return 0;
		
		return top.min;
	}

	public static void main(String[] args) {
		push(15);
		push(25);
		push(10);
		push(40);
		System.out.println("min val " + min());
		push(30);
		push(20);
		pop();
		System.out.println("min val " + min());
		pop();
		pop();
		System.out.println("min val " + min());
		pop();
		System.out.println("min val " + min());
		pop();
		System.out.println("min val " + min());
		pop();
		System.out.println("min val " + min());
		pop();
		System.out.println("min val " + min());
	}
}

class Node {
	int val;
	int min;
	Node next;

	public Node(int val, int min) {
		this.val = val;
		this.min = min;
	}
}
