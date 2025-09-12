# Graph Problems and patterns and study plan

Absolutely! Graph problems can be overwhelming at first, but once you understand the **core patterns**, they become very manageable.

---

## 🧠 **Graph Problem Patterns (with Java Solutions)**

There are 9 major graph patterns you must know. For each one, I’ll share:

1. ✅ Pattern Summary
2. 📌 One representative problem
3. 🔧 Java code solution
4. 📅 A **7-day FAST-PACE study plan** at the end

---

### ✅ 1. **DFS (Depth-First Search)**

**Use When:** You want to explore all paths, check connectivity, or perform backtracking.

**📌 Problem:** [695. Max Area of Island](https://leetcode.com/problems/max-area-of-island/)

```java
public int maxAreaOfIsland(int[][] grid) {
    int max = 0;
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == 1) {
                max = Math.max(max, dfs(grid, i, j));
            }
        }
    }
    return max;
}

private int dfs(int[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
        return 0;

    grid[i][j] = 0; // mark visited
    return 1 + dfs(grid, i+1, j) + dfs(grid, i-1, j) + dfs(grid, i, j+1) + dfs(grid, i, j-1);
}
```

---

### ✅ 2. **BFS (Breadth-First Search)**

**Use When:** You want the shortest path in **unweighted** graphs or level-by-level traversal.

**📌 Problem:** [542. 01 Matrix](https://leetcode.com/problems/01-matrix/)

```java
public int[][] updateMatrix(int[][] mat) {
    int m = mat.length, n = mat[0].length;
    Queue<int[]> q = new LinkedList<>();
    int[][] dist = new int[m][n];
    boolean[][] visited = new boolean[m][n];

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (mat[i][j] == 0) {
                q.offer(new int[]{i, j});
                visited[i][j] = true;
            }
        }
    }

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    while (!q.isEmpty()) {
        int[] cell = q.poll();
        for (int[] d : dirs) {
            int r = cell[0] + d[0], c = cell[1] + d[1];
            if (r >= 0 && c >= 0 && r < m && c < n && !visited[r][c]) {
                dist[r][c] = dist[cell[0]][cell[1]] + 1;
                q.offer(new int[]{r, c});
                visited[r][c] = true;
            }
        }
    }
    return dist;
}
```

---

### ✅ 3. **Topological Sort (Kahn’s or DFS-based)**

**Use When:** You want to order tasks given prerequisites (DAGs only).

**📌 Problem:** [207. Course Schedule](https://leetcode.com/problems/course-schedule/)

```java
public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
    int[] indegree = new int[numCourses];

    for (int[] p : prerequisites) {
        graph.get(p[1]).add(p[0]);
        indegree[p[0]]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++)
        if (indegree[i] == 0) queue.offer(i);

    int count = 0;
    while (!queue.isEmpty()) {
        int curr = queue.poll();
        count++;
        for (int next : graph.get(curr)) {
            if (--indegree[next] == 0) queue.offer(next);
        }
    }

    return count == numCourses;
}
```

---

### ✅ 4. **Union-Find (Disjoint Set Union - DSU)**

**Use When:** You need to check connectivity, cycles, or grouping.

**📌 Problem:** [547. Number of Provinces](https://leetcode.com/problems/number-of-provinces/)

```java
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (isConnected[i][j] == 1)
                    union(parent, i, j);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(find(parent, i));
        return set.size();
    }

    private int find(int[] parent, int i) {
        if (parent[i] != i)
            parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    private void union(int[] parent, int x, int y) {
        parent[find(parent, x)] = find(parent, y);
    }
}
```

---

### ✅ 5. **Dijkstra’s Algorithm**

**Use When:** You want the shortest path in **weighted** graphs with **non-negative weights**.

**📌 Problem:** [743. Network Delay Time](https://leetcode.com/problems/network-delay-time/)

```java
public int networkDelayTime(int[][] times, int n, int k) {
    List<int[]>[] graph = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
    for (int[] time : times)
        graph[time[0]].add(new int[]{time[1], time[2]});

    int[] dist = new int[n + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[k] = 0;

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    pq.offer(new int[]{k, 0});

    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int node = curr[0], d = curr[1];
        if (d > dist[node]) continue;

        for (int[] nei : graph[node]) {
            int next = nei[0], w = nei[1];
            if (dist[next] > d + w) {
                dist[next] = d + w;
                pq.offer(new int[]{next, dist[next]});
            }
        }
    }

    int max = 0;
    for (int i = 1; i <= n; i++) {
        if (dist[i] == Integer.MAX_VALUE) return -1;
        max = Math.max(max, dist[i]);
    }

    return max;
}
```

---

### ✅ 6. **Bellman-Ford (Negative Weights)**

**Use When:** Graph has **negative weights** (but no negative cycles).

**📌 Problem:** [787. Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/)

---

### ✅ 7. **Cycle Detection (DFS or Union-Find)**

**Use When:** Need to detect if a graph contains a cycle.

**📌 Problem:** [785. Is Graph Bipartite?](https://leetcode.com/problems/is-graph-bipartite/)

---

### ✅ 8. **Backtracking on Graph (Hamiltonian paths, Coloring)**

**Use When:** You want to try all possible configurations on a graph.

**📌 Problem:** [1319. Number of Operations to Make Network Connected](https://leetcode.com/problems/number-of-operations-to-make-network-connected/)

---

### ✅ 9. **Minimum Spanning Tree (Prim/Kruskal)**

**Use When:** You want to connect all nodes with minimum cost.

**📌 Problem:** [1584. Min Cost to Connect All Points](https://leetcode.com/problems/min-cost-to-connect-all-points/)

---

## 🗓️ **Fast-Track 7-Day Study Plan (Graphs)**

> 🚀 Finish essential graph topics in **1 week** (2-3 hours/day)

| Day   | Focus               | Topics                    | Problems  |
| ----- | ------------------- | ------------------------- | --------- |
| Day 1 | Basics              | DFS, BFS                  | 695, 542  |
| Day 2 | Topological Sort    | DFS & Kahn's              | 207, 210  |
| Day 3 | Union-Find          | DSU, Cycle detection      | 547, 684  |
| Day 4 | Shortest Paths I    | Dijkstra                  | 743, 1334 |
| Day 5 | Shortest Paths II   | Bellman-Ford, BFS K-stops | 787, 1334 |
| Day 6 | MST & Hard Problems | Kruskal, Prim             | 1584      |


, 1135 |
\| Day 7 | Review & Reattempt | Mock contest | Revisit all marked problems |


## 🧠 FAANG Graph Interview Plan (14-Day Intensive)

### ⏰ Daily:

* **1-1.5 hrs solving**
* **30 mins reviewing solutions**
* **Optional: mock/peer interview weekly**

---

### 🗓️ Week 1: Core Graph Patterns & Implementation Mastery

| Day   | Focus                              | Topics                                                      | Leetcode Problems                                                                                                                                                                           |
| ----- | ---------------------------------- | ----------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Day 1 | **Graph Representation**           | Adjacency list, matrix, visited array, building graphs      | [133. Clone Graph](https://leetcode.com/problems/clone-graph/), [323. Number of Connected Components](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/) |
| Day 2 | **DFS (Recursive + Iterative)**    | Traversal, connected components, max area                   | [200. Number of Islands](https://leetcode.com/problems/number-of-islands/), [695. Max Area of Island](https://leetcode.com/problems/max-area-of-island/)                                    |
| Day 3 | **BFS**                            | Shortest path in unweighted graphs, visited tracking        | [542. 01 Matrix](https://leetcode.com/problems/01-matrix/), [994. Rotting Oranges](https://leetcode.com/problems/rotting-oranges/)                                                          |
| Day 4 | **Cycle Detection**                | Directed/undirected graphs, DFS, Union-Find                 | [207. Course Schedule](https://leetcode.com/problems/course-schedule/), [261. Graph Valid Tree](https://leetcode.com/problems/graph-valid-tree/)                                            |
| Day 5 | **Topological Sort**               | Kahn’s Algorithm (BFS), DFS approach, multiple valid orders | [210. Course Schedule II](https://leetcode.com/problems/course-schedule-ii/), [133. Clone Graph](https://leetcode.com/problems/clone-graph/)                                                |
| Day 6 | **Union-Find (Disjoint Set)**      | Union by rank, path compression, cycle detection            | [684. Redundant Connection](https://leetcode.com/problems/redundant-connection/), [547. Number of Provinces](https://leetcode.com/problems/number-of-provinces/)                            |
| Day 7 | **Weekly Review & Mock Interview** | Reattempt, debug, pair solve                                | Reattempt 3 hardest problems + mock with friend/interviewer                                                                                                                                 |

---

### 🗓️ Week 2: Advanced Patterns & Problem Solving

| Day    | Focus                                | Topics                                               | Leetcode Problems                                                                                                                                                                                                                                                               |
| ------ | ------------------------------------ | ---------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Day 8  | **Dijkstra’s Algorithm**             | Shortest paths, PQ (min-heap), graph modeling        | [743. Network Delay Time](https://leetcode.com/problems/network-delay-time/), [1631. Path With Minimum Effort](https://leetcode.com/problems/path-with-minimum-effort/)                                                                                                         |
| Day 9  | **Bellman-Ford & BFS K-Stops**       | Negative weights, limited hops, edge-based traversal | [787. Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/), [1334. Find the City With the Smallest Number of Neighbors](https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/) |
| Day 10 | **Minimum Spanning Tree**            | Kruskal (UF), Prim (min-heap), greedy                | [1584. Min Cost to Connect All Points](https://leetcode.com/problems/min-cost-to-connect-all-points/), [1135. Connecting Cities With Minimum Cost](https://leetcode.com/problems/connecting-cities-with-minimum-cost/)                                                          |
| Day 11 | **Graph Coloring & Bipartite Check** | 2-coloring, DFS/BFS coloring                         | [785. Is Graph Bipartite?](https://leetcode.com/problems/is-graph-bipartite/), [886. Possible Bipartition](https://leetcode.com/problems/possible-bipartition/)                                                                                                                 |
| Day 12 | **Backtracking on Graphs**           | Hamiltonian paths, constraints, recursion            | [847. Shortest Path Visiting All Nodes](https://leetcode.com/problems/shortest-path-visiting-all-nodes/) *(Hard)*                                                                                                                                                               |
| Day 13 | **Real-World Scenarios**             | Connectivity, redundancy, graphs in system design    | [1319. Number of Operations to Make Network Connected](https://leetcode.com/problems/number-of-operations-to-make-network-connected/), [1057. Campus Bikes](https://leetcode.com/problems/campus-bikes/)                                                                        |
| Day 14 | **Mock Interview Day**               | 2 Hard Problems, timed, talk out loud                | Pick 1 hard + 1 medium, simulate 1-hour FAANG-style interview                                                                                                                                                                                                                   |

---

## 🎯 Must-Know Concepts for FAANG Graph Rounds

| Topic           | Must Know                                             |
| --------------- | ----------------------------------------------------- |
| Traversal       | DFS (recursive & stack), BFS (queue-based)            |
| Graph Types     | Directed/Undirected, Weighted/Unweighted              |
| Representations | Adjacency list vs matrix                              |
| Cycle Detection | DFS, Union-Find                                       |
| Topo Sort       | Kahn's Algo, DFS-based                                |
| Shortest Path   | BFS (unweighted), Dijkstra (weighted), Bellman-Ford   |
| Connectivity    | DSU, connected components                             |
| MST             | Kruskal (UF), Prim (Heap)                             |
| Others          | Bipartite, Backtracking, Bitmasking, Multi-source BFS |

---

## 🛠 Tools

* Use [Leetcode Graph Tag](https://leetcode.com/tag/graph/) as your main source.
* Use [visualgo.net](https://visualgo.net/en/graphds) to visualize graph algorithms.
* Track in a Notion / Excel sheet (optional template available).

---
