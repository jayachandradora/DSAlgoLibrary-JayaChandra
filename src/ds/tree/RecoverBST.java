package ds.tree;

public class RecoverBST {

	TreeNode first;
	TreeNode second;
	TreeNode pre;

	public void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		if (pre == null) {
			pre = root;
		} else {
			if (root.val < pre.val) {
				if (first == null) {
					first = pre;
				}
				second = root;
			}
			pre = root;
		}
		inorder(root.right);
	}

	public void recoverTree(TreeNode root) {
		if (root == null)
			return;
		inorder(root);

		if (second != null && first != null) {
			int val = second.val;
			second.val = first.val;
			first.val = val;
		}
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.right = new TreeNode(1);
		root.left.right = new TreeNode(2);
		
		
		RecoverBST rb = new RecoverBST();
		rb.recoverTree(root);
		rb.printInroderTraversal(root);
		
		
	}
	
	void printInroderTraversal(TreeNode root) {
		
		if(root == null)
			return;
		
		printInroderTraversal(root.left);
		System.out.println(root.val);
		printInroderTraversal(root.right);
		
	}

}
