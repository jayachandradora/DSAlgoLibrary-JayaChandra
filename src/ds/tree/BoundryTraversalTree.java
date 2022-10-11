package ds.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundryTraversalTree {

	public static void main(String[] args) {

		TreeNode root = null;
		root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(12);
		//root.left.right.left = new TreeNode(10);
		//root.left.right.right = new TreeNode(14);
		root.right = new TreeNode(22);
		//root.right.right = new TreeNode(25);
		printBoundary(root);
		System.out.println(postorderTraversal(root));
	}

	
	public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        if(root == null)
            return res;
        
        st.add(root);
        
        while(!st.isEmpty()){
            TreeNode node = st.peek();
            
            while(node.left != null){
                st.add(node.left);
                node = node.left;
            }
            
            if(st.isEmpty())
                break;
            
            TreeNode temp = st.peek();
            if(temp.right != null)
                st.add(temp.right);
            else {
                res.add(st.pop().val);
                
            }
        }
        return res;
    }
	public static void printBoundary(TreeNode root) {
		if (root == null)
			return;
		System.out.println(root.val);
		printLeftBoundry(root.left);
		printLeafNode(root.left);
		System.out.println();
		printLeafNode(root.right);
		printRightBoundry(root.right);

	}

	public static void printLeftBoundry(TreeNode root) {

		if (root == null)
			return;

		if (root.left != null) {
			System.out.print(root.val + " ");
			printLeftBoundry(root.left);
		} else if (root.right != null) {
			System.out.print(root.val + " ");
			printLeftBoundry(root.right);
		}
	}

	public static void printRightBoundry(TreeNode root) {
		if (root == null)
			return;

		if (root.right != null) {
			System.out.print(root.val + " ");
			printRightBoundry(root.right);
		} else if (root.left != null) {
			System.out.print(root.val + " ");
			printRightBoundry(root.left);
		}
	}

	public static void printLeafNode(TreeNode root) {

		if (root == null)
			return;

		printLeafNode(root.left);

		if (root.left == null && root.right == null)
			System.out.print(root.val + " ");

		printLeafNode(root.right);

	}
}
