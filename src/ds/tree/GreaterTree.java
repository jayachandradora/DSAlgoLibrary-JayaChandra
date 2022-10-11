package ds.tree;

import java.util.Stack;

/*5
/   \
2     13  
		     18
            /   \
          20     13 */
public class GreaterTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(13);
		convertBST(root);
		preTraversal(root);
		
	}
	
	static void preTraversal(TreeNode root) {
		if(root == null)
			return;
		System.out.println(root.val + " ");
		preTraversal(root.left);
		preTraversal(root.right);
	}
	static TreeNode convertBST(TreeNode root) {
		int val = 0;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();        
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }            
            cur = stack.pop();
            cur.val += val;
            val = cur.val;
            cur = cur.left;            
        }
        return root;
    }

}
