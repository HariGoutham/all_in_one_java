package ocjp_cerification_concepts.inheritance.features;

// Parent class demonstrating different access modifiers
class Parent7 {
    // Private variable: Not inherited and accessible only within this class
    private String privateVar = "I am private";

    // Protected variable: Accessible in child classes and within the same package
    protected String protectedVar = "I am protected";

    // Public variable: Fully accessible from anywhere
    public String publicVar = "I am public";

    // Default (package-private) variable: Accessible within the same package
    String defaultVar = "I am default (package-private)";

    // Method to demonstrate access to private variable
    void showPrivate() {
        System.out.println(privateVar); // Accessible here
    }
}

// Child class that extends Parent
class Child7 extends Parent7 {
    void display() {
        // System.out.println(privateVar); // Not accessible: privateVar is not inherited

        // Accessing protected variable from Parent
        System.out.println(protectedVar); // Accessible here

        // Accessing public variable from Parent
        System.out.println(publicVar); // Accessible here

        // Accessing default variable from Parent
        System.out.println(defaultVar); // Accessible here
    }
}

// Another class in the same package to demonstrate default access
class SamePackageClass {
    void display() {
        Parent7 parent = new Parent7();
        // System.out.println(parent.privateVar); // Not accessible: privateVar is not inherited
        // System.out.println(parent.protectedVar); // Not accessible: protectedVar is not inherited outside the child class
        System.out.println(parent.publicVar); // Accessible here
        System.out.println(parent.defaultVar); // Accessible here
    }
}

// Main class to run the example
public class AccessModifiers {
    public static void main(String[] args) {
        Child child = new Child();
        child.display(); // Displaying access from Child class

        SamePackageClass samePackage = new SamePackageClass();
        samePackage.display(); // Displaying access from another class in the same package
    }
}

//    Explanation of Access Modifiers:

//        Private:
//        The privateVar variable in the Parent class is marked as private. This means it is not accessible outside the Parent class, including in the Child class.
//        The commented-out line in the Child class demonstrates that trying to access privateVar will result in a compilation error.
//        The method showPrivate() in the Parent class can access privateVar because it is within the same class.

//        Protected:
//        The protectedVar variable is marked as protected. This means it is accessible in the Child class (which extends Parent) and also within the same package.
//        The Child class can access protectedVar without any issues.

//        Public:
//        The publicVar variable is marked as public. This means it is accessible from anywhere, including from the Child class and any other class in any package.
//        The Child class can access publicVar without any restrictions.

//        Default (Package-Private):
//        The defaultVar variable has no access modifier specified, making it package-private (default). This means it is accessible within the same package.
//        The Child class can access defaultVar because it is in the same package as Parent.
//        The SamePackageClass also demonstrates that it can access publicVar and defaultVar from the Parent class, but it cannot access privateVar or protectedVar since it is not a subclass.