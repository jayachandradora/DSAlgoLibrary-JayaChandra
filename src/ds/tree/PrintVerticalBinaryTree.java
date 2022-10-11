package ds.tree;

class Values {
	int max, min;
}

class PrintVerticalBinaryTree {
	TreeNode root;
	Values val = new Values();

	// A utility function to find min and max distances with respect to root.
	void findMinMax(TreeNode node, Values min, Values max, int hd) {
		// Base case
		if (node == null)
			return;

		// Update min and max
		if (hd < min.min)
			min.min = hd;
		else if (hd > max.max)
			max.max = hd;

		// Recur for left and right subtrees
		findMinMax(node.left, min, max, hd - 1);
		findMinMax(node.right, min, max, hd + 1);
	}

	// A utility function to print all nodes on a given line_no. hd is horizontal distance of current node with respect to root.
	void printVerticalLine(TreeNode node, int line_no, int hd) {
		// Base case
		if (node == null)
			return;

		// If this node is on the given line number
		if (hd == line_no)
			System.out.print(node.val + " ");

		// Recur for left and right subtrees
		printVerticalLine(node.left, line_no, hd - 1);
		printVerticalLine(node.right, line_no, hd + 1);
	}

	// The main function that prints a given binary tree in vertical order
	void verticalOrder(TreeNode node) {
		// Find min and max distances with resepect to root
		findMinMax(node, val, val, 0);

		// Iterate through all possible vertical lines starting from the leftmost line and print nodes line by line
		for (int line_no = val.min; line_no <= val.max; line_no++) {
			printVerticalLine(node, line_no, 0);
			System.out.println("");
		}
	}

	// Driver program to test the above functions
	public static void main(String args[]) {
		PrintVerticalBinaryTree tree = new PrintVerticalBinaryTree();

		TreeNode root = new TreeNode(1);
		
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		root.right.right.right = new TreeNode(9);

		System.out.println("vertical order traversal is :");
		tree.verticalOrder(root);
	}
}
