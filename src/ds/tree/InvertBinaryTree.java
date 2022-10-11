package ds.tree;

public class InvertBinaryTree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		TreeNode node = invert(root);
		printLevel(node);
	}

	static void printLevel(TreeNode root) {
		if (root == null)
			return;

		int h = height(root);
		for (int i = 1; i <= h; i++) {
			printGivenLevel(root, i);
			System.out.println();
		}
	}

	static TreeNode invert(TreeNode root) {
		if (root == null)
			return root;

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		invert(root.left);
		invert(root.right);

		return root;
	}

	static void printGivenLevel(TreeNode root, int level) {
		if (root == null)
			return;

		if (level == 1)
			System.out.print(root.val + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	static int height(TreeNode root) {
		if (root == null)
			return 0;

		int l = height(root.left);
		int r = height(root.right);
		return max(l, r) + 1;
	}

	static int max(int x, int y) {
		return x > y ? x : y;
	}

}
