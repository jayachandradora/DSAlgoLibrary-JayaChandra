package ds.tree;

public class PathTargetSum {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);

	//	System.out.println(maxPathSum(root));
		
		
		TreeNode root1 = new TreeNode(5);
		root1.left = new TreeNode(4);
		root1.right = new TreeNode(8);
		
		System.out.println(hasPathSum(root1, 13));
	}
	
  /* 5
    / \
   4   8
  /   / \
 11  13  4
/  \      \
7    2      1 */
	
	
	static boolean hasPathSum(TreeNode node, int sum){ 
        if (node == null) 
            return sum == 0; 
        
        return hasPathSum(node.left, sum - node.val) 
        		|| hasPathSum(node.right, sum - node.val); 
    }

	static int max = Integer.MIN_VALUE;

	static int maxPathSum(TreeNode root) {
		maxPathSumR(root);
		return max;
	}

	static int maxPathSumR(TreeNode root) {

		if (root == null)
			return 0;

		int left = maxPathSumR(root.left);
		int right = maxPathSumR(root.right);

		int temp = Math.max(root.val, Math.max(root.val + left, root.val + right));
		max = Math.max(temp, Math.max(temp, left + right + root.val));
		return temp;
	}

}
