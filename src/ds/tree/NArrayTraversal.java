package ds.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class NArrayTraversal {

	public static void main(String[] args) {

		List<NNode> children = new ArrayList<NNode>();

		List<NNode> children3 = new ArrayList<NNode>();
		children3.add(new NNode(5));
		children3.add(new NNode(6));

		NNode node3 = new NNode(3, children3);

		children.add(node3);
		children.add(new NNode(2));
		children.add(new NNode(4));

		NNode root = new NNode(1, children);
		
		for (List<Integer> list : levelOrder(root))
			System.out.print(list);

		System.out.println(preorderItr(root));

	}

	static List<List<Integer>> levelOrder(NNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;

		Queue<NNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> level = new ArrayList<>();

			for (int i = 0; i < size; ++i) {
				NNode node = queue.poll();
				level.add(node.val);

				if (node.children != null)
					for (NNode child : node.children) {
						queue.offer(child);
					}
			}
			res.add(level);
		}
		return res;
	}

	static List<Integer> preorder(NNode root) {
		List<Integer> res = new ArrayList<>();
		preorderSoln(root, res);
		return res;
	}

	static void preorderSoln(NNode root, List<Integer> res) {
		if (root == null)
			return;

		res.add(root.val);

		if (root.children != null)
			for (NNode child : root.children) {
				preorderSoln(child, res);
			}
	}

	static List<Integer> preorderItr(NNode root) {
		List<Integer> lst = new LinkedList<>();
		if (root == null)
			return lst;
		Deque<NNode> stack = new ArrayDeque<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			NNode curr = stack.pop();
			lst.add(curr.val);
			if (curr.children != null) {
				int n = curr.children.size();
				for (int i = n - 1; i >= 0; --i)
					stack.push(curr.children.get(i));
			}
		}
		return lst;
	}

	static List<Integer> postorder(NNode root) {
		List<Integer> res = new ArrayList<>();
		postorderSoln(root, res);
		return res;
	}

	static void postorderSoln(NNode root, List<Integer> res) {
		if (root == null)
			return;

		for (NNode child : root.children) {
			preorderSoln(child, res);
		}
		res.add(root.val);
	}

	static List<Integer> postorderItr(NNode root) {
		List<Integer> ans = new LinkedList<>();
		if (root == null)
			return ans;
		Stack<NNode> stack = new Stack<>();
		NNode last = null;
		stack.push(root);
		while (!stack.isEmpty()) {
			NNode cur = stack.peek();
			if (cur == last || cur.children.size() > 0 && cur.children.contains(last)) {
				cur = stack.pop();
				ans.add(cur.val);
			} else {
				for (int i = cur.children.size() - 1; i >= 0; i--) {
					stack.push(cur.children.get(i));
				}
			}
			last = cur;
		}
		return ans;
	}
}

class NNode {
	
	public int val;
	public List<NNode> children;

	public NNode() {
	}

	public NNode(int V) {
		this.val = V;
	}

	public NNode(int V, List<NNode> children) {
		this.val = V;
		this.children = children;
	}
};
