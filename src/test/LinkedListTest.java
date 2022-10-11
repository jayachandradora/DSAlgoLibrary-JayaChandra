package test;

public class LinkedListTest {

	public static void main(String[] args) {

		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		node.next.next.next.next = new Node(5);
		
		System.out.println(middleNode(node).val);
		System.out.println(hasCycle(node));

		Node node1 = new Node(1);
		node1.next = new Node(2);
		node1.next.next = new Node(3);
		node1.next.next.next = new Node(4);
		node1.next.next.next.next = new Node(5);
		node1.next.next.next.next.next = new Node(6);
		node1.next.next.next.next.next.next = new Node(7);


		System.out.println(removeNthFromEnd(node, 2).val);

	}

	static Node middleNode(Node head) {

		if (head == null)
			return head;

		Node firstP = head;
		Node slowP = head;
		while (slowP != null) {
			if (firstP.next == null || firstP.next.next == null)
				return slowP;

			firstP = firstP.next.next;
			slowP = slowP.next;
		}
		return slowP;
	}

	static boolean hasCycle(Node head) {

		if (head == null)
			return false;

		Node firstP = head;
		Node slowP = head;
		while (slowP != null) {
			if (firstP.next == null || firstP.next.next == null)
				return false;

			firstP = firstP.next.next;
			slowP = slowP.next;

			if (firstP.val == slowP.val)
				return true;
		}
		return false;
	}

	static Node reverse(Node head) {
		if (head == null) {
			return head;
		}

		if (head.next == null) {
			return head;
		}

		Node newHeadNode = reverse(head.next);

		head.next.next = head;
		head.next = null;

		return newHeadNode;
	}

	static Node removeNthFromEnd(Node head, int n) {
		Node slow = head, fast = head;
		while (fast != null) {
			if (n < 0)
				slow = slow.next;
			else
				n -= 1;
			fast = fast.next;
		}
		
		if (n < 0)
			slow.next = slow.next.next;
		return n == 0 ? head.next : head;
	}
	
}

class Node {
	int val;
	Node next;

	public Node(int v) {
		this.val = v;
		this.next = null;
	}
}