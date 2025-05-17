
# 🌀 Type Casting in Java – Full Guide

## 🔍 What is Type Casting?

**Type casting** in Java is the process of **converting one data type into another**.  
Java is a statically typed language, so **you must tell it explicitly** when you're converting between **incompatible types**.

---

## 🧭 Two Types of Type Casting

### 1. Widening Casting (Automatic / Implicit)
- Converts **smaller type to larger type**
- **Safe** because no data is lost

| From | To |
|------|----|
| byte | short, int, long, float, double |
| short | int, long, float, double |
| char | int, long, float, double |
| int | long, float, double |
| long | float, double |
| float | double |

```java
int a = 10;
double b = a; // implicit casting: int to double
System.out.println(b); // Output: 10.0
```

### 2. Narrowing Casting (Manual / Explicit)
- Converts **larger type to smaller type**
- **Can lose data** or cause errors

```java
double x = 9.78;
int y = (int) x; // explicit casting: double to int
System.out.println(y); // Output: 9
```

---

## 💡 Real-World Analogy

- **Widening** = pouring water from a cup into a bucket (safe)
- **Narrowing** = pouring water from a bucket into a cup (may overflow)

---

###### Note : Beginners can skip from here as to understand this you should have a basic knowledge of OOPs

## 📦 Casting Between Reference Types (Objects)

### 1. Upcasting (Automatic) child class --> parent class
```java
class Animal {}
class Dog extends Animal {}

Animal a = new Dog(); // upcasting
```

### 2. Downcasting (Manual) parent class --> child class
```java
Animal a = new Dog();
if (a instanceof Dog) {
    Dog d = (Dog) a;
}
```

---

## ⚠️ Common Mistakes

| Mistake | Result |
|---------|--------|
| Casting without checking | ClassCastException |
| Too much narrowing | Overflow or truncation |
| Incompatible references | Compile-time error |

```java
int large = 130;
byte small = (byte) large;
System.out.println(small); // Output: -126
```

---

## 📜 Summary Cheat Sheet

| Casting Type | Direction | Automatic? | Risky? | Example |
|--------------|-----------|-------------|--------|---------|
| Widening | Small → Large | Yes | No | int to double |
| Narrowing | Large → Small | No | Yes | double to int |
| Upcasting | Child → Parent | Yes | No | Dog to Animal |
| Downcasting | Parent → Child | No | Yes | Animal to Dog |

---

## 🧪 Practice Challenge

What will be the output?

```java
float f = 123.456f;
int i = (int) f;
System.out.println(i);
```

➡️ Answer: `123` (fractional part is truncated)


##### Note : there's a pdf of practise questions for type casting is available with this folder , to open a pdf in vsCode u can download vscode-pdf extension
