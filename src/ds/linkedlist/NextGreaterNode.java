package ds.linkedlist;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterNode {

	public static void main(String[] args) {
		Node111 node = new Node111(1);
		node.next = new Node111(0);
		node.next.next = new Node111(3);
		node.next.next.next = new Node111(2);
		node.next.next.next.next = new Node111(5);

		for (int in : nextLargerNodes(node))
			System.out.print(in + " ");
	}

	static int[] nextLargerNodes(Node111 head) {
		ArrayList<Integer> list = new ArrayList<>();

		for (Node111 node = head; node != null; node = node.next)
			list.add(node.val);

		int[] res = new int[list.size()];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < list.size(); ++i) {

			while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i))
				res[stack.pop()] = list.get(i);

			stack.push(i);
		}
		return res;
	}

}

class Node111 {
	int val;
	Node111 next;

	public Node111(int v) {
		this.val = v;
		this.next = null;
	}
}