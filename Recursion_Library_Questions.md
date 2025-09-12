# Recursion_Library_Questions

Here's a **comprehensive list of recursion problems** for practice, categorized by **difficulty** and **type**. These range from basic to advanced and cover various use-cases such as backtracking, tree recursion, dynamic programming, and more.

---

## 🟢 **Beginner: Basics of Recursion**

These problems focus on understanding the core concept of recursion.

1. **Factorial of a number**
2. **Fibonacci series (nth Fibonacci number)**
3. **Sum of first N natural numbers**
4. **Print numbers from 1 to N and N to 1**
5. **Check if a string is a palindrome**
6. **Reverse a string**
7. **Find the maximum/minimum in an array recursively**
8. **Check if an array is sorted**
9. **108. Convert Sorted Array to Binary Search Tree** https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

---

## 🟡 **Intermediate: Array/String + Recursion**

These build on basic recursion and introduce array manipulations and decision trees.

1. **Linear Search in an array (recursively)**
2. **Binary Search using recursion**
3. **Generate all subsets of a set (Power Set)**
4. **Print all permutations of a string**
5. **Count the number of subsets with a given sum**
6. **Find the first and last occurrence of an element in an array**
7. **Remove all occurrences of a character from a string**
8. **Tower of Hanoi problem**
9. **Minimum Falling Path Sum Leetcode 931** https://www.youtube.com/watch?v=EQC0ckOyEGs

---

## 🔵 **Advanced: Backtracking + Recursion**

These problems explore recursive tree-based solutions with backtracking.

1. **N-Queens Problem**
2. **Sudoku Solver**
3. **Rat in a Maze**
4. **Word Search in a matrix**
5. **Generate all valid parentheses for n pairs**
6. **Letter Combinations of a Phone Number**
7. **Subsets with Duplicates**
8. **Permutations with Duplicates**

---

## 🔴 **Expert: Recursion with Dynamic Programming (Memoization/Tabulation)**

These combine recursion with optimization techniques.

1. **0/1 Knapsack Problem**
2. **Longest Common Subsequence (LCS)**
3. **Longest Palindromic Subsequence**
4. **Edit Distance**
5. **Matrix Chain Multiplication**
6. **Egg Dropping Problem**
7. **Boolean Parenthesization**
8. **Count Ways to Make Change (Coin Change Problem)**

---

## 🧠 **Bonus Challenges: Recursion in Trees and Graphs**

1. **Inorder / Preorder / Postorder Traversal**
2. **Diameter of a Binary Tree**
3. **Check if two trees are identical**
4. **Flatten a Binary Tree**
5. **Find all paths from root to leaf**
6. **Lowest Common Ancestor (LCA)**
7. **Word Break Problem**
8. **Clone a Graph**

---

### 🔁 Want Randomized Practice?

# 5 random problems now to start practicing?

Great! Here are **5 randomly selected recursion problems** across different difficulty levels to challenge and grow your skills:

---

### 🔹 **1. Print All Subsets (Power Set)**

**Difficulty:** Intermediate
**Prompt:**
Given a string (or array) of distinct elements, print all possible subsets (the power set).
**Example Input:** `"abc"`
**Expected Output:** `["", "a", "b", "c", "ab", "ac", "bc", "abc"]`

> 💡 *Use recursion to include or exclude each character.*

---

### 🔹 **2. N-Queens Problem**

**Difficulty:** Advanced
**Prompt:**
Place N queens on an N×N chessboard such that no two queens attack each other.
**Task:** Print all valid board configurations.
**Input:** `N = 4`
**Output:** List of 2D boards where queens are safely placed.

> 💡 *Use recursion + backtracking with column and diagonal checks.*

---

### 🔹 **3. First and Last Occurrence of an Element in an Array**

**Difficulty:** Intermediate
**Prompt:**
Given an array and a target value, find the first and last index where the value occurs using recursion.
**Input:** `[1, 2, 3, 4, 2, 5]`, target = `2`
**Output:** `First = 1, Last = 4`

> 💡 *Use index parameter and two recursive calls.*

---

