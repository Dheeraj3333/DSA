# 7. Collection Framework, Vector Class, Enums in Java

This section covers Java's powerful Collection Framework, a legacy collection class, and the concept of Enums.

## 7.1. Collection Framework

The **Java Collection Framework** is a set of interfaces and classes that provide a unified architecture for representing and manipulating collections of objects. It provides various data structures and algorithms for common operations like storing, retrieving, and manipulating data.

### Key Benefits:
* **Reduced programming effort:** Provides ready-to-use data structures.
* **Increased performance:** Highly optimized implementations.
* **Interoperability:** Standardized interfaces allow different implementations to work together.

### Core Interfaces of the Collection Framework:

The framework is built around several core interfaces:

* ### a. `Collection` Interface (Root Interface)
    * The root interface in the collection hierarchy.
    * Defines common operations applicable to all collections (e.g., `add()`, `remove()`, `size()`, `isEmpty()`, `contains()`).

* ### b. `List` Interface
    * Extends `Collection`.
    * Represents an ordered collection (sequence) of elements.
    * Allows duplicate elements.
    * Elements can be accessed by their integer index.
    * **Common Implementations:** `ArrayList`, `LinkedList`, `Vector`.

    **Example (`ArrayList`):**
    `ArrayList` is a dynamic array. It's fast for random access but slower for insertions/deletions in the middle.

    ```java
    import java.util.ArrayList;
    import java.util.List; // Good practice to use interface type for variable

    public class ListDemo {
        public static void main(String[] args) {
            List<String> fruits = new ArrayList<>(); // Using ArrayList
            fruits.add("Apple");
            fruits.add("Banana");
            fruits.add("Apple"); // Duplicates allowed
            fruits.add("Cherry");

            System.out.println("Fruits: " + fruits); // Output: [Apple, Banana, Apple, Cherry]
            System.out.println("Element at index 1: " + fruits.get(1)); // Output: Banana

            fruits.remove("Banana"); // Removes first occurrence
            System.out.println("After removing Banana: " + fruits); // Output: [Apple, Apple, Cherry]

            System.out.println("Contains Cherry? " + fruits.contains("Cherry")); // Output: true
            System.out.println("Size: " + fruits.size()); // Output: 3
        }
    }
    ```

* ### c. `Set` Interface
    * Extends `Collection`.
    * Represents a collection that contains **no duplicate elements**.
    * Does not maintain insertion order (generally).
    * **Common Implementations:** `HashSet`, `LinkedHashSet`, `TreeSet`.

    **Example (`HashSet`):**
    `HashSet` uses a hash table for storage, offering very fast add, remove, and contains operations.

    ```java
    import java.util.HashSet;
    import java.util.Set;

    public class SetDemo {
        public static void main(String[] args) {
            Set<String> uniqueColors = new HashSet<>(); // Using HashSet
            uniqueColors.add("Red");
            uniqueColors.add("Green");
            uniqueColors.add("Blue");
            uniqueColors.add("Red"); // Duplicate, will not be added

            System.out.println("Unique Colors: " + uniqueColors); // Order might vary: [Red, Blue, Green] or similar
            System.out.println("Size: " + uniqueColors.size()); // Output: 3

            System.out.println("Contains Green? " + uniqueColors.contains("Green")); // Output: true
            uniqueColors.remove("Blue");
            System.out.println("After removing Blue: " + uniqueColors); // Output: [Red, Green]
        }
    }
    ```

* ### d. `Map` Interface
    * **Does not extend `Collection`**. It's part of the framework but represents a mapping from keys to values.
    * Stores elements as **key-value pairs**.
    * Keys must be unique; values can be duplicated.
    * **Common Implementations:** `HashMap`, `LinkedHashMap`, `TreeMap`, `Hashtable`.

    **Example (`HashMap`):**
    `HashMap` provides fast key-value lookups.

    ```java
    import java.util.HashMap;
    import java.util.Map;

    public class MapDemo {
        public static void main(String[] args) {
            Map<String, Integer> studentScores = new HashMap<>(); // Using HashMap
            studentScores.put("Alice", 95);
            studentScores.put("Bob", 88);
            studentScores.put("Charlie", 95); // Value can be duplicate
            studentScores.put("Alice", 98); // Key "Alice" already exists, value will be updated

            System.out.println("Student Scores: " + studentScores); // Output: {Bob=88, Alice=98, Charlie=95}
            System.out.println("Alice's score: " + studentScores.get("Alice")); // Output: 98

            System.out.println("Contains key 'Bob'? " + studentScores.containsKey("Bob")); // Output: true
            System.out.println("Contains value 88? " + studentScores.containsValue(88)); // Output: true

            studentScores.remove("Charlie");
            System.out.println("After removing Charlie: " + studentScores); // Output: {Bob=88, Alice=98}

            // Iterating over keys
            System.out.println("\nKeys:");
            for (String name : studentScores.keySet()) {
                System.out.println(name);
            }

            // Iterating over values
            System.out.println("\nValues:");
            for (Integer score : studentScores.values()) {
                System.out.println(score);
            }

            // Iterating over key-value pairs (Entry Set)
            System.out.println("\nEntries:");
            for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }
    ```

