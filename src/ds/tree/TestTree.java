package ds.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TestTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			List<List<Integer>> list = new ArrayList<>();
			List<Integer> innerList = new ArrayList<>();
			
			Boolean odd = true;
	        if(root == null)
				return list;
			
			q.add(root);
			while(!q.isEmpty()){
				for(int i=0;i<q.size(); i++)
					innerList.add(0, q.poll().val);
				
				if(!odd)
					Collections.reverse(innerList);
					
				list.add(innerList);
				odd = !odd;
				
				if(root.left != null)
					q.add(root.left);
					
				if(root.right != null)
					q.add(root.right);
			
			}
			
			return list;
	    }
}
