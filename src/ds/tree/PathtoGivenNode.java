package ds.tree;

import java.util.ArrayList;
import java.util.List;

public class PathtoGivenNode {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		PathtoGivenNode pn = new PathtoGivenNode();
		System.out.println(pn.pathtoGivenNode(root, 6));

	}

	public boolean solve(TreeNode root, int n, List<Integer> res) {
		if (root == null)
			return false;

		res.add(root.val);
		
		if (root.val == n)
			return true;
		
		if (solve(root.left, n, res) || solve(root.right, n, res))
			return true;
		
		res.remove(res.size() - 1);
		
		return false;
	}

	public List<Integer> pathtoGivenNode(TreeNode A, int B) {
		List<Integer> res = new ArrayList<>();
		solve(A, B, res);
		return res;
	}

}
