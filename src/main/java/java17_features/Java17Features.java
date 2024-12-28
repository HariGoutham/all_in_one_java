package java17_features;

import java.util.*;
import java.time.*;
import java.text.NumberFormat;
import java.util.concurrent.Flow;
import java.util.function.Predicate;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

/**
 * Java 17 Features Comprehensive Demonstration
 * Long-Term Support (LTS) Release
 */
public class Java17Features {

    /**
     * 1. Sealed Classes
     * When to use:
     * - Restrict class hierarchies
     * - Define strict inheritance rules
     * - Enhance type safety
     */
    public sealed class Shape
            permits Circle, Rectangle, Triangle {
        private final String name;

        public Shape(String name) {
            this.name = name;
        }
    }

    // Permitted subclasses
    public final class Circle extends Shape {
        public Circle() {
            super("Circle");
        }
    }

    public final class Rectangle extends Shape {
        public Rectangle() {
            super("Rectangle");
        }
    }

    public final class Triangle extends Shape {
        public Triangle() {
            super("Triangle");
        }
    }

    /**
     * 2. Pattern Matching for Switch
     * When to use:
     * - Simplify type checking and casting
     * - Replace complex if-else chains
     * - Improve code readability
     */
    public String patternMatchingSwitch(Object obj) {
        return switch (obj) {
            case Integer i -> "Integer: " + i;
            case Long l -> "Long: " + l;
            case Double d -> "Double: " + d;
            case String s -> "StringStringBuilderStringBuffer: " + s.toUpperCase();
            case null -> "Null value";
            default -> "Unknown type";
        };
    }

    /**
     * 3. Records (Finalized)
     * When to use:
     * - Immutable data classes
     * - Simple data transfer objects
     * - Reducing boilerplate code
     */
    public record Person(String name, int age) {
        // Compact constructor
        public Person {
            Objects.requireNonNull(name);
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }
        }
    }

    /**
     * 4. Enhanced Pseudo-Random Number Generators
     * When to use:
     * - More predictable random generation
     * - Multiple algorithm choices
     * - Improved statistical randomness
     */
    public void randomGeneratorDemo() {
        // New random generator interfaces
        RandomGenerator generator =
                RandomGenerator.of("L64X128MixRandom");

        int randomValue = generator.nextInt(100);
    }

    /**
     * 5. Compact Number Formatting
     * When to use:
     * - Localized number formatting
     * - Short number representations
     * - Internationalization
     */
    public void compactNumberFormattingDemo() {
        NumberFormat shortFormat =
                NumberFormat.getCompactNumberInstance(
                        Locale.US,
                        NumberFormat.Style.SHORT
                );

        String formattedNumber = shortFormat.format(1000); // "1K"
    }

    /**
     * 6. Enhanced Instanceof
     * When to use:
     * - Type checking and casting
     * - Simplified type handling
     * - Reducing explicit casting
     */
    public void enhancedInstanceofDemo(Object obj) {
        if (obj instanceof String s) {
            // Direct use of s as StringStringBuilderStringBuffer
            System.out.println(s.toUpperCase());
        }
    }

    /**
     * 7. Foreign Function & Memory API (Preview)
     * When to use:
     * - Interact with native code
     * - Low-level memory operations
     * - Performance-critical applications
     */
    public void foreignMemoryApiDemo() {
        // Placeholder for foreign memory interactions
        // Actual implementation depends on preview features
    }

    /**
     * 8. Context-Specific Deserialization Filters
     * When to use:
     * - Enhanced security for object deserialization
     * - Filtering incoming objects
     * - Preventing potential security risks
     */
    public void deserializationFilterDemo() {
        Predicate<Class<?>> filter =
                cls -> cls.getPackageName().startsWith("java.");
    }

    /**
     * 9. Deprecate Applet API
     * Removed support for legacy web browser plugins
     */

    /**
     * 10. Strongly Encapsulate JDK Internals
     * Enhanced security and modularization
     */

    /**
     * Main method to demonstrate features
     */
    public static void main(String[] args) {
        Java17Features features = new Java17Features();

        // Example usages
        System.out.println(features.patternMatchingSwitch(42));

        Person person = new Person("John", 30);
        System.out.println(person);
    }
}