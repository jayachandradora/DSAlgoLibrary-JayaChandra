# Burning Nodes in Tree and Graphs

Great question! You're describing a classic problem known as **"Burning a Binary Tree from a Given Node"**, which is commonly asked in interviews at FAANG and similar companies.

---

### 🔥 Problem Statement

Given a **binary tree** and a **target node** (where fire starts), fire spreads to **connected nodes** (left child, right child, and parent) in **1 unit of time**. We need to find the **total time required to burn the entire tree**.

---

### ✅ Key Concepts to Solve

* You need **parent access**, which standard binary tree nodes don’t have. So we first:

  * Build a **parent map** using BFS.
* Then use **multi-source BFS** (fire spreads in all directions) to count levels (i.e., time units).

---

### 💡 Approach

1. **Build parent references** using BFS.
2. Start a **BFS from the fire source node**.
3. Each level of BFS = 1 time unit.
4. Track visited nodes to avoid revisits.

---

### ✅ Java Code Implementation

```java
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class BurnTree {
    
    // Step 1: Map child to parent using BFS
    private Map<TreeNode, TreeNode> mapParents(TreeNode root, TreeNode target) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                queue.add(curr.left);
            }
            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                queue.add(curr.right);
            }
        }
        return parentMap;
    }

    // Step 2: Burn tree using BFS and count levels
    private int burnTree(TreeNode target, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.add(target);
        visited.add(target);

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean anyFireSpread = false;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                // check left
                if (curr.left != null && !visited.contains(curr.left)) {
                    queue.add(curr.left);
                    visited.add(curr.left);
                    anyFireSpread = true;
                }

                // check right
                if (curr.right != null && !visited.contains(curr.right)) {
                    queue.add(curr.right);
                    visited.add(curr.right);
                    anyFireSpread = true;
                }

                // check parent
                TreeNode parent = parentMap.get(curr);
                if (parent != null && !visited.contains(parent)) {
                    queue.add(parent);
                    visited.add(parent);
                    anyFireSpread = true;
                }
            }

            if (anyFireSpread) time++;
        }

        return time;
    }

    public int amountOfTime(TreeNode root, int startVal) {
        // Step 1: Find target node
        TreeNode targetNode = findNode(root, startVal);
        if (targetNode == null)
          return 0;

        // Step 2: Build parent references
        Map<TreeNode, TreeNode> parentMap = mapParents(root, targetNode);

        // Step 3: Burn the tree from target
        return burnTree(targetNode, parentMap);
    }

    // Utility to find the node with given value
    private TreeNode findNode(TreeNode root, int val) {
        if (root == null)
          return null;
        if (root.val == val)
          return root;

        TreeNode left = findNode(root.left, val);
        if (left != null)
           return left;

        return findNode(root.right, val);
    }

    // You can test with a sample tree here
    public static void main(String[] args) {
        BurnTree burn = new BurnTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.right.left = new TreeNode(7);

        int time = burn.amountOfTime(root, 5);
        System.out.println("Time to burn the entire tree: " + time);
    }
}
```

---

### 🔍 Sample Tree Used:

```
         1
       /   \
      2     3
     / \   /
    4   5 6
       /
      7
```

If fire starts at node `5`, fire spreads like:

* Time 0: 5
* Time 1: 2, 7
* Time 2: 1, 4
* Time 3: 3
* Time 4: 6 → 🔥 **Answer = 4**

---

### ✅ Time & Space Complexity

* **Time:** O(n) — One traversal to build parent map, one BFS to simulate fire.
* **Space:** O(n) — For parent map, visited set, and queue.

---

Great twist on the problem! 🔥 You're now dealing with a **multi-source burning problem** — fire starts from **multiple nodes** simultaneously, and it spreads in **1 unit of time** to neighbors (left, right, and parent).

---

## 🔁 Problem Statement (Updated)

