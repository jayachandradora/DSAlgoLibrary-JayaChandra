package ds.hashing;

class Node
{
	int data;
	Node left = null, right = null;

	Node(int data) {
		this.data = data;
	}
}

class Main
{
	// Recursive function to insert a key into BST
	public static Node insert(Node root, int key)
	{
		// if the root is null, create a new node and return it
		if (root == null) {
			return new Node(key);
		}

		// if given key is less than the root node, recur for left subtree
		if (key < root.data) {
			root.left = insert(root.left, key);
		}
		// if given key is more than the root node, recur for right subtree
		else {
			root.right = insert(root.right, key);
		}

		return root;
	}

	// Function to determine if given Binary Tree is a BST or not by keeping a
	// valid range (starting from [MIN_VALUE, MAX_VALUE]) and keep shrinking
	// it down for each node as we go down recursively
	public static boolean isBST(Node node, int minKey, int maxKey)
	{
		// base case
		if (node == null) {
			return true;
		}

		// if node's value fall outside valid range
		if (node.data < minKey || node.data > maxKey) {
			return false;
		}

		// recursively check left and right subtrees with updated range
		return isBST(node.left, minKey, node.data) &&
			isBST(node.right, node.data, maxKey);
	}

	// Function to determine if given Binary Tree is a BST or not
	public static void isBST(Node root)
	{
		if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
			System.out.println("This is a BST.");
		} else {
			System.out.println("This is NOT a BST!");
		}
	}

	private static void swap(Node root) {
		Node left = root.left;
		root.left = root.right;
		root.right = left;
	}

	public static void main(String[] args)
	{
		Node root = null;
		int[] keys = { 15, 10, 20, 8, 12, 16, 25 };

		for (int key : keys) {
			root = insert(root, key);
		}

		// swap left and right nodes
		swap(root);
		isBST(root);
	}
}