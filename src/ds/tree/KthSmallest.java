package ds.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class KthSmallest {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);

		System.out.println(kthsmallest(root, 2));
		
		System.out.println(t2Sum(root, 4));
		

	}

	static int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode p = root;
		int result = 0;

		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				TreeNode t = stack.pop();
				k--;
				if (k == 0)
					return t.val;
				p = t.right;
			}
		}
		return result;
	}

	static int kthsmallest(TreeNode A, int B) {

		if (A == null)
			return 0;

		ArrayList<Integer> al = new ArrayList<>();
		inorder(A, al);
		System.out.println(al);
		return al.get(B - 1);
	}

	static void inorder(TreeNode root, ArrayList<Integer> al) {
		if (root != null) {
			inorder(root.left, al);
			al.add(root.val);
			inorder(root.right, al);
		}
	}

	static Set<Integer> set = new HashSet<>();

	static int t2Sum(TreeNode A, int B) {
		if (A == null)
			return 0;
		if (set.contains(B - A.val)) {
			return 1;
		}

		set.add(A.val);
        return Math.max(t2Sum(A.left, B), t2Sum(A.right, B));
	}
}
