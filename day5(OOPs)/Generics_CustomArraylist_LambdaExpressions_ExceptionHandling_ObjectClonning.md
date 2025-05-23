# 6. Generics, Custom ArrayList, Lambda Expressions, Exception Handling, Object Cloning

This section covers several powerful features in Java that enhance type safety, code conciseness, and robustness.

## 6.1. Generics

**Generics** allow you to write classes, interfaces, and methods that operate on objects of various types while providing compile-time type safety. They enable you to define classes and methods with placeholder types, which are then replaced with actual types at compile time.

**Problem without Generics:**
Before generics, collections like `ArrayList` stored `Object` types. This meant you could add any type of object, leading to potential `ClassCastException` at runtime if you tried to retrieve an object and cast it to the wrong type.

```java
import java.util.ArrayList;

public class WithoutGenerics {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // Stores Objects
        list.add("Hello");
        list.add(123); // Can add any type

        String s = (String) list.get(0); // OK
        // Integer i = (Integer) list.get(1); // OK
        // String s2 = (String) list.get(1); // RUNTIME ERROR: ClassCastException
        System.out.println(s);
    }
}
```

**Solution with Generics:**
Generics enforce type checking at compile time, preventing `ClassCastException` at runtime.

```java
import java.util.ArrayList;

public class WithGenerics {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>(); // Now stores only Strings
        names.add("Alice");
        names.add("Bob");
        // names.add(123); // Compile-time ERROR: incompatible types

        String name1 = names.get(0); // No cast needed, type-safe
        System.out.println(name1);
    }
}
```

### Type Parameters
Generics use type parameters, often represented by single uppercase letters like `T` (for Type), `E` (for Element), `K` (for Key), `V` (for Value).

**Example of a Generic Class:**

```java
// A simple generic box that can hold any type of item
class Box<T> { // T is the type parameter
    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }
}

public class GenericClassDemo {
    public static void main(String[] args) {
        // Create a Box for Strings
        Box<String> stringBox = new Box<>();
        stringBox.setContent("Java is fun!");
        String text = stringBox.getContent(); // No cast needed
        System.out.println("String Box: " + text);

        // Create a Box for Integers
        Box<Integer> integerBox = new Box<>();
        integerBox.setContent(123);
        int number = integerBox.getContent(); // No cast needed
        System.out.println("Integer Box: " + number);

        // Box<String> wrongBox = new Box<>();
        // wrongBox.setContent(456); // Compile-time ERROR: incompatible types
    }
}
```

## 6.2. Custom ArrayList (Concept)

While you wouldn't typically implement your own `ArrayList` from scratch in real-world applications (because `java.util.ArrayList` is highly optimized), understanding its underlying concept helps in grasping data structures and generics.

A custom `ArrayList` (or a dynamic array) would conceptually work like this:

1.  **Internal Array:** It uses a regular Java array internally to store elements.
2.  **Dynamic Resizing:** When the internal array becomes full, a new, larger array is created (e.g., double the size), and all elements from the old array are copied to the new one.
3.  **`add()` method:** Adds an element. If the array is full, it triggers resizing.
4.  **`get()` method:** Retrieves an element at a specific index.
5.  **`size()` method:** Returns the current number of elements.
6.  **Generics (`<E>`):** To make it type-safe, you'd use generics, similar to `java.util.ArrayList<E>`.

**Conceptual Sketch (not a full implementation):**

```java
// This is a conceptual example, not a complete, robust implementation
class MyCustomArrayList<E> { // E for Element type
    private Object[] data; // Internal array to store elements
    private int size;      // Current number of elements
    private static final int DEFAULT_CAPACITY = 10;

    public MyCustomArrayList() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(E element) {
        if (size == data.length) {
            // Need to resize: create a new, larger array and copy elements
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
        data[size++] = element;
    }

    @SuppressWarnings("unchecked") // Suppress warning for unchecked cast
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) data[index]; // Cast to the generic type
    }

    public int size() {
        return size;
    }

    // ... other methods like remove, set, etc.
}

public class CustomArrayListDemo {
    public static void main(String[] args) {
        MyCustomArrayList<String> myList = new MyCustomArrayList<>();
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Cherry");

        System.out.println("Size: " + myList.size());
        System.out.println("Element at index 1: " + myList.get(1));

        myList.add("Date");
        myList.add("Elderberry");
        // Add more elements to trigger resize...
        for (int i = 0; i < 7; i++) {
            myList.add("Fruit" + i);
        }

        System.out.println("New Size: " + myList.size());
        System.out.println("Last element: " + myList.get(myList.size() - 1));
    }
}
```

## 6.3. Lambda Expressions

**Lambda expressions** (introduced in Java 8) provide a concise way to represent an anonymous function (a function without a name). They are primarily used to implement **functional interfaces** (interfaces with a single abstract method).

**Syntax:**
`(parameters) -> expression`
or
`(parameters) -> { statements; }`