## 7.2. Vector Class

The `Vector` class is part of the Java Collection Framework and implements the `List` interface. It's one of the oldest collection classes in Java, introduced in the very first version of Java.

### Key Characteristics:
* **Synchronized:** All methods of `Vector` are synchronized. This means that only one thread can access a `Vector` instance at a time, making it thread-safe.
* **Legacy Class:** While it's thread-safe, `Vector` is generally considered a legacy class. For most modern applications, `ArrayList` (for unsynchronized, fast list operations) and `Collections.synchronizedList(new ArrayList<>())` or `CopyOnWriteArrayList` (for thread-safe list operations) are preferred over `Vector` due to better performance characteristics (synchronization adds overhead).
* **Dynamic Array:** Similar to `ArrayList`, it uses a dynamic array internally.
* **Allows Duplicates:** Like `ArrayList`, it allows duplicate elements.
* **Maintains Insertion Order:** Elements are stored and retrieved in the order they were inserted.

**Example:**

```java
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<String> animals = new Vector<>();

        animals.add("Dog");
        animals.add("Cat");
        animals.add("Elephant");
        animals.add("Dog"); // Duplicates allowed

        System.out.println("Animals in Vector: " + animals); // Output: [Dog, Cat, Elephant, Dog]
        System.out.println("First animal: " + animals.firstElement()); // Output: Dog
        System.out.println("Last animal: " + animals.lastElement());   // Output: Dog

        animals.removeElement("Cat");
        System.out.println("After removing Cat: " + animals); // Output: [Dog, Elephant, Dog]

        System.out.println("Size: " + animals.size()); // Output: 3
    }
}
```

## 7.3. Enums in Java

An **enum** (short for enumeration) in Java is a special data type that represents a fixed set of named constants. It's used when you have a collection of related constant values that don't change.

### Key Characteristics:
* Defined using the `enum` keyword.
* Each enum constant is implicitly `public static final`.
* Enums can have constructors, methods, and fields, just like regular classes (but enum constructors are implicitly `private`).
* Enums can implement interfaces.
* Enums cannot extend classes (as they implicitly extend `java.lang.Enum`).

**Purpose:**
* **Type Safety:** Prevents invalid values. Instead of using arbitrary integers or strings, you use specific enum constants.
* **Readability:** Makes code more readable and self-documenting.
* **Compile-time Checking:** Catches errors at compile time rather than runtime.

**Example:**

```java
// Declaring an Enum for Days of the Week
enum Day {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}

// Enum with custom fields and methods
enum TrafficLight {
    RED("Stop", 30),
    YELLOW("Prepare to stop", 5),
    GREEN("Go", 25);

    private final String action;
    private final int durationSeconds;

    // Enum constructor (implicitly private)
    TrafficLight(String action, int durationSeconds) {
        this.action = action;
        this.durationSeconds = durationSeconds;
    }

    // Getter methods for enum fields
    public String getAction() {
        return action;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public void displayInfo() {
        System.out.println("Light: " + this.name() + ", Action: " + action + ", Duration: " + durationSeconds + "s");
    }
}

public class EnumDemo {
    public static void main(String[] args) {
        // Using Day enum
        Day today = Day.MONDAY;
        System.out.println("Today is: " + today); // Output: Today is: MONDAY

        if (today == Day.SUNDAY || today == Day.SATURDAY) {
            System.out.println("It's the weekend!");
        } else {
            System.out.println("It's a weekday.");
        }

        // Iterating through enum constants
        System.out.println("\nAll days of the week:");
        for (Day d : Day.values()) { // .values() returns an array of all enum constants
            System.out.println(d);
        }

        // Using TrafficLight enum
        TrafficLight currentLight = TrafficLight.RED;
        currentLight.displayInfo(); // Output: Light: RED, Action: Stop, Duration: 30s

        TrafficLight nextLight = TrafficLight.YELLOW;
        nextLight.displayInfo(); // Output: Light: YELLOW, Action: Prepare to stop, Duration: 5s

        System.out.println("Action for GREEN light: " + TrafficLight.GREEN.getAction());
    }
}
