
# 3. Principles of OOP: Inheritance, Polymorphism, Encapsulation, Abstraction

Object-Oriented Programming is built upon four fundamental principles, often referred to as the "four pillars of OOP." These principles help in designing robust, scalable, and maintainable software systems.

## 3.1. Inheritance

**Inheritance** is a mechanism where one class acquires the properties (attributes) and behaviors (methods) of another class. The class that inherits is called the **subclass** (or child class, derived class), and the class from which properties are inherited is called the **superclass** (or parent class, base class).

* **"Is-A" Relationship:** Inheritance represents an "is-a" relationship. For example, a "Car is a Vehicle," or a "Dog is an Animal."
* **`extends` Keyword:** In Java, the `extends` keyword is used to implement inheritance. A subclass can extend only one superclass (Java does not support multiple inheritance of classes).
* **Code Reusability:** The primary benefit of inheritance is code reusability. Common logic can be defined in the superclass and reused by multiple subclasses.

**Example:**

```java
// Superclass (Parent Class)
class Vehicle {
    String brand = "Generic Brand";

    void honk() {
        System.out.println("Tuut, tuut!");
    }
}

// Subclass (Child Class) - Car inherits from Vehicle
class Car extends Vehicle {
    String modelName = "Mustang";

    public static void main(String[] args) {
        Car myCar = new Car();

        // Accessing inherited attribute from Vehicle
        System.out.println(myCar.brand); // Output: Generic Brand

        // Accessing inherited method from Vehicle
        myCar.honk(); // Output: Tuut, tuut!

        // Accessing its own attribute
        System.out.println(myCar.modelName); // Output: Mustang
    }
}
```

### Method Overriding
When a subclass provides a specific implementation for a method that is already defined in its superclass, it's called **method overriding**. The method signature (name, parameters, return type) must be the same.

```java
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    // Overriding the makeSound() method
    @Override // Annotation to indicate intent to override (good practice)
    void makeSound() {
        System.out.println("Dog barks: Woof woof!");
    }
}

class Cat extends Animal {
    // Overriding the makeSound() method
    @Override
    void makeSound() {
        System.out.println("Cat meows: Meow!");
    }
}

public class OverridingDemo {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        Animal myDog = new Dog(); // Polymorphism in action
        Animal myCat = new Cat(); // Polymorphism in action

        myAnimal.makeSound(); // Output: Animal makes a sound
        myDog.makeSound();    // Output: Dog barks: Woof woof!
        myCat.makeSound();    // Output: Cat meows: Meow!
    }
}
```

## 3.2. Polymorphism

**Polymorphism** means "many forms." In Java, it refers to the ability of an object to take on many forms. Specifically, it allows objects of different classes to be treated as objects of a common type (their superclass or an interface they implement).

There are two main types of polymorphism in Java:

### a. Compile-time Polymorphism (Method Overloading)
Also known as **static polymorphism**. This occurs when there are multiple methods with the same name in the same class, but they have different parameters (different number of arguments, different types of arguments, or different order of arguments). The compiler decides which method to call based on the arguments provided.

```java
class Calculator {
    // Method 1: adds two integers
    int add(int a, int b) {
        return a + b;
    }

    // Method 2: adds three integers (overloaded method)
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method 3: adds two doubles (overloaded method)
    double add(double a, double b) {
        return a + b;
    }
}

public class OverloadingDemo {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(5, 10));        // Calls Method 1
        System.out.println(calc.add(5, 10, 15));    // Calls Method 2
        System.out.println(calc.add(2.5, 3.5));     // Calls Method 3
    }
}
```

### b. Run-time Polymorphism (Method Overriding / Dynamic Method Dispatch)
Also known as **dynamic polymorphism**. This occurs when a superclass reference variable refers to an object of a subclass. The method that is called is determined at runtime based on the actual object type, not the reference type. This is achieved through method overriding.

```java
class Shape {
    void draw() {
        System.out.println("Drawing a generic shape");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

public class RuntimePolymorphismDemo {
    public static void main(String[] args) {
        Shape s1 = new Circle();    // s1 is a Shape reference, but points to a Circle object
        Shape s2 = new Rectangle(); // s2 is a Shape reference, but points to a Rectangle object
        Shape s3 = new Shape();     // s3 is a Shape reference, points to a Shape object

        s1.draw(); // Calls Circle's draw()
        s2.draw(); // Calls Rectangle's draw()
        s3.draw(); // Calls Shape's draw()
    }
}
```