### 🔹 **4. Longest Palindromic Subsequence**

**Difficulty:** Expert
**Prompt:**
Given a string, return the length of the longest palindromic subsequence.
**Input:** `"bbabcbcab"`
**Output:** `7` (`"babcbab"` is the longest)

> 💡 *Use recursion + memoization to avoid recomputing substrings.*

---

### 🔹 **5. Reverse a String Recursively**

**Difficulty:** Beginner
**Prompt:**
Write a recursive function to reverse a string in place.
**Input:** `"hello"`
**Output:** `"olleh"`

> 💡 *Use start and end index, swap characters recursively.*

---

Here are **5 more randomly selected recursion problems** — this batch includes a fresh mix of concepts like backtracking, number theory, and decision-making.

---

### 🔹 **6. Generate All Balanced Parentheses**

**Difficulty:** Advanced
**Prompt:**
Given `n`, print all combinations of well-formed parentheses using `n` pairs.
**Input:** `n = 3`
**Output:** `["((()))", "(()())", "(())()", "()(())", "()()()"]`

> 💡 *Use recursion with two counters: open and close.*

---

### 🔹 **7. Count Ways to Reach the N-th Stair**

**Difficulty:** Intermediate
**Prompt:**
You can climb either 1 or 2 steps at a time. Given `n` stairs, count the number of distinct ways to reach the top.
**Input:** `n = 4`
**Output:** `5`

> 💡 *Classic recursion with overlapping subproblems. Can optimize with memoization.*

---

### 🔹 **8. Word Search in a Grid**

**Difficulty:** Advanced (Backtracking)
**Prompt:**
Given a 2D board and a word, check if the word exists in the grid (moving horizontally or vertically).
**Input:**

```text
Board: [ ["A","B","C","E"], ["S","F","C","S"], ["A","D","E","E"] ]
Word: "ABCCED"
```

**Output:** `true`

> 💡 *Use DFS with visited tracking.*

---

### 🔹 **9. Print All Permutations of a String**

**Difficulty:** Intermediate
**Prompt:**
Print all permutations of a given string (assume no duplicates for now).
**Input:** `"abc"`
**Output:** `["abc", "acb", "bac", "bca", "cab", "cba"]`

> 💡 *Use a recursive swap strategy.*

---

### 🔹 **10. K-th Symbol in Grammar**

**Difficulty:** Expert
**Prompt:**
In the first row, we write a `0`. In each subsequent row, every `0` becomes `01` and every `1` becomes `10`.
Find the `k-th` symbol in row `n`.
**Input:** `n = 4, k = 5`
**Output:** `1`

> 💡 *Think of the tree structure and how position relates to its parent.*

---


Absolutely! Here's your **complete guide** to mastering **Recursion** — covering:

* ✅ Core concepts
* 🔁 Common **patterns**
* 💡 Tips to avoid stack overflow & improve performance
* 📚 Example problems with solutions
* 🗓️ A focused **7-day study plan**

---

# 📚 Recursion: Patterns & Study Plan (FAANG-Oriented)

---

## 🧠 What is Recursion?

Recursion is a programming technique where a function **calls itself** to solve a problem by breaking it into smaller subproblems. It’s a key concept behind many **divide & conquer**, **backtracking**, and **dynamic programming** problems.

---

## 🧩 Recursion Patterns

