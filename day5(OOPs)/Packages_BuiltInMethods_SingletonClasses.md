
# 2. Packages, Static, Singleton Classes, In-built Methods

This section delves into some more advanced concepts that are crucial for structuring and managing Java code effectively.

## 2.1. Packages

**Packages** in Java are a way to organize related classes and interfaces into a single unit. They provide a mechanism for:
* **Name collision avoidance:** You can have two classes with the same name in different packages.
* **Access protection:** Packages control visibility of classes and members.
* **Easier management:** Grouping related classes makes your project more organized and easier to navigate.

Think of packages like folders on your computer for organizing files.

### Declaring a Package
To declare a class as part of a package, you use the `package` keyword as the first statement in your Java source file:

```java
// In a file named MyClass.java, located in a folder structure like com/example/myapp/
package com.example.myapp;

public class MyClass {
    // ... class content
}
```

### Importing Packages
To use classes from other packages, you need to `import` them.

* **Importing a specific class:**
    ```java
    import java.util.ArrayList; // Imports only the ArrayList class
    ```
* **Importing all classes from a package (wildcard import):**
    ```java
    import java.util.*; // Imports all classes from the java.util package
    ```

**Example:**
Let's say you have a `Calculator` class in a package `com.mycompany.math`:

```java
// File: com/mycompany/math/Calculator.java
package com.mycompany.math;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}
```

And you want to use it in another class:

```java
// File: com/mycompany/main/App.java
package com.mycompany.main;

import com.mycompany.math.Calculator; // Import the Calculator class

public class App {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int sum = calc.add(5, 3);
        System.out.println("Sum: " + sum);
    }
}
```

## 2.2. The `static` Keyword

The `static` keyword is used for memory management. It can be applied to variables, methods, blocks, and nested classes. A `static` member belongs to the class itself, rather than to any specific object of that class.

### a. Static Variables (Class Variables)
* A `static` variable is shared among all instances of a class.
* There's only one copy of a static variable per class, regardless of how many objects are created.
* They are initialized once, when the class is loaded.

```java
class Student {
    String name;
    int rollNo;
    static String college = "ABC College"; // Static variable

    Student(String n, int r) {
        name = n;
        rollNo = r;
    }

    void display() {
        System.out.println(name + " " + rollNo + " " + college);
    }
}

public class StaticVariableDemo {
    public static void main(String[] args) {
        Student s1 = new Student("Alice", 101);
        Student s2 = new Student("Bob", 102);

        s1.display(); // Output: Alice 101 ABC College
        s2.display(); // Output: Bob 102 ABC College

        // We can change the static variable directly using the class name
        Student.college = "XYZ University";

        s1.display(); // Output: Alice 101 XYZ University (changed for all instances)
        s2.display(); // Output: Bob 102 XYZ University
    }
}
```

### b. Static Methods (Class Methods)
* A `static` method belongs to the class, not to an object.
* It can be called directly using the class name, without creating an object.
* Static methods can only access static variables and static methods. They cannot use `this` or `super` keywords.

```java
class MathOperations {
    static int add(int a, int b) {
        return a + b;
    }

    static int multiply(int a, int b) {
        return a * b;
    }
}

public class StaticMethodDemo {
    public static void main(String[] args) {
        // Calling static methods directly using the class name
        int sum = MathOperations.add(10, 5);
        int product = MathOperations.multiply(4, 6);

        System.out.println("Sum: " + sum);       // Output: Sum: 15
        System.out.println("Product: " + product); // Output: Product: 24
    }
}
```

### c. Static Blocks
* A `static` block is used to initialize `static` variables.
* It is executed only once when the class is loaded into memory.

```java
class StaticBlockExample {
    static int data;

    static {
        System.out.println("Static block executed.");
        data = 100;
    }

    StaticBlockExample() {
        System.out.println("Constructor executed.");
    }

    public static void main(String[] args) {
        System.out.println("Inside main method.");
        StaticBlockExample obj1 = new StaticBlockExample(); // Static block runs first time class is loaded
        StaticBlockExample obj2 = new StaticBlockExample(); // Static block does not run again
        System.out.println("Data: " + StaticBlockExample.data);
    }
}
```
**Output:**
```
Static block executed.
Inside main method.
Constructor executed.
Constructor executed.
Data: 100
```

## 2.3. Singleton Classes

A **Singleton class** is a design pattern that restricts the instantiation of a class to a single object. This is useful when exactly one object is needed to coordinate actions across the system (e.g., a logging utility, a configuration manager, a database connection pool).

**Key characteristics for implementing a Singleton:**
1.  **Private constructor:** Prevents direct instantiation from outside the class.
2.  **Private static instance variable:** Holds the single instance of the class.
3.  **Public static method:** Provides the global access point to get the single instance.

**Example:**

```java
class DatabaseConnection {
    // 2. Private static instance of the class
    private static DatabaseConnection instance;

    // 1. Private constructor
    private DatabaseConnection() {
        System.out.println("DatabaseConnection instance created.");
        // Initialize connection here
    }

    // 3. Public static method to get the instance
    public static DatabaseConnection getInstance() {
        if (instance == null) { // If no instance exists, create one
            instance = new DatabaseConnection();
        }
        return instance; // Return the existing instance
    }

    public void executeQuery(String query) {
        System.out.println("Executing query: " + query);
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        // Get the first instance
        DatabaseConnection conn1 = DatabaseConnection.getInstance();
        conn1.executeQuery("SELECT * FROM users");

        // Try to get another instance
        DatabaseConnection conn2 = DatabaseConnection.getInstance();
        conn2.executeQuery("INSERT INTO logs VALUES ('login successful')");

        // Verify that both references point to the same object
        System.out.println("Are conn1 and conn2 the same object? " + (conn1 == conn2));
    }
}
```
**Output:**
```
DatabaseConnection instance created.
Executing query: SELECT * FROM users
Executing query: INSERT INTO logs VALUES ('login successful')
Are conn1 and conn2 the same object? true
```
Notice "DatabaseConnection instance created." is printed only once, confirming only one object was made.

## 2.4. In-built Methods

Java provides a vast library of pre-written classes and methods that you can use directly in your programs. These are often referred to as "in-built methods" or "library methods." They save you from writing common functionalities from scratch.

These methods are part of various classes in the Java API (Application Programming Interface).

**Examples of common in-built methods:**

* **`System.out.println()`**: Used for printing output to the console. `System` is a class, `out` is a static member of `System` (an object of type `PrintStream`), and `println()` is a method of `PrintStream`.
    ```java
    System.out.println("Hello, Java!");
    ```

* **`Math.sqrt()`**: Returns the square root of a number. `Math` is a utility class, and `sqrt()` is a static method within it.
    ```java
    double result = Math.sqrt(25.0); // result will be 5.0
    System.out.println("Square root of 25: " + result);
    ```

* **`String.length()`**: Returns the length of a string. `length()` is an instance method of the `String` class.
    ```java
    String message = "Java Programming";
    int len = message.length(); // len will be 16
    System.out.println("Length of message: " + len);
    ```

* **`Integer.parseInt()`**: Converts a string to an integer. `parseInt()` is a static method of the `Integer` wrapper class.
    ```java
    String numStr = "123";
    int num = Integer.parseInt(numStr); // num will be 123
    System.out.println("Parsed number: " + num);
    ```

* **`ArrayList.add()`**: Adds an element to an `ArrayList`.
    ```java
    import java.util.ArrayList;

    ArrayList<String> names = new ArrayList<>();
    names.add("Alice");
    names.add("Bob");
    System.out.println("Names: " + names);
    ```

These are just a few examples. The Java API documentation is a comprehensive resource for exploring all the available in-built classes and methods.
