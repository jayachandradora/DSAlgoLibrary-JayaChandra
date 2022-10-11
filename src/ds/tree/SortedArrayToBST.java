package ds.tree;

public class SortedArrayToBST {

	public static void main(String[] args) {

		int arr[] = {1,2,3,4,5,6};
		
		preOrderTraversal(convertBST(arr, 0, arr.length-1));
	}
	
	
	static void preOrderTraversal(TreeNode root) {
		if(root == null)
			return;
		
		System.out.print(root.val + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
	static TreeNode convertBST(int arr[], int start, int end) {
		
		if(start > end)
			return null;
		
		int mid =  (start + end)/2;
		
		TreeNode root = new TreeNode(arr[mid]);
		
		root.left= convertBST(arr, start, mid-1);
		root.right = convertBST(arr, mid +1, end);
		
		return root;
	}

}
