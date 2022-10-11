package ds.tree;

import java.util.Stack;

public class RangeSumBST {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(9);
		root.right = new TreeNode(12);
		root.right.left = new TreeNode(11);
		root.right.right = new TreeNode(15);

		System.out.println(rangeSumBSTRec(root, 9, 11));
		
		printRangeBST(root, 9, 11);
	}

	static int rangeSumBST(TreeNode root, int L, int R) {
		if (root == null)
			return 0;

		if (root.val < L)
			return rangeSumBST(root.right, L, R);

		if (R < root.val)
			return rangeSumBST(root.left, L, R);

		return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
	}

	static int rangeSumBSTRec(TreeNode root, int L, int R) {
		Stack<TreeNode> st = new Stack<>();
		st.add(root);
		int sum = 0;
		while (!st.isEmpty()) {
			TreeNode n = st.pop();
			
			if (n == null)
				continue;
			
			if (n.val >= L && n.val <= R)
				sum += n.val;
			
			if (n.val > L)
				st.push(n.left);
			
			if (n.val < R)
				st.push(n.right);
			
		}
		return sum;
	}

	static void printRangeBST(TreeNode root, int L, int R) {
		if (root == null)
			return;

		if (L < root.val)
			printRangeBST(root.left, L, R);

		if (L <= root.val && R >= root.val)
			System.out.println(root.val + " ");

		if (R > root.val)
			printRangeBST(root.right, L, R);

	}
}