| # | Pattern                                | Description                            | Example Problem                                                                             |
| - | -------------------------------------- | -------------------------------------- | ------------------------------------------------------------------------------------------- |
| 1 | **Basic Recursion**                    | Solve by reducing input                | [Factorial, Fibonacci](https://leetcode.com/problems/fibonacci-number/)                     |
| 2 | **Decision Tree (Choose/Not Choose)**  | Binary decisions at each step          | [Subsets (78)](https://leetcode.com/problems/subsets/)                                      |
| 3 | **Backtracking**                       | Recursion + undo decision              | [Permutations (46)](https://leetcode.com/problems/permutations/)                            |
| 4 | **Divide & Conquer**                   | Split problem into halves              | [Merge Sort, Quick Sort](https://leetcode.com/problems/sort-an-array/)                      |
| 5 | **DFS/Binary Tree Recursion**          | Recursive tree traversal               | [Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/) |
| 6 | **Memoized Recursion (Top-down DP)**   | Cache subproblem results               | [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)                           |
| 7 | **Recursive Linked List/Backtracking** | Use recursion to reverse or manipulate | [Reverse Linked List (206)](https://leetcode.com/problems/reverse-linked-list/)             |

---

## ✅ Key Recursive Templates (Java)

---

### 📌 Basic Recursion Template

```java
void recurse(args) {
    if (base case) return;
    recurse(smaller problem);
}
```

---

### 📌 Subset (Choose / Not Choose)

```java
void helper(int[] nums, int index, List<Integer> path) {
    if (index == nums.length) {
        result.add(new ArrayList<>(path));
        return;
    }
    // Not choose
    helper(nums, index + 1, path);

    // Choose
    path.add(nums[index]);
    helper(nums, index + 1, path);
    path.remove(path.size() - 1); // backtrack
}
```

---

## 🔁 Must-Know Recursion Problems by Pattern

---

### 1️⃣ Basic Recursion

**Problem:** [509. Fibonacci Number](https://leetcode.com/problems/fibonacci-number/)

```java
public int fib(int n) {
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);
}
```

---

### 2️⃣ Subsets / Power Set

**Problem:** [78. Subsets](https://leetcode.com/problems/subsets/)

---

### 3️⃣ Permutations

**Problem:** [46. Permutations](https://leetcode.com/problems/permutations/)

---

### 4️⃣ Tree Recursion

**Problem:** [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)

---

### 5️⃣ Backtracking (N-Queens, Sudoku)

**Problem:** [51. N-Queens](https://leetcode.com/problems/n-queens/)

---

### 6️⃣ Divide & Conquer

**Problem:** [912. Sort an Array (Merge Sort)](https://leetcode.com/problems/sort-an-array/)

---

### 7️⃣ Memoized Recursion

**Problem:** [70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)

---

## 🛡️ Tips to Master Recursion

| Tip                                      | Why It Helps                       |
| ---------------------------------------- | ---------------------------------- |
| Define a clear **base case**             | Prevents infinite loops            |
| Reduce the problem size                  | Ensures progress toward base       |
| Use **memoization** to optimize          | Avoids exponential time            |
| Practice with tracing                    | Build confidence in call stack     |
| Convert recursive → iterative (optional) | For performance/stack size control |

---

## 🗓️ 7-Day Recursion Study Plan

| Day   | Focus                       | Practice Problems          |
| ----- | --------------------------- | -------------------------- |
| Day 1 | Basic Recursion & Fibonacci | 509, 1137                  |
| Day 2 | Tree Recursion (DFS)        | 104, 226, 543              |
| Day 3 | Subsets & Permutations      | 78, 90, 46                 |
| Day 4 | Backtracking Basics         | 39, 40, 17                 |
| Day 5 | Advanced Backtracking       | 51 (N-Queens), 37 (Sudoku) |
| Day 6 | Divide & Conquer            | 912, 23                    |
| Day 7 | Memoization & Optimization  | 70, 198, 322               |

---

## ⚔️ Interview-Ready Recursion Problems (Top Picks)

| Problem                       | Category                    |
| ----------------------------- | --------------------------- |
| 46. Permutations              | Backtracking                |
| 78. Subsets                   | Recursion Tree              |
| 51. N-Queens                  | Advanced Backtracking       |
| 104. Max Depth                | Tree DFS                    |
| 70. Climbing Stairs           | Memoization                 |
| 394. Decode String            | Recursive Stack Parsing     |
| 206. Reverse Linked List      | Recursive List Manipulation |
| 98. Validate BST              | Tree recursion              |
| 124. Binary Tree Max Path Sum | Recursive State             |
| 200. Number of Islands        | DFS Recursion               |

---

## 📘 Summary

* Recursion = **base case** + **recurrence relation**
* It's the foundation of **backtracking, tree traversal, and DP**
* Train by practicing **patterned problems**
* Start small → visualize call stack → optimize with memoization





