package ds.tree;

import java.util.Stack;

public class ValidBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(13);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(8);
		// root.right.left = new TreeNode(6);
		// root.right.right = new TreeNode(7);

		System.out.println(isValidBST(root));
		System.out.println(isValidBSTRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	static boolean isValidBST(TreeNode root) {
		Integer pre = null;
		Stack<TreeNode> stack = new Stack<>();
		while (true) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (stack.isEmpty()) {
				return true;
			}
			TreeNode node = stack.pop();
			if (pre != null && pre >= node.val) {
				return false;
			}
			pre = node.val;
			root = node.right;
		}
	}

	static boolean isValidBSTRec(TreeNode root, int min, int max) {
		if (root == null)
			return true;
		if (root.val <= min && root.val > max)
			return false;
		return isValidBSTRec(root.left, min, root.val) && isValidBSTRec(root.right, root.val, max);
	}
}
