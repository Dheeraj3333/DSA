
# ➕ Operators in Java – Full Guide

## 🔍 What Are Operators?

**Operators** in Java are special symbols used to perform operations on variables and values.

---

## 🧮 Types of Operators

### 1. Arithmetic Operators
Used to perform basic arithmetic operations.

| Operator | Description        | Example        | Result      |
|----------|--------------------|----------------|-------------|
| `+`      | Addition            | `10 + 5`       | `15`        |
| `-`      | Subtraction         | `10 - 5`       | `5`         |
| `*`      | Multiplication      | `10 * 5`       | `50`        |
| `/`      | Division            | `10 / 5`       | `2`         |
| `%`      | Modulus (remainder) | `10 % 3`       | `1`         |

###### **Note** : java doesn't have a exponential operator like other languages have (**) , to do exponential operator you can use Math.pow(base,power) comes from java.lang.Math package

---

### 2. Relational (Comparison) Operators
Used to compare two values.

| Operator | Description       | Example       | Result      |
|----------|-------------------|---------------|-------------|
| `==`     | Equal to          | `5 == 5`      | `true`      |
| `!=`     | Not equal to      | `5 != 3`      | `true`      |
| `>`      | Greater than      | `5 > 3`       | `true`      |
| `<`      | Less than         | `5 < 3`       | `false`     |
| `>=`     | Greater or equal  | `5 >= 5`      | `true`      |
| `<=`     | Less or equal     | `5 <= 6`      | `true`      |

---

### 3. Logical Operators
Used to perform logical operations.

| Operator | Description           | Example               | Result      |
|----------|-----------------------|------------------------|-------------|
| `&&`     | Logical AND           | `true && false`       | `false`     |
| `||`     | Logical OR            | `true || false`       | `true`      |
| `!`      | Logical NOT           | `!true`               | `false`     |

---

### 4. Assignment Operators
Used to assign values to variables.

| Operator | Description            | Example        | Equivalent To      |
|----------|------------------------|----------------|--------------------|
| `=`      | Assign                 | `a = 5`        | —                  |
| `+=`     | Add and assign         | `a += 5`       | `a = a + 5`        |
| `-=`     | Subtract and assign    | `a -= 5`       | `a = a - 5`        |
| `*=`     | Multiply and assign    | `a *= 5`       | `a = a * 5`        |
| `/=`     | Divide and assign      | `a /= 5`       | `a = a / 5`        |
| `%=`     | Modulus and assign     | `a %= 5`       | `a = a % 5`        |

---

### 5. Unary Operators
Work with only one operand.

| Operator | Description        | Example       | Result     |
|----------|--------------------|---------------|------------|
| `+`      | Unary plus         | `+a`          | `+a`       |
| `-`      | Unary minus        | `-a`          | `-a`       |
| `++`     | Increment           | `a++` or `++a`| `a+1`      |
| `--`     | Decrement           | `a--` or `--a`| `a-1`      |
| `!`      | Logical NOT         | `!true`       | `false`    |

---

### 6. Bitwise Operators
Operate on bits and perform bit-by-bit operations.

| Operator | Description       | Example   |
|----------|-------------------|-----------|
| `&`      | Bitwise AND       | `a & b`   |
| `\|`     | Bitwise OR       | `a \| b`   |
| `^`      | Bitwise XOR       | `a ^ b`   |
| `~`      | Bitwise Complement| `~a`      |
| `<<`     | Left Shift        | `a << 2`  |
| `>>`     | Right Shift       | `a >> 2`  |

---

### 7. Ternary Operator
A shorthand for `if-else`.

```java
int result = (a > b) ? a : b;
```

---

### 8. Instanceof Operator
Checks if an object is an instance of a specific class.

```java
if (obj instanceof String) {
    // true if obj is a String
}
```

---

## 🧪 Practice Questions

1. What is the output of `5 + 3 * 2`?
2. What does `a &= b` mean?
3. How do you write a ternary operation to find the minimum of two numbers?
4. What is the difference between `==` and `equals()` in Java?

---

## 📝 Summary

Operators are building blocks for logic and calculation in Java. Learn how each one behaves to write clean and correct code.
