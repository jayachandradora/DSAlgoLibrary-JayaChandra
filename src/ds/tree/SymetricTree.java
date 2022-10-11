package ds.tree;

public class SymetricTree {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(2);
		//node.right.left = new TreeNode(2);

		System.out.println(isSymetric(node));
		
	}
	
	static boolean isSymetric(TreeNode root) {
		if(root == null)
			return true;
		
		return isMirror(root.left, root.right);
	}
	
	static boolean isMirror(TreeNode node1, TreeNode node2) {
		if(node1 == null && node2 == null)
			return true;
		
		if(node1 == null || node2 == null|| node1.val != node2.val)
			return false;
		
		return isMirror(node1.right, node2.left) && isMirror(node1.left, node2.right);
		
	}
	

}
