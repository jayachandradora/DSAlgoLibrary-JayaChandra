package ds.tree;

public class HeightBalancedTree {

	static int checkHeightBalanced(TreeNode node) {

		if (node == null)
			return 0;

		int left = checkHeightBalanced(node.left);
		if (left == -1)
			return -1;

		int right = checkHeightBalanced(node.right);
		if (right == -1)
			return -1;

		if (Math.abs(left - right) > 1)
			return -1;

		return (Math.max(left, right) + 1);
	}

	static boolean checkIfBalanced(TreeNode root) {
		if (checkHeightBalanced(root) == -1)
			return false;

		return true;
	}
	
	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		//root.left.right = new TreeNode(5);
		//root.right.left = new TreeNode(6);
		//root.right.right = new TreeNode(7);
		System.out.println(checkIfBalanced(root));
	}

	
}


