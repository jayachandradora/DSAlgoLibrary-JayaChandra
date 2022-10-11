package ds.tree;

import java.util.HashMap;
import java.util.Map;

public class MinCountTree {

	Node root;

	public static void main(String[] args) {
		MinCountTree tree = new MinCountTree();
		Map<Integer, Integer> mincount = new HashMap();

		tree.root = new Node(3);
		mincount.put(3, 0);
		tree.insert(tree.root, 5, mincount);
		tree.insert(tree.root, 1, mincount);
		tree.insert(tree.root, 9, mincount);
		mincount.forEach((k, l) -> System.out.println("Key " + k + " value " + l));
		// tree.print(tree.root);

	}

	void print(Node root) {
		if (root != null) {
			print(root.left);
			System.out.println("Data " + root.value);
			print(root.right);
		}
	}

	// Insertion with recursion
	public void insert(Node node, int value, Map mincount) {
		if (value < node.value) {
			if (node.left != null) {
				insert(node.left, value, mincount);
			} else {
				System.out.println("  Inserted " + value + " to left of Node " + node.value);
				node.left = new Node(value);
			}
		} else if (value > node.value) {
			if (node.right != null) {
				insert(node.right, value, mincount);
			} else {
				System.out.println("  Inserted " + value + " to right of Node " + node.value);
				node.right = new Node(value);
			}
		}
	}

	//
	public Node insertNode(Node root, Node node) {
		if (root == null)
			return node;

		Node curr = root;
		while (true) {
			if (node.value < curr.value) {
				if (curr.left != null)
					curr = curr.left;
				else {
					curr.left = node;
					break;
				}
			} else if (node.value > curr.value) {
				if (curr.right != null)
					curr = curr.right;
				else {
					curr.right = node;
					break;
				}
			} else {
				curr.value = node.value;
				break;
			}
		}
		return root;
	}
}

class Node {

	int value;
	Node left;
	Node right;

	Node(int d) {
		value = d;
		left = null;
		right = null;
	}
}