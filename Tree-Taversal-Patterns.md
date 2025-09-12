# Tree Traversal Solution Patters

Great question! Solving tree problems effectively often comes down to recognizing **common patterns**. Below is a comprehensive list of **tree problem-solving patterns**, each with a **short explanation** and a **Java code example**.

---

## 🌳 Tree Problem Patterns (with Examples)

---

### ✅ 1. **DFS Traversal (Preorder, Inorder, Postorder)**

* Used for visiting all nodes in different orders.
* Recursive or iterative.

**🧠 Common Use:** Search, print, serialize/deserialize, or process nodes in order.

**📌 Example:** Inorder Traversal

```java
void inorder(TreeNode root) {
    if (root == null) return;
    inorder(root.left);
    System.out.print(root.val + " ");
    inorder(root.right);
}
```

---

### ✅ 2. **BFS (Level Order Traversal)**

* Used to process nodes level by level (top-down).
* Use a `Queue`.

**📌 Example:** Level Order Traversal

```java
List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
        int size = queue.size();
        List<Integer> level = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            level.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        result.add(level);
    }

    return result;
}
```

---

### ✅ 3. **Bottom-Up DFS (Post-order Traversal)**

* Useful when you need to **compute values from children to parent** (like height, diameter).

**📌 Example:** Balanced Binary Tree (Leetcode 110)

```java
public boolean isBalanced(TreeNode root) {
    return check(root) != -1;
}

private int check(TreeNode node) {
    if (node == null) return 0;
    int left = check(node.left);
    int right = check(node.right);
    if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
    return Math.max(left, right) + 1;
}
```

---

### ✅ 4. **Top-Down DFS**

* Process current node first, pass data to children (e.g., path sum, depth).

**📌 Example:** Maximum Depth of Binary Tree (Leetcode 104)

```java
public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
}
```

---

### ✅ 5. **Two-Pointer (LCA - Lowest Common Ancestor)**

* Useful when finding the relationship between two nodes.

**📌 Example:** Lowest Common Ancestor of Binary Tree (Leetcode 236)

```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left != null && right != null) return root;
    return left != null ? left : right;
}
```

---

### ✅ 6. **Recursive Path Building (Backtracking)**

* Used in path-based problems (e.g., all root-to-leaf paths, path sum).

**📌 Example:** Binary Tree Paths (Leetcode 257)

```java
public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    buildPaths(root, "", result);
    return result;
}

private void buildPaths(TreeNode node, String path, List<String> result) {
    if (node == null) return;

    path += node.val;

    if (node.left == null && node.right == null) {
        result.add(path);
    } else {
        path += "->";
        buildPaths(node.left, path, result);
        buildPaths(node.right, path, result);
    }
}
```

---

### ✅ 7. **Binary Search Tree (BST) Properties**

* Use BST properties: left < root < right

**📌 Example:** Validate BST (Leetcode 98)

```java
public boolean isValidBST(TreeNode root) {
    return isValid(root, null, null);
}

private boolean isValid(TreeNode node, Integer min, Integer max) {
    if (node == null) return true;
    if ((min != null && node.val <= min) || (max != null && node.val >= max)) return false;
    return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
}
```

---

### ✅ 8. **Morris Traversal (O(1) Space Traversal)**

* Advanced technique to traverse a tree without recursion or stack.
* Mostly used for **inorder**.

**📌 Example:** Inorder Traversal without recursion/stack

```java
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    TreeNode current = root;

    while (current != null) {
        if (current.left == null) {
            result.add(current.val);
            current = current.right;
        } else {
            TreeNode predecessor = current.left;
            while (predecessor.right != null && predecessor.right != current) {
                predecessor = predecessor.right;
            }

            if (predecessor.right == null) {
                predecessor.right = current;
                current = current.left;
            } else {
                predecessor.right = null;
                result.add(current.val);
                current = current.right;
            }
        }
    }

    return result;
}
```

---

### ✅ 9. **Serialize & Deserialize a Tree**

* Encode and decode a tree for storage or transmission.

**📌 Example:** Serialize & Deserialize (Leetcode 297)

```java
// Serialize
public String serialize(TreeNode root) {
    if (root == null) return "null,";
    return root.val + "," + serialize(root.left) + serialize(root.right);
}

// Deserialize
private int index = 0;
public TreeNode deserialize(String data) {
    String[] nodes = data.split(",");
    return buildTree(nodes);
}

private TreeNode buildTree(String[] nodes) {
    if (nodes[index].equals("null")) {
        index++;
        return null;
    }

    TreeNode node = new TreeNode(Integer.parseInt(nodes[index++]));
    node.left = buildTree(nodes);
    node.right = buildTree(nodes);
    return node;
}
```

---

## 🧩 Summary Table of Patterns

| Pattern          | Description                     | Example Problem        |
| ---------------- | ------------------------------- | ---------------------- |
| DFS Traversal    | Preorder, Inorder, Postorder    | Tree Traversal         |
| BFS              | Level-by-level traversal        | Level Order Traversal  |
| Bottom-Up DFS    | Calculate height, balance       | Balanced Tree          |
| Top-Down DFS     | Carry info from root to leaves  | Max Depth              |
| LCA              | Two-pointer approach            | Lowest Common Ancestor |
| Path Building    | Backtracking for all paths      | Root-to-Leaf Paths     |
| BST Property     | Validate or search in BST       | Validate BST           |
| Morris Traversal | O(1) space traversal            | Inorder Without Stack  |
| Serialization    | Convert tree to string and back | Serialize/Deserialize  |

