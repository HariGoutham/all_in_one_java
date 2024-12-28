package ocjp_cerification_concepts.inheritance.features;


// Interface A
interface A {
    void show(); // Abstract method to be implemented by classes
}

// Interface B
interface B {
    void show(); // Abstract method to be implemented by classes
}

// Class C implements both interfaces A and B
class C implements A, B {
    @Override
    public void show() {
        System.out.println("Resolved method from class C");
    }
}

// Parent class demonstrating static methods
class Parent10 {
    // Static method in Parent class
    static void show() {
        System.out.println("Parent static method");
    }

    // Parent constructor
    Parent10() {
        System.out.println("Parent Constructor");
    }
}

// Child class extending Parent
class Child10 extends Parent10 {
    // Static method in Child class
    static void show() {
        System.out.println("Child static method");
    }

    // Child constructor
    Child10() {
        // Implicitly calls Parent constructor first
        System.out.println("Child Constructor");
    }
}

// Main class to run the example
public class Miscc1 {
    public static void main(String[] args) {
        // Demonstrating multiple inheritance through interfaces
        C c = new C();
        c.show(); // Calls the show method from class C

        // Demonstrating static methods
        Parent10.show(); // Calls the static method from Parent class
        Child10.show();  // Calls the static method from Child class

        // Demonstrating constructor behavior in inheritance
        Child child = new Child(); // Creates an instance of Child, invoking Parent constructor first
    }
}

//        Explanation of Concepts:

//        Multiple Inheritance through Interfaces:
//        Interfaces A and B both declare a method show(). The class C implements both interfaces and provides a concrete implementation of the show() method.
//        When c.show() is called, it invokes the show() method defined in class C, which prints "Resolved method from class C".

//        Access Control:
//        In this example, we don't explicitly demonstrate access control violations, but it's important to note that private members of a parent class are
//        not accessible in the child class, even if you try to access them using super. This is a key point to remember when dealing with inheritance.

//        Static Methods:
//        The Parent class has a static method show(), and the Child class also defines a static method with the same name. This is known as method hiding, not overriding.
//        When Parent.show() is called, it prints "Parent static method". When Child.show() is called, it prints "Child static method". T
//        his demonstrates that static methods belong to the class rather than instances of the class.

//        Constructor Behavior in Inheritance:
//        When an instance of Child is created with new Child(), the constructor of the Parent class is called first, even though it is not explicitly invoked. This is the default behavior in Java.
//        The output will first show "Parent Constructor" followed by "Child Constructor".