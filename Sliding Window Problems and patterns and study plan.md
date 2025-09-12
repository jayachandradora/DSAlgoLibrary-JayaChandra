# Sliding Window Problems and patterns and study plan

Absolutely! Here's a **comprehensive guide** to **Sliding Window** problems, including:

* 🔁 Common **patterns**
* 🧠 Strategy to recognize and solve them
* ✅ One solved example per pattern (Java-style)
* 📅 **7-day study plan** for focused practice

---

# 📚 Sliding Window: Problems, Patterns & Study Plan

---

## 🔑 What is Sliding Window?

Sliding Window is a technique used to **reduce time complexity** when solving problems involving **subarrays/substrings**, by maintaining a moving window over the data and updating it dynamically.

---

## 🔁 Core Sliding Window Patterns

| # | Pattern                                          | Use Case                                        | Example Problem                                                                                                                 |
| - | ------------------------------------------------ | ----------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------- |
| 1 | **Fixed-size Window**                            | Max/min/sum of window of size `k`               | [Max Sum of Subarray of Size K](https://leetcode.com/problems/maximum-average-subarray-i/)                                      |
| 2 | **Dynamic-size Window**                          | Longest/shortest substring with some constraint | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) |
| 3 | **Sliding Window Maximum**                       | Max/min in every window (optimized with Deque)  | [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)                                                 |
| 4 | **Minimum/Longest Substring Containing Pattern** | Use HashMap/Frequency Count                     | [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)                                             |
| 5 | **Counting Occurrences in Window**               | Find permutation/anagram/count in substrings    | [Permutation in String](https://leetcode.com/problems/permutation-in-string/)                                                   |
| 6 | **Variable k Constraint**                        | Replace/substitute to meet constraint           | [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)               |
| 7 | **Prefix Sum + Window**                          | Window with advanced calculations               | [Shortest Subarray with Sum at Least K](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/)                   |

---

## ✅ Sample Problems & Java Solutions

---

### 1️⃣ Fixed-size Window

**📌 Problem:** [643. Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/)

```java
public double findMaxAverage(int[] nums, int k) {
    double sum = 0;
    for (int i = 0; i < k; i++) sum += nums[i];
    double max = sum;

    for (int i = k; i < nums.length; i++) {
        sum += nums[i] - nums[i - k];
        max = Math.max(max, sum);
    }

    return max / k;
}
```

---

### 2️⃣ Dynamic-size Window

**📌 Problem:** [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

```java
public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int left = 0, maxLen = 0;

    for (int right = 0; right < s.length(); right++) {
        while (set.contains(s.charAt(right)))
            set.remove(s.charAt(left++));
        set.add(s.charAt(right));
        maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
}
```

---

### 3️⃣ Sliding Window Maximum (with Deque)

**📌 Problem:** [239. Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)

```java
public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> dq = new LinkedList<>();
    int[] res = new int[nums.length - k + 1];

    for (int i = 0; i < nums.length; i++) {
        while (!dq.isEmpty() && dq.peek() < i - k + 1) dq.poll();
        while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();
        dq.offer(i);
        if (i >= k - 1) res[i - k + 1] = nums[dq.peek()];
    }

    return res;
}
```

---

### 4️⃣ Minimum Window Substring

**📌 Problem:** [76. Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)

> Use two hash maps (target and window), and a match counter to contract/expand window

---

### 5️⃣ Find Anagrams in a String

**📌 Problem:** [438. Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/)

> Fixed size, use `char[]` frequency for quick comparison

---

### 6️⃣ Longest Repeating Character Replacement

**📌 Problem:** [424. Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)

> Dynamic window, track most frequent char, shrink when needed

---

### 7️⃣ Shortest Subarray with Sum ≥ K

**📌 Problem:** [862. Shortest Subarray with Sum at Least K](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/)

> Use prefix sums + deque (advanced)

---

## 🗓️ 7-Day Sliding Window Study Plan

| Day   | Focus                         | Problems                 |
| ----- | ----------------------------- | ------------------------ |
| Day 1 | **Fixed-size windows**        | 643, 1695                |
| Day 2 | **Dynamic windows**           | 3, 424                   |
| Day 3 | **Anagram & Pattern Match**   | 567, 438                 |
| Day 4 | **Minimum Substring**         | 76, 340                  |
| Day 5 | **Max in Window (Deque)**     | 239, 480                 |
| Day 6 | **Prefix Sum Window**         | 862, 325                 |
| Day 7 | **Mock Day / Mixed Practice** | Pick 3 random from above |

---

## 🔥 Pro Tips

* Always ask: **Fixed size or dynamic?**
* Use **HashMap or int\[26]** for char frequency
* **Deque** helps in keeping monotonic max/min windows
* Practice **dry runs** to solidify intuition

---

