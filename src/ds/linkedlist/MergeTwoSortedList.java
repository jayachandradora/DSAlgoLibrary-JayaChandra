package ds.linkedlist;

public class MergeTwoSortedList {

	public static void main(String[] args) {
		Node l1 = new Node(1);
		l1.next = new Node(3);
		l1.next.next = new Node(7);

		Node l2 = new Node(2);
		l2.next = new Node(4);
		l2.next.next = new Node(5);
		l2.next.next.next = new Node(10);

		l1 = mergeTwoLists(l1, l2);

		while (l1 != null) {
			System.out.print(l1.item + " ");
			l1 = l1.next;
		}

	}

	static Node mergeTwoList(Node l1, Node l2) {
		if (l1 == null || l2 == null)
			return l1 == null ? l2 : l1;

		if (l1.item > l2.item)
			return mergeTwoList(l2, l1);

		l1.next = mergeTwoList(l1.next, l2);

		return l1;
	}

	static Node mergeTwoLists(Node l1, Node l2) {
		
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		
		Node t1 = l1;
		Node t2 = l2;

		if (t1.item > t2.item) {
			Node temp = t1;
			t1 = t2;
			t2 = temp;
		}
		l1 = t1;

		while (t1.next != null && t2 != null) {
			if (t1.item <= t2.item && t1.next.item <= t2.item) {
				t1 = t1.next;
			} else if (t1.item <= t2.item) {
				Node temp = t2;
				t2 = t1.next;
				t1.next = temp;
			}
		}
		if (t1.next == null) {
			t1.next = t2;
		}
		return l1;
	}

}
