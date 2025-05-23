# 1. Introduction to Object-Oriented Programming (OOP) in Java

- Object-Oriented Programming (OOP) is a programming paradigm that organizes software design around "objects" rather than "actions" or "logic." In simpler terms, it's a way of structuring your code to model real-world entities and their interactions. Java is a strongly object-oriented language.

- The core idea behind OOP is to create self-contained modules (objects) that encapsulate data and the functions that operate on that data. This approach helps in managing complexity, promoting reusability, and making code more maintainable.

## Key Concepts

### 1.1. Classes

Think of a **class** as a blueprint or a template for creating objects. It defines the characteristics (attributes or properties) and behaviors (methods or functions) that all objects of that type will have. A class doesn't consume any memory when it's defined; it's just a definition.

**Example:**
Imagine you want to create a blueprint for a "Car."
A `Car` class might have:
* **Attributes:** `color`, `make`, `model`, `speed`
* **Behaviors:** `start()`, `stop()`, `accelerate()`, `brake()`

```java
// This is a class definition
class Car {
    // Attributes (also called fields or member variables)
    String color;
    String make;
    String model;
    int speed;

    // Behaviors (also called methods)
    void start() {
        System.out.println(make + " " + model + " started.");
    }

    void accelerate(int increment) {
        speed += increment;
        System.out.println("Current speed: " + speed + " mph");
    }

    void brake() {
        speed = 0;
        System.out.println("Car stopped.");
    }
}
```

### 1.2. Objects

An **object** is an instance of a class. It's a concrete entity created from the class blueprint. When you create an object, memory is allocated for its attributes, and you can call its methods to perform actions.

**Example:**
Using our `Car` blueprint, we can create actual car objects:

```java
public class MyGarage {
    public static void main(String[] args) {
        // Creating objects (instances) of the Car class
        Car myCar = new Car(); // 'myCar' is an object
        Car anotherCar = new Car(); // 'anotherCar' is another object

        // Setting attributes for myCar
        myCar.color = "Red";
        myCar.make = "Toyota";
        myCar.model = "Camry";
        myCar.speed = 0;

        // Calling behaviors (methods) of myCar
        myCar.start();
        myCar.accelerate(50);
        myCar.brake();

        System.out.println("\n--- Another Car ---");
        // Setting attributes for anotherCar
        anotherCar.color = "Blue";
        anotherCar.make = "Honda";
        anotherCar.model = "Civic";
        anotherCar.speed = 0;

        // Calling behaviors (methods) of anotherCar
        anotherCar.start();
        anotherCar.accelerate(60);
    }
}
```
**Output:**
```
Toyota Camry started.
Current speed: 50 mph
Car stopped.

--- Another Car ---
Honda Civic started.
Current speed: 60 mph
```

### 1.3. Constructors

A **constructor** is a special type of method that is automatically called when an object is created using the `new` keyword. Its primary purpose is to initialize the object's state (its attributes).

Key characteristics of constructors:
* They have the **same name as the class**.
* They do **not have a return type** (not even `void`).
* If you don't define any constructor, Java provides a **default constructor** (a no-argument constructor).

**Types of Constructors:**

* **Default Constructor (No-arg constructor):**
    ```java
    class Dog {
        String name;
        int age;

        // Default constructor (provided by Java if you don't write any)
        // Dog() {
        //    name = null;
        //    age = 0;
        // }
    }
    ```

* **Parameterized Constructor:** Allows you to initialize attributes with specific values when creating an object.

    ```java
    class Dog {
        String name;
        int age;

        // Parameterized constructor
        Dog(String dogName, int dogAge) {
            name = dogName;
            age = dogAge;
            System.out.println("A new dog named " + name + " is born!");
        }

        void bark() {
            System.out.println(name + " says Woof!");
        }
    }

    public class PetStore {
        public static void main(String[] args) {
            // Creating objects using the parameterized constructor
            Dog myDog = new Dog("Buddy", 3);
            myDog.bark();

            Dog anotherDog = new Dog("Lucy", 5);
            anotherDog.bark();
        }
    }
    ```
    **Output:**
    ```
    A new dog named Buddy is born!
    Buddy says Woof!
    A new dog named Lucy is born!
    Lucy says Woof!
    ```

### 1.4. Important Keywords Related to Classes and Objects

* `new`: Used to create a new instance (object) of a class. It allocates memory for the object on the heap and calls the constructor.
    ```java
    Car myCar = new Car(); // 'new' creates the Car object
    ```

* `this`: Refers to the current object. It's often used inside a class's methods or constructors to differentiate between instance variables and local variables (especially constructor parameters with the same name).

    ```java
    class Book {
        String title;
        String author;

        // Using 'this' to refer to instance variables
        Book(String title, String author) {
            this.title = title;   // 'this.title' refers to the instance variable
            this.author = author; // 'this.author' refers to the instance variable
        }

        void displayInfo() {
            System.out.println("Title: " + this.title + ", Author: " + this.author);
        }
    }
    ```

* `super`: Used to refer to the immediate parent class object. It's primarily used in subclasses to:
    * Call the parent class's constructor (`super()`).
    * Access parent class's methods (`super.methodName()`).
    * Access parent class's fields (`super.fieldName`).
    (More detail on `super` will be covered in the Inheritance section).

* `instanceof`: An operator used to check if an object is an instance of a particular class or an interface. It returns `true` if the object is an instance of the specified type, and `false` otherwise.

    ```java
    class Animal {}
    class Cat extends Animal {}

    public class TypeChecker {
        public static void main(String[] args) {
            Animal a = new Cat();
            Animal b = new Animal();

            System.out.println(a instanceof Cat);    // Output: true
            System.out.println(a instanceof Animal); // Output: true
            System.out.println(b instanceof Cat);    // Output: false
            System.out.println(b instanceof Object); // Output: true (all objects are instances of Object)
        }
    }
    