package ds.tree;

public class PrintLeafNodes {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		printLeafNodes(root);
	}

	static void printLeafNodes(TreeNode root) {
		if (root == null)
			return;

		if (root.left == null && root.right == null)
			System.out.println(root.val);

		if (root.left != null)
			printLeafNodes(root.left);

		if (root.right != null)
			printLeafNodes(root.right);
	}

}
