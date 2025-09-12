# Backtracking Problems and patterns and study plan and share each pattern with one solutions

Perfect — **Backtracking** is another essential FAANG topic that comes up often in coding interviews, especially for **recursive, combinatorial, and constraint-based problems**.

---

## 🧠 Backtracking — Complete Guide for FAANG

### What You Get:

* ✅ **7 must-know backtracking patterns**
* 🔧 One Java **solution per pattern**
* 📅 **7-Day FAANG-style study plan**
* 🎯 Focus on problem **recognition + pruning**

---

## 🔁 7 Core Backtracking Patterns

| # | Pattern                             | Description                          |
| - | ----------------------------------- | ------------------------------------ |
| 1 | **Permutations**                    | All arrangements of elements         |
| 2 | **Combinations**                    | Select subsets of size `k`           |
| 3 | **Subsets (Power Set)**             | All subsets                          |
| 4 | **Palindrome Partitioning**         | Partition string into palindromes    |
| 5 | **N-Queens / Sudoku**               | Constrained board configurations     |
| 6 | **Word Search / Matrix DFS**        | Search in 2D grid with backtracking  |
| 7 | **Combinatorial Sum / Coin Change** | Target sum using recursion + choices |

---

## ✅ 7 Patterns with Java Solutions

---

### 1️⃣ Permutations

