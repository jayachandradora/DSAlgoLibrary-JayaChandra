# Heap Problems and patterns and study plan

Great! Heaps are **critical for FAANG interviews**, especially when dealing with problems involving:

* **Top K elements**
* **Running minimum/maximum**
* **Priority scheduling**
* **Streaming data**

They're often combined with **greedy**, **sliding window**, or **graph algorithms** (e.g., Dijkstra).

---

## 💡 Heap Patterns & Study Plan

### 🧠 What You Get:

* ✅ **7 Heap problem-solving patterns**
* 🛠 1 Java solution per pattern
* 🗓️ **7-day study plan**
* 🎯 Focus on **min-heap**, **max-heap**, and **custom comparators**

---

## 🔁 7 Essential Heap Patterns (with Java Solutions)

| # | Pattern                      | Common Use Case           | Example Problem         |
| - | ---------------------------- | ------------------------- | ----------------------- |
| 1 | **Top K Elements**           | Find k smallest/largest   | Top K Frequent Words    |
| 2 | **Kth Largest/Smallest**     | Selection                 | Kth Largest Element     |
| 3 | **Sliding Window with Heap** | Dynamic range queries     | Sliding Window Maximum  |
| 4 | **Merge K Sorted Lists**     | Multi-way merge           | Merge K Lists, K Arrays |
| 5 | **Rearrange Elements**       | Frequency-based placement | Reorganize String       |
| 6 | **Running Median**           | Streaming median          | Median from Data Stream |
| 7 | **Dijkstra’s Shortest Path** | Weighted graph traversal  | Network Delay Time      |

---

### ✅ Java Solutions for Each Pattern

---

### 1️⃣ Top K Frequent Elements

**📌 Problem:** [347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)

```java
public List<Integer> topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);
    
    PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));
    for (int n : freq.keySet()) {
        heap.add(n);
        if (heap.size() > k) heap.poll();
    }

    List<Integer> res = new ArrayList<>();
    while (!heap.isEmpty()) res.add(heap.poll());
    Collections.reverse(res);
    return res;
}
```

---

### 2️⃣ Kth Largest Element

**📌 Problem:** [215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)

```java
public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int n : nums) {
        minHeap.add(n);
        if (minHeap.size() > k) minHeap.poll();
    }
    return minHeap.peek();
}
```

---

### 3️⃣ Sliding Window Maximum

**📌 Problem:** [239. Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)
*Optimized with deque, but heap version shown here*

```java
public int[] maxSlidingWindow(int[] nums, int k) {
    PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
    int[] res = new int[nums.length - k + 1];

    for (int i = 0; i < nums.length; i++) {
        heap.add(new int[]{nums[i], i});
        if (i >= k - 1) {
            while (heap.peek()[1] <= i - k) heap.poll();
            res[i - k + 1] = heap.peek()[0];
        }
    }
    return res;
}
```

---

### 4️⃣ Merge K Sorted Lists

**📌 Problem:** [23. Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)

```java
public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
    for (ListNode node : lists)
        if (node != null) heap.offer(node);

    ListNode dummy = new ListNode(0), tail = dummy;
    while (!heap.isEmpty()) {
        ListNode curr = heap.poll();
        tail.next = curr;
        tail = curr;
        if (curr.next != null) heap.offer(curr.next);
    }
    return dummy.next;
}
```

---

### 5️⃣ Reorganize String

**📌 Problem:** [767. Reorganize String](https://leetcode.com/problems/reorganize-string/)

```java
public String reorganizeString(String s) {
    int[] freq = new int[26];
    for (char c : s.toCharArray()) freq[c - 'a']++;

    PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    for (int i = 0; i < 26; i++)
        if (freq[i] > 0) heap.offer(new int[]{i, freq[i]});

    StringBuilder sb = new StringBuilder();
    while (heap.size() >= 2) {
        int[] first = heap.poll();
        int[] second = heap.poll();
        sb.append((char)(first[0] + 'a')).append((char)(second[0] + 'a'));
        if (--first[1] > 0) heap.offer(first);
        if (--second[1] > 0) heap.offer(second);
    }

    if (!heap.isEmpty()) {
        if (heap.peek()[1] > 1) return "";
        sb.append((char)(heap.poll()[0] + 'a'));
    }

    return sb.toString();
}
```

---

### 6️⃣ Median from Data Stream

**📌 Problem:** [295. Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/)

```java
class MedianFinder {
    PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> large = new PriorityQueue<>();

    public void addNum(int num) {
        small.add(num);
        large.add(small.poll());
        if (small.size() < large.size()) small.add(large.poll());
    }

    public double findMedian() {
        if (small.size() > large.size()) return small.peek();
        return (small.peek() + large.peek()) / 2.0;
    }
}
```

---

### 7️⃣ Dijkstra’s Shortest Path

**📌 Problem:** [743. Network Delay Time](https://leetcode.com/problems/network-delay-time/)

```java
public int networkDelayTime(int[][] times, int n, int k) {
    List<int[]>[] graph = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();
    for (int[] time : times)
        graph[time[0]].add(new int[]{time[1], time[2]});

    int[] dist = new int[n + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[k] = 0;

    PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    heap.offer(new int[]{k, 0});

    while (!heap.isEmpty()) {
        int[] curr = heap.poll();
        int u = curr[0], d = curr[1];
        if (d > dist[u]) continue;
        for (int[] nei : graph[u]) {
            int v = nei[0], w = nei[1];
            if (dist[v] > dist[u] + w) {
                dist[v] = dist[u] + w;
                heap.offer(new int[]{v, dist[v]});
            }
        }
    }

    int max = Arrays.stream(dist, 1, n + 1).max().getAsInt();
    return max == Integer.MAX_VALUE ? -1 : max;
}
```

---

## 🗓️ 7-Day Heap Study Plan (FAANG Style)

| Day   | Focus                         | Problems |
| ----- | ----------------------------- | -------- |
| Day 1 | **Heap Basics + Kth Largest** | 215, 703 |
| Day 2 | **Top K Elements**            | 347, 692 |
| Day 3 | **Sliding Window + Heaps**    | 239, 480 |
| Day 4 | **Merging Sorted Data**       | 23, 378  |
| Day 5 | **Heap + Frequency**          | 767, 621 |
| Day 6 | **Streaming Median**          | 295      |
| Day 7 | **Graphs + Heap (Dijkstra)**  | 743, 787 |

---

## 📌 Summary

| Pattern               | Core Skill                   |
| --------------------- | ---------------------------- |
| Min/Max Heap          | Efficient top element access |
| Custom Comparator     | Sort by frequency/value      |
| Double Heap           | Median problems              |
| Heap + Graph          | Dijkstra’s Algorithm         |
| Heap + Sliding Window | Dynamic window max/min       |

