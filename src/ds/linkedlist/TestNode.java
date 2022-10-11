package ds.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestNode {

	TNode root = null;

	public static void main(String[] args) {

		TestNode t = new TestNode();
		t.create();
		t.test();

	}

	TNode test() {

		TNode fast = root;
		TNode slow = root;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	void create() {
		root = new TNode(1);
		root.next = new TNode(2);
		root.next.next = new TNode(22);
		root.next.next.next = new TNode(1);
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		Collections.reverse(list);
		System.out.println(list);
	}

}

class TNode {
	TNode next = null;
	int val;

	TNode(int val) {
		this.val = val;
	}
}