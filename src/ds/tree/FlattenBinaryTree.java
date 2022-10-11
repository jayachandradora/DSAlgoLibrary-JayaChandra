package ds.tree;

import java.util.Stack;

public class FlattenBinaryTree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		flatten(root);
		System.out.println(root.val);

		System.out.println(countNode(root));
		
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		
		System.out.println(sumNumbers(node));

	}

	static int countNode(TreeNode root) {
		if (root == null)
			return 0;

		int l = countNode(root.left);
		int r = countNode(root.right);

		return l + r + 1;

	}
	
	static int sumNumbers(TreeNode root) {
		return dfs(root, 0);
	}

	static int dfs(TreeNode node, int path) {
		if (node == null) {
			return 0;
		}

		path = path * 10 + node.val;

		if (node.left == null && node.right == null) {
			return path;
		}

		return dfs(node.left, path) + dfs(node.right, path);
	}

	static void flatten(TreeNode root) {
		while (root != null) {
			TreeNode last = root.left;
			if (last != null) {
				while (last.right != null)
					last = last.right;
				last.right = root.right;
				root.right = root.left;
				root.left = null;
			}
			root = root.right;
		}
	}

	TreeNode first = null;

	public void flatten1(TreeNode root) {
		if (root == null)
			return;
		flatten1(root.right);
		flatten1(root.left);
		root.right = first;
		root.left = null;
		first = root;
	}
}
