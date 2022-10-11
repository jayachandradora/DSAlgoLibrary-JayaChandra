package ds;

public class QueueLinkedList {

	public static void main(String[] args) {

		Node2 node = new Node2(10);
		node.next = new Node2(24);
		node.add(10);
		node.add(15);
		node.add(17);

		System.out.println(node.peek());
		System.out.println("Remove " + node.remove() + "  " + node.remove());
		System.out.println(node.peek());
	}
}

class Node2 {
	int data;
	Node2 next;

	Node2(int data) {
		this.data = data;
	}

	Node2 head; // remove from here
	Node2 tail; // add things here

	boolean isEmpty() {
		return head == null;
	}

	int peek() {
		return head.data;
	}

	void add(int data) {
		Node2 node = new Node2(data);

		if (tail != null)
			tail.next = node;

		tail = node;

		if (head == null)
			head = node;
	}

	int remove() {
		int data = head.data;
		head = head.next;
		if (head == null)
			tail = null;
		return data;
	}

}