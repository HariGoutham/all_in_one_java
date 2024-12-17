package java_interview;

/**
 * Comprehensive Java Abstraction and Interface Concepts Demonstration
 *
 * Concepts Covered:
 * 1. Abstraction and Generalization
 * 2. Abstract Classes
 * 3. Interfaces
 * 4. Java 8+ Interface Features
 * 5. Access Modifiers
 * 6. Interface vs Abstract Class Comparison
 *
 * Key Learning Objectives:
 * - Understand abstraction principles
 * - Explore interface and abstract class capabilities
 * - Demonstrate modern Java interface features
 */

// Interface with modern Java features
interface Shape {
    // Abstract method (must be implemented by implementing classes)
    double calculateArea();

    // Default method (Java 8+)
    default void printDescription() {
        System.out.println("This is a geometric shape.");
    }

    // Static method (Java 8+)
    static Shape createDefaultShape() {
        return new Circle(1.0);
    }

    // Private method (Java 9+)
    private double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    // Default method using private method
    default double getFormattedArea() {
        return roundToTwoDecimals(calculateArea());
    }
}

// Abstract base class demonstrating abstraction
abstract class GeometricShape implements Shape {
    // Protected member for subclass access
    protected String color;

    // Abstract constructor
    public GeometricShape(String color) {
        this.color = color;
    }

    // Abstract method to be implemented by subclasses
    public abstract double getPerimeter();

    // Concrete method in abstract class
    public String getColor() {
        return color;
    }
}

// Concrete implementation of Shape interface
class Circle extends GeometricShape {
    private double radius;

    public Circle(double radius) {
        this(radius, "Red");
    }

    public Circle(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Another concrete implementation
class Rectangle extends GeometricShape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this(width, height, "Blue");
    }

    public Rectangle(double width, double height, String color) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}

// Functional interface demonstration
@FunctionalInterface
interface ShapeProcessor {
    double process(Shape shape);
}

public class Java7AbstractionAndInterfaceDemonstration {
    public static void main(String[] args) {
        // Demonstrating polymorphism with interfaces and abstract classes
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);

        // Interface default method
        circle.printDescription();

        // Area calculations
        System.out.println("Circle Area: " + circle.getFormattedArea());
        System.out.println("Rectangle Area: " + rectangle.getFormattedArea());

        // Static interface method
        Shape defaultShape = Shape.createDefaultShape();
        System.out.println("Default Shape Area: " + defaultShape.calculateArea());

        // Functional interface demonstration
        ShapeProcessor areaProcessor = shape -> shape.calculateArea();

        System.out.println("Circle Area via Processor: " +
                areaProcessor.process(circle));

        // Demonstrating access to abstract class methods
        if (circle instanceof GeometricShape geometricCircle) {
            System.out.println("Circle Color: " + geometricCircle.getColor());
        }

        // Access Modifier Demonstration
        demonstrateAccessModifiers();
    }

    // Access Modifiers Demonstration
    private static void demonstrateAccessModifiers() {
        System.out.println("\nAccess Modifiers Demonstration:");

        // Access Modifier Levels:
        // public: Accessible everywhere
        // protected: Accessible within package and subclasses
        // default (no modifier): Accessible within package
        // private: Accessible only within the same class

        class AccessDemo {
            public int publicVar = 1;
            protected int protectedVar = 2;
            int defaultVar = 3;
            private int privateVar = 4;

            public void printAccessLevels() {
                System.out.println("Public: " + publicVar);
                System.out.println("Protected: " + protectedVar);
                System.out.println("Default: " + defaultVar);
                System.out.println("Private: " + privateVar);
            }
        }

        AccessDemo demo = new AccessDemo();
        demo.printAccessLevels();
    }
}
