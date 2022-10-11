package ds.linkedlist;

import java.util.Stack;

public class FlattenMultilevelDoublyLinkedList {

	public static void main(String[] args) {

	}

	public DNode flatten(DNode head) {
		Stack<DNode> s = new Stack<>();
		DNode t = head;
		while (t != null) {
			if (t.child != null) {
				if (t.next != null)
					s.push(t.next);
				t.next = t.child;
				t.child.prev = t;
				t.child = null;
				t = t.next;
			} else if (t.next != null) {
				t = t.next;
			} else if (!s.isEmpty()) {
				DNode next = s.pop();
				t.next = next;
				next.prev = t;
				t = next;
			} else {
				t = null;
			}
		}
		return head;
	}
}

class DNode {
	public int val;
	public DNode prev;
	public DNode next;
	public DNode child;

	DNode(int V) {
		this.val = V;
	}

}