
# 📚 Arrays and Strings in Java – Deep Explanation

---

## 🔢 PART 1: Arrays in Java

### ✅ What is an Array?
An **array** is a **container object** that holds a fixed number of values of a **single type**.  
Think of it as a **row of lockers**, each holding one item, and each with an index.

---

### 🧱 Declaration and Initialization

```java
int[] numbers = new int[5];           // Declaration + memory allocation
int[] values = {10, 20, 30, 40, 50};  // Declaration + initialization
```

- `int[]` is an array of integers.
- Indexing starts from `0`.

---

### 🔁 Accessing Elements

```java
System.out.println(numbers[0]);  // Access first element
numbers[2] = 100;                // Update third element
```

---

### 📏 Array Length

```java
int len = numbers.length;  // Gives number of elements
```

> 🚨 Note: `length` is a **property**, not a method (no `()`).

---

### 🔄 Iterating Through Arrays

#### Using for loop:
```java
for (int i = 0; i < values.length; i++) {
    System.out.println(values[i]);
}
```

#### Using for-each loop:
```java
for (int val : values) {
    System.out.println(val);
}
```

---

### 🧠 Important Array Concepts

- Arrays are **zero-indexed**.
- Arrays are **objects** in Java.
- You must **define size** when using `new`.
- Once created, array size is **fixed**.
- Java provides `Arrays` utility class for common operations like sorting and searching.

---

## 🧪 Example: Finding Max in an Array

```java
int[] nums = {3, 7, 2, 9, 4};
int max = nums[0];

for (int i = 1; i < nums.length; i++) {
    if (nums[i] > max) {
        max = nums[i];
    }
}
System.out.println("Max = " + max);
```

---

## 🔠 PART 2: Strings in Java

### ✅ What is a String?
A **String** is a sequence of characters.  
In Java, `String` is an **object** of the `String` class, not a primitive data type.

---

### 📦 Declaring Strings

```java
String name = "Alice";
String message = new String("Hello");
```

---

### 🔄 String Immutability

Strings in Java are **immutable** — once created, they cannot be changed.  
Every modification creates a **new object**.

```java
String s = "Java";
s.concat(" Rocks");   // Does NOT change s
System.out.println(s); // Still "Java"
```

---

### 🔧 Common String Methods

| Method              | Description                        |
|---------------------|------------------------------------|
| `length()`          | Returns string length              |
| `charAt(index)`     | Returns character at index         |
| `substring(start, end)` | Extracts substring           |
| `equals()`          | Compares content (case-sensitive)  |
| `equalsIgnoreCase()`| Compares ignoring case             |
| `toUpperCase()`     | Converts to uppercase              |
| `toLowerCase()`     | Converts to lowercase              |
| `indexOf()`         | Finds index of substring/char      |
| `replace()`         | Replaces characters                 |
| `trim()`            | Removes leading/trailing spaces    |

---

### 🧪 Example: Palindrome Check

```java
String word = "madam";
String reversed = "";

for (int i = word.length() - 1; i >= 0; i--) {
    reversed += word.charAt(i);
}

if (word.equals(reversed)) {
    System.out.println("Palindrome");
} else {
    System.out.println("Not Palindrome");
}
```

---

### 🔄 StringBuilder (Mutable Strings)

For efficient string manipulations (especially in loops), use `StringBuilder`.

```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
System.out.println(sb.toString());  // Output: Hello World
```

---

## 📌 Arrays vs. Strings – Summary Table

| Feature           | Array                         | String                       |
|------------------|-------------------------------|------------------------------|
| Type             | Data structure                | Class/Object                 |
| Mutability       | Mutable                       | Immutable                    |
| Storage          | Elements of same type         | Sequence of characters       |
| Iteration        | With `for`, `for-each` loops  | With `for`, `charAt()`       |
| Tools            | `Arrays` class                | `String`, `StringBuilder`    |

---

## 🧪 Practice Problems

1. Write a program to reverse an array.
2. Count vowels in a string.
3. Find the largest and smallest element in an integer array.
4. Replace all spaces in a string with `_`.

---

## 📝 Summary

- Arrays are **fixed-size containers** for same-type data.
- Strings are **immutable sequences** of characters.
- Use `StringBuilder` for heavy string manipulation.
- Mastering these is key to data handling and algorithm development in Java.

---

## 🛠️ Basic Array Methods and Operations (Using Arrays Class)

Java provides a utility class called `java.util.Arrays` for array operations:

### ✅ Import Arrays Class
```java
import java.util.Arrays;
```

### 🔧 Useful Methods

| Method                            | Description                              |
|-----------------------------------|------------------------------------------|
| `Arrays.toString(array)`          | Prints array contents                    |
| `Arrays.sort(array)`              | Sorts the array in ascending order       |
| `Arrays.copyOf(array, length)`    | Copies part of the array                 |
| `Arrays.equals(arr1, arr2)`       | Compares two arrays for equality         |
| `Arrays.fill(array, value)`       | Fills array with a specific value        |
| `Arrays.binarySearch(array, key)` | Searches for a key in a **sorted** array |

### 🧪 Examples

```java
int[] numbers = {5, 2, 9, 1};

// Print
System.out.println(Arrays.toString(numbers));  // [5, 2, 9, 1]

// Sort
Arrays.sort(numbers);  // [1, 2, 5, 9]

// Fill
Arrays.fill(numbers, 0);  // All elements become 0

// Copy
int[] copy = Arrays.copyOf(numbers, 3);  // First 3 elements

// Compare
boolean isEqual = Arrays.equals(numbers, copy);

// Binary Search (only on sorted arrays)
int index = Arrays.binarySearch(numbers, 5); // Returns index of 5
```

> ✅ These methods simplify many array operations and reduce manual coding effort.
