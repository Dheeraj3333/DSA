# Data Types in Java

In Java, data types specify the different sizes and values that can be stored in variables. Java data types are divided into two main categories:

- **Primitive Data Types**
- **Non-Primitive (Reference) Data Types**

---

## Primitive Data Types

Java gives you basic building blocks called primitive types. These are the smallest units of data. Java has **8 primitive data types**:

### byte
- **Size**: 1 byte
- **Range**: -128 to 127
- **Use**: Saving memory in large arrays
- **Example**: `byte a = 100;`

### short
- **Size**: 2 bytes
- **Range**: -32,768 to 32,767
- **Example**: `short b = 10000;`

### int
- **Size**: 4 bytes
- **Range**: -2,147,483,648 to 2,147,483,647
- **Use**: Default data type for integral values
- **Example**: `int c = 100000;`

### long
- **Size**: 8 bytes
- **Range**: Very large numbers
- **Note**: Use `L` at the end of the number
- **Example**: `long d = 10000000000L;`

### float
- **Size**: 4 bytes
- **Use**: Decimal values with less precision
- **Note**: Use `f` at the end of the number
- **Example**: `float e = 10.5f;`

### double
- **Size**: 8 bytes
- **Use**: Decimal values with more precision
- **Example**: `double f = 99.99;`

### char
- **Size**: 2 bytes
- **Use**: Single 16-bit Unicode character
- **Example**: `char g = 'A';`

### boolean
- **Size**: 1 bit (theoretically)
- **Use**: Only `true` or `false`
- **Example**: `boolean h = true;`

---

## Non-Primitive (Reference) Data Types

These data types are not predefined like primitive types. They are created using constructors or class definitions and can store multiple values or complex behaviors.

### String
- Represents a sequence of characters.
- Example: `String name = "Java";`

### Array
- Stores multiple values of the same type.
- Example: `int[] numbers = {1, 2, 3};`

### Class
- Blueprint for creating objects.
- Example:
  ```java
  class Car {
      String model;
      int year;
  }
