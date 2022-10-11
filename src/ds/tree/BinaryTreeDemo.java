package ds.tree;

public class BinaryTreeDemo {

	Node3 root;

	public static void main(String[] args) {
		BinaryTreeDemo btd = new BinaryTreeDemo();
		btd.root = new Node3(5);
		btd.root.right = new Node3(3);
		btd.print(btd.root);
	}

	void insert(Node3 root, int data) {
		if (root != null) {

		}
	}

	void print(Node3 root) {
		if (root != null) {
			while (root.left != null) {
				System.out.println(" left node data " + root.key);
				root = root.left;
			}
			while (root.right != null) {
				System.out.println("Right node data " + root.key);
				root = root.right;
			}
		}
	}
}

class Node3 {

	int key;
	Node3 left;
	Node3 right;

	Node3(int data) {
		key = data;
		left = null;
		right = null;
	}
}