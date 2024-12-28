package ocjp_cerification_concepts.abstraction;

// Example demonstrating key concepts of Interfaces and Abstract Classes
interface Flyable {
    // Interface methods are implicitly public and abstract
    void fly(); // Abstract method - must be implemented by any implementing class

    // Default method - introduced in Java 8
    default void takeOff() {
        System.out.println("Taking off from default method in Flyable interface");
    }

    // Static method - introduced in Java 8
    static void showDescription() {
        System.out.println("This is a static method in the Flyable interface");
    }
}

// Another interface to demonstrate multiple inheritance
interface Swimmable {
    void swim(); // Abstract method
}

// Abstract class demonstrating shared implementation
abstract class Animal12 {
    private String name;

    // Abstract class constructor
    public Animal12(String name) {
        this.name = name;
    }

    // Concrete method
    public void eat() {
        System.out.println(name + " is eating");
    }

    // Abstract method - must be implemented by subclasses
    public abstract void sound();

    // Final method - cannot be overridden
    public final void sleep() {
        System.out.println(name + " is sleeping");
    }
}

// Concrete class implementing multiple interfaces and extending an abstract class
class Bird extends Animal12 implements Flyable, Swimmable {
    public Bird(String name) {
        super(name); // Call to abstract class constructor
    }

    // Implementing abstract method from Animal12 class
    @Override
    public void sound() {
        System.out.println("Bird chirps");
    }

    // Implementing method from Flyable interface
    @Override
    public void fly() {
        System.out.println("Bird is flying");
    }

    // Implementing method from Swimmable interface
    @Override
    public void swim() {
        System.out.println("Bird is swimming");
    }

    // Resolving conflict between multiple default methods (if present)
    // Uncomment this section if two interfaces with conflicting methods are implemented
    /*
    @Override
    public void takeOff() {
        Flyable.super.takeOff(); // Specify which interface's default method to use
        System.out.println("Overridden takeOff method in Bird class");
    }
    */
}

public class AbstractInterfaceExample {
    public static void main(String[] args) {
        // Abstract Class and Concrete Class Interaction
        Animal12 bird = new Bird("Parrot"); // Polymorphism: Animal12 reference, Bird object
        bird.eat(); // Calls concrete method in Animal12
        bird.sound(); // Calls overridden method in Bird
        bird.sleep(); // Calls final method in Animal12 (cannot be overridden)

        // Interface Interaction
        Flyable flyingBird = new Bird("Sparrow");
        flyingBird.fly(); // Calls implemented method
        flyingBird.takeOff(); // Calls default method in Flyable interface
        Flyable.showDescription(); // Calls static method in Flyable interface

        // Demonstrating Multiple Inheritance with Interfaces
        Swimmable swimmingBird = new Bird("Duck");
        swimmingBird.swim(); // Calls implemented method
    }
}

