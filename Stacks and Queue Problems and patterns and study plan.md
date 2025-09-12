# Stacks and Queue Problems and patterns and study plan
Sure! Here’s a complete breakdown of **Stacks and Queues** — their core **patterns**, example solutions, and a **study plan** to master them quickly for FAANG-style interviews.

---

# 📚 Stacks & Queues: Patterns, Solutions & Study Plan

---

## 🔑 Key Patterns for Stacks & Queues

| # | Pattern                             | Description                                                               | Example Problem                         |
| - | ----------------------------------- | ------------------------------------------------------------------------- | --------------------------------------- |
| 1 | **Basic Stack Operations**          | Push, Pop, Peek to solve balanced parentheses, etc.                       | Valid Parentheses (20)                  |
| 2 | **Monotonic Stack**                 | Maintain increasing or decreasing order for next greater/smaller elements | Next Greater Element (496)              |
| 3 | **Stack for Expression Evaluation** | Evaluate postfix/infix expressions or simplify paths                      | Evaluate Reverse Polish Notation (150)  |
| 4 | **Sliding Window Maximum (Deque)**  | Use deque to find max/min in sliding windows                              | Sliding Window Maximum (239)            |
| 5 | **Queue Using Stacks**              | Implement queue with two stacks and vice versa                            | Implement Queue Using Stacks (232)      |
| 6 | **Circular Queue**                  | Handle wrap-around in fixed size queue                                    | Design Circular Queue (622)             |
| 7 | **Using Queue for BFS**             | Graph/tree traversal with queue                                           | Binary Tree Level Order Traversal (102) |
| 8 | **Stack + Backtracking**            | Use stack to simulate recursion or backtracking states                    | Basic Calculator (224)                  |

---

## 📌 8 Stack & Queue Patterns with Java Solutions (Concise)

---

### 1️⃣ Basic Stack: Valid Parentheses

**Problem:** [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

```java
public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
        if (c == '(') stack.push(')');
        else if (c == '{') stack.push('}');
        else if (c == '[') stack.push(']');
        else if (stack.isEmpty() || stack.pop() != c) return false;
    }
    return stack.isEmpty();
}
```

---

### 2️⃣ Monotonic Stack: Next Greater Element

**Problem:** [496. Next Greater Element I](https://leetcode.com/problems/next-greater-element-i/)

```java
public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    Stack<Integer> stack = new Stack<>();
    for (int num : nums2) {
        while (!stack.isEmpty() && stack.peek() < num) {
            map.put(stack.pop(), num);
        }
        stack.push(num);
    }
    int[] res = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
        res[i] = map.getOrDefault(nums1[i], -1);
    }
    return res;
}
```

---

### 3️⃣ Expression Evaluation: Evaluate Reverse Polish Notation

**Problem:** [150. Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/)

```java
public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for (String t : tokens) {
        if ("+".equals(t)) {
            stack.push(stack.pop() + stack.pop());
        } else if ("-".equals(t)) {
            int b = stack.pop(), a = stack.pop();
            stack.push(a - b);
        } else if ("*".equals(t)) {
            stack.push(stack.pop() * stack.pop());
        } else if ("/".equals(t)) {
            int b = stack.pop(), a = stack.pop();
            stack.push(a / b);
        } else {
            stack.push(Integer.parseInt(t));
        }
    }
    return stack.pop();
}
```

---

### 4️⃣ Sliding Window Maximum (Deque)

**Problem:** [239. Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)

```java
public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> deque = new LinkedList<>();
    int[] res = new int[nums.length - k + 1];
    int idx = 0;
    for (int i = 0; i < nums.length; i++) {
        while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) deque.pollFirst();
        while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
        deque.offerLast(i);
        if (i >= k - 1) res[idx++] = nums[deque.peekFirst()];
    }
    return res;
}
```

---

### 5️⃣ Queue Using Two Stacks

**Problem:** [232. Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/)

```java
class MyQueue {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek();
        return output.pop();
    }

    public int peek() {
        if (output.isEmpty())
            while (!input.isEmpty()) output.push(input.pop());
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
```

---

### 6️⃣ Circular Queue Implementation

**Problem:** [622. Design Circular Queue](https://leetcode.com/problems/design-circular-queue/)
*(Skip full code here, but essential to know fixed size + mod for index wraparound)*

---

### 7️⃣ Queue for BFS: Level Order Traversal

**Problem:** [102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)

```java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;

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
        res.add(level);
    }
    return res;
}
```

---

### 8️⃣ Stack + Backtracking: Basic Calculator

**Problem:** [224. Basic Calculator](https://leetcode.com/problems/basic-calculator/)
*(Use stack to handle parentheses and intermediate sums, skipping full code here for brevity)*

---

## 🗓️ 7-Day Study Plan for Stacks & Queues

| Day   | Focus Area                          | Problems to Solve                                                         |
| ----- | ----------------------------------- | ------------------------------------------------------------------------- |
| Day 1 | Basic Stack Ops                     | 20 (Valid Parentheses), 155 (Min Stack)                                   |
| Day 2 | Monotonic Stack                     | 496 (Next Greater Element), 503 (Next Greater Element II)                 |
| Day 3 | Expression Evaluation               | 150 (Reverse Polish Notation), 224 (Basic Calculator)                     |
| Day 4 | Sliding Window + Deque              | 239 (Sliding Window Maximum), 862 (Shortest Subarray with Sum at Least K) |
| Day 5 | Queue Using Stacks & Circular Queue | 232, 225 (Implement Stack using Queues), 622 (Circular Queue)             |
| Day 6 | BFS with Queue                      | 102 (Level Order), 107 (Level Order Bottom), 199 (Right Side View)        |
| Day 7 | Mixed Mock                          | Pick 3 from above and do timed solving + review                           |

---

## 💡 Tips for Mastery

* Visualize stack/queue operations on paper.
* Dry-run tricky inputs to understand flow.
* Learn to optimize monotonic stack usage (common in histogram, rainwater trap).
* Practice coding queue with two stacks & stack with two queues till fluent.
* Combine BFS with queue problems to recognize the pattern quickly.

---
