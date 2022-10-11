package ds.tree;

public class MaximumPathSumAnyLeafNode {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		System.out.println("MaxPathSum : " + maxPathSumR(root, Integer.MIN_VALUE));
		
	}

	static int maxPathSumR(TreeNode root, int res) {

		if (root == null)
			return 0;
		int left = maxPathSumR(root.left, res);
		int right = maxPathSumR(root.right, res);

		int temp = max(left, right) + root.val;
		if (root.left == null && root.right == null)
			temp = max(temp, root.val);

		int ans = max(temp, left + right + root.val);
		res = max(res, ans);

		return res;
	}

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

}
