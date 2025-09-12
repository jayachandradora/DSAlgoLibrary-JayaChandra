
# Union and find and patterns and study plan


Comprehensive guide to **Union-Find (Disjoint Set Union - DSU)** — including:

* 🔁 Core **patterns**
* 💡 Typical **use-cases**
* ✅ Example problems with Java-style solutions
* 🗓️ A focused **5-day study plan**

---

# 📚 Union-Find (Disjoint Set Union - DSU): Patterns & Study Plan

---

## 🔧 What is Union-Find?

Union-Find is a **data structure** used to track a **set of elements partitioned into disjoint subsets**. It supports two main operations efficiently:

* `find(x)`: Find the root (representative) of x
* `union(x, y)`: Merge two subsets

Used in:

* ✅ Cycle detection in graphs
* ✅ Connected components
* ✅ Kruskal’s Minimum Spanning Tree (MST)
* ✅ Equivalence and grouping problems

---

## 🔁 Union-Find Patterns

| # | Pattern                            | Description                                   | Example Problem                                                                                                  |
| - | ---------------------------------- | --------------------------------------------- | ---------------------------------------------------------------------------------------------------------------- |
| 1 | **Basic DSU**                      | Classic union and find operations             | [547. Number of Provinces](https://leetcode.com/problems/number-of-provinces/)                                   |
| 2 | **Cycle Detection in Graph**       | Use DSU to detect cycles in undirected graphs | [684. Redundant Connection](https://leetcode.com/problems/redundant-connection/)                                 |
| 3 | **Dynamic Connectivity**           | Union components as you go                    | [990. Satisfiability of Equality Equations](https://leetcode.com/problems/satisfiability-of-equality-equations/) |
| 4 | **Kruskal’s MST**                  | Use DSU to select edges                       | [1584. Min Cost to Connect All Points](https://leetcode.com/problems/min-cost-to-connect-all-points/)            |
| 5 | **Connected Components (in Grid)** | Model a grid as a union-find structure        | [305. Number of Islands II](https://leetcode.com/problems/number-of-islands-ii/)                                 |

---

## 🧠 Union-Find Template (Java)

```java
class UnionFind {
    int[] parent, rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]); // path compression
        return parent[x];
    }

    public boolean union(int x, int y) {
        int xr = find(x), yr = find(y);
        if (xr == yr) return false; // already connected
        if (rank[xr] < rank[yr]) parent[xr] = yr;
        else if (rank[xr] > rank[yr]) parent[yr] = xr;
        else {
            parent[yr] = xr;
            rank[xr]++;
        }
        return true;
    }
}
```

---

## ✅ Key Union-Find Problems with Patterns

---

### 1️⃣ Basic DSU

**Problem:** [547. Number of Provinces](https://leetcode.com/problems/number-of-provinces/)

```java
public int findCircleNum(int[][] isConnected) {
    int n = isConnected.length;
    UnionFind uf = new UnionFind(n);

    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (isConnected[i][j] == 1) uf.union(i, j);
        }
    }

    Set<Integer> provinces = new HashSet<>();
    for (int i = 0; i < n; i++) {
        provinces.add(uf.find(i));
    }

    return provinces.size();
}
```

---

### 2️⃣ Detect Cycle

**Problem:** [684. Redundant Connection](https://leetcode.com/problems/redundant-connection/)

> Return the edge that causes a cycle.

---

### 3️⃣ Equality Equations

**Problem:** [990. Satisfiability of Equality Equations](https://leetcode.com/problems/satisfiability-of-equality-equations/)

> Handle `"a==b"` and `"a!=b"` by unifying groups and checking conflicts.

---

### 4️⃣ Kruskal’s MST

**Problem:** [1584. Min Cost to Connect All Points](https://leetcode.com/problems/min-cost-to-connect-all-points/)

> Sort edges by weight and use DSU to avoid cycles.

---

### 5️⃣ Dynamic Islands

**Problem:** [305. Number of Islands II](https://leetcode.com/problems/number-of-islands-ii/)

> Convert grid into Union-Find and update on land addition.

---

## 🗓️ 5-Day Union-Find Study Plan

| Day   | Focus                             | Problems                 |
| ----- | --------------------------------- | ------------------------ |
| Day 1 | Understand DSU + Path Compression | 547, 959                 |
| Day 2 | Cycle Detection in Graphs         | 684, 685                 |
| Day 3 | Character/Equation Union-Find     | 990, 721                 |
| Day 4 | Kruskal’s MST + Edge Problems     | 1584, 1135               |
| Day 5 | Union-Find on Grid/Matrix         | 305, 200 (as BFS vs DSU) |

---

## ⚠️ Common Mistakes to Avoid

* Forgetting to compress paths in `find()`
* Not unifying properly in Kruskal’s MST
* Failing to initialize Union-Find structure with correct size
* Comparing characters directly without mapping (for a–z problems)

---

## ✅ Bonus: Top 3 Advanced Union-Find Problems

| Problem                                                                                          | Concept                          |
| ------------------------------------------------------------------------------------------------ | -------------------------------- |
| [924. Minimize Malware Spread](https://leetcode.com/problems/minimize-malware-spread/)           | Component Size                   |
| [128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/) | Can be solved with Union-Find    |
| [839. Similar String Groups](https://leetcode.com/problems/similar-string-groups/)               | Merge groups based on similarity |

---

## 📘 Summary

| Feature         | Value                                                    |
| --------------- | -------------------------------------------------------- |
| Use-case        | Connected components, cycle detection, grouping          |
| Time Complexity | `O(α(n))` per op (with path compression & union by rank) |
| Extension       | Kruskal, Islands, String Grouping                        |