You're given a binary tree and a list of nodes where fire starts simultaneously. Each second, fire spreads to the **left child**, **right child**, and **parent** of every burning node.
Your goal is to **return the minimum time to burn the entire tree**.

---

## ✅ Approach

### 🔧 Steps

1. **Map each node to its parent** using BFS.
2. **Find all the nodes** in the given list of start nodes.
3. Use a **multi-source BFS** to simulate the fire spreading from all starting points at once.
4. Count how many levels (seconds) it takes to burn all nodes.

---

## ✅ Java Code

```java
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class BurnTreeMultipleSources {

    // Step 1: Build parent map using BFS
    private Map<TreeNode, TreeNode> buildParentMap(TreeNode root) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                queue.add(curr.left);
            }

            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                queue.add(curr.right);
            }
        }
        return parentMap;
    }

    // Step 2: Get node references from values
    private void collectBurningNodes(TreeNode root, Set<Integer> burningVals, Map<Integer, TreeNode> nodeMap) {
        if (root == null) return;
        nodeMap.put(root.val, root);
        collectBurningNodes(root.left, burningVals, nodeMap);
        collectBurningNodes(root.right, burningVals, nodeMap);
    }

    // Step 3: Burn from multiple sources
    private int burnTreeFromMultipleSources(Set<TreeNode> burningNodes, Map<TreeNode, TreeNode> parentMap) {
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>(burningNodes);
        visited.addAll(burningNodes);

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean anyFireSpread = false;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                for (TreeNode neighbor : Arrays.asList(curr.left, curr.right, parentMap.get(curr))) {
                    if (neighbor != null && !visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                        anyFireSpread = true;
                    }
                }
            }

            if (anyFireSpread) time++;
        }

        return time;
    }

    public int timeToBurnTree(TreeNode root, List<Integer> fireStartNodes) {
        if (root == null || fireStartNodes.isEmpty()) return 0;

        // Step 1: Build parent links
        Map<TreeNode, TreeNode> parentMap = buildParentMap(root);

        // Step 2: Map value to node for quick lookup
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        collectBurningNodes(root, new HashSet<>(fireStartNodes), nodeMap);

        // Step 3: Collect actual TreeNode objects where fire starts
        Set<TreeNode> burningStartNodes = new HashSet<>();
        for (int val : fireStartNodes) {
            if (nodeMap.containsKey(val)) {
                burningStartNodes.add(nodeMap.get(val));
            }
        }

        // Step 4: Perform BFS from multiple fire sources
        return burnTreeFromMultipleSources(burningStartNodes, parentMap);
    }

    // Driver Code
    public static void main(String[] args) {
        BurnTreeMultipleSources solver = new BurnTreeMultipleSources();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.right.left = new TreeNode(7);

        // Fire starts from nodes 5 and 3
        List<Integer> fireStartNodes = Arrays.asList(5, 3);

        int time = solver.timeToBurnTree(root, fireStartNodes);
        System.out.println("Time to burn the entire tree: " + time);
    }
}
```

---

## 🔍 Sample Tree

```
         1
       /   \
      2     3
     / \   /
    4   5 6
       /
      7
```

If fire starts at nodes **5 and 3**, the fire spreads like:

```
Time 0: 5, 3
Time 1: 2, 7, 6
Time 2: 1, 4
→ ✅ Total time = 2
```

---

## ✅ Time and Space Complexity

* **Time Complexity:** O(n) — each node is visited once.
* **Space Complexity:** O(n) — for parent map, visited set, and queue.

---

Great question! The **tree burning problem** generalized to a **graph** is a classic **multi-source BFS** problem with slight tweaks.

---

## 🔥 Burning Nodes in a Graph — Single Source & Multiple Sources

---

### Problem Restatement (Graph)

You are given an undirected graph (nodes and edges) and:

* A **single source** node or
* A **list of source nodes** (where fire starts simultaneously).

Each **unit time**, fire spreads from burning nodes to **all their neighbors**.

