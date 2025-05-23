# 5. Abstract Classes, Interfaces, Annotation

Abstraction is a core OOP principle, and in Java, it's primarily achieved through **abstract classes** and **interfaces**. **Annotations** provide a way to add metadata to your code.

## 5.1. Abstract Classes

An **abstract class** is a class that cannot be instantiated directly (you cannot create objects of it). It's designed to be a base class for other classes to extend. Abstract classes can have both abstract methods (methods without a body) and concrete methods (methods with a body).

### Key Characteristics:
* Declared using the `abstract` keyword.
* Cannot be instantiated (you cannot do `new AbstractClass()`).
* Can have `abstract` methods (methods without implementation, declared with `abstract` keyword and ending with a semicolon).
* Can have concrete (non-abstract) methods.
* Can have constructors (these are called by the subclass constructors using `super()`).
* If a class has at least one abstract method, the class itself must be declared abstract.
* A subclass that extends an abstract class **must** implement all its abstract methods, or it must also be declared abstract.

**Purpose:**
* To provide a common base for related classes.
* To define a contract or a template for subclasses to follow.
* To achieve partial abstraction (some methods are implemented, others are left for subclasses).

**Example:**

```java
// Abstract class: Defines a general concept of a "Shape"
abstract class Shape {
    String color;

    // Constructor for the abstract class
    public Shape(String color) {
        this.color = color;
    }

    // Abstract method: Every shape must know how to calculate its area,
    // but the calculation differs for each shape.
    public abstract double calculateArea();

    // Concrete method: Common behavior for all shapes
    public void displayColor() {
        System.out.println("This shape is " + color);
    }
}

// Concrete subclass: Provides implementation for the abstract method
class Circle extends Shape {
    double radius;

    public Circle(String color, double radius) {
        super(color); // Call to abstract class constructor
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Another concrete subclass
class Rectangle extends Shape {
    double length;
    double width;

    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

public class AbstractClassDemo {
    public static void main(String[] args) {
        // Shape s = new Shape("Green"); // Compile-time ERROR: Cannot instantiate abstract class

        Circle myCircle = new Circle("Red", 5.0);
        myCircle.displayColor();
        System.out.println("Circle Area: " + myCircle.calculateArea());

        Rectangle myRectangle = new Rectangle("Blue", 4.0, 6.0);
        myRectangle.displayColor();
        System.out.println("Rectangle Area: " + myRectangle.calculateArea());

        // Polymorphism with abstract classes
        Shape genericShape1 = new Circle("Yellow", 3.0);
        Shape genericShape2 = new Rectangle("Purple", 2.0, 8.0);

        System.out.println("Generic Shape 1 Area: " + genericShape1.calculateArea());
        System.out.println("Generic Shape 2 Area: " + genericShape2.calculateArea());
    }
}
```

## 5.2. Interfaces

An **interface** in Java is a blueprint of a class. It contains abstract methods and static final fields (constants). Starting from Java 8, interfaces can also have `default` and `static` methods with implementations.

### Key Characteristics:
* Declared using the `interface` keyword.
* Cannot be instantiated.
* Methods are implicitly `public abstract` (before Java 8).
* Fields are implicitly `public static final`.
* A class uses the `implements` keyword to implement an interface.
* A class can implement multiple interfaces (achieves multiple inheritance of *type*).
* An interface can extend another interface.

**Purpose:**
* To achieve **100% abstraction** (before Java 8, all methods were abstract).
* To define a contract: Any class that implements an interface guarantees to provide implementations for all its abstract methods.
* To support multiple inheritance of behavior (a class can implement many interfaces).
* To achieve loose coupling.

**Example (Pre-Java 8 style):**

```java
// Interface: Defines a contract for objects that can be "Flyable"
interface Flyable {
    // Methods are implicitly public abstract
    void fly();
    void land();
}

// Class implementing the Flyable interface
class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Bird is flying high.");
    }

    @Override
    public void land() {
        System.out.println("Bird is landing on a branch.");
    }
}

// Another class implementing the Flyable interface
class Airplane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Airplane is soaring through the sky.");
    }

    @Override
    public void land() {
        System.out.println("Airplane is landing on the runway.");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        Flyable myBird = new Bird();
        myBird.fly();
        myBird.land();

        Flyable myAirplane = new Airplane();
        myAirplane.fly();
        myAirplane.land();
    }
}
```

### Default and Static Methods in Interfaces (Java 8+)
* **`default` methods:** Provide a default implementation for a method in an interface. This allows adding new methods to an interface without breaking existing classes that implement it.
* **`static` methods:** Utility methods that belong to the interface itself. They can be called directly using the interface name.

