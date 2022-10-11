package ds.tree;

import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeLevelCount {

	// Root of the Binary Tree
	LevelNode root;

	public BinaryTreeLevelCount() {
		root = null;
	}

	public static void main(String args[]) {
		BinaryTreeLevelCount tree = new BinaryTreeLevelCount();
		tree.root = new LevelNode(1);
		tree.root.left = new LevelNode(2);
		tree.root.right = new LevelNode(3);
		tree.root.left.left = new LevelNode(4);
		tree.root.left.right = new LevelNode(5);

		System.out.println("Level order traversal of binary tree is ");
		tree.printLevelOrder();
	}

	void printLevelOrder() {
		Queue<LevelNode> queue = new LinkedList<LevelNode>();
		queue.add(root);
		while (!queue.isEmpty()) {

			LevelNode tempNode = queue.poll();
			System.out.print(tempNode.data + " ");

			/* Enqueue left child */
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}

			/* Enqueue right child */
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}

}

class LevelNode {
	int data;
	LevelNode left, right;

	public LevelNode(int item) {
		data = item;
		left = right = null;
	}
}