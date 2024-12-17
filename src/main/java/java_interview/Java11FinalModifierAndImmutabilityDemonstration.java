package java_interview;

/**
 * Comprehensive Java Final Modifier and Immutability Demonstration
 *
 * Concepts Covered:
 * 1. Final Modifier for Variables, Methods, and Classes
 * 2. Immutable Classes and Objects
 * 3. Defensive Copying
 * 4. Unmodifiable Collections
 * 5. Initializers
 * 6. Record Constructors
 * 7. Enum Constructors
 * 8. Sealed Classes
 * 9. Constructor Access Modifiers
 */

import java.util.*;

// Final Class - Cannot be inherited
final class FinalClassExample {
    // Final method - Cannot be overridden
    public final void finalMethod() {
        System.out.println("This method cannot be overridden");
    }
}

// Immutable Class Example
final class ImmutablePersonRecord {
    // Final fields - cannot be modified after initialization
    private final String name;
    private final int age;
    private final List<String> hobbies;

    // Constructor with defensive copying
    public ImmutablePersonRecord(String name, int age, List<String> hobbies) {
        this.name = name;
        this.age = age;
        // Create a defensive copy to prevent external modification
        this.hobbies = hobbies == null ? new ArrayList<>() : new ArrayList<>(hobbies);
    }

    // Getters return defensive copies or immutable views
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getHobbies() {
        // Return unmodifiable view of the list
        return Collections.unmodifiableList(hobbies);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", hobbies=" + hobbies + "}";
    }
}

// Sealed Class Demonstration
sealed abstract class Shape1
        permits Circle1, Rectangle1, Triangle {
    protected final String color;

    public Shape1(String color) {
        this.color = color;
    }

    public abstract double calculateArea();
}

// Permitted subclasses of sealed Shape1 class
final class Circle1 extends Shape1 {
    private final double radius;

    public Circle1(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

final class Rectangle1 extends Shape1 {
    private final double width;
    private final double height;

    public Rectangle1(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

final class Triangle extends Shape1 {
    private final double base;
    private final double height;

    public Triangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

// Enum with Constructor
enum DaysOfWeek1 {
    // Enum constants with constructor
    MONDAY("Start of the week"),
    TUESDAY("Second day"),
    WEDNESDAY("Middle of the week"),
    THURSDAY("Almost weekend"),
    FRIDAY("End of work week"),
    SATURDAY("Weekend begins"),
    SUNDAY("Weekend day");

    // Final field
    private final String description;

    // Enum constructor (private by default)
    DaysOfWeek1(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

// Record Demonstration (Immutable by design)
record PersonRecord(String name, int age, List<String> hobbies) {
    // Compact constructor for additional validation
    public PersonRecord {
        Objects.requireNonNull(name, "Name cannot be null");
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        // Defensive copy for mutable fields
        hobbies = hobbies == null ? List.of() : List.copyOf(hobbies);
    }
}

public class Java11FinalModifierAndImmutabilityDemonstration {
    // Final local variable
    public static void demonstrateFinalVariable() {
        final int MAX_VALUE = 100;
        // MAX_VALUE = 200; // Compilation error - cannot reassign

        // Final reference - object's state can be modified
        final List<String> finalList = new ArrayList<>();
        finalList.add("Hello"); // Allowed
        // finalList = new ArrayList<>(); // Compilation error
    }

    // Static Initializer Block
    private static final List<String> STATIC_LIST;
    static {
        STATIC_LIST = new ArrayList<>();
        STATIC_LIST.add("Static Initialized");
    }

    // Instance Initializer Block
    private final List<String> instanceList;
    {
        instanceList = new ArrayList<>();
        instanceList.add("Instance Initialized");
    }

    public static void main(String[] args) {
        // Immutable Object Demonstration
        List<String> hobbies = Arrays.asList("Reading", "Swimming");
        ImmutablePersonRecord person = new ImmutablePersonRecord("Alice", 30, hobbies);
        System.out.println("Immutable Person: " + person);

        // Unmodifiable Collection
        List<String> unmodifiableHobbies = person.getHobbies();
        // unmodifiableHobbies.add("Coding"); // Throws UnsupportedOperationException

        // Record Demonstration
        PersonRecord recordPerson = new PersonRecord("Bob", 25,
                Arrays.asList("Coding", "Gaming"));
        System.out.println("Record Person: " + recordPerson);

        // Enum Demonstration
        DaysOfWeek1 today = DaysOfWeek1.WEDNESDAY;
        System.out.println("Today: " + today +
                ", Description: " + today.getDescription());

        // Sealed Class Demonstration
        Shape1[] Shape1s = {
                new Circle1("Red", 5),
                new Rectangle1("Blue", 4, 6),
                new Triangle("Green", 3, 4)
        };

        Arrays.stream(Shape1s).forEach(Shape1 ->
                System.out.println("Shape1: " + Shape1.color +
                        ", Area: " + Shape1.calculateArea())
        );
    }
}
