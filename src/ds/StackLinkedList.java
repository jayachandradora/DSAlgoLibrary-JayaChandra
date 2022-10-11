package ds;

public class StackLinkedList {

	public static void main(String[] args) {

		Node1 node = new Node1(10);
		node.push(15);
		node.push(20);
		node.push(25);
		node.push(30);

		System.out.println("pop " + node.pop() + " " + node.pop());
		System.out.println("Peek " + node.peek() + "  " + node.peek());

	}

}

class Node1 {

	Node1 next;
	int data;
	Node1 top = null;

	Node1(int data) {
		this.data = data;
	}

	boolean isEmpty() {
		return top == null;
	}

	public int peek() {
		return top.data;
	}

	public void push(int data) {

		Node1 node = new Node1(data);
		node.next = top;
		top = node;
	}

	public int pop() {
		int data = top.data;
		top = top.next;
		return data;
	}

}
