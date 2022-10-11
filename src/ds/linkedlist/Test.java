package ds.linkedlist;

// No node

// 1 node
// same node then enter next node is a given node.
// check if node between

public class Test {

	Node6 root;

	// 1. detected cycle. 2. detected begining of cycle 3. removed the cycle.
	public static void main(String[] args) {

		Node root = new Node(1);
		// root.next = root;

		root.next = new Node(2);
		root.next.next = new Node(3);
		root.next.next.next = new Node(4);
		root.next.next.next = root.next;

		Node root1 = new Node(1);
		root1.next = new Node(2);
		root1.next.next = new Node(3);
		root1.next.next.next = new Node(4);
		root1.next.next.next.next = new Node(5);
		root1.next.next.next.next.next = new Node(6);
		Test test = new Test();
		test.root = new Node6(1);
		test.root.next = new Node6(3);
		test.root.next.prev = test.root;
		test.display(3);

	}

	public void display(int value) {
	}
}

class Node6 {
	int val;
	Node6 next;
	Node6 prev;

	Node6(int val) {
		this.val = val;
		next = null;
		prev = null;
	}
}