
# 4. Access Control, In-built Packages, Object Class

Understanding how to control access to your class members and knowing about fundamental built-in components are crucial for writing robust and well-structured Java applications.

## 4.1. Access Control (Access Modifiers)

Access modifiers in Java define the scope or visibility of classes, fields (attributes), methods, and constructors. They determine which parts of your code can access these members.

There are four types of access modifiers in Java:

### a. `private`
* **Visibility:** Members declared `private` are accessible only within the **same class**.
* They are the most restrictive.
* Used primarily for data hiding (encapsulation).

**Example:**
```java
class DataHolder {
    private int secretValue = 10; // Only accessible inside DataHolder

    public void displaySecret() {
        System.out.println("Secret value: " + secretValue); // Accessible
    }
}

public class PrivateAccessDemo {
    public static void main(String[] args) {
        DataHolder obj = new DataHolder();
        // System.out.println(obj.secretValue); // Compile-time ERROR: secretValue has private access
        obj.displaySecret(); // Works because displaySecret() is public and accesses it internally
    }
}
```

### b. `default` (No Keyword)
* **Visibility:** If no access modifier is specified, it's considered `default` (also known as package-private).
* Members are accessible only within the **same package**.
* They are not accessible from outside the package.

**Example:**
Assume `com.mycompany.package1` and `com.mycompany.package2` are two different packages.

```java
// File: com/mycompany/package1/MyClass.java
package com.mycompany.package1;

class MyClass { // Default class access (only accessible within package1)
    int defaultVar = 20; // Default variable access
    void defaultMethod() { // Default method access
        System.out.println("Default method in MyClass.");
    }
}
```

```java
// File: com/mycompany/package1/Package1Demo.java
package com.mycompany.package1;

public class Package1Demo {
    public static void main(String[] args) {
        MyClass obj = new MyClass(); // Accessible within the same package
        System.out.println(obj.defaultVar);
        obj.defaultMethod();
    }
}
```

```java
// File: com/mycompany/package2/Package2Demo.java
package com.mycompany.package2;

import com.mycompany.package1.MyClass; // This import would fail if MyClass was not public

public class Package2Demo {
    public static void main(String[] args) {
        // MyClass obj = new MyClass(); // Compile-time ERROR: MyClass is not public in package1
        // System.out.println(obj.defaultVar); // Compile-time ERROR
    }
}
```
*Note: For a class itself to be accessible across packages, it must be declared `public`.*

### c. `protected`
* **Visibility:** Members declared `protected` are accessible within the **same package** AND by **subclasses in any package**.
* This modifier is primarily used when you want to allow subclasses to access certain members, even if they are in different packages, while still restricting general public access.

**Example:**

```java
// File: com/mycompany/base/ParentClass.java
package com.mycompany.base;

public class ParentClass {
    protected int protectedVar = 30;

    protected void protectedMethod() {
        System.out.println("Protected method in ParentClass.");
    }
}
```

```java
// File: com/mycompany/derived/ChildClass.java
package com.mycompany.derived;

import com.mycompany.base.ParentClass;

public class ChildClass extends ParentClass {
    public void accessParentMembers() {
        System.out.println("Accessing protectedVar from ChildClass: " + protectedVar); // Accessible
        protectedMethod(); // Accessible
    }

    public static void main(String[] args) {
        ChildClass child = new ChildClass();
        child.accessParentMembers();
    }
}
```

```java
// File: com/mycompany/other/OtherClass.java
package com.mycompany.other;

import com.mycompany.base.ParentClass;

public class OtherClass {
    public static void main(String[] args) {
        ParentClass parent = new ParentClass();
        // System.out.println(parent.protectedVar); // Compile-time ERROR: protectedVar has protected access
        // parent.protectedMethod(); // Compile-time ERROR
    }
}
```

### d. `public`
* **Visibility:** Members declared `public` are accessible from **anywhere** (within the same class, same package, subclasses in different packages, and non-subclasses in different packages).
* They are the least restrictive.

**Example:**

```java
// File: com/mycompany.common/PublicClass.java
package com.mycompany.common;

public class PublicClass {
    public int publicVar = 40;

    public void publicMethod() {
        System.out.println("Public method in PublicClass.");
    }
}
```

```java
// File: com/mycompany.app/AppRunner.java
package com.mycompany.app;

import com.mycompany.common.PublicClass;

public class AppRunner {
    public static void main(String[] args) {
        PublicClass obj = new PublicClass();
        System.out.println(obj.publicVar); // Accessible
        obj.publicMethod(); // Accessible
    }
}
```

**Summary Table of Access Modifiers:**

| Modifier    | Same Class | Same Package | Subclass (different package) | Other Class (different package) |
| :---------- | :--------- | :----------- | :--------------------------- | :------------------------------ |
| `private`   | Yes        | No           | No                           | No                              |
| `default`   | Yes        | Yes          | No                           | No                              |
| `protected` | Yes        | Yes          | Yes                          | No                              |
| `public`    | Yes        | Yes          | Yes                          | Yes                             |

## 4.2. In-built Packages

Java comes with a rich set of pre-defined classes and interfaces organized into various packages. These are often referred to as "in-built packages" or "standard library packages." They provide a vast array of functionalities, from basic data structures to network communication.

Some of the most commonly used in-built packages include:

* **`java.lang`**:
    * This is the most fundamental package.
    * It contains classes that are fundamental to the design of the Java language, such as `Object`, `String`, `Math`, `System`, `Thread`, and wrapper classes (`Integer`, `Double`, etc.).
    * **Classes in `java.lang` are automatically imported into every Java program**, so you don't need an `import` statement for them.

