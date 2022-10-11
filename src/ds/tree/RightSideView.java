package ds.tree;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		/*root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);*/
		
		System.out.println(rightSideView(root));

	}

	static List<Integer> rightSideView(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		dfs(root, ans, 1);
		return ans;
	}

	static void dfs(TreeNode root, List<Integer> ans, int level) {
		if (root == null)
			return;
		
		if (ans.size() < level)
			ans.add(root.val);
		
		dfs(root.right, ans, level + 1);
		dfs(root.left, ans, level + 1);
	}

}
