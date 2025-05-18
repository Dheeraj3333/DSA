
# 🧩 Methods in Java – Deep Explanation

---

## ✅ What is a Method in Java?

A **method** in Java is a **block of code** that performs a specific task.  
You define it once and **reuse** it wherever and whenever needed in your program.

Think of a method as a **mini-program inside your main program**. It helps break large problems into smaller, more manageable parts.

---

## 🎯 Why Use Methods?

- **Reusability** – Write once, use many times.
- **Organization** – Break code into meaningful sections.
- **Maintainability** – Easier to debug and modify.
- **Abstraction** – Hide complex code behind simple method names.

---

## 🧱 Structure of a Method

```java
returnType methodName(parameters) {
    // method body
    return value; // if returnType is not void
}
```

Each part explained:

| Part         | Meaning                                                 |
|--------------|----------------------------------------------------------|
| returnType   | Type of value returned (e.g., `int`, `String`, `void`)   |
| methodName   | Name of the method (should be descriptive)               |
| parameters   | Input values (can be zero or more)                       |
| method body  | The block of code that runs when the method is called    |

---

## 🧠 Example – Basic Method

```java
public static int add(int a, int b) {
    return a + b;
}
```

- `public static`: modifiers (explained below)
- `int`: return type
- `add`: method name
- `(int a, int b)`: parameters
- `return a + b;`: returns the result

---

## 🏷️ Types of Methods

### 1. **Predefined Methods**
Provided by Java libraries (like `System.out.println()`, `Math.max()`).

### 2. **User-defined Methods**
Created by programmers to perform specific tasks.

---

## 🔁 Method Overloading

You can define **multiple methods** with the **same name** but different **parameter lists**.

```java
void greet() {
    System.out.println("Hello!");
}

void greet(String name) {
    System.out.println("Hello, " + name);
}
```

---

## 🧬 Static vs. Non-Static Methods

| Type        | Call From                          | Keyword   |
|-------------|------------------------------------|-----------|
| Static      | Directly or via class name         | `static`  |
| Non-static  | Only via object of the class       | (no keyword)

🔸 Example:

```java
public class Demo {
    static void sayHi() {
        System.out.println("Hi");
    }

    void sayBye() {
        System.out.println("Bye");
    }

    public static void main(String[] args) {
        sayHi();              // static method call
        Demo obj = new Demo();
        obj.sayBye();         // non-static method call
    }
}
```

---

## 🔂 Method Calling Flow

1. Method is defined.
2. It is called from `main()` or another method.
3. Control jumps to method definition.
4. Executes code.
5. Returns value (if not `void`).
6. Control returns to caller.

---

## 📦 Return Types

- `void` → returns nothing
- any data type (`int`, `String`, etc.) → must return a value

```java
void printHello() {
    System.out.println("Hello");
}

String getName() {
    return "Alice";
}
```

---

## 🧪 Practice Ideas

1. Write a method to find the factorial of a number.
2. Create a method that returns the larger of two numbers.
3. Overload a method that multiplies 2 or 3 numbers.
4. Write a method that reverses a string.

---

## 📝 Summary

| Concept           | Description                              |
|-------------------|------------------------------------------|
| Method            | Reusable block of code                   |
| returnType        | Type of value returned                   |
| Parameters        | Inputs to method                         |
| Overloading       | Same name, different parameters          |
| Static method     | Belongs to class, no object needed       |
| Non-static method | Needs object to be called                |

Methods make your code **modular, clean, and efficient**. Use them to structure your logic in an elegant way.

###### **Note** : Making a method public allows it to be accessible out of it's class either it used by other class or in other places in different packages 
