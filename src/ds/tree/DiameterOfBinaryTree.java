package ds.tree;

public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);

		System.out.println("diameeter : " + diameterOfBinaryTree(root));
		System.out.println("diameeter Solve() : " + solve(root, Integer.MIN_VALUE));
	}

	public static int diameterOfBinaryTree(TreeNode root) {
		helper(root);
		return diameter;
	}

	static int diameter = 0;

	private static int helper(TreeNode node) {
		if (node == null)
			return 0;

		int left = helper(node.left);
		int right = helper(node.right);

		diameter = max(diameter, left + right);
		return max(left, right) + 1;
	}

	static int solve(TreeNode node, int res) {
		if (node == null)
			return 0;

		int left = solve(node.left, res);
		int right = solve(node.right, res);

		int temp = max(left, right)+1;
		int ans = max(temp, left+right);
		res = max(res, ans);
		return res;
	}

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}
}
