package intv.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class BottomViewTree {

	public static void main(String[] args) {
		BottomViewTree bt = new BottomViewTree();
		Node root = bt.new Node(20);
		root.left = bt.new Node(8);
		root.right = bt.new Node(22);
		root.left.left = bt.new Node(5);
		root.left.right = bt.new Node(3);
		root.right.left = bt.new Node(4);
		root.right.right = bt.new Node(25);
		root.left.right.left = bt.new Node(10);
		root.left.right.right = bt.new Node(14);

		BottomViewTree tree = new BottomViewTree(root);
		System.out.println("Bottom view of the given binary tree:");
		tree.bottomView();
	}

	Node root;

	public BottomViewTree() {
	}

	public BottomViewTree(Node node) {
		root = node;
	}

	public void bottomView() {
		if (root == null)
			return;

		int hd = 0;
		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Node> queue = new LinkedList<Node>();
		root.hd = hd;
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.remove();
			hd = temp.hd;
			map.put(hd, temp.data);

			if (temp.left != null) {
				temp.left.hd = hd - 1;
				queue.add(temp.left);
			}
			if (temp.right != null) {
				temp.right.hd = hd + 1;
				queue.add(temp.right);
			}
		}
		Set<Entry<Integer, Integer>> set = map.entrySet();
		Iterator<Entry<Integer, Integer>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<Integer, Integer> me = iterator.next();
			System.out.print(me.getValue() + " ");
		}
	}

	class Node {
		int data;
		int hd; // horizontal distance of the node
		Node left, right;

		public Node(int key) {
			data = key;
			hd = Integer.MAX_VALUE;
			left = right = null;
		}
	}
}
