package java8_features.j8_1_functional_interface.example;


/*
 * Reasons for Adding Lambda Expressions in Java 8:
 *
 * 1. Streamlined Code:
 *    - Lambda expressions make Java more concise and expressive.
 *    - They allow behavior to be passed as data, reducing boilerplate code.
 *
 * 2. Support for Lambdas:
 *    - Lambda expressions target functional interfaces, enabling functional-style programming.
 *    - This allows developers to write cleaner and more maintainable code.
 *
 * 3. Immutability and Parallelism:
 *    - Functional programming emphasizes immutability, which helps in writing safer code.
 *    - It makes it easier to implement parallelism and thread-safe operations.
 */

/*
 * Functional Interfaces
 *
 * Exists Since: Java 1.0
 *
 * Definition:
 * A Functional Interface (also known as a Single Abstract Method Interface or SAM Interface)
 * is an interface that has exactly one abstract method (but it can have default methods from java 8)
 *
 * @FunctionalInterface Annotation:
 * Introduced in JDK 1.8.
 * This is an optional annotation used to signify an interface as a Functional Interface.
 * It helps prevent accidental addition of extra abstract methods in the interface.
 */

@FunctionalInterface
public interface Greeting {
    void greet(String message); // Single abstract method
}
