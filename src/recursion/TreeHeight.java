package recursion;

public class TreeHeight {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.left.left = new Node(4);
		
		System.out.println(height(root));
	}

	// Startagy is IHB ...induction Hypothesis..base condition.
	static int height(Node root) {

		// Base Condition... smaller input
		if (root == null)
			return 0;

		// hypothesis...
		int l = height(root.left);
		int r = height(root.right);

		// induction....
		return max(l, r) + 1;
	}

	static int max(int x, int y) {
		return x > y ? x : y;
	}
}

class Node {
	int val;
	Node left;
	Node right;

	Node(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}