**📌 Problem:** [46. Permutations](https://leetcode.com/problems/permutations/)

```java
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    backtrack(res, new ArrayList<>(), nums);
    return res;
}

private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums) {
    if (temp.size() == nums.length) {
        res.add(new ArrayList<>(temp));
        return;
    }
    for (int num : nums) {
        if (temp.contains(num)) continue;
        temp.add(num);
        backtrack(res, temp, nums);
        temp.remove(temp.size() - 1);
    }
}
```

---

### 2️⃣ Combinations

**📌 Problem:** [77. Combinations](https://leetcode.com/problems/combinations/)

```java
public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> res = new ArrayList<>();
    backtrack(1, n, k, new ArrayList<>(), res);
    return res;
}

private void backtrack(int start, int n, int k, List<Integer> curr, List<List<Integer>> res) {
    if (curr.size() == k) {
        res.add(new ArrayList<>(curr));
        return;
    }
    for (int i = start; i <= n; i++) {
        curr.add(i);
        backtrack(i + 1, n, k, curr, res);
        curr.remove(curr.size() - 1);
    }
}
```

---

### 3️⃣ Subsets (Power Set)

**📌 Problem:** [78. Subsets](https://leetcode.com/problems/subsets/)

```java
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    backtrack(0, nums, new ArrayList<>(), res);
    return res;
}

private void backtrack(int index, int[] nums, List<Integer> path, List<List<Integer>> res) {
    res.add(new ArrayList<>(path));
    for (int i = index; i < nums.length; i++) {
        path.add(nums[i]);
        backtrack(i + 1, nums, path, res);
        path.remove(path.size() - 1);
    }
}
```

---

### 4️⃣ Palindrome Partitioning

**📌 Problem:** [131. Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/)

```java
public List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<>();
    backtrack(0, s, new ArrayList<>(), res);
    return res;
}

private void backtrack(int start, String s, List<String> path, List<List<String>> res) {
    if (start == s.length()) {
        res.add(new ArrayList<>(path));
        return;
    }
    for (int end = start + 1; end <= s.length(); end++) {
        String prefix = s.substring(start, end);
        if (isPalindrome(prefix)) {
            path.add(prefix);
            backtrack(end, s, path, res);
            path.remove(path.size() - 1);
        }
    }
}

private boolean isPalindrome(String str) {
    int l = 0, r = str.length() - 1;
    while (l < r) {
        if (str.charAt(l++) != str.charAt(r--)) return false;
    }
    return true;
}
```

---

### 5️⃣ N-Queens (Board Configurations)

**📌 Problem:** [51. N-Queens](https://leetcode.com/problems/n-queens/)

```java
public List<List<String>> solveNQueens(int n) {
    List<List<String>> res = new ArrayList<>();
    char[][] board = new char[n][n];
    for (char[] row : board) Arrays.fill(row, '.');
    backtrack(0, board, res);
    return res;
}

private void backtrack(int row, char[][] board, List<List<String>> res) {
    if (row == board.length) {
        List<String> config = new ArrayList<>();
        for (char[] line : board) config.add(new String(line));
        res.add(config);
        return;
    }
    for (int col = 0; col < board.length; col++) {
        if (isValid(board, row, col)) {
            board[row][col] = 'Q';
            backtrack(row + 1, board, res);
            board[row][col] = '.';
        }
    }
}

private boolean isValid(char[][] board, int row, int col) {
    for (int i = 0; i < row; i++)
        if (board[i][col] == 'Q') return false;

    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
        if (board[i][j] == 'Q') return false;

    for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
        if (board[i][j] == 'Q') return false;

    return true;
}
```

---

### 6️⃣ Word Search in Matrix

**📌 Problem:** [79. Word Search](https://leetcode.com/problems/word-search/)

```java
public boolean exist(char[][] board, String word) {
    for (int i = 0; i < board.length; i++)
        for (int j = 0; j < board[0].length; j++)
            if (dfs(board, word, i, j, 0)) return true;
    return false;
}

private boolean dfs(char[][] board, String word, int i, int j, int idx) {
    if (idx == word.length()) return true;
    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(idx))
        return false;

    char temp = board[i][j];
    board[i][j] = '#'; // mark visited
    boolean found = dfs(board, word, i+1, j, idx+1) ||
                    dfs(board, word, i-1, j, idx+1) ||
                    dfs(board, word, i, j+1, idx+1) ||
                    dfs(board, word, i, j-1, idx+1);
    board[i][j] = temp; // backtrack
    return found;
}
```

---

### 7️⃣ Combination Sum

**📌 Problem:** [39. Combination Sum](https://leetcode.com/problems/combination-sum/)

```java
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    backtrack(0, candidates, target, new ArrayList<>(), res);
    return res;
}

private void backtrack(int start, int[] candidates, int target, List<Integer> path, List<List<Integer>> res) {
    if (target == 0) {
        res.add(new ArrayList<>(path));
        return;
    }

    for (int i = start; i < candidates.length; i++) {
        if (candidates[i] > target) continue;
        path.add(candidates[i]);
        backtrack(i, candidates, target - candidates[i], path, res); // i not i+1 (reuse allowed)
        path.remove(path.size() - 1);
    }
}
```

---

## 🗓️ 7-Day FAANG Backtracking Study Plan (FAST MODE)

| Day   | Focus         | Patterns                           | Problems |
| ----- | ------------- | ---------------------------------- | -------- |
| Day 1 | Basics        | Subsets, Combinations              | 78, 77   |
| Day 2 | Permutations  | All arrangements                   | 46, 47   |
| Day 3 | Target Sum    | Combination Sum                    | 39, 40   |
| Day 4 | Strings       | Palindrome partition, phone digits | 131, 17  |
| Day 5 | Board         | N-Queens, Sudoku Solver            | 51, 37   |
| Day 6 | 2D Grid       | Word Search                        | 79, 212  |
| Day 7 | Mock + Review | 3 problems, mixed types            | Pick     |


1 easy, 1 med, 1 hard |

---

## 🧠 Tips to Master Backtracking

1. **Base case first**, always.
2. Use **`List.remove(size - 1)`** to backtrack.
3. Use **pruning**: skip unfit branches early.
4. Understand **input/output/state** separation.
5. **Visualize recursion tree** (dry-run small examples).

---

# **combo plan for DP + Backtracking + Graphs**

Awesome! Here's a **focused combo study plan** for mastering **Dynamic Programming, Backtracking, and Graphs** — the **top 3 topics** tested in **FAANG technical interviews**.

---

## 🚀 FAANG Combo Study Plan: DP + Backtracking + Graphs

### 📅 Duration: **21 Days**

* **Time/day**: 1.5–2.5 hours
* Includes **core patterns**, **Leetcode problems**, and **mock days**
* Ideal for: **Interview prep**, **revisions**, or **second-pass mastery**

---

### 🧠 Covered Topics

| Area                    | Core Patterns (What you'll master)                                    |
| ----------------------- | --------------------------------------------------------------------- |
| **Dynamic Programming** | Knapsack, subsequences, DP on strings/grids, state compression, trees |
| **Backtracking**        | Permutations, combinations, subsets, partitioning, board constraints  |
| **Graphs**              | BFS, DFS, Dijkstra, Union-Find, Topological Sort, MST                 |

---

## 📚 3-Week Study Plan (DP + Backtracking + Graphs)

| Day                   | Topic              | Focus                         | Key Problems |
| --------------------- | ------------------ | ----------------------------- | ------------ |
| **WEEK 1 — DP Focus** |                    |                               |              |
| Day 1                 | DP Intro           | Climbing Stairs, Min Path Sum | 70, 64       |
| Day 2                 | 0/1 Knapsack       | Partition Equal Subset Sum    | 416, 494     |
| Day 3                 | Unbounded Knapsack | Coin Change I & II            | 322, 518     |
| Day 4                 | DP on Strings      | LCS, Edit Distance            | 1143, 72     |
| Day 5                 | DP on Subsequences | LIS, Count Subsequences       | 300, 115     |
| Day 6                 | DP on Trees/State  | House Robber III, Tiling      | 337, 790     |
| Day 7                 | **Mock + Review**  | Any 3 (mix types)             | Custom set   |

---

| Day                             | Topic                   | Focus                          | Key Problems |
| ------------------------------- | ----------------------- | ------------------------------ | ------------ |
| **WEEK 2 — Backtracking Focus** |                         |                                |              |
| Day 8                           | Subsets + Combinations  | Subsets I, II, Combinations    | 78, 90, 77   |
| Day 9                           | Permutations            | All perms, Unique perms        | 46, 47       |
| Day 10                          | Target Sum + Comb Sum   | Combination Sum I & II         | 39, 40       |
| Day 11                          | Palindrome Partitioning | Partition + Validate           | 131          |
| Day 12                          | N-Queens                | Constraints, Recursive pruning | 51, 52       |
| Day 13                          | Word Search + Matrix    | DFS + backtracking             | 79, 212      |
| Day 14                          | **Mock + Review**       | 2 Med + 1 Hard                 | Custom set   |

---

| Day                       | Topic                      | Focus                             | Key Problems  |
| ------------------------- | -------------------------- | --------------------------------- | ------------- |
| **WEEK 3 — Graphs Focus** |                            |                                   |               |
| Day 15                    | Graph Representation + DFS | Clone Graph, Island Problems      | 133, 200, 695 |
| Day 16                    | BFS + Shortest Path        | 0/1 Matrix, Oranges               | 542, 994      |
| Day 17                    | Topological Sort + Cycle   | Course Schedule I & II            | 207, 210      |
| Day 18                    | Union-Find                 | Provinces, Redundant Conn.        | 547, 684      |
| Day 19                    | Dijkstra + Weighted Graphs | Network Delay, Path Effort        | 743, 1631     |
| Day 20                    | MST + Bipartite            | Min Cost Connect, Graph Bipartite | 1584, 785     |
| Day 21                    | **Mock + Final Review**    | 1 hard from each topic            | 3-problem set |

---

## 🔧 Resources You’ll Use

* **Leetcode**: Main platform (\[Lists provided on request])
* **Visualgo.net**: Visualize graph/DP
* **NeetCode / Tech Interview Handbook**: Quick refreshers
* **Notebook or Notion**: To track patterns and edge cases

---

## 📝 Tracking Sheet Includes

I can generate a **custom Notion template or PDF tracker** that includes:

* ✅ 50+ problem checklist
* 📌 Pattern tags
* ❗ “Missed edge case?” tracker
* ⏱️ Timer log for real-time practice

---

## 🧪 Mock Interview Plan (Optional)

If you want, I can:

* Give **2 full mock interviews**
* Score and give feedback on your code + communication
* Help pick blindspots or weakest patterns

---

## ⚡ Want Fast Mode?

I can also generate a **10-Day Crash Plan** that covers:

* Only the **most important 5 patterns**
* FAANG-level **top 20 questions**
---

## 🎯 FAANG-Level Top 20 Questions: DP + Backtracking + Graphs

| #  | Topic        | Problem                                                                                                            | Pattern                    |
| -- | ------------ | ------------------------------------------------------------------------------------------------------------------ | -------------------------- |
| 1  | DP           | [**322. Coin Change**](https://leetcode.com/problems/coin-change/)                                                 | Unbounded Knapsack         |
| 2  | DP           | [**1143. Longest Common Subsequence**](https://leetcode.com/problems/longest-common-subsequence/)                  | DP on Strings              |
| 3  | DP           | [**198. House Robber**](https://leetcode.com/problems/house-robber/)                                               | State Compression          |
| 4  | DP           | [**72. Edit Distance**](https://leetcode.com/problems/edit-distance/)                                              | DP on Strings              |
| 5  | DP           | [**494. Target Sum**](https://leetcode.com/problems/target-sum/)                                                   | Subset Sum                 |
| 6  | DP           | [**64. Minimum Path Sum**](https://leetcode.com/problems/minimum-path-sum/)                                        | DP on Grids                |
| 7  | Backtracking | [**46. Permutations**](https://leetcode.com/problems/permutations/)                                                | Basic Backtracking         |
| 8  | Backtracking | [**39. Combination Sum**](https://leetcode.com/problems/combination-sum/)                                          | Combination Sum            |
| 9  | Backtracking | [**131. Palindrome Partitioning**](https://leetcode.com/problems/palindrome-partitioning/)                         | Palindromic DFS            |
| 10 | Backtracking | [**79. Word Search**](https://leetcode.com/problems/word-search/)                                                  | Grid DFS                   |
| 11 | Backtracking | [**77. Combinations**](https://leetcode.com/problems/combinations/)                                                | Recursive Combinations     |
| 12 | Backtracking | [**51. N-Queens**](https://leetcode.com/problems/n-queens/)                                                        | Board Backtracking         |
| 13 | Graph        | [**200. Number of Islands**](https://leetcode.com/problems/number-of-islands/)                                     | DFS/BFS Traversal          |
| 14 | Graph        | [**133. Clone Graph**](https://leetcode.com/problems/clone-graph/)                                                 | DFS with Map               |
| 15 | Graph        | [**207. Course Schedule**](https://leetcode.com/problems/course-schedule/)                                         | Topological Sort           |
| 16 | Graph        | [**743. Network Delay Time**](https://leetcode.com/problems/network-delay-time/)                                   | Dijkstra’s Algorithm       |
| 17 | Graph        | [**547. Number of Provinces**](https://leetcode.com/problems/number-of-provinces/)                                 | Union-Find                 |
| 18 | Graph        | [**684. Redundant Connection**](https://leetcode.com/problems/redundant-connection/)                               | Union-Find Cycle Detection |
| 19 | Graph        | [**785. Is Graph Bipartite?**](https://leetcode.com/problems/is-graph-bipartite/)                                  | DFS Coloring               |
| 20 | Graph + DP   | [**329. Longest Increasing Path in a Matrix**](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/) | DFS + Memoization          |

---

## 🔥 Bonus: 3 Super FAANG+ Problems (Advanced)

| Problem                                                                                                                                     | Area                | Why It's Advanced                       |
| ------------------------------------------------------------------------------------------------------------------------------------------- | ------------------- | --------------------------------------- |
| [**212. Word Search II**](https://leetcode.com/problems/word-search-ii/)                                                                    | Backtracking + Trie | Combines data structures with recursion |
| [**2246. Longest Path With Different Adjacent Characters**](https://leetcode.com/problems/longest-path-with-different-adjacent-characters/) | Graph + DP          | Topo sort + stateful DFS                |
| [**847. Shortest Path Visiting All Nodes**](https://leetcode.com/problems/shortest-path-visiting-all-nodes/)                                | Graph + Bitmask     | TSP with bitmasking                     |

---

## 🧪 What to Do with These

* ✅ Use them as a **mock set**
* 🧠 Reflect on patterns: Can you **identify the technique** before coding?
* 💬 Practice explaining out loud (like in real interviews)
* ⏱️ Time yourself: Try **30 min/problem** as a max

---
