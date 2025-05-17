
# 🎁 Wrapper Classes in Java – Complete Guide

## ✅ What Are Wrapper Classes?

A **wrapper class** in Java is an **object representation of a primitive data type**.

Java is an object-oriented language, but its 8 primitive data types (`int`, `char`, `boolean`, etc.) are not objects.  
To treat them like objects (e.g., for use in collections like `ArrayList`, or for using methods), we use **wrapper classes**.

---

## 📦 List of Wrapper Classes

| Primitive Type | Wrapper Class |
|----------------|----------------|
| `byte`         | `Byte`         |
| `short`        | `Short`        |
| `int`          | `Integer`      |
| `long`         | `Long`         |
| `float`        | `Float`        |
| `double`       | `Double`       |
| `char`         | `Character`    |
| `boolean`      | `Boolean`      |

---

## 🧪 Example: Wrapping and Unwrapping

```java
int num = 5;

// Boxing (primitive → object)
Integer obj = Integer.valueOf(num);

// Unboxing (object → primitive)
int newNum = obj.intValue();

System.out.println(obj);     // Output: 5
System.out.println(newNum);  // Output: 5
```

---

## 🔁 Autoboxing and Unboxing (Automatic Conversion)

Java makes life easier by converting between primitives and wrapper objects automatically.

### Autoboxing:
```java
int x = 10;
Integer xObj = x; // Java automatically converts to Integer
```

### Unboxing:
```java
Integer yObj = 20;
int y = yObj; // Java automatically converts to int
```

---

## 💡 Why Use Wrapper Classes?

1. ✅ **Collections (e.g., ArrayList)** only work with objects:
   ```java
   ArrayList<Integer> list = new ArrayList<>();
   list.add(10); // Cannot use 'int', must use 'Integer'
   ```

2. ✅ **Nullability** – primitives can't be `null`, objects can:
   ```java
   Integer i = null; // ok
   int j = null;     // ❌ error
   ```

3. ✅ **Utility methods** (parsing, conversion):
   ```java
   int n = Integer.parseInt("123");
   ```

---

## 📝 Summary

| Concept        | Meaning                                |
|----------------|-----------------------------------------|
| Wrapper Class  | Object form of a primitive              |
| Boxing         | Primitive → Object                      |
| Unboxing       | Object → Primitive                      |
| Autoboxing     | Automatic boxing                       |
| Use Cases      | Collections, nulls, utility methods     |

---

## 🧪 Mini Quiz

**Q1:** What is the wrapper class for `boolean`?  
**Q2:** Will this code work? Why?
```java
ArrayList<int> list = new ArrayList<>();
```

**solution2** as java's generic types like ArrayList<T> are designed to work with reference types (objects) and as int is primitive ,so this code doesn't work.

**correct code**
```java
ArrayList<Integer> list = new ArrayList<>();