**Example (Java 8+):**

```java
interface Vehicle {
    void start(); // Abstract method

    // Default method: provides a default implementation
    default void honk() {
        System.out.println("Default honk sound.");
    }

    // Static method: belongs to the interface, cannot be overridden
    static void getVehicleType() {
        System.out.println("This is a generic vehicle.");
    }
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car engine started.");
    }

    // Can override default method if needed
    @Override
    public void honk() {
        System.out.println("Car horn blares!");
    }
}

class Bicycle implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bicycle starts pedaling.");
    }
    // Bicycle uses the default honk() method
}

public class InterfaceJava8Demo {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.start();
        myCar.honk(); // Calls Car's overridden honk()

        Bicycle myBicycle = new Bicycle();
        myBicycle.start();
        myBicycle.honk(); // Calls default honk() from Vehicle interface

        Vehicle.getVehicleType(); // Calling static method of interface
    }
}
```

### Abstract Class vs. Interface Summary

| Feature                 | Abstract Class                                    | Interface                                          |
| :---------------------- | :------------------------------------------------ | :------------------------------------------------- |
| **Type of Abstraction** | Can be partial (0-100%)                           | Full (100% before Java 8), can be partial with default/static methods (Java 8+) |
| **Methods** | Can have abstract and concrete methods            | Can have abstract, default, and static methods (Java 8+) |
| **Variables** | Can have non-final, non-static variables          | Only `public static final` variables (constants)   |
| **Constructor** | Can have constructors                             | Cannot have constructors                           |
| **Inheritance** | Uses `extends` keyword                            | Uses `implements` keyword                          |
| **Multiple Inheritance**| A class can extend only one abstract class        | A class can implement multiple interfaces          |
| **Access Modifiers** | Can have any access modifier for members          | Methods are implicitly `public abstract` (before Java 8), fields are implicitly `public static final` |

## 5.3. Annotations

**Annotations** in Java are a form of metadata that can be added to Java source code. They provide information about the code but do not directly affect the execution of the code. They are used by compilers, development tools, and runtime environments.

### Purpose of Annotations:
* **Information for the compiler:** e.g., `@Override` checks if a method is correctly overridden.
* **Compile-time and deployment-time processing:** Tools can read annotations to generate code, XML files, etc.
* **Runtime processing:** Annotations can be inspected at runtime using reflection.

### Syntax:
Annotations start with an `@` symbol followed by the annotation name.

**Example:**

```java
// A simple class
class OldCalculator {
    public int add(int a, int b) {
        return a + b;
    }

    // @Deprecated annotation: indicates that this method should no longer be used
    @Deprecated
    public int subtract(int a, int b) {
        return a - b;
    }
}

class NewCalculator extends OldCalculator {
    // @Override annotation: tells the compiler that this method is intended to override a method in the superclass
    @Override
    public int add(int a, int b) {
        System.out.println("Using new add method.");
        return a + b + 10;
    }

    // @SuppressWarnings annotation: tells the compiler to suppress specific warnings
    @SuppressWarnings("deprecation") // Suppresses the warning for using a deprecated method
    public void performOldOperation() {
        int result = subtract(20, 5); // Using the deprecated method
        System.out.println("Result of old subtraction: " + result);
    }
}

public class AnnotationDemo {
    public static void main(String[] args) {
        NewCalculator nc = new NewCalculator();
        System.out.println(nc.add(10, 5));
        nc.performOldOperation();
    }
}
```
**Output:**
```
Using new add method.
25
Result of old subtraction: 15
```
When you compile `AnnotationDemo.java`, the compiler might issue a warning about `subtract()` being deprecated, but the `@SuppressWarnings` annotation on `performOldOperation()` will prevent that specific warning from being shown for that method.

### Common Built-in Annotations:
* `@Override`: Ensures that a method is correctly overriding a method from a superclass or implementing an interface method.
* `@Deprecated`: Marks a program element (class, method, field) as outdated and suggests it should no longer be used.
* `@SuppressWarnings`: Suppresses compiler warnings for a specific code section.
* `@FunctionalInterface`: (Introduced in Java 8) Indicates that an interface is a "functional interface," meaning it has exactly one abstract method. Used for Lambda Expressions.
* `@SafeVarargs`: (Introduced in Java 7) Used on methods or constructors that take a variable number of arguments (varargs) to suppress compiler warnings related to potential heap pollution.
* `@Retention`, `@Target`, `@Documented`, `@Inherited`, `@Repeatable`: These are meta-annotations, used to define custom annotations.
