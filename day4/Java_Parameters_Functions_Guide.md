
# 🧩 Types of Parameters and Functions in Java – Deep Explanation

---

## 🧪 PART 1: Types of Parameters in Java

Parameters are **inputs** passed to methods. Java supports two key types of parameter **passing techniques**:

---

### 🔹 1. Pass by Value (Default in Java)

Java always uses **pass-by-value**, even for objects.

- For **primitive data types**, the **value itself** is passed.
- For **objects**, the **reference (memory address)** is passed **by value**.

📌 Important: You cannot change the original primitive value in the caller.

🔸 Example:
```java
void changeValue(int x) {
    x = 10;  // This won't affect the original value
}

int a = 5;
changeValue(a);
System.out.println(a);  // Output: 5
```

---

### 🔹 2. Object Reference Parameter

When you pass an object, you pass a **copy of the reference**.  
So if you modify **fields** of the object, the change **is visible** outside the method.

🔸 Example:
```java
void updateName(Person p) {
    p.name = "Alice";  // This affects the original object
}

Person person = new Person();
updateName(person);
System.out.println(person.name);  // Output: Alice
```

---

## 🧠 Summary Table: Parameter Passing

| Data Type  | Behavior         | Can Modify Caller Data? |
|------------|------------------|--------------------------|
| Primitive  | Pass by value    | ❌ No                   |
| Object     | Reference by value | ✅ Yes (fields only)   |

---

## 🔧 PART 2: Types of Functions/Methods in Java

Java supports various types of methods based on **purpose, usage, and structure**.

---

### 🔹 1. Based on Return Type

| Type              | Description                         | Example                         |
|-------------------|-------------------------------------|----------------------------------|
| `void` method     | Does not return anything            | `void greet() {}`               |
| Returning method  | Returns a specific value            | `int sum(int a, int b)`         |

---

### 🔹 2. Based on Parameters

| Type                        | Description                         | Example                       |
|-----------------------------|-------------------------------------|-------------------------------|
| No parameters               | Method takes no input               | `void greet()`                |
| With parameters             | Takes one or more inputs            | `int add(int a, int b)`       |

---

### 🔹 3. Based on Scope

| Type           | Description                          | Example                          |
|----------------|--------------------------------------|----------------------------------|
| Instance Method| Belongs to an object                 | `obj.show();`                    |
| Static Method  | Belongs to the class itself          | `ClassName.display();`           |

---

### 🔹 4. Based on Access Level

| Modifier       | Description                          |
|----------------|--------------------------------------|
| `public`       | Accessible from anywhere             |
| `private`      | Accessible only within the class     |
| `protected`    | Accessible in package + subclasses   |
| *(default)*    | Package-private access               |

---

### 🔹 5. Special Types

#### a. **Constructor**
- Special method to initialize objects
- Same name as class
- No return type

```java
public class Car {
    Car() {
        System.out.println("Constructor called");
    }
}
```

#### b. **Main Method**
- Entry point of a Java application

```java
public static void main(String[] args) {
    // Program starts here
}
```

#### c. **Abstract Method**
- Declared in abstract class or interface
- No body

```java
abstract void draw();  // Must be overridden
```

#### d. **Overloaded Method**
- Same method name, different parameters

```java
void show() {}
void show(int a) {}
```

---

## 📝 Summary Table: Function/Method Types

| Classification | Examples                  | Key Point                         |
|----------------|---------------------------|-----------------------------------|
| Return Type    | `void`, `int`, `String`   | `void` = no return                |
| Parameters     | `show()`, `add(int, int)` | Can have zero or more            |
| Scope          | `static`, instance method | Static called without object      |
| Access         | `public`, `private`       | Controls where it's accessible   |
| Special        | `main`, constructor       | Special purposes in class design |

---

## 🧪 Practice Ideas

1. Create a method that returns the square of a number.
2. Write an overloaded method to calculate the area of circle and rectangle.
3. Create a constructor that sets the name and age of a `Person` object.
4. Demonstrate `pass by value` using a primitive and an object.

---

## 🔚 Conclusion

Understanding how parameters are passed and how methods are defined gives you full control over how your Java programs behave and communicate between different parts of the code.
