package ocjp_cerification_concepts.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionHandlingBestPractices {

    // 1. Best Practices
    // 1.1 Catch specific exceptions rather than generic Exception.
    public void catchSpecificException() {
        try {
            int result = 10 / 0; // This will throw ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Caught specific exception: " + e.getMessage());
        }
    }

    // 1.2 Avoid catching Throwable unless absolutely necessary.
    public void avoidCatchingThrowable() {
        try {
            throw new Exception("This is a general exception");
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        // Avoid catching Throwable here
    }

    // 1.3 Always close resources properly (preferably with try-with-resources).
    public void tryWithResourcesExample() {
        try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }

    // 1.4 Log exceptions for debugging.
    public void logExceptions() {
        try {
            int result = 10 / 0; // This will throw ArithmeticException
        } catch (ArithmeticException e) {
            // Log the exception (simulated here with a print statement)
            System.err.println("Error: " + e.getMessage());
        }
    }

    // 1.5 Avoid overusing checked exceptions in APIs.
    public void avoidCheckedExceptions() throws IOException {
        // Simulating a method that throws a checked exception
        throw new IOException("Checked exception example");
    }

    // 2. Exception Propagation
    public void exceptionPropagation() {
        try {
            methodA(); // This will throw a custom exception
        } catch (CustomException e) {
            System.out.println("Caught exception in main: " + e.getMessage());
        }
    }

    public void methodA() throws CustomException {
        methodB(); // This will throw a CustomException
    }

    public void methodB() throws CustomException {
        throw new CustomException("Exception from methodB");
    }

    // 3. Exception and Inheritance
    public void exceptionInheritance() {
        try {
            methodC(); // This will throw a checked exception
        } catch (CustomCheckedException e) {
            System.out.println("Caught checked exception: " + e.getMessage());
        }
    }

    public void methodC() throws CustomCheckedException {
        throw new CustomCheckedException("Checked exception from methodC");
    }

    // 4. Common Pitfalls and Traps
    public void commonPitfalls() {
        // 4.1 Catching Exception Instead of Specific Exceptions
        try {
            int result = 10 / 0; // This will throw ArithmeticException
        } catch (Exception e) {
            System.out.println("Caught general exception: " + e.getMessage());
        }

        // 4.2 Unchecked Exceptions
        try {
            String str = null;
            System.out.println(str.length()); // This will throw NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught unchecked exception: " + e.getMessage());
        }

        // 4.3 Order of catch Blocks
        try {
            int result = 10 / 0; // This will throw ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException");
        } catch (Exception e) {
            System.out.println("Caught general exception");
        }
    }

    // Custom Exception Classes
    public static class CustomException extends Exception {
        public CustomException(String message) {
            super(message);
        }
    }

    public static class CustomCheckedException extends Exception {
        public CustomCheckedException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        ExceptionHandlingBestPractices examples = new ExceptionHandlingBestPractices();

        System.out.println("Catch Specific Exception:");
        examples.catchSpecificException();

        System.out.println("\nAvoid Catching Throwable:");
        examples.avoidCatchingThrowable();

        System.out.println("\nTry-With-Resources Example:");
        // Uncomment the following line to test try-with-resources
        // examples.tryWithResourcesExample();

        System.out.println("\nLog Exceptions:");
        examples.logExceptions();

        System.out.println("\nException Propagation:");
        examples.exceptionPropagation();

        System.out.println("\nException and Inheritance:");
        examples.exceptionInheritance();

        System.out.println("\nCommon Pitfalls and Traps:");
        examples.commonPitfalls();
    }

/*
Explanation of the Code

Best Practices:
Catch Specific Exceptions: The catchSpecificException method demonstrates catching a specific exception (ArithmeticException) instead of a generic one.
Avoid Catching Throwable: The avoidCatchingThrowable method shows the importance of not catching Throwable, which can lead to catching unintended exceptions.
Try-With-Resources: The tryWithResourcesExample method illustrates the use of try-with-resources for automatic resource management, ensuring that resources are closed properly.
Log Exceptions: The logExceptions method simulates logging an exception for debugging purposes.
Avoid Overusing Checked Exceptions: The avoidCheckedExceptions method demonstrates a method that throws a checked exception, emphasizing the need to use them judiciously in APIs.

Exception Propagation:
The exceptionPropagation method shows how exceptions bubble up the call stack. The methodA calls methodB, which throws a CustomException, demonstrating how exceptions propagate.

Exception and Inheritance:
The exceptionInheritance method illustrates that overridden methods cannot throw new or broader checked exceptions. The methodC throws a CustomCheckedException, which is caught in the main method.

Common Pitfalls and Traps:
Catching Exception Instead of Specific Exceptions: The commonPitfalls method demonstrates the risk of catching a general exception, which can lead to unintended behavior.
Unchecked Exceptions: It shows how to handle unchecked exceptions like NullPointerException.
Order of Catch Blocks: The order of catch blocks is crucial; more specific exceptions should be caught before general ones to avoid unreachable code.

*/
}
