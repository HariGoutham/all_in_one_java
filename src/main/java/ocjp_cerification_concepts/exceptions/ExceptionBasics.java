package ocjp_cerification_concepts.exceptions;


/*
Checked Exceptions: These must be either caught or declared in the method signature. Common examples include:
IOException,SQLException,ClassNotFoundException,FileNotFoundException,ParseException

Unchecked Exceptions: These do not require explicit handling and include:
NullPointerException,ArithmeticException,ArrayIndexOutOfBoundsException,ClassCastException,IllegalArgumentException

Errors:
StackOverflowError, OutOfMemoryError, VirtualMachineError
 */
public class ExceptionBasics {

    // 1. Basics of Exceptions in Java
    // 1.1 Definition of Exceptions
    // Exceptions are events that disrupt the normal flow of a program.
    // They are objects that describe an error or unexpected event.

    // 1.2 Types of Exceptions
    // Checked Exceptions: Checked at compile time (e.g., IOException, SQLException).
    // Unchecked Exceptions: Checked at runtime (e.g., NullPointerException, ArithmeticException).
    // Errors: Serious problems that applications should not try to catch (e.g., OutOfMemoryError, StackOverflowError).

    // 1.3 Exception Hierarchy
    // java.lang.Throwable
    // ├── java.lang.Exception
    // │   ├── Checked Exceptions
    // │   └── Runtime (Unchecked) Exceptions
    // └── java.lang.Error

    // Example of Checked Exception
    public void checkedExceptionExample() {
        try {
            throw new java.io.IOException("This is a checked exception");
        } catch (java.io.IOException e) {
            System.out.println("Caught checked exception: " + e.getMessage());
        }
    }

    // Example of Unchecked Exception
    public void uncheckedExceptionExample() {
        try {
            String str = null;
            System.out.println(str.length()); // This will throw NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught unchecked exception: " + e.getMessage());
        }
    }

    // Example of Error
    public void errorExample() {
        try {
            // This will cause a StackOverflowError
            recursiveMethod();
        } catch (StackOverflowError e) {
            System.out.println("Caught error: " + e.getMessage());
        }
    }

    private void recursiveMethod() {
        recursiveMethod(); // Infinite recursion
    }

    // Edge Cases and Critical Scenarios
    public void edgeCases() {
        // 1. Handling multiple exceptions
        try {
            int result = 10 / 0; // ArithmeticException
            String str = null;
            System.out.println(str.length()); // NullPointerException
        } catch (ArithmeticException | NullPointerException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // 2. Finally block execution
        try {
            System.out.println("Inside try block");
            throw new RuntimeException("Exception thrown");
        } catch (RuntimeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed");
        }

        // 3. Custom Exception
        try {
            throw new CustomException("This is a custom exception");
        } catch (CustomException e) {
            System.out.println("Caught custom exception: " + e.getMessage());
        }
    }

    // Custom Exception Class
    public static class CustomException extends Exception {
        public CustomException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        ExceptionBasics eb = new ExceptionBasics();
        eb.checkedExceptionExample();
        eb.uncheckedExceptionExample();
        eb.errorExample();
        eb.edgeCases();
    }
}
