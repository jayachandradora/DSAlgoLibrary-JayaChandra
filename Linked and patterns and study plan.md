# Linked and patterns and study plan

Great! Here's a complete guide to mastering **Linked Lists & Doubly Linked Lists** — essential for FAANG interviews and common in both algorithmic and systems design questions.

---

# 📚 Linked List & Doubly Linked List: Patterns & Study Plan

---

## 🔧 Why Linked Lists Matter

Linked Lists are important because they:

* Enable efficient insertions/deletions (O(1))
* Form the basis for many advanced data structures (LRU cache, trees, graphs)
* Are commonly used in pointer-based problems

---

## 🔁 Core Patterns in Linked List Problems

| # | Pattern                      | Description                        | Example Problem                                                                                                   |
| - | ---------------------------- | ---------------------------------- | ----------------------------------------------------------------------------------------------------------------- |
| 1 | **Reversal**                 | Reverse entire or part of a list   | [206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)                                    |
| 2 | **Two Pointers (Fast/Slow)** | Detect cycles, middle nodes, etc.  | [141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)                                        |
| 3 | **Merge**                    | Merge two sorted lists             | [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)                               |
| 4 | **Rearrange Nodes**          | Reorder, rotate, partition lists   | [92. Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/)                               |
| 5 | **Dummy Node Technique**     | Simplifies head operations         | [82. Remove Duplicates from Sorted List II](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/) |
| 6 | **Cycle Detection**          | Check loops, intersection          | [142. Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)                                  |
| 7 | **Doubly Linked List**       | Track both previous and next nodes | [146. LRU Cache](https://leetcode.com/problems/lru-cache/)                                                        |

---

## ✅ Key Java Code Snippets

### 🔁 Reverse a Linked List (206)

```java
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
}
```

---

### 🐢🐇 Detect Cycle (141)

```java
public boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) return true;
    }
    return false;
}
```

---

### 🧠 LRU Cache Using Doubly Linked List + HashMap (146)

> Design a data structure with O(1) access and eviction.

* HashMap stores key → Node
* Doubly Linked List tracks order (head = most recent, tail = least)

---

## 🗓️ 7-Day Linked List Study Plan

| Day   | Focus                             | Problems                                       |
| ----- | --------------------------------- | ---------------------------------------------- |
| Day 1 | Basics: Traversal, Insert, Delete | 206, 203                                       |
| Day 2 | Two-Pointer Techniques            | 141, 876                                       |
| Day 3 | Reversal Problems                 | 206, 92, 234                                   |
| Day 4 | Merge & Sort Lists                | 21, 23, 148                                    |
| Day 5 | Cycle Detection & Intersection    | 141, 142, 160                                  |
| Day 6 | Advanced Manipulations            | 19, 86, 143                                    |
| Day 7 | Doubly Linked List & Design       | 146 (LRU Cache), 432 (All O(1) Data Structure) |

---

## 🧠 Extra Challenges for Mastery

| Problem                        | Type              | Link                                                                    |
| ------------------------------ | ----------------- | ----------------------------------------------------------------------- |
| 25. Reverse Nodes in K-Group   | Advanced reversal | [Link](https://leetcode.com/problems/reverse-nodes-in-k-group/)         |
| 148. Sort List                 | Merge sort        | [Link](https://leetcode.com/problems/sort-list/)                        |
| 160. Intersection of Two Lists | Cycle-style       | [Link](https://leetcode.com/problems/intersection-of-two-linked-lists/) |

---

## 🔄 Common Doubly Linked List Use-Cases

| Use Case       | Description                             |
| -------------- | --------------------------------------- |
| LRU Cache      | Remove least recently used item in O(1) |
| Navigable List | "Back and forward" navigation           |
| Undo/Redo      | Track history both ways                 |

---

## 🧠 Tips for Linked List Problems

* Use a **dummy node** to simplify head/tail edge cases.
* Practice **fast/slow pointer** logic until intuitive.
* For **reverse problems**, always **track three pointers**: `prev`, `curr`, `next`.
* **Dry-run** on paper — visualization helps a lot.

---

## 📘 Summary

| Feature     | Singly LL  | Doubly LL                             |
| ----------- | ---------- | ------------------------------------- |
| Direction   | One way    | Both ways                             |
| Extra space | Minimal    | More (prev & next)                    |
| Use-cases   | Algorithms | Systems design (e.g., cache, history) |

---
