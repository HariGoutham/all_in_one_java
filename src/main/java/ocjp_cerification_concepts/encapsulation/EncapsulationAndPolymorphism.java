package ocjp_cerification_concepts.encapsulation;

//Encapsulation and Polymorphism: Explanation with Example
// Encapsulation and polymorphism are complementary concepts in object-oriented programming.
// Encapsulation focuses on hiding implementation details and exposing only essential methods,
// while polymorphism allows dynamic method binding (method behavior can change depending on the object at runtime).

//Key Points

//  Encapsulation:
//        Hides data by using private fields and exposes behavior through public methods.
//        Provides controlled access to fields, ensuring data security.

//   Polymorphism:
//        Enables dynamic method invocation at runtime.
//        Works seamlessly with encapsulation because objects interact through exposed methods.

// Parent class representing a generic shape
abstract class Shape {
    // Encapsulated field for the color of the shape
    private String color;

    // Constructor to initialize the color
    public Shape(String color) {
        this.color = color;
    }

    // Getter method for the color
    public String getColor() {
        return color;
    }

    // Setter method for the color
    public void setColor(String color) {
        this.color = color;
    }

    // Abstract method for calculating the area
    // Polymorphism: Subclasses will provide specific implementations
    public abstract double calculateArea();

    // Method to display shape details (polymorphic behavior in action)
    public void displayDetails() {
        System.out.println("Shape color: " + getColor());
        System.out.println("Shape area: " + calculateArea());
    }
}

// Subclass for a Circle
class Circle extends Shape {
    private double radius;

    // Constructor to initialize color and radius
    public Circle(String color, double radius) {
        super(color); // Call parent constructor
        this.radius = radius;
    }

    // Implementation of calculateArea specific to Circle
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Subclass for a Rectangle
class Rectangle extends Shape {
    private double length;
    private double width;

    // Constructor to initialize color, length, and width
    public Rectangle(String color, double length, double width) {
        super(color); // Call parent constructor
        this.length = length;
        this.width = width;
    }

    // Implementation of calculateArea specific to Rectangle
    @Override
    public double calculateArea() {
        return length * width;
    }
}

// Main class to demonstrate Encapsulation and Polymorphism
public class EncapsulationAndPolymorphism {
    public static void main(String[] args) {
        // Creating an array of shapes (polymorphic collection)
        Shape[] shapes = {
                new Circle("Red", 5.0),      // Circle with radius 5
                new Rectangle("Blue", 4.0, 6.0) // Rectangle with length 4 and width 6
        };

        // Iterating over shapes and displaying details (polymorphism in action)
        for (Shape shape : shapes) {
            shape.displayDetails(); // Calls the appropriate method at runtime
            System.out.println();
        }
    }
}

