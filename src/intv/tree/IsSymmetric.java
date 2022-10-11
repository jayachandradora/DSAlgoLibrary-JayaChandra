package intv.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsSymmetric {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);

		IsSymmetric is = new IsSymmetric();
		System.out.println(is.isSymmetric_BFS(root));

	}

	public boolean isSymmetric_BFS(TreeNode root) {

		Queue<Pair<TreeNode, TreeNode>> queue = new LinkedList<>();
		queue.add(new Pair<TreeNode, TreeNode>(root, root));

		while (!queue.isEmpty()) {
			Pair<TreeNode, TreeNode> nodes = queue.poll();
			TreeNode n1 = nodes.getKey();
			TreeNode n2 = nodes.getValue();

			if (n1 != null || n2 != null) {
				if (n1 != null && n2 != null && n1.val == n2.val) {

					queue.add(new Pair<>(n1.left, n2.right));
					queue.add(new Pair<>(n1.right, n2.left));
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isSymmetric_DFS(TreeNode root) {

		Stack<Pair<TreeNode, TreeNode>> stack = new Stack<>();
		stack.push(new Pair<TreeNode, TreeNode>(root, root));

		while (!stack.isEmpty()) {
			Pair<TreeNode, TreeNode> nodes = stack.pop();
			TreeNode n1 = nodes.getKey();
			TreeNode n2 = nodes.getValue();

			if (n1 != null || n2 != null) {
				if (n1 != null && n2 != null && n1.val == n2.val) {
					stack.push(new Pair<>(n1.left, n2.right));
					stack.push(new Pair<>(n1.right, n2.left));
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;

		return isMirror(root.left, root.right);
	}

	private boolean isMirror(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null)
			return true;

		if (node1 == null || node2 == null || node1.val != node2.val)
			return false;

		return isMirror(node1.right, node2.left) && isMirror(node1.left, node2.right);
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}