* **`java.util`**:
    * Contains utility classes and interfaces.
    * Includes the **Collection Framework** (e.g., `ArrayList`, `HashMap`, `HashSet`), date and time utilities (`Date`, `Calendar`), `Scanner` for input, `Random` for random numbers, etc.
    * You almost always need to import classes from `java.util`.

* **`java.io`**:
    * Provides classes for input and output operations.
    * Includes classes for reading from and writing to files, streams, and other I/O sources (e.g., `FileInputStream`, `FileOutputStream`, `BufferedReader`, `PrintWriter`).

* **`java.net`**:
    * Provides classes for networking applications.
    * Includes classes for creating sockets, URLs, and handling network connections (e.g., `Socket`, `ServerSocket`, `URL`).

* **`java.awt` and `javax.swing`**:
    * Packages for GUI (Graphical User Interface) development.
    * `java.awt` (Abstract Window Toolkit) is older and platform-dependent.
    * `javax.swing` (Swing) is newer, more powerful, and platform-independent.

* **`java.sql`**:
    * Provides classes for connecting to and interacting with databases using JDBC (Java Database Connectivity).
    * Includes interfaces and classes like `Connection`, `Statement`, `ResultSet`.

## 4.3. The `Object` Class

In Java, the `java.lang.Object` class is the **root of the class hierarchy**. This means that every class in Java, whether explicitly or implicitly, is a direct or indirect subclass of `Object`.

* **Universal Superclass:** If a class does not explicitly extend another class, it implicitly extends `Object`.
* **Common Functionality:** The `Object` class provides a set of common methods that are inherited by all Java objects. These methods define basic behaviors that any object might need.

**Key methods of the `Object` class (and why they are important):**

### a. `public String toString()`
* **Purpose:** Returns a string representation of the object.
* **Default Implementation:** By default, it returns a string consisting of the class name, an "@" sign, and the unsigned hexadecimal representation of the object's hash code (e.g., `MyClass@1a2b3c4d`).
* **Importance:** It's highly recommended to **override** this method in your custom classes to provide a meaningful and readable string representation of your objects, especially for debugging and logging.

**Example:**
```java
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Overriding toString() for a meaningful representation
    @Override
    public String toString() {
        return "Person[name=" + name + ", age=" + age + "]";
    }
}

public class ToStringDemo {
    public static void main(String[] args) {
        Person p = new Person("Alice", 30);
        System.out.println(p); // Calls p.toString() implicitly
        System.out.println(p.toString()); // Explicit call
    }
}
```
**Output:**
```
Person[name=Alice, age=30]
Person[name=Alice, age=30]
```

### b. `public boolean equals(Object obj)`
* **Purpose:** Indicates whether some other object is "equal to" this one.
* **Default Implementation:** The default `equals()` method in `Object` performs a **reference comparison** (i.e., it checks if `this` object and `obj` refer to the exact same object in memory).
* **Importance:** You should **override** this method if you want to define "equality" based on the **content** or **state** of the objects rather than just their memory addresses. When overriding, you should also override `hashCode()`.

**Example:**
```java
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Overriding equals() for content comparison
    @Override
    public boolean equals(Object obj) {
        // 1. Check for same reference
        if (this == obj) return true;
        // 2. Check for null and class type
        if (obj == null || getClass() != obj.getClass()) return false;
        // 3. Cast and compare fields
        Point other = (Point) obj;
        return x == other.x && y == other.y;
    }

    // Must override hashCode() when overriding equals()
    @Override
    public int hashCode() {
        // Simple hash code for demonstration
        return java.util.Objects.hash(x, y);
    }
}

public class EqualsDemo {
    public static void main(String[] args) {
        Point p1 = new Point(10, 20);
        Point p2 = new Point(10, 20);
        Point p3 = new Point(30, 40);
        Point p4 = p1; // p4 refers to the same object as p1

        System.out.println("p1 == p2: " + (p1 == p2));         // Output: false (different objects in memory)
        System.out.println("p1.equals(p2): " + p1.equals(p2)); // Output: true (content is same)
        System.out.println("p1.equals(p3): " + p1.equals(p3)); // Output: false
        System.out.println("p1.equals(p4): " + p1.equals(p4)); // Output: true (same object reference)
    }
}
```

### c. `public int hashCode()`
* **Purpose:** Returns a hash code value for the object.
* **Default Implementation:** Typically returns a unique integer for each distinct object in memory.
* **Importance:** It's crucial to **override `hashCode()` whenever you override `equals()`**. The contract states that if two objects are equal according to the `equals()` method, then calling the `hashCode()` method on each of the two objects must produce the same integer result. This is vital for correct functioning of hash-based collections like `HashMap` and `HashSet`.

### d. `protected Object clone() throws CloneNotSupportedException`
* **Purpose:** Creates and returns a copy of this object.
* **Importance:** Used for object cloning. Requires the class to implement the `Cloneable` interface. (More detail in section 6).

### e. `public final Class<?> getClass()`
* **Purpose:** Returns the runtime class of this `Object`.
* **Importance:** Useful for reflection and type checking (e.g., as seen in the `equals()` method example).

### f. `protected void finalize() throws Throwable`
* **Purpose:** Called by the garbage collector on an object when garbage collection determines that there are no more references to the object.
* **Importance:** Rarely used in modern Java. It's generally discouraged due to unpredictable timing and potential performance issues. `try-with-resources` and explicit resource management are preferred.

### g. `public void notify()`, `public void notifyAll()`, `public void wait()`
* **Purpose:** Used for inter-thread communication in multithreaded programming.
* **Importance:** Essential for coordinating threads that need to wait for certain conditions to be met.
