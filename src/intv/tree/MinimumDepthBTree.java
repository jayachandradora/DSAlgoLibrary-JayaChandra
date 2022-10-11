package intv.tree;

import intv.Node;

public class MinimumDepthBTree {

	Node root;
	public static void main(String[] args) {
		MinimumDepthBTree tree = new MinimumDepthBTree();
		tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        
        System.out.println("minDepth " + minDepth(tree.root));
        System.out.println("maxDepth " + maxDepth(tree.root));

	}
	
	static int minDepth(Node root) {
		if (root == null)
			return 0;

		int maxDepth = Math.min(minDepth(root.left), maxDepth(root.right)) + 1;
		return maxDepth;
	}
	
	static int maxDepth(Node root) {
		if (root == null)
			return 0;

		int maxDepth = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
		return maxDepth;
	}

}
