package ocjp_cerification_concepts.abstraction;

// Define an abstract class
abstract class Animal1 {
    // Instance variable
    String name;

    // Constructor
    Animal1(String name) {
        this.name = name;
    }

    // Abstract method
    abstract void makeSound();

    // Concrete method
    void eat() {
        System.out.println(name + " is eating");
    }
}

// Extend the abstract class
class Dog1 extends Animal1 {
    Dog1(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Bark");
    }
}

// Another class extending the same abstract class
class Cat1 extends Animal1 {
    Cat1(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Meow");
    }
}

//        Method Implementation:
//        Interface: Cannot have method bodies (prior to Java 8). From Java 8 onwards, interfaces can have default and static methods with bodies.
//        Abstract Class: Can have both abstract methods (without bodies) and concrete methods (with bodies).

//        Multiple Inheritance:
//        Interface: A class can implement multiple interfaces, allowing for multiple inheritance of type.
//        Abstract Class: A class can extend only one abstract class, which limits inheritance to a single hierarchy.

//        Fields:
//        Interface: Can only have static final variables (constants).
//        Abstract Class: Can have instance variables, which can be non-static and mutable.

//        Use Cases:
//        Interface: Best used when you want to define a contract that multiple classes can implement, especially when those classes are not related.
//        Abstract Class: Best used when you want to share code among closely related classes and provide a common base with some shared implementation.

public class AbstractMain {
    public static void main(String[] args) {
        Animal1 myDog = new Dog1("Buddy");
        myDog.makeSound(); // Outputs: Buddy says: Bark
        myDog.eat(); // Outputs: Buddy is eating

        Animal1 myCat = new Cat1("Whiskers");
        myCat.makeSound(); // Outputs: Whiskers says: Meow
        myCat.eat(); // Outputs: Whiskers is eating
    }
}