**Goal:** Find how long it takes to burn the entire graph (i.e., all nodes reachable from the sources).

---

## 🔁 Approach: BFS on Graph

1. **Build adjacency list** for the graph.
2. For **single source**, run BFS from that node.
3. For **multiple sources**, run BFS initialized with all source nodes (multi-source BFS).
4. Count how many levels it takes to visit all reachable nodes.
5. If graph is disconnected, nodes unreachable from fire sources remain unburned, so you can decide how to handle that (usually ignore unreachable or return -1).

---

## ✅ Step-by-step Solution Outline

---

### 1. **Build graph**

* Use a map or array of lists to represent adjacency.

### 2. **Multi-source BFS**

* Initialize a queue with all source nodes.
* Maintain a visited set.
* At each BFS level, spread fire to all neighbors not yet visited.
* Increment time for each BFS level.
* When no more new nodes can be burnt, time is total burn time.

---

## ✅ Java Code for Graph Burning (Multi-source BFS)

```java
import java.util.*;

public class GraphBurning {

    public int burnGraph(int n, int[][] edges, List<Integer> startNodes) {
        // n = number of nodes (assumed 0 to n-1)
        // edges = list of undirected edges
        // startNodes = nodes where fire starts
        
        // Step 1: Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // Step 2: Initialize BFS queue with start nodes
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for(int node : startNodes) {
            queue.offer(node);
            visited[node] = true;
        }
        
        int time = 0;
        
        // Step 3: BFS to spread fire
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean anySpread = false;
            
            for(int i=0; i<size; i++) {
                int curr = queue.poll();
                for(int neighbor : graph.get(curr)) {
                    if(!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                        anySpread = true;
                    }
                }
            }
            if(anySpread) time++;  // increase time only if fire spreads this round
        }
        
        // Optional: Check if all nodes burned
        // for(boolean v : visited) if(!v) return -1; // unreachable node exists
        
        return time;
    }
    
    public static void main(String[] args) {
        GraphBurning gb = new GraphBurning();
        
        // Example graph with 7 nodes (0-6)
        int n = 7;
        int[][] edges = {
            {0,1}, {1,2}, {1,3}, {2,4}, {3,5}, {5,6}
        };
        
        // Fire starts from nodes 2 and 5
        List<Integer> startNodes = Arrays.asList(2,5);
        
        int burnTime = gb.burnGraph(n, edges, startNodes);
        System.out.println("Time to burn entire graph: " + burnTime);
    }
}
```

---

## 🔍 Explanation of Example

Graph edges:

```
0 - 1 - 2 - 4
    |
    3 - 5 - 6
```

* Fire starts at nodes 2 and 5.
* Time 0: fire at 2, 5
* Time 1: fire spreads to 1, 3, 6
* Time 2: fire spreads to 0, 4
* Time 3: no more nodes → total time = 2

---

## 🔑 Key Takeaways

* BFS naturally models spreading processes (fire, infection, water flow).
* Multi-source BFS means queue initialized with all start points.
* Time taken = number of BFS levels until no new nodes to spread.
* Handle disconnected components carefully (decide if unreachable nodes matter).

---

## Comparison with Tree Burning

| Aspect           | Tree Burning                    | Graph Burning                         |
| ---------------- | ------------------------------- | ------------------------------------- |
| Structure        | Tree (no cycles, parent-child)  | General graph (may have cycles)       |
| Parent mapping   | Needed to move upwards in tree  | Graph adjacency handles all neighbors |
| BFS queue        | Single or multiple source nodes | Same, multi-source BFS                |
| Visited tracking | Needed to prevent revisits      | Same                                  |
| Complexity       | O(n)                            | O(V+E)                                |

---

If you want, I can help build:

* Variants with weighted edges (fire spreads faster/slower)
* Handling directed graphs
* Implementations in other languages
* Visualization for teaching/interview prep





