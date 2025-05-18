
# 🔁 Conditional Statements and Loops in Java – Full Guide

---

## ✅ Conditional Statements

Conditional statements allow your program to make decisions based on **boolean conditions** (`true` or `false`).

### 1. if Statement
Executes code if a condition is true.

```java
if (condition) {
    // code block
}
```

🔸 Example:
```java
int age = 18;
if (age >= 18) {
    System.out.println("You can vote!");
}
```

---

### 2. if-else Statement
Chooses between two blocks based on a condition.

```java
if (condition) {
    // true block
} else {
    // false block
}
```

🔸 Example:
```java
int number = 5;
if (number % 2 == 0) {
    System.out.println("Even");
} else {
    System.out.println("Odd");
}
```

---

### 3. if-else if-else Ladder
Checks multiple conditions.

```java
if (condition1) {
    // block 1
} else if (condition2) {
    // block 2
} else {
    // fallback block
}
```

---

### 4. switch Statement
Simplifies decision-making for multiple exact matches.

```java
switch (expression) {
    case value1:
        // code
        break;
    case value2:
        // code
        break;
    default:
        // fallback
}
```

🔸 Example:
```java
int day = 2;
switch (day) {
    case 1: System.out.println("Monday"); break;
    case 2: System.out.println("Tuesday"); break;
    default: System.out.println("Other day");
}
```

---

## 🔁 Loops in Java

Loops allow you to **execute a block of code repeatedly**.

---

### 1. for Loop
Used when number of iterations is known.

```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```

---

### 2. while Loop
Used when condition is checked **before** execution.

```java
int i = 0;
while (i < 5) {
    System.out.println(i);
    i++;
}
```

---

### 3. do-while Loop
Condition is checked **after** the first execution.

```java
int i = 0;
do {
    System.out.println(i);
    i++;
} while (i < 5);
```

---

### 4. for-each Loop (Enhanced for loop)
Used to iterate over arrays or collections.

```java
int[] numbers = {1, 2, 3, 4};
for (int num : numbers) {
    System.out.println(num);
}
```

---

## ⛔ Loop Control Statements

### break
Stops the loop entirely.

```java
for (int i = 0; i < 10; i++) {
    if (i == 5) break;
    System.out.println(i);
}
```

### continue
Skips the current iteration and continues with the next.

```java
for (int i = 0; i < 10; i++) {
    if (i % 2 == 0) continue;
    System.out.println(i); // prints odd numbers
}
```

---

## 🧪 Practice Questions

1. Write a program to check if a number is positive, negative or zero.
2. Write a loop that prints numbers from 1 to 100 but stops at 45.
3. Write a program that uses `switch` to print the month name based on number (1-12).
4. Print all even numbers from 1 to 50 using a `for` loop.

---

## 📝 Summary

| Concept       | Use Case                                      |
|---------------|-----------------------------------------------|
| `if`          | Single condition                              |
| `if-else`     | Either-or decision                            |
| `else-if`     | Multiple conditions                           |
| `switch`      | Many fixed values                             |
| `for`         | Fixed repetitions                             |
| `while`       | Repeat with pre-condition                     |
| `do-while`    | Repeat with post-condition                    |
| `for-each`    | Collection/array traversal                    |
| `break`       | Exit loop                                     |
| `continue`    | Skip iteration                                |