**Purpose:**
* **Conciseness:** Reduces boilerplate code, especially for anonymous inner classes.
* **Functional Programming:** Enables a more functional style of programming in Java.
* **Stream API:** Crucial for working with the Java Stream API.

**Example (Traditional vs. Lambda):**

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LambdaDemo {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Charlie");
        names.add("Alice");
        names.add("Bob");

        System.out.println("Original names: " + names);

        // --- Traditional way to sort (using anonymous inner class) ---
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        System.out.println("Sorted (traditional): " + names);

        // Reset names for next demo
        names.clear();
        names.add("Charlie");
        names.add("Alice");
        names.add("Bob");

        // --- Using Lambda Expression to sort ---
        // Comparator is a functional interface. Its single abstract method is compare(T o1, T o2).
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
        System.out.println("Sorted (lambda): " + names);

        // Example with a custom functional interface
        // A functional interface must have exactly one abstract method.
        @FunctionalInterface
        interface MyCalculator {
            int operate(int a, int b);
        }

        MyCalculator adder = (x, y) -> x + y;
        MyCalculator multiplier = (x, y) -> x * y;

        System.out.println("10 + 5 = " + adder.operate(10, 5));
        System.out.println("10 * 5 = " + multiplier.operate(10, 5));

        // Lambda with multiple statements
        MyCalculator complexOperation = (x, y) -> {
            int sum = x + y;
            int product = x * y;
            System.out.println("Sum inside lambda: " + sum);
            return product;
        };
        System.out.println("Complex operation (product): " + complexOperation.operate(3, 4));
    }
}
```

## 6.4. Exception Handling

**Exception handling** is a mechanism to deal with runtime errors (exceptions) that disrupt the normal flow of a program. It allows your program to gracefully recover from errors or terminate in a controlled manner, rather than crashing.

### Key Keywords:
* `try`: A block of code where you suspect an exception might occur.
* `catch`: A block of code that handles the exception if it occurs in the `try` block.
* `finally`: A block of code that is always executed, whether an exception occurred or not. It's typically used for cleanup operations (e.g., closing files, database connections).
* `throw`: Used to explicitly throw an exception.
* `throws`: Used in a method signature to declare that a method might throw certain types of exceptions.

### Types of Exceptions:
* **Checked Exceptions:** Exceptions that are checked at compile time. The compiler forces you to either `catch` them or `declare` them using `throws`. (e.g., `IOException`, `SQLException`).
* **Unchecked Exceptions (Runtime Exceptions):** Exceptions that are not checked at compile time. They occur due to programming errors (e.g., `NullPointerException`, `ArrayIndexOutOfBoundsException`, `ArithmeticException`). You are not forced to handle them, but it's good practice for critical paths.
* **Errors:** Serious problems that an application should not try to catch (e.g., `OutOfMemoryError`, `StackOverflowError`).

**Example:**

```java
import java.io.FileReader;
import java.io.IOException;

public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        // --- Example 1: ArithmeticException (Unchecked) ---
        try {
            int result = 10 / 0; // This will throw an ArithmeticException
            System.out.println("Result: " + result); // This line will not be executed
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
            System.out.println("Exception message: " + e.getMessage());
        } finally {
            System.out.println("Finally block for division example.");
        }
        System.out.println("Program continues after division example.\n");

        // --- Example 2: ArrayIndexOutOfBoundsException (Unchecked) ---
        int[] numbers = {1, 2, 3};
        try {
            System.out.println(numbers[5]); // This will throw ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds!");
        }
        System.out.println("Program continues after array example.\n");

        // --- Example 3: IOException (Checked) with try-with-resources (Java 7+) ---
        // This ensures resources are closed automatically
        try (FileReader reader = new FileReader("nonexistent.txt")) {
            int charCode = reader.read();
            System.out.println("Character read: " + (char) charCode);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            System.out.println("Finally block for file reading example.");
        }
        System.out.println("Program continues after file example.\n");

        // --- Example 4: Custom Exception and 'throw' / 'throws' ---
        try {
            validateAge(15);
        } catch (InvalidAgeException e) {
            System.out.println("Custom Exception Caught: " + e.getMessage());
        }
        try {
            validateAge(20); // This will not throw an exception
        } catch (InvalidAgeException e) {
            System.out.println("This won't be printed.");
        }
    }

    // Custom Exception Class
    static class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(message);
        }
    }

    // Method that declares it might throw InvalidAgeException
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or older."); // Explicitly throw
        } else {
            System.out.println("Age is valid: " + age);
        }
    }
}
```


## 6.5. Object Cloning

**Object cloning** in Java is the process of creating an exact copy of an object. The `Object` class provides a `protected` method `clone()` for this purpose.

### Key Concepts:
* **`Cloneable` interface:** A marker interface (has no methods). A class must implement `Cloneable` to indicate that its objects can be cloned. If you call `clone()` on an object that doesn't implement `Cloneable`, it will throw a `CloneNotSupportedException`.
* **`clone()` method:** The `protected Object clone() throws CloneNotSupportedException` method in the `Object` class. You typically override this method in your class and call `super.clone()` to get a shallow copy.

### Shallow Copy vs. Deep Copy:
* **Shallow Copy:** The `clone()` method by default performs a shallow copy. This means that if your object contains references to other objects, only the references are copied, not the objects themselves. Both the original and the cloned object will share the same nested objects.
* **Deep Copy:** To perform a deep copy, you need to manually clone all nested objects within your overridden `clone()` method.

**Example (Shallow Copy):**

```java
// Class to be nested inside another class
class Address {
    String city;
    String street;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + ", street=" + street + "]";
    }
}

