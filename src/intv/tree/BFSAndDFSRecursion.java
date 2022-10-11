package intv.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSAndDFSRecursion {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		breadthFirstSearch(queue);
		
		System.out.println();
		
		Stack<Node> stack = new Stack<>();
		stack.add(root);
		depthFirstSearch(stack);
	}

	static void breadthFirstSearch(Queue<Node> queue) {
		if (queue.isEmpty())
			return;

		Node node = (Node) queue.poll();

		System.out.print(node.val + " ");

		if (node.right != null)
			queue.offer(node.right);

		if (node.left != null)
			queue.offer(node.left);

		breadthFirstSearch(queue);
	}

	static void depthFirstSearch(Stack<Node> stack) {
		if (stack.isEmpty())
			return;

		Node node = (Node) stack.pop();

		System.out.print(node.val + " ");

		if (node.right != null)
			stack.push(node.right);

		if (node.left != null)
			stack.push(node.left);

		depthFirstSearch(stack);
	}
}

class Node {
	int val;
	Node left;
	Node right;

	Node(int x) {
		val = x;
	}
}
