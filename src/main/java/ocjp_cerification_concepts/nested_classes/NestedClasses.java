package ocjp_cerification_concepts.nested_classes;
/*
Static Nested Class:
=>Created without needing an instance of the outer class.
=>Can access only static members of the outer class.

Non-Static Inner Class
=>Created using an instance of the outer class.
=>Can access all members (static and instance) of the outer class.

Local Inner Class
=>Defined inside a method.
=>Can access final or effectively final variables of the enclosing method and members of the outer class.

Anonymous Inner Class
=>Defined inline, usually for implementing interfaces or extending classes.
=>Does not have a name and cannot have a constructor or static members.
*/
// Outer class containing all types of nested classes
class OuterClass {

    // Static field and instance field of the outer class
    private static String staticField = "Static Field of OuterClass";
    private String instanceField = "Instance Field of OuterClass";

    // 1. Static Nested Class
    static class StaticNestedClass {
        void display() {
            // Can access static members of the outer class directly
            System.out.println("Inside Static Nested Class: " + staticField);

            // Cannot access instance fields directly
            // Uncommenting the below line will cause a compile error:
            // System.out.println(instanceField);
        }
    }

    // 2. Non-Static Inner Class (Member Inner Class)
    class InnerClass {
        void display() {
            // Can access both static and instance members of the outer class
            System.out.println("Inside Non-Static Inner Class: " + instanceField);
            System.out.println("Accessing static member: " + staticField);
        }
    }

    // Method to demonstrate Local Inner Class and Anonymous Inner Class
    void demonstrateLocalAndAnonymousClass() {
        // Local variable to be used in the local inner class
        final String localVariable = "Final Local Variable";

        // 3. Local Inner Class
        class LocalInnerClass {
            void display() {
                // Can access effectively final variables from the enclosing scope
                System.out.println("Inside Local Inner Class: " + localVariable);
                System.out.println("Accessing instance field: " + instanceField);
            }
        }

        // Creating an object of the local inner class and calling its method
        LocalInnerClass localInner = new LocalInnerClass();
        localInner.display();

        // 4. Anonymous Inner Class
        Runnable anonymousClassExample = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Anonymous Inner Class implementing Runnable");
                System.out.println("Accessing instance field: " + instanceField);
            }
        };

        // Running the anonymous inner class
        anonymousClassExample.run();
    }
}

// Driver class to test all nested classes
public class NestedClasses {
    public static void main(String[] args) {
        // 1. Static Nested Class - does not require an instance of the outer class
        OuterClass.StaticNestedClass staticNested = new OuterClass.StaticNestedClass();
        staticNested.display();

        // 2. Non-Static Inner Class - requires an instance of the outer class
        OuterClass outer = new OuterClass(); // Creating an instance of the outer class
        OuterClass.InnerClass inner = outer.new InnerClass(); // Creating an instance of the inner class
        inner.display();

        // 3 & 4. Demonstrating Local Inner Class and Anonymous Inner Class
        outer.demonstrateLocalAndAnonymousClass();
    }
}
