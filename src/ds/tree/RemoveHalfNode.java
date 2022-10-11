package ds.tree;

public class RemoveHalfNode {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(7);
		inorder(RemoveHalfNodes(root));
	}

	static void inorder(TreeNode root) {

		if (root == null)
			return;

		inorder(root.left);
		System.out.println(root.val + " ");
		inorder(root.right);
	}

	static TreeNode RemoveHalfNodes(TreeNode node) {

		if (node == null)
			return null;

		node.left = RemoveHalfNodes(node.left);
		node.right = RemoveHalfNodes(node.right);

		if (node.left == null && node.right == null)
			return node;

		if (node.left == null) {
			TreeNode new_root = node.right;
			return new_root;
		}

		if (node.right == null) {
			TreeNode new_root = node.left;
			return new_root;
		}

		return node;
	}

}
