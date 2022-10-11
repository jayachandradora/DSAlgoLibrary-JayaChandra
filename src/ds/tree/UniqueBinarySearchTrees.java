package ds.tree;

public class UniqueBinarySearchTrees {

	public static void main(String[] args) {

		System.out.println(numTrees(3));
	}

	static int numTrees(int n) {

		// base case
		if (n == 0)
			return 0;

		// dp(i) represents the no. of unique BSTs till i
		// dp(0) = 1, means there's a null node
		int[] dp = new int[n + 1];
		dp[0] = 1;

		for (int i = 1; i <= n; i++)
			// use j as root
			for (int j = 1; j <= i; j++)
				dp[i] += dp[j - 1] * dp[i - j];

		return dp[n];
	}
}
/*  catalan_Number
96. Unique Binary Search Trees(BST)
Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

*/