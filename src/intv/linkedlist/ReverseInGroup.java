package intv.linkedlist;

public class ReverseInGroup {

	Node head; // head of list
	public void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		ReverseInGroup llist = new ReverseInGroup();

		/* Constructed Linked List is 1->2->3->4->5->6-> 7->8->8->9->null */
		//llist.push(9);
		llist.push(8);
		llist.push(7);
		llist.push(6);
		llist.push(5);
		llist.push(4);
		llist.push(3);
		llist.push(2);
		llist.push(1);

		System.out.println("Given Linked List");
		llist.printList();

		llist.head = llist.reverseKGroup(llist.head, 3);
		
		System.out.println("Reversed list");
		llist.printList();
	}

	public Node reverseKGroup(Node head, int k) {

		int l = 0;
		Node cur = head;

		while (cur != null) {
			l++;
			cur = cur.next;
		}

		if (l < k) {
			return head;
		}

		int n = l / k;
		Node pre = new Node(0), node, rem, ret = pre;
		for (int i = 0; i < n; i++) {
			node = null;
			rem = head;
			for (int j = 0; j < k; j++) {
				Node nxt = head.next;
				head.next = node;
				node = head;
				head = nxt;
			}
			pre.next = node;
			rem.next = head;
			pre = rem;
		}
		return ret.next;
	}

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}
}
