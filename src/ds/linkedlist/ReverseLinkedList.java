package ds.linkedlist;

public class ReverseLinkedList {

	static ListNode head;

	static class ListNode {

		int data;
		ListNode next;

		ListNode(int d) {
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {
		ReverseLinkedList list = new ReverseLinkedList();
		list.head = new ListNode(1);
		list.head.next = new ListNode(2);
		list.head.next.next = new ListNode(3);
		list.head.next.next.next = new ListNode(4);
		list.head.next.next.next.next = new ListNode(5);

		//reverseWithRecursion(head);
		ListNode node = list.reverseList1(head); //list.reverseBetween(head, 2, 4);
		printList(node);
	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode current = head;
		ListNode nextNode = current.next;
		head.next = null;

		while (current != null && nextNode != null) {
			ListNode temp = nextNode.next;
			nextNode.next = current;
			current = nextNode;
			nextNode = temp;
		}
		return current;
	}

	public ListNode reverseList1(ListNode head) {
		ListNode dummy = new ListNode(0), tmp = head;
		while (tmp != null) {
			head = tmp.next;
			tmp.next = dummy.next;
			dummy.next = tmp;
			tmp = head;
		}
		return dummy.next;
	}

	// prints content of double linked list
	static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {

		if (head == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode then = head.next;
		for (int i = 1; i < m; i++) {
			prev = prev.next;
			head = head.next;
			then = then.next;
		}
		for (int i = m; i < n; i++) {
			head.next = then.next;
			then.next = prev.next;
			prev.next = then;
			then = head.next;
		}
		return dummy.next;
	}

	void detectLoop() {
		ListNode slow_p = head, fast_p = head;
		while (slow_p != null && fast_p != null && fast_p.next != null) {
			slow_p = slow_p.next;
			fast_p = fast_p.next.next;
			if (slow_p.data == fast_p.data) {
				System.out.println("Found loop " + slow_p.data);
				return;
			}
		}
	}

	public static void reverseWithRecursion(ListNode head) {
		if (head == null)
			return;
		reverseWithRecursion(head.next);
		System.out.print(head.data + "   ");
	}

	static ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode newHeadNode = reverse(head.next);

		// change references for middle chain
		head.next.next = head;
		head.next = null;

		// send back new head node in every recursion
		return newHeadNode;
	}
}