---
# **comprehensive study plan** for **tree problems**, organized by patterns. Each pattern includes:

* ✅ **Pattern description**
* 📘 **Practice problems (Leetcode)**
* 📅 **Study plan schedule (2 weeks)**

This is ideal for **interview prep** or **strengthening your tree problem skills**.

---

## 🧠 Tree Patterns with Practice Problems

---

### ✅ 1. **DFS Traversal (Inorder, Preorder, Postorder)**

**Description:** Basic traversals to explore nodes in specific order.

**Problems:**

* [94. Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)
* [144. Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/)
* [145. Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/)

---

### ✅ 2. **BFS / Level Order Traversal**

**Description:** Use a queue to process the tree level-by-level.

**Problems:**

* [102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)
* [107. Binary Tree Level Order Traversal II](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/)
* [103. Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)

---

### ✅ 3. **Bottom-Up DFS (Post-order)**

**Description:** Useful when result depends on children (e.g. height, balance, diameter).

**Problems:**

* [110. Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/)
* [543. Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/)
* [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)

---

### ✅ 4. **Top-Down DFS**

**Description:** Useful for carrying data down the tree (e.g. depth, path sum).

**Problems:**

* [112. Path Sum](https://leetcode.com/problems/path-sum/)
* [113. Path Sum II](https://leetcode.com/problems/path-sum-ii/)
* [437. Path Sum III](https://leetcode.com/problems/path-sum-iii/)

---

### ✅ 5. **Lowest Common Ancestor (Two-Pointer)**

**Description:** Find the lowest node that is an ancestor to two given nodes.

**Problems:**

* [236. Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
* [235. LCA in BST](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)
* [1644. LCA of a Binary Tree II](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/)

---

### ✅ 6. **Path Building / Backtracking**

**Description:** Useful for generating all paths from root to leaves or nodes.

**Problems:**

* [257. Binary Tree Paths](https://leetcode.com/problems/binary-tree-paths/)
* [129. Sum Root to Leaf Numbers](https://leetcode.com/problems/sum-root-to-leaf-numbers/)
* [988. Smallest String Starting From Leaf](https://leetcode.com/problems/smallest-string-starting-from-leaf/)

---

### ✅ 7. **BST Properties**

**Description:** Use the `left < root < right` rule to solve BST-specific problems.

**Problems:**

* [98. Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)
* [700. Search in a BST](https://leetcode.com/problems/search-in-a-binary-search-tree/)
* [701. Insert into a BST](https://leetcode.com/problems/insert-into-a-binary-search-tree/)
* [450. Delete Node in a BST](https://leetcode.com/problems/delete-node-in-a-binary-search-tree/)

---

### ✅ 8. **Morris Traversal (O(1) space)**

**Description:** Inorder traversal without recursion/stack using threaded binary trees.

**Problems:**

* [94. Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/) *(Implement using Morris Traversal)*

---

### ✅ 9. **Serialization and Deserialization**

**Description:** Convert tree to a string and back (for storage or transmission).

**Problems:**

* [297. Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)
* [449. Serialize and Deserialize BST](https://leetcode.com/problems/serialize-and-deserialize-bst/)

---

## 🗓️ 14-Day Tree Study Plan

### **Week 1 — Fundamentals & DFS**

| Day   | Focus                       | Problems                        |
| ----- | --------------------------- | ------------------------------- |
| Day 1 | DFS Traversals              | 94, 144, 145                    |
| Day 2 | BFS Traversals              | 102, 103, 107                   |
| Day 3 | Bottom-Up DFS               | 110, 543                        |
| Day 4 | Top-Down DFS                | 104, 112                        |
| Day 5 | Mixed Depth Problems        | 113, 437                        |
| Day 6 | Practice Day                | Try random mix of past problems |
| Day 7 | Review & Reattempt mistakes | All missed/marked ones          |

---

### **Week 2 — Advanced Patterns**

| Day    | Focus                   | Problems             |
| ------ | ----------------------- | -------------------- |
| Day 8  | LCA Problems            | 236, 235             |
| Day 9  | Path Building           | 257, 129             |
| Day 10 | BST Operations          | 98, 700, 701         |
| Day 11 | Deletion in BST         | 450                  |
| Day 12 | Morris Traversal        | 94 (Morris version)  |
| Day 13 | Serialize / Deserialize | 297, 449             |
| Day 14 | Mock Interview & Review | Pick 2 hard problems |

---

## 🧰 Tips for Success

* **Write code on paper or whiteboard** to simulate interviews.
* Use **debug prints or visualizations** to understand recursion.
* Focus on **writing recursive logic cleanly** — tree problems are 80% recursion-based.
* For hard problems, **trace manually** how recursive calls behave.

---

Would you like a printable checklist or Notion/GDocs version of this plan? I can generate that for you too.
