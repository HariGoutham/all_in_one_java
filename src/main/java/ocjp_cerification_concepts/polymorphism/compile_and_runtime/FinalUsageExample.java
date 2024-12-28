package ocjp_cerification_concepts.polymorphism.compile_and_runtime;

// FinalUsageExample demonstrates the different usages of the final keyword in Java
public class FinalUsageExample {

    // 1. Final Variable
    // A final variable can only be assigned once. It cannot be changed after initialization.
    final int finalVariable = 10;

    // 2. Final Method
    // A final method cannot be overridden by subclasses.
    final void finalMethod() {
        System.out.println("This is a final method.");
    }

    // 3. Final Class
    // A final class cannot be subclassed.
    final class FinalClass {
        void display() {
            System.out.println("This is a final class.");
        }
    }

    // 4. Final Parameters
    // A final parameter cannot be modified within the method.
    void methodWithFinalParameter(final int param) {
        // param = 20; // This will cause a compilation error
        System.out.println("Final parameter value: " + param);
    }

    public static void main(String[] args) {
        // 5. Using final variable
        FinalUsageExample example = new FinalUsageExample();
        System.out.println("Final Variable: " + example.finalVariable);

        // 6. Using final method
        example.finalMethod();

        // 7. Using final class
        FinalClass finalClassInstance = example.new FinalClass();
        finalClassInstance.display();

        // 8. Using final parameter
        example.methodWithFinalParameter(15);

        // 9. Attempting to change final variable (uncommenting will cause an error)
        // example.finalVariable = 20; // This will cause a compilation error

        // 10. Attempting to override final method (uncommenting will cause an error)
        // SubClass subClassInstance = new SubClass();
        // subClassInstance.finalMethod(); // This will cause a compilation error

        // 11. Attempting to subclass final class (uncommenting will cause an error)
        // class SubClass extends FinalClass { } // This will cause a compilation error
    }

    // 12. Example of subclassing a non-final class
    class NonFinalClass {
        void nonFinalMethod() {
            System.out.println("This is a non-final method.");
        }
    }

    // 13. Subclassing a non-final class
    class SubClass extends NonFinalClass {
        @Override
        void nonFinalMethod() {
            System.out.println("This is an overridden method in the subclass.");
        }
    }
}
