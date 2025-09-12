# DynamicAbsolutely! Mastering **Dynamic Programming (DP)** is critical for cracking **FAANG interviews**, as it's one of the most tested topics.

---

## 🧠 Dynamic Programming (DP) — Core Patterns

### What You Get:

* ✅ The **10 must-know DP patterns**
* 💡 A **Java solution** for each
* 📅 A **7-day FAANG-style study plan**
* 🎯 Focus on **intuition > memorization**

---

## 🔟 Must-Know Dynamic Programming Patterns

| #  | Pattern                       | Description                              |
| -- | ----------------------------- | ---------------------------------------- |
| 1  | **0/1 Knapsack**              | Choose or skip an item (binary choice)   |
| 2  | **Unbounded Knapsack**        | Use an item **multiple times**           |
| 3  | **Subset Sum / Target Sum**   | Can we reach a sum from given elements?  |
| 4  | **DP on Subsequences**        | Compare or build subsequences (LCS, LIS) |
| 5  | **DP on Strings**             | Edit distance, palindrome, segmentation  |
| 6  | **DP on Grids**               | Unique paths, min path sum               |
| 7  | **DP on Trees**               | Use post-order to compute subtree DP     |
| 8  | **DP with Bitmasking**        | Keep state using bits (e.g., TSP)        |
| 9  | **DP with Sliding Window**    | Use window to optimize space/time        |
| 10 | **DP with State Compression** | Reduce space using optimal substructure  |

---

## ✅ Each Pattern with One Java Solution

---

### 1️⃣ **0/1 Knapsack**

**📌 Problem:** [416. Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/)

```java
public boolean canPartition(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    if (sum % 2 != 0) return false;
    int target = sum / 2;
    boolean[] dp = new boolean[target + 1];
    dp[0] = true;

    for (int num : nums) {
        for (int j = target; j >= num; j--) {
            dp[j] = dp[j] || dp[j - num];
        }
    }
    return dp[target];
}
```
---

### 2️⃣ **Unbounded Knapsack**

**📌 Problem:** [518. Coin Change II](https://leetcode.com/problems/coin-change-ii/)

```java
public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int coin : coins) {
        for (int j = coin; j <= amount; j++) {
            dp[j] += dp[j - coin];
        }
    }
    return dp[amount];
}
```

---

### 3️⃣ **Subset Sum / Target Sum**

**📌 Problem:** [494. Target Sum](https://leetcode.com/problems/target-sum/)

```java
public int findTargetSumWays(int[] nums, int S) {
    int sum = Arrays.stream(nums).sum();
    if (S > sum || (S + sum) % 2 != 0) return 0;
    int target = (S + sum) / 2;
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int num : nums) {
        for (int i = target; i >= num; i--) {
            dp[i] += dp[i - num];
        }
    }
    return dp[target];
}
```

---

### 4️⃣ **DP on Subsequences**

**📌 Problem:** [1143. Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/)

```java
public int longestCommonSubsequence(String text1, String text2) {
    int[][] dp = new int[text1.length()+1][text2.length()+1];
    for (int i = 1; i <= text1.length(); i++) {
        for (int j = 1; j <= text2.length(); j++) {
            if (text1.charAt(i-1) == text2.charAt(j-1))
                dp[i][j] = dp[i-1][j-1] + 1;
            else
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
    }
    return dp[text1.length()][text2.length()];
}
```

---

### 5️⃣ **DP on Strings**

**📌 Problem:** [72. Edit Distance](https://leetcode.com/problems/edit-distance/)

```java
public int minDistance(String word1, String word2) {
    int[][] dp = new int[word1.length()+1][word2.length()+1];
    for (int i = 0; i <= word1.length(); i++)
        for (int j = 0; j <= word2.length(); j++) {
            if (i == 0) dp[i][j] = j;
            else if (j == 0) dp[i][j] = i;
            else if (word1.charAt(i-1) == word2.charAt(j-1))
                dp[i][j] = dp[i-1][j-1];
            else
                dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
        }
    return dp[word1.length()][word2.length()];
}
```

---

### 6️⃣ **DP on Grids**

**📌 Problem:** [64. Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)

```java
public int minPathSum(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    for (int i = 1; i < m; i++) grid[i][0] += grid[i-1][0];
    for (int j = 1; j < n; j++) grid[0][j] += grid[0][j-1];

    for (int i = 1; i < m; i++)
        for (int j = 1; j < n; j++)
            grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);

    return grid[m-1][n-1];
}
```

---

### 7️⃣ **DP on Trees**

**📌 Problem:** [337. House Robber III](https://leetcode.com/problems/house-robber-iii/)

```java
public int rob(TreeNode root) {
    int[] res = robHelper(root);
    return Math.max(res[0], res[1]);
}

private int[] robHelper(TreeNode node) {
    if (node == null) return new int[2];

    int[] left = robHelper(node.left);
    int[] right = robHelper(node.right);

    int rob = node.val + left[1] + right[1];
    int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

    return new int[]{rob, notRob};
}
```

---

### 8️⃣ **DP with Bitmasking**

**📌 Problem:** [698. Partition to K Equal Sum Subsets](https://leetcode.com/problems/partition-to-k-equal-sum-subsets/)

(Hard — bitmask + memo)

---

### 9️⃣ **DP with Sliding Window**

**📌 Problem:** [198. House Robber](https://leetcode.com/problems/house-robber/)

```java
public int rob(int[] nums) {
    int prev1 = 0, prev2 = 0;
    for (int num : nums) {
        int temp = prev1;
        prev1 = Math.max(prev2 + num, prev1);
        prev2 = temp;
    }
    return prev1;
}
```

---

### 🔟 **State Compression**

**📌 Problem:** [70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)

```java
public int climbStairs(int n) {
    int a = 1, b = 1;
    for (int i = 2; i <= n; i++) {
        int temp = a + b;
        a = b;
        b = temp;
    }
    return b;
}
```

---

## 🗓️ 7-Day FAANG DP Study Plan (FAST MODE)

| Day   | Focus           | Pattern                                  | Problems                   |
| ----- | --------------- | ---------------------------------------- | -------------------------- |
| Day 1 | Foundation      | 1D/2D DP, Climbing Stairs, Grid Paths    | 70, 198, 64, 62            |
| Day 2 | Knapsack        | 0/1 + Unbounded + Subset Sum             | 416, 518, 494              |
| Day 3 | Strings         | LCS, Edit Distance, Palindrome Partition | 1143, 72, 131              |
| Day 4 | Subsequences    | LIS, Count of subsequences               | 300, 1035, 115             |
| Day 5 | Trees & Bitmask | House Robber III, Partition Subsets      | 337, 698                   |
| Day 6 | Mixed Practice  | Review + custom set                      | Pick 5 problems from above |
| Day 7 | Mock Day        | 2 Medium + 1 Hard (Timed)                | Mix & Reattempt            |

---