// Class that implements Cloneable for shallow copy
class Employee implements Cloneable {
    int id;
    String name;
    Address address; // Reference type field

    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // Overriding the clone method to perform shallow copy
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // This performs a shallow copy
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
    }
}

public class ShallowCloneDemo {
    public static void main(String[] args) {
        Address addr1 = new Address("New York", "Broadway");
        Employee emp1 = new Employee(101, "Alice", addr1);

        try {
            Employee emp2 = (Employee) emp1.clone(); // Shallow clone

            System.out.println("Original: " + emp1);
            System.out.println("Cloned:   " + emp2);

            // Verify if they are different objects (references)
            System.out.println("emp1 == emp2: " + (emp1 == emp2)); // false
            // Verify if their nested Address objects are the same (references)
            System.out.println("emp1.address == emp2.address: " + (emp1.address == emp2.address)); // true (shallow copy)

            // Modify the nested object in the cloned object
            emp2.address.city = "Los Angeles";
            emp2.name = "Bob"; // Modifying primitive type field

            System.out.println("\nAfter modification of cloned object:");
            System.out.println("Original: " + emp1); // Original's address city also changed!
            System.out.println("Cloned:   " + emp2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
```
**Output:**
```
Original: Employee [id=101, name=Alice, address=Address [city=New York, street=Broadway]]
Cloned:   Employee [id=101, name=Alice, address=Address [city=New York, street=Broadway]]
emp1 == emp2: false
emp1.address == emp2.address: true

After modification of cloned object:
Original: Employee [id=101, name=Alice, address=Address [city=Los Angeles, street=Broadway]]
Cloned:   Employee [id=101, name=Bob, address=Address [city=Los Angeles, street=Broadway]]
```
Notice how changing `emp2.address.city` also changed `emp1.address.city` because both `emp1` and `emp2` share the *same* `Address` object.

**Example (Deep Copy):**
To achieve a deep copy, you must manually clone the mutable objects within your class.

```java
// Class to be nested inside another class (must also be Cloneable for deep copy)
class AddressDeep implements Cloneable {
    String city;
    String street;

    public AddressDeep(String city, String street) {
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + ", street=" + street + "]";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // Shallow copy of Address itself
    }
}

// Class that implements Cloneable for deep copy
class EmployeeDeep implements Cloneable {
    int id;
    String name;
    AddressDeep address; // Reference type field

    public EmployeeDeep(int id, String name, AddressDeep address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // Overriding the clone method to perform DEEP copy
    @Override
    public Object clone() throws CloneNotSupportedException {
        EmployeeDeep clonedEmployee = (EmployeeDeep) super.clone(); // Shallow copy of Employee
        // Now, perform a deep copy of the mutable Address object
        clonedEmployee.address = (AddressDeep) address.clone();
        return clonedEmployee;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
    }
}

public class DeepCloneDemo {
    public static void main(String[] args) {
        AddressDeep addr1 = new AddressDeep("New York", "Broadway");
        EmployeeDeep emp1 = new EmployeeDeep(101, "Alice", addr1);

        try {
            EmployeeDeep emp2 = (EmployeeDeep) emp1.clone(); // Deep clone

            System.out.println("Original: " + emp1);
            System.out.println("Cloned:   " + emp2);

            // Verify if their nested Address objects are different (references)
            System.out.println("emp1.address == emp2.address: " + (emp1.address == emp2.address)); // false (deep copy)

            // Modify the nested object in the cloned object
            emp2.address.city = "Los Angeles";
            emp2.name = "Bob";

            System.out.println("\nAfter modification of cloned object:");
            System.out.println("Original: " + emp1); // Original's address city remains unchanged!
            System.out.println("Cloned:   " + emp2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
```
**Output:**
```
Original: Employee [id=101, name=Alice, address=Address [city=New York, street=Broadway]]
Cloned:   Employee [id=101, name=Alice, address=Address [city=New York, street=Broadway]]
emp1.address == emp2.address: false

After modification of cloned object:
Original: Employee [id=101, name=Alice, address=Address [city=New York, street=Broadway]]
Cloned:   Employee [id=101, name=Bob, address=Address [city=Los Angeles, street=Broadway]]
```
Now, `emp1.address.city` remains "New York" because `emp2` has its own independent `AddressDeep` object.
