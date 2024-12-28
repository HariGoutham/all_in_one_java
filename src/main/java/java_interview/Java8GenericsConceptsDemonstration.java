package java_interview;
/**
 * Comprehensive Java Generics Concepts Demonstration
 *
 * Concepts Covered:
 * 1. Generic Classes
 * 2. Comparable Interface
 * 3. Comparator Interface
 * 4. Generics Methods and Wildcards
 * 5. Type Erasure
 * 6. Multiple Upper Bounds
 * 7. Static Methods with Generics
 */

import java.io.Serializable;
import java.util.*;

// Generic Class with Multiple Type Parameters
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }
}

// Comparable Implementation
class Student1 implements Comparable<Student1> {
    private String name;
    private int age;

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Natural ordering based on age
    @Override
    public int compareTo(Student1 other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return name + " (Age: " + age + ")";
    }

    public String getName() { return name; }
    public int getAge() { return age; }
}

// Custom Comparator
class Student1NameComparator implements Comparator<Student1> {
    @Override
    public int compare(Student1 s1, Student1 s2) {
        return s1.getName().compareTo(s2.getName());
    }
}

// Generic Method with Wildcards and Upper Bounds
class GenericsUtility {
    // Wildcard with Upper Bound
    public static double sumOfList(List<? extends Number> list) {
        return list.stream()
                .mapToDouble(Number::doubleValue)
                .sum();
    }

    // Multiple Upper Bounds
    public static <T extends Comparable<T> & Serializable> T findMax(T a, T b) {
        return (a.compareTo(b) > 0) ? a : b;
    }

    // Generic Method with Multiple Type Parameters
    public static <T, U> void printPair(T first, U second) {
        System.out.println("First: " + first + ", Second: " + second);
    }

    // Static Method with Type Inference
    public static <T> List<T> createList(T... elements) {
        return Arrays.asList(elements);
    }
}

public class Java8GenericsConceptsDemonstration {
    public static void main(String[] args) {
        // 1. Generic Pair Demonstration
        Pair<String, Integer> pair = new Pair<>("Age", 30);
        System.out.println("Pair: " + pair.getKey() + " = " + pair.getValue());

        // 2. Comparable Demonstration
        List<Student1> Student1s = Arrays.asList(
                new Student1("Alice", 22),
                new Student1("Bob", 20),
                new Student1("Charlie", 25)
        );

        // Natural Ordering (using Comparable)
        Collections.sort(Student1s);
        System.out.println("Sorted by Age: " + Student1s);

        // 3. Comparator Demonstration
        Student1NameComparator nameComparator = new Student1NameComparator();
        Student1s.sort(nameComparator);
        System.out.println("Sorted by Name: " + Student1s);

        // 4. Wildcards and Upper Bounds
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5);

        System.out.println("Sum of Integers: " + GenericsUtility.sumOfList(intList));
        System.out.println("Sum of Doubles: " + GenericsUtility.sumOfList(doubleList));

        // 5. Generic Method Demonstrations
        GenericsUtility.printPair("Hello", 42);
        GenericsUtility.printPair(3.14, true);

        // 6. Static Method with Type Inference
        List<String> stringList = GenericsUtility.createList("A", "B", "C");
        List<Integer> integerList = GenericsUtility.createList(1, 2, 3);

        System.out.println("StringStringBuilderStringBuffer List: " + stringList);
        System.out.println("Integer List: " + integerList);

        // 7. Type Erasure Demonstration
        demonstrateTypeErasure();
    }

    // Type Erasure Demonstration
    @SuppressWarnings("unchecked")
    private static void demonstrateTypeErasure() {
        // Compile-time type information is removed
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();

        // Both become List at runtime
        System.out.println("Type Erasure:");
        System.out.println("StringStringBuilderStringBuffer List Class: " + stringList.getClass());
        System.out.println("Integer List Class: " + integerList.getClass());

        // Potential runtime type issues
        List rawList = stringList;
        rawList.add(42); // Compiles, but can cause runtime errors
    }
}