package ds.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MaxDepth {

	public static void main(String[] args) {
		TreeNode2 r1 = new TreeNode2(2);
		r1.left = new TreeNode2(3);
		r1.right = new TreeNode2(4);
		r1.left.left = new TreeNode2(5);

		TreeNode2 r2 = new TreeNode2(10);
		r2.left = new TreeNode2(11);
		r2.right = new TreeNode2(12);
		r2.right.left = new TreeNode2(13);
		r2.right.right = new TreeNode2(14);

		TreeNode2 r3 = new TreeNode2(2);
		r3.left = new TreeNode2(3);
		r3.right = new TreeNode2(4);
		r3.left.left = new TreeNode2(5);
		r3.left.right = new TreeNode2(6);
		r3.right.left = new TreeNode2(7);
		r3.right.right = new TreeNode2(8);

		System.out.println("diameterOfBinaryTree " + diameterOfBinaryTree(r1));
		
		int num[] = {4,3,2,7,8,2,3,1};
		for(Integer in : findDisappearedNumbers(num))
		System.out.println(in);

		System.out.println("Invert treee");
		printTree(invertTree(r3));

		System.out.println("depth  " +maxDepth(r2));
		printTree(merge(r1, r2));

		int arr[] = { 4, 1, 2, 1, 2, 4, 4, 3, 2 };
		System.out.println(singleNumber(arr));

		int nums[] = {2,2,1,1,1,2,2,2,4,4,4,4 };
		System.out.println("majorityElement "  + majorityElement(nums));
		
		TreeNode2 l1 = new TreeNode2(2);
		l1.left = new TreeNode2(3);
		l1.right = new TreeNode2(4);
		
		TreeNode2 l2 = new TreeNode2(1);
		l2.left = new TreeNode2(3);
		l2.right = new TreeNode2(4);
		
		System.out.println("isSameTree " +isSameTree(null, null));
	}
	
    public static List<Integer> findDisappearedNumbers(int[] nums) {
    	Long startTime = System.currentTimeMillis();
    	
        // Set<Integer> set = new HashSet(Arrays.asList(nums));

        Set<Integer> set = new HashSet<>();
        for (int i=1;i<=nums.length;i++)set.add(i);
        for (int i=0;i<nums.length;i++)set.remove(nums[i]);
         
        List<Integer> list = new ArrayList<Integer>();//set.stream().collect(Collectors.toList());
        for(Integer in : set)
        	list.add(in);
        
        Long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println("Time Taken : " + timeTaken);
        return list;
    }


	public static int majorityElement(int[] nums) {
		int count = 0, ret = 0;
		for (int num : nums) {
			if (count == 0)
				ret = num;
			if (num != ret)
				count--;
			else
				count++;
		}
		return ret;
	}

	static void printTree(TreeNode2 root) {

		if (root == null)
			return;

		System.out.print(root.val + " ");
		printTree(root.left);
		printTree(root.right);
	}

	static TreeNode2 merge(TreeNode2 r1, TreeNode2 r2) {
		if (r1 == null)
			return r2;
		if (r2 == null)
			return r1;
		r1.val = r1.val + r2.val;
		r1.left = merge(r1.left, r2.left);
		r1.right = merge(r1.right, r2.right);
		return r1;
	}

	static int maxDepth(TreeNode2 root) {
		if (root == null)
			return 0;

		int maxDepth = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
		return maxDepth;
	}

	static TreeNode2 invertTree(TreeNode2 root) {
		if (root == null)
			return null;

		TreeNode2 temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		invertTree(root.left);
		invertTree(root.right);

		return root;
	}

	static int singleNumber(int arr[]) {
		Set<Integer> set = new HashSet<Integer>();

		for (int a : arr) {
			if (set.contains(a))
				set.remove(a);
			else
				set.add(a);
		}
		return set.iterator().next();
	}

	public int singleNumber1(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, 2);
			} else
				map.put(num, 1);
		}
		for (Integer key : map.keySet()) {
			if (map.get(key) == 1) {
				return key;
			}
		}
		return 0;
	}

	public static int diameterOfBinaryTree(TreeNode2 node) {

		if (node == null)
			return 0;

		int left = diameterOfBinaryTree(node.left);
		int right = diameterOfBinaryTree(node.right);

		int diameter = 0;
		diameter = Math.max(diameter, left + right);
		return Math.max(left, right) + 1;
	}
	
	static boolean isSameTree(TreeNode2 l1, TreeNode2 l2) {
		if(l1 == null && l2 == null)
			return true;
		
		if(l1.val != l2.val)
			return false;
		
		return isSameTree(l1.left, l2.left) || isSameTree(l1.right, l2.right);
		
	}
}

class TreeNode2 {
	int val;
	TreeNode2 left;
	TreeNode2 right;

	TreeNode2(int x) {
		val = x;
	}
}