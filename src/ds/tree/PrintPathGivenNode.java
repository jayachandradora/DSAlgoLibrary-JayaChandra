package ds.tree;

import java.util.ArrayList;
import java.util.List;

public class PrintPathGivenNode {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		List<Integer> lst = new ArrayList<Integer>();
		System.out.println("Path Exist " + hasPath(root,4, lst));
		System.out.println(lst);

	}

	static boolean hasPath(TreeNode root, int nodeVal, List<Integer> list){
		
		if(root == null)
			return false;
		
		list.add(root.val);
		
		if(root.val == nodeVal)
			return true;
		
		
		if( hasPath(root.left, nodeVal, list) || hasPath(root.right, nodeVal, list))
			return true;
		
       list.remove(list.size()-1);  

		return false;
		
	}
}
