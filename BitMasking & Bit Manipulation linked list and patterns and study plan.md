# BitMasking & Bit Manipulation linked list and patterns and study plan

Here’s your complete guide to **Bit Manipulation & Bitmasking** — along with **patterns**, **Linked List applications (if any)**, and a **focused study plan** ideal for interviews like FAANG.

---

# 📚 Bit Manipulation & Bitmasking: Patterns & Study Plan

---

## 🧠 What is Bit Manipulation?

Bit manipulation refers to using **bitwise operations** (like `&`, `|`, `^`, `~`, `<<`, `>>`) to solve problems **efficiently** — often in O(1) time for certain operations.

It's widely used in:

* Optimization
* Subset generation
* Math tricks
* Bitmask DP
* Graphs (on small sets)
* Hashing, compression, permissions

---

## 🧩 Common Bitwise Operators

| Operator    | Symbol | Description               |                            |
| ----------- | ------ | ------------------------- | -------------------------- |
| AND         | `&`    | 1 only if both bits are 1 |                            |
| OR          | \`     | \`                        | 1 if at least one bit is 1 |
| XOR         | `^`    | 1 if bits are different   |                            |
| NOT         | `~`    | Inverts the bits          |                            |
| Left Shift  | `<<`   | Multiply by 2             |                            |
| Right Shift | `>>`   | Divide by 2               |                            |

---

## 🔁 Bit Manipulation Patterns

| # | Pattern                          | Example Problem                                                                                          | Description                                |
| - | -------------------------------- | -------------------------------------------------------------------------------------------------------- | ------------------------------------------ |
| 1 | **Find Unique Element**          | [Single Number (136)](https://leetcode.com/problems/single-number/)                                      | Use XOR to cancel duplicates               |
| 2 | **Check Set Bit**                | [Power of Two (231)](https://leetcode.com/problems/power-of-two/)                                        | `n & (n-1) == 0`                           |
| 3 | **Count Set Bits**               | [191. Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/)                                 | Use `n & (n-1)` repeatedly                 |
| 4 | **Bitmask Enumeration**          | [Subsets (78)](https://leetcode.com/problems/subsets/)                                                   | Loop through `1 << n` subsets              |
| 5 | **Bitmask DP**                   | [698. Partition to K Equal Sum Subsets](https://leetcode.com/problems/partition-to-k-equal-sum-subsets/) | Store state as bitmask                     |
| 6 | **Swap Bits / Reverse Bits**     | [190. Reverse Bits](https://leetcode.com/problems/reverse-bits/)                                         | Use bit shifts                             |
| 7 | **Graph/Matching on Small Sets** | [691. Stickers to Spell Word](https://leetcode.com/problems/stickers-to-spell-word/)                     | DP with bitmask states                     |
| 8 | **Linked List XOR Trick**        | Rare, low-level memory trick                                                                             | XOR of prev and next stored in one pointer |

---

### ✅ Example 1: Find Unique Number using XOR (136)

```java
public int singleNumber(int[] nums) {
    int result = 0;
    for (int num : nums) {
        result ^= num;
    }
    return result;
}
```

---

### ✅ Example 2: Check Power of Two (231)

```java
public boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
}
```

---

### ✅ Example 3: Generate All Subsets (78)

```java
public List<List<Integer>> subsets(int[] nums) {
    int n = nums.length;
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < (1 << n); i++) {
        List<Integer> subset = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if ((i & (1 << j)) != 0) {
                subset.add(nums[j]);
            }
        }
        res.add(subset);
    }
    return res;
}
```

---

## ⚙️ Advanced Applications

* **Bitmask DP**: Represent state with bits, like subset visited
* **Permission Systems**: Encode permission flags
* **Optimization**: Speed up comparisons/counting
* **Graph problems**: Where node set is small (`n <= 16`)

---

## 💡 Bit Manipulation in Linked Lists?

While not common in standard problems, **Linked List XOR trick** (used in low-level memory-efficient systems) stores:

```
node.npx = XOR(prev_pointer, next_pointer)
```

But this is **not recommended** in high-level languages like Java or Python due to lack of pointer manipulation.

---

## 🗓️ 7-Day Bit Manipulation Study Plan

| Day   | Focus                   | Problems              |
| ----- | ----------------------- | --------------------- |
| Day 1 | Basics: XOR, AND, OR    | 136, 137              |
| Day 2 | Power of Two & Set Bits | 191, 231, 326         |
| Day 3 | Subsets & Enumeration   | 78, 90                |
| Day 4 | Bitmask DP Intro        | 416, 698              |
| Day 5 | Reverse/Swap Bits       | 190, 201              |
| Day 6 | Advanced DP / Graph     | 691, 847              |
| Day 7 | Mock/Review             | Pick 3 mixed problems |

---

## 🚀 Bonus Bit Tricks

| Task                       | Bit Trick       |            |
| -------------------------- | --------------- | ---------- |
| Turn off rightmost set bit | `n & (n-1)`     |            |
| Check if nth bit is set    | `n & (1 << k)`  |            |
| Set nth bit                | \`n             | (1 << k)\` |
| Clear nth bit              | `n & ~(1 << k)` |            |
| Toggle nth bit             | `n ^ (1 << k)`  |            |

---

## 🧪 Bit Masking Interview Questions (Must-Practice)

| Problem                               | Type                       |
| ------------------------------------- | -------------------------- |
| 268. Missing Number                   | XOR Trick                  |
| 421. Max XOR of Two Numbers           | Trie + Bitmask             |
| 78. Subsets                           | Bitmask Enumeration        |
| 1870. Minimum Speed to Arrive on Time | Binary Search + Bit        |
| 318. Maximum Product of Word Lengths  | Word Encoding with Bitmask |

---

## ✅ Summary

* Bit Manipulation is **fast**, **memory efficient**, and **powerful**
* Core to **subset generation**, **DP optimization**, **XOR-based logic**
* Important in **low-level**, **competitive programming**, and **interview problems**

---

Let me know your preferred format or next topic you'd like to cover (e.g., Trees, Tries, SegTrees).
