package ocjp_cerification_concepts.inheritance.features;


//Constructor Behavior in Inheritance

// Order of Constructor Execution:
// Parent class constructors are called before child class constructors.

// Calling Parent Class Constructor:
// Explicitly using super() or implicitly by default.
// Must be the first statement in the subclass constructor.

class Parent5 {
    // Parent class constructor
    Parent5() {
        System.out.println("Parent Constructor");
    }

    // Method in the parent class
    void display() {
        System.out.println("Display from Parent");
    }
}

class Child5 extends Parent5 {
    // Child class constructor
    Child5() {
        super(); // Calls the parent class constructor, This must be the first statement, otherwise we get compilation error.
        System.out.println("Child Constructor");
    }

    // Overriding the display method from the Parent class
    @Override
    void display() {
        System.out.println("Display from Child");
    }

    // Uncommenting the following method would cause a compilation error

//    @Override
//    private void display() { // This violates the access modifier rule
//        System.out.println("Display from Child with private access");
//    }

}

public class MethodOverridingConstructorChaining {
    public static void main(String[] args) {
        // Creating an instance of Child class
        Child5 child = new Child5(); // This will invoke the Parent constructor first, then the Child constructor
        child.display(); // This will call the overridden method in the Child class
    }
}

//Explanation:

//Constructor Chaining:
//
//        In the Child class constructor, super(); is called, which invokes the constructor of the Parent class. This is an example of constructor chaining,
//        where the child class constructor must call the parent class constructor either explicitly (using super()) or implicitly (if super() is not written,
//        Java automatically calls the no-argument constructor of the parent class).
//        When you create an instance of Child, the output will first show "Parent Constructor" followed by "Child Constructor".

//Method Overriding:
//        The Child class overrides the display() method from the Parent class. The overridden method in the Child class has the same signature (name and parameters) and return type as the method in the Parent class.
//        When child.display() is called, it invokes the overridden method in the Child class, which prints "Display from Child".

//Access Modifier Rule:

//        The commented-out method in the Child class demonstrates a violation of the access modifier rule.
//        If you try to override the display() method with a more restrictive access modifier (like private), it will cause a compilation error.
//        The overridden method must not have a more restrictive access level than the method in the parent class.