## 3.3. Encapsulation

**Encapsulation** is the mechanism of wrapping data (attributes) and the code that operates on the data (methods) into a single unit (a class). It's about bundling data and methods that work on that data within one unit, and restricting direct access to some of the object's components.

* **Data Hiding:** The primary goal of encapsulation is data hiding. By making the attributes `private`, you prevent direct external access.
* **Getters and Setters:** To allow controlled access to private data, you provide public methods called "getters" (to read data) and "setters" (to write data).

**Benefits:**
* **Control over data:** You can add validation logic in setters to ensure data integrity.
* **Flexibility:** You can change the internal implementation of a class without affecting external code that uses it.
* **Easier debugging:** Issues are localized within the class.

**Example:**

```java
class Account {
    private double balance; // Private attribute (data hiding)
    private String accountNumber;

    public Account(String accNum, double initialBalance) {
        this.accountNumber = accNum;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Initial balance cannot be negative. Setting to 0.");
        }
    }

    // Getter method for balance
    public double getBalance() {
        return balance;
    }

    // Setter method for balance (with validation)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Getter method for account number
    public String getAccountNumber() {
        return accountNumber;
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {
        Account myAccount = new Account("123456789", 1000.0);

        // Cannot directly access myAccount.balance = -500; (would be a compile error)

        System.out.println("Account Number: " + myAccount.getAccountNumber());
        System.out.println("Current Balance: " + myAccount.getBalance());

        myAccount.deposit(500.0);
        myAccount.deposit(-100.0); // This will be rejected by the setter logic

        System.out.println("Final Balance: " + myAccount.getBalance());
    }
}
```
**Output:**
```
Account Number: 123456789
Current Balance: 1000.0
Deposited: 500.0. New balance: 1500.0
Deposit amount must be positive.
Final Balance: 1500.0
```

## 3.4. Abstraction

**Abstraction** is the concept of showing only essential information and hiding the complex implementation details. It focuses on "what" an object does rather than "how" it does it.

* **Simplification:** It simplifies complex systems by breaking them down into smaller, manageable parts.
* **Focus on Interface:** It allows you to focus on the interface (what methods are available) rather than the concrete implementation.
* **Achieved through:** Abstract classes and Interfaces (which will be covered in detail in a later section).

**Example:**
Think about driving a car. You know how to `start()`, `accelerate()`, and `brake()`. You don't need to know the intricate details of how the engine works, how fuel is injected, or how the braking system engages. The car provides an abstract interface (steering wheel, pedals, gear stick) that hides the underlying complexity.

In programming:

```java
// Abstract class (defines a contract)
abstract class BankAccount {
    String accountHolder;
    double balance;

    public BankAccount(String holder, double bal) {
        this.accountHolder = holder;
        this.balance = bal;
    }

    // Abstract method: no implementation here, must be implemented by subclasses
    public abstract void withdraw(double amount);

    // Concrete method: has implementation
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + ". New balance: " + balance);
        }
    }

    public void displayBalance() {
        System.out.println(accountHolder + "'s balance: " + balance);
    }
}

// Concrete subclass providing implementation for abstract method
class SavingsAccount extends BankAccount {
    double interestRate;

    public SavingsAccount(String holder, double bal, double rate) {
        super(holder, bal);
        this.interestRate = rate;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ". Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }
}

public class AbstractionDemo {
    public static void main(String[] args) {
        // BankAccount acc = new BankAccount("John Doe", 500); // ERROR: Cannot instantiate abstract class

        SavingsAccount savAcc = new SavingsAccount("Jane Doe", 1000, 0.05);
        savAcc.displayBalance();
        savAcc.deposit(200);
        savAcc.withdraw(300);
        savAcc.withdraw(1500); // Insufficient funds
        savAcc.displayBalance();
    }
}
```
**Output:**
```
Jane Doe's balance: 1000.0
Deposited 200.0. New balance: 1200.0
Withdrew 300.0. Remaining balance: 900.0
Insufficient funds for withdrawal.
Jane Doe's balance: 900.0
```
Here, `BankAccount` provides an abstract view of what a bank account does (`withdraw`, `deposit`), but `SavingsAccount` provides the concrete "how" for `withdraw`.
