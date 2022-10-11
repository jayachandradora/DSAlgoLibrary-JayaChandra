package intv.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import intv.Node;
//https://www.youtube.com/watch?v=wTloJwckQTU&list=PLUcsbZa0qzu3yNzzAxgvSgRobdUUJvz7p&index=62&ab_channel=AnujBhaiya
public class TopView {

	Node root;

	public TopView() {
		root = null;
	}

	class QueueObj {
		Node node;
		int hd;

		QueueObj(Node node, int hd) {
			this.node = node;
			this.hd = hd;
		}
	}
	private void TopView(Node root) {
		

		Queue<QueueObj> q = new LinkedList<QueueObj>();
		Map<Integer, Node> topViewMap = new TreeMap<Integer, Node>();

		if (root == null)
			return;
		else
			q.add(new QueueObj(root, 0));

		while (!q.isEmpty()) {
			
			QueueObj tmpNode = q.poll();
			if (!topViewMap.containsKey(tmpNode.hd))
				topViewMap.put(tmpNode.hd, tmpNode.node);
			
			if (tmpNode.node.left != null)
				q.add(new QueueObj(tmpNode.node.left, tmpNode.hd - 1));

			if (tmpNode.node.right != null)
				q.add(new QueueObj(tmpNode.node.right, tmpNode.hd + 1));

		}
		for (Map.Entry<Integer, Node> entry : topViewMap.entrySet())
			System.out.print(entry.getValue().data + " ");
	}

	private void BottomView(Node root) {
		
		Queue<QueueObj> q = new LinkedList<QueueObj>();
		Map<Integer, Node> topViewMap = new TreeMap<Integer, Node>();

		if (root == null)
			return;
		else
			q.add(new QueueObj(root, 0));

		while (!q.isEmpty()) {
			QueueObj tmpNode = q.poll();

			topViewMap.put(tmpNode.hd, tmpNode.node);

			if (tmpNode.node.left != null)
				q.add(new QueueObj(tmpNode.node.left, tmpNode.hd - 1));

			if (tmpNode.node.right != null)
				q.add(new QueueObj(tmpNode.node.right, tmpNode.hd + 1));

		}
		for (Map.Entry<Integer, Node> entry : topViewMap.entrySet())
			System.out.print(entry.getValue().data + " ");
	}

	public static void main(String[] args) {
		TopView tree = new TopView();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.left.right.right = new Node(5);
		tree.root.left.right.right.right = new Node(6);
		System.out.println("Following are nodes in top view of Binary Tree");
		tree.TopView(tree.root);

		System.out.println();
		TopView tree1 = new TopView();
		tree1.root = new Node(20);
		tree1.root.left = new Node(8);
		tree1.root.right = new Node(22);
		tree1.root.left.left = new Node(5);
		tree1.root.left.right = new Node(3);
		tree1.root.right.left = new Node(4);
		tree1.root.right.right = new Node(25);
		tree1.root.left.right.left = new Node(10);
		tree1.root.left.right.right = new Node(14);
		System.out.println("Bottom view of the given binary tree:");
		tree1.BottomView(tree1.root);
	}

}
