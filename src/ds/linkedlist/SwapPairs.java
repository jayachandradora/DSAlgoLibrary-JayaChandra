package ds.linkedlist;

public class SwapPairs {

	public static void main(String[] args) {
		Node ls1 = new Node(2);
		ls1.next = new Node(4);
		ls1.next.next = new Node(5);
		ls1.next.next.next = new Node(7);
		print(swapPairs(ls1));
	}

	static Node swapPairs(Node head) {

		if (head == null || head.next == null)
			return head;

		Node newHead = new Node(0);
		Node t = newHead, p = head;
		while (p != null && p.next != null) {
			Node next = p.next.next;
			t.next = p.next;
			p.next.next = p;
			t = t.next.next;
			p = next;
		}
		t.next = p;
		return newHead.next;
	}

	static void print(Node head) {
		while (head != null) {
			System.out.print(" " + head.item);
			head = head.next;
		}
	}
}
