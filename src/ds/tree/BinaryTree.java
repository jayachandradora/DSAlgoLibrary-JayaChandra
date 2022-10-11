package ds.tree;

public class BinaryTree {

	Node4 root;

	public BinaryTree(int key) {
		root = new Node4(key);
	}

	public BinaryTree() {
		root = null;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node4(5);

		bt.root.left = new Node4(3);
		bt.root.left.right = new Node4(31);
		bt.root.right = new Node4(7);
		bt.root.left.left = new Node4(1);

		print(bt.root);
	}

	static void print(Node4 root) {

		Node4 tempRoot = root;
		while (root != null) {
			System.out.print(" " + root.key + " ");
			root = root.left;
		}
		while (tempRoot != null) {
			tempRoot = tempRoot.right;
			if (tempRoot != null)
				System.out.print(" " + tempRoot.key + " ");
		}
	}
}

class Node4 {
	int key;
	Node4 left, right;

	public Node4(int item) {
		key = item;
		left = right = null;
	}
}