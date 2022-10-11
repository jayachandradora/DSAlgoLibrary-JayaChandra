package ds.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {

	static List<Integer> preOrderTraversalApp1(TreeNode root) {

		List<Integer> ret = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node != null) {
				ret.add(node.val);
				stack.push(node.right);
				stack.push(node.left);
			}
		}
		return ret;

	}

	static List<Integer> preOrderTraversal(TreeNode root) {
		Stack<TreeNode> stk = new Stack<>();
		List<Integer> list = new ArrayList<Integer>();
		while (true) {
			while (root != null) {
				list.add(root.val);
				stk.push(root);
				root = root.left;
			}
			TreeNode temp = stk.pop();
			if (temp.right != null) {
				stk.push(temp.right);
				root = temp.right;
			}
			if (stk.isEmpty())
				return list;
		}
	}

	static List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> ret = new ArrayList<>();
		while (true) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (stack.isEmpty()) {
				break; // no node left
			}
			TreeNode node = stack.pop();
			ret.add(node.val);
			root = node.right;
		}
		return ret;
	}

	static List<Integer> postorderTraversal(TreeNode root) {

		LinkedList<Integer> ans = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();

		if (root == null)
			return ans;

		stack.push(root);

		while (!stack.isEmpty()) {

			TreeNode cur = stack.pop();
			ans.addFirst(cur.val);

			if (cur.left != null) {
				stack.push(cur.left);
			}

			if (cur.right != null) {
				stack.push(cur.right);
			}
		}

		return ans;
	}
	
	static void printPostOrderTraversal(TreeNode root) {

		Stack<TreeNode> st = new Stack<>();
		while (true) {
			while (root != null) {
				st.push(root);
				root = root.left;
			}

			if (st.isEmpty())
				break;

			root = st.peek();
			root = root.right;
			if(root == null) {
				root = st.pop();
				System.out.print(root.val);
			}
				

		}
	}
	
	static List<List<Integer>> levelOrderItrative(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Deque<TreeNode> queue = new LinkedList<>();
		queue.addFirst(root);
		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int n = queue.size();
			for (int i = 0; i < n; i++) {
				TreeNode t = queue.removeLast();
				if (t == null)
					continue;
				list.add(t.val);
				queue.addFirst(t.left);
				queue.addFirst(t.right);
			}
			if (!list.isEmpty())
				res.add(list);
		}
		return res;
	}

	static void printLevelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {

			TreeNode tempNode = queue.poll();
			System.out.print(tempNode.val + " ");

			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}

			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		// root.right.left = new TreeNode(6);
		// root.right.right = new TreeNode(7);
		System.out.println(preOrderTraversalApp1(root));

		System.out.println(postorderTraversal(root));
		
		System.out.println();
		
		System.out.println(" Levele ORder Trabversal");
		for(List ls :levelOrderItrative(root))
			System.out.print(ls + " ");
	}

}
