package ds.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSum {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> tList = new ArrayList<>();
		List<Integer> sList = new ArrayList<>();
		hasPathSum(root, sum, tList, sList);
		return tList;
	}

	public void hasPathSum(TreeNode root, int sum, List<List<Integer>> tList, List<Integer> sList) {

		if (root != null) {
			sList.add(root.val);

			if (root.left == null && root.right == null && root.val == sum) {
				tList.add(sList);
			}
			hasPathSum(root.left, sum - root.val, tList, new ArrayList(sList));
			hasPathSum(root.right, sum - root.val, tList, new ArrayList(sList));
		}
	}
	
	static boolean hasPathSum(TreeNode node, int sum){ 
        if (node == null) 
            return sum == 0; 
        
        return hasPathSum(node.left, sum - node.val) 
        		|| hasPathSum(node.right, sum - node.val); 
    } 

	
	//Tushar
	public boolean printPath(TreeNode root, int sum, List<TreeNode> path){
        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null){
            if(root.val == sum){
                path.add(root);
                return true;
            }else{
                return false;
            }
        }
        if(printPath(root.left, sum-root.val, path) || printPath(root.right, sum - root.val, path)){
            path.add(root);
            return true;
        }
        return false;
    }

	
  /* 5
    / \
   4   8
  /   / \
 11  13  4
/  \      \
7    2      1 */
	
	
	static boolean hasPathSumIterative(TreeNode root, int sum) {
		
		Stack<TreeNode> visitedNode = new Stack<>();
		TreeNode prev = null;

		while(root!=null || !visitedNode.isEmpty()) {
			while(root != null) {
				sum -=root.val;
				prev = root;
				visitedNode.push(root);
				root = root.left;
			}
			
			root = visitedNode.peek();
			if(root.left == null && root.right ==  null && sum ==0)
				return true;
			
			if(root.right != null && prev != root.right)
				root = root.right;
			else {
				sum += root.val;
				prev = visitedNode.pop();
				root = null;
			}
		}
		return false;
	}


	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
	//	root.left.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		
		PathSum ps = new PathSum();
		List<List<Integer>> list = ps.pathSum(root, 22);
		for(List lst : list)
				System.out.println(lst);
		
		System.out.println("hasPathSum  " + hasPathSum(root, 22));
		
		System.out.println("Iterative version " + hasPathSumIterative(root, 22));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}