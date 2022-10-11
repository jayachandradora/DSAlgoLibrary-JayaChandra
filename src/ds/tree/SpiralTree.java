package ds.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SpiralTree {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);

		node.left.left.left = new TreeNode(8);
		node.left.left.right = new TreeNode(9);
		// node.left.left.left.right = new TreeNode(10);
		printSpiralTreeStack(node);

	}

	static void printSpiralTreeStack(TreeNode root) {

		Stack<TreeNode> st1 = new Stack<>();
		Stack<TreeNode> st2 = new Stack<>();
		boolean flag = true;
		st1.push(root);
		while (!st1.isEmpty() || !st2.isEmpty()) {
			if (flag) {
				while (!st1.isEmpty()) {
					TreeNode temp1 = null;
					temp1 = st1.pop();
					System.out.print(temp1.val + " ");
					if (temp1.left != null)
						st2.push(temp1.left);

					if (temp1.right != null)
						st2.push(temp1.right);
				}
				if (flag == true)
					flag = false;
			} else {
				while (!st2.isEmpty()) {
					TreeNode temp = null;
					temp = st2.pop();
					System.out.print(temp.val + " ");

					if (temp.right != null)
						st1.push(temp.right);

					if (temp.left != null)
						st1.push(temp.left);
				}

				if (flag == false)
					flag = true;
			}
			System.out.println();
		}
	}

	static void printSpiralTreeQueue(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		List<Integer> lst = new ArrayList<>();
		int level = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			level += 1;

			for (int i = 0; i < size; i++) {
				TreeNode temp = queue.remove();

				if (level % 2 == 0) {
					lst.add(temp.val);
				} else {
					System.out.print(temp.val + " ");
				}
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
			if (level % 2 == 0) {
				Collections.reverse(lst);

				for (Integer in : lst)
					System.out.print(in + " ");
			}
			lst.clear();
		}
	}

	static void printLevelTreeQueue(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode temp = queue.remove();
				System.out.print(temp.val + " ");

				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);

			}
		}
	}

	static int depth(TreeNode root) {
		int level = 0;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			level += 1;
			for (int i = 0; i < size; i++) {
				TreeNode temp = queue.remove();
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
		}
		return level;
	}

}
