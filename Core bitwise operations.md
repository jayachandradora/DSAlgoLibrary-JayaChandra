# core bitwise operations

Absolutely! Bitwise problems can be intimidating at first, but they follow **predictable patterns** once you learn what each operation does and how to use it strategically.

Let's break it down into **core bitwise operations**, when and how to use them, and then look at **example patterns** with explanations.

---

## 🧠 Bitwise Operations — Quick Reference

| Operation   | Symbol                          | Description                          | Common Use Cases                      |
| ----------- | ------------------------------- | ------------------------------------ | ------------------------------------- |
| AND         | `&`                             | Bit is `1` if **both** bits are `1`  | Masking bits                          |
| OR          | `\|`                            | Bit is `1` if **either** bit is `1`  | Setting bits                          |
| XOR         | `^`                             | Bit is `1` if bits are **different** | Toggling bits, finding unique numbers |
| NOT         | `~`                             | Inverts the bits (`0` becomes `1`)   | Flipping bits                         |
| Left Shift  | `<<`                            | Shifts bits left, fills with 0       | Multiply by 2                         |
| Right Shift | `>>` (signed), `>>>` (unsigned) | Shifts bits right                    | Divide by 2, remove LSB               |

---

## 🎯 General Patterns & When to Use

---

### ✅ 1. **Check if a specific bit is set**

**Pattern**:

```java
if ((num & (1 << i)) != 0)
    // bit i is set (1)
```

**Explanation**:

* `(1 << i)` sets only the `i-th` bit to 1.
* `num & (1 << i)` will be non-zero only if that bit in `num` is also 1.

**Example**: Is the 3rd bit of `num` set?

```java
int num = 10; // 1010
if ((num & (1 << 3)) != 0) {
    System.out.println("3rd bit is set"); // true
}
```

---

### ✅ 2. **Set a specific bit to 1**

**Pattern**:

```java
num = num | (1 << i);
```

**Explanation**: Ensures the `i-th` bit is turned on regardless of its previous state.

---

### ✅ 3. **Clear (unset) a specific bit**

**Pattern**:

```java
num = num & ~(1 << i);
```

**Explanation**:

* `(1 << i)` sets only the bit you want to clear.
* `~(1 << i)` flips it to 0, keeping other bits as 1.
* `&` keeps other bits unchanged but clears the `i-th` bit.

---

### ✅ 4. **Toggle a specific bit**

**Pattern**:

```java
num = num ^ (1 << i);
```

**Explanation**:

* Flips the `i-th` bit: if it was 1 → 0, and vice versa.

---

### ✅ 5. **Count number of set bits**

**Pattern**:

```java
int count = 0;
while (num != 0) {
    count++;
    num = num & (num - 1); // drops the lowest set bit
}
```

**Explanation**:

* Each time through the loop, removes the rightmost `1` bit.

---

### ✅ 6. **Check if a number is power of 2**

**Pattern**:

```java
(num & (num - 1)) == 0
```

**Condition**: `num > 0`

**Explanation**:

* Powers of 2 in binary have only **one bit set**. e.g. `8 = 1000`, `4 = 0100`
* Subtracting 1 flips all bits **after** the only set bit.

---

### ✅ 7. **Find unique number when all others appear twice**

**Pattern**:

```java
int result = 0;
for (int num : nums) {
    result ^= num;
}
```

**Explanation**:

* `x ^ x = 0`, `x ^ 0 = x`
* All duplicates cancel out, leaving the unique number.

---

### ✅ 8. **Right shift vs unsigned right shift**

```java
int x = -8;
System.out.println(x >> 1);  // signed right shift → keeps sign bit
System.out.println(x >>> 1); // unsigned right shift → fills with 0
```

**Use Case**: `>>>` is used for **bit-level unsigned logic**, especially with **negative numbers**.

---

## 🔍 Real Problem Examples & Their Patterns

---

### 🧩 **Problem 1: First Repeating Character (as you asked earlier)**

**Pattern**:

* Use a bitmask to track characters seen:

```java
int mask = 0;
for (char ch : s.toCharArray()) {
    int bit = 1 << (ch - 'a');
    if ((mask & bit) != 0) return ch;
    mask |= bit;
}
```

---

### 🧩 **Problem 2: Swap two numbers without a temp**

**Pattern (XOR swap)**:

```java
a = a ^ b;
b = a ^ b; // now b = a
a = a ^ b; // now a = b
```

---

### 🧩 **Problem 3: Isolate the lowest set bit**

```java
int lowBit = num & -num;
```

**Example**:
`num = 12 (1100)` → `lowBit = 4 (0100)`

**Use Case**: Optimization, bitmasks in subset problems, Fenwick Trees (BIT).

---

### 🧩 **Problem 4: Check if bitmask is subset of another**

```java
if ((mask1 & mask2) == mask1)
    // mask1 is a subset of mask2
```

Used in:

* Word masks in string problems
* Permissions systems
* Subset relationships

---

## 🧠 Tips to Master Bitwise Thinking

1. **Learn to think in binary** — manually write out binary representations.
2. **Memorize common patterns** (like `x & (x - 1)` for power of 2).
3. **Visualize bits** — try small examples (e.g., 5 = 0101).
4. **Practice problems on LeetCode**:

   * [Single Number](https://leetcode.com/problems/single-number/)
   * [Counting Bits](https://leetcode.com/problems/counting-bits/)
   * [Bitwise AND of Numbers Range](https://leetcode.com/problems/bitwise-and-of-numbers-range/)
   * [Sum of Two Integers](https://leetcode.com/problems/sum-of-two-integers/)

---

## ✅ Summary of Patterns

| Task           | Pattern                  |           
| -------------- | ------------------------ |
| Check bit set  | `num & (1 << i)`         |           
| Set bit        | `num (1 << i)`           |
| Clear bit      | `num & ~(1 << i)`        |           
| Toggle bit     | `num ^ (1 << i)`         |           
| Count bits     | `num & (num - 1)`        |            
| Power of 2     | `(num & (num - 1)) == 0` |            
| Unique element | `x ^ x = 0`              |            
| Isolate LSB    | `x & -x`                 |            

---

Want flashcards, visual diagrams, or exercises based on this? I can help you build those too.

