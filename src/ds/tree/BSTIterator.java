package ds.tree;

import java.util.Stack;

public class BSTIterator {

	private Stack<TreeNode> stack;
	public BSTIterator(TreeNode root) {
	    stack = new Stack<>();
	    pushLeft(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
	    return !stack.isEmpty() ;
	}

	private void pushLeft(TreeNode node) {
	    while (node != null) {
	        stack.push(node);
	        node = node.left;
	    }
	}
	/** @return the next smallest number */
	public int next() {
	    TreeNode node = stack.pop();
	    pushLeft(node.right);
	    return node.val;
	}
	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		
		BSTIterator iterator = new BSTIterator(root);
		System.out.println(iterator.next());    // return 3
		System.out.println(iterator.next());    // return 7
		System.out.println(iterator.hasNext()); // return true
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.hasNext()); // return true

	}

}
