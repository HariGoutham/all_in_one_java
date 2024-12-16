# Java Basics and Object-Oriented Programming (OOP)

## Basics
### Expressions, Data Types, Operators, Statements
- **Expressions:** Combination of variables, constants, operators, and method calls to compute a value.
- **Data Types:** Primitive (int, char, float, boolean, etc.) and Non-Primitive (String, Arrays, Objects).
- **Operators:** Arithmetic, Logical, Relational, Bitwise, Assignment, Ternary, etc.
- **Statements:** Declaration, Assignment, Control Flow (if, switch, loops), and more.

### Control Flow
- **If-Else Statements:** Used for conditional branching.
- **Switch Case:** Efficient alternative to multiple if-else statements.
- **Loops:** For, While, Do-While for iteration.

### Strings, StringBuilder, StringBuffer
- **String:** Immutable sequence of characters stored in the String Pool.
- **StringBuilder:** Mutable; not thread-safe but faster for single-threaded operations.
- **StringBuffer:** Mutable and thread-safe, but slower than `StringBuilder`.

**Key Differences:**  
| Feature         | String         | StringBuilder      | StringBuffer       |
|-----------------|----------------|--------------------|--------------------|
| **Mutability**  | Immutable      | Mutable            | Mutable            |
| **Thread Safety** | Thread-safe   | Not thread-safe    | Thread-safe        |
| **Performance** | Slower         | Faster             | Slower             |

### Arrays, Enums, Varargs
- **Arrays:** Fixed-size, ordered collection of elements of the same type.
- **Enums:** Special data type for constants (`enum Days { MON, TUE, WED }`).
- **Varargs:** Simplifies method calls by accepting variable arguments (`public void print(String... args)`).

### Autoboxing and Unboxing
- **Autoboxing:** Automatic conversion of primitive types to their wrapper classes (`int → Integer`).
- **Unboxing:** Automatic conversion of wrapper classes to primitive types (`Integer → int`).

### Static and Final Keywords
- **Static:**
    - Belongs to the class rather than instances.
    - Commonly used for utility methods or shared variables.
- **Final:**
    - **Final Variable:** Cannot be reassigned after initialization.
    - **Final Method:** Cannot be overridden by subclasses.
    - **Final Class:** Cannot be subclassed.

---

## Object-Oriented Programming (OOP)
### Classes and Objects
- **Class:** Blueprint for creating objects.
- **Object:** Instance of a class.

### Inheritance
- Enables one class to inherit fields and methods from another.
- Supports **single**, **multilevel**, and **hierarchical** inheritance. (Java does not support multiple inheritance via classes, only interfaces).

### Polymorphism
- **Compile-time (Static):** Method Overloading.
- **Runtime (Dynamic):** Method Overriding.

### Abstraction
- Hiding implementation details and exposing only essential functionality.
- Achieved using **abstract classes** and **interfaces**.

### Encapsulation
- Wrapping data (fields) and methods into a single unit (class).
- Use of private access modifiers and getter/setter methods for controlled access.

### Access Modifiers
| Modifier       | Same Class | Same Package | Subclass | Everywhere |
|----------------|------------|--------------|----------|------------|
| **Private**    | Yes        | No           | No       | No         |
| **Default**    | Yes        | Yes          | No       | No         |
| **Protected**  | Yes        | Yes          | Yes      | No         |
| **Public**     | Yes        | Yes          | Yes      | Yes        |

### Method Overloading and Overriding
- **Overloading:** Same method name, different parameter list.
- **Overriding:** Redefining a method in a subclass with the same signature as in its superclass.

### Final, Immutable Classes, and Sealed Classes
- **Final Classes:** Cannot be extended (`final class MyClass {}`).
- **Immutable Classes:** Classes where instances cannot be modified after creation (e.g., `String`).
- **Sealed Classes:** Restricts which classes can extend or implement them (`sealed class A permits B, C {}`).

### Constructors and Initializers
- **Constructors:** Special methods to initialize objects. (`public MyClass(int x) { ... }`).
- **Initializers:**
    - **Instance Initializer Block:** Executes before the constructor.
    - **Static Initializer Block:** Executes when the class is loaded.

### Nested Classes and Types
- **Inner Class:** Non-static class defined within another class.
- **Static Nested Class:** Static class defined within another class.
- **Anonymous Class:** Class with no name, usually defined inline for single-use cases.

---

## Key Interview Questions
1. **What is the difference between `String`, `StringBuilder`, and `StringBuffer`?**
2. **How does the String Pool work?**
3. **What happens if you declare a method `static` and `final`?**
4. **Explain the difference between `final`, `finally`, and `finalize()`.**
5. **What are the rules for method overloading and overriding?**
6. **How do you achieve immutability in Java?**
7. **What is the difference between `static` and instance methods?**
8. **Why are constructors not inherited?**
9. **What is the purpose of nested and anonymous classes?**
10. **How does autoboxing/unboxing work internally?**
