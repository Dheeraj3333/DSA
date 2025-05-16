
# 📦 Java Packages – Complete Notes

## ✅ What is a Package in Java?

A **package** in Java is like a **folder** or **namespace** that organizes your Java classes.

### Purpose of Packages:
- Prevent **class name conflicts**
- Group related classes together
- Control **access levels** with `public`, `protected`, `private`
- Provide better **modularity and readability**

---

## 🧱 Types of Packages

1. **Built-in Packages**
   - Already provided by Java
   - Examples:
     ```java
     import java.util.Scanner;
     import java.io.File;
     ```

2. **User-defined Packages**
   - Created by programmers
   - Example:
     ```java
     package myapp.utils;

     public class Helper {
         // Your code
     }
     ```

---

## 📁 Folder Structure and Compilation

### Example:
```java
package day1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello from package!");
    }
}
```

### Save File As:
```
d:\DSA\day1\Main.java
```

### Compile From Root (`DSA`):
```bash
javac day1/Main.java
```

### Run:
```bash
java day1.Main
```

> ⚠️ You must **run from outside** the `day1` folder, because `Main` is in the `day1` package.

---

## ❌ Common Error: `NoClassDefFoundError`

### Cause:
You compile with a package:
```java
package day1;
```

But run like this:
```bash
cd day1
java Main
```

### Error Message:
```
Error: Could not find or load main class Main
Caused by: java.lang.NoClassDefFoundError: day1/Main (wrong name)
```

### Solution:
- Go **one level above** the package directory
- Run using **fully qualified class name**

---

## ✅ Alternative: Remove the Package

### Code without `package`:
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("No package used.");
    }
}
```

Then you can compile and run directly:
```bash
cd d:\DSA\day1
javac Main.java
java Main
```

---

## 📝 Summary Table

| Scenario                            | What to Do                                 |
|-------------------------------------|---------------------------------------------|
| Using `package day1;`               | Compile from root (`javac day1/Main.java`) <br> Run with `java day1.Main` |
| Not using any package               | Compile and run in the same directory       |
| Getting `NoClassDefFoundError`      | Check if you are in the wrong folder or missing the package prefix |
