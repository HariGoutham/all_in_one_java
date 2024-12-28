package ocjp_cerification_concepts.exceptions;

import java.io.FileReader;
import java.io.IOException;

/*
Explanation of the Code

Using throw:
The throw statement is used to explicitly throw an exception. In the throwExample method, an IllegalArgumentException is thrown with a custom message.
The exception is caught in the catch block, and the message is printed.

Using throws:
The throws keyword is used in a method signature to declare that the method can throw exceptions.
In the readFile method, IOException is declared, indicating that this method may throw an IOException if the file cannot be found or read.
The caller of this method must handle the exception, as shown in the edgeCases method.

Edge Cases and Critical Scenarios:
Catching Multiple Exceptions: The code demonstrates how to catch multiple exceptions in a single catch block using the multi-catch feature introduced in Java 7.
In this case, both ArithmeticException and NullPointerException are caught.
Using throws with Custom Exceptions: The validateAge method throws an IllegalArgumentException if the age is less than 18. This demonstrates how to throw custom exceptions based on specific conditions.
Exception Propagation: The readFile method is called, and if it throws an IOException, it is caught in the edgeCases method. This shows how exceptions can propagate up the call stack.
 */
public class ExceptionThrowingExamples {

    // 1. Throwing Exceptions
    // 1.1 Using throw
    public void throwExample() {
        try {
            // Explicitly throwing an IllegalArgumentException
            throw new IllegalArgumentException("Invalid argument");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    // 1.2 Using throws
    public void readFile() throws IOException {
        FileReader fr = new FileReader("file.txt");
        // Simulate reading from the file
        System.out.println("Reading from file...");
        fr.close(); // Always close the resource
    }

    // Edge Cases and Critical Scenarios
    public void edgeCases() {
        // 1. Catching multiple exceptions
        try {
            // This will throw an ArithmeticException
            int result = 10 / 0;
            // This will throw a NullPointerException
            String str = null;
            System.out.println(str.length());
        } catch (ArithmeticException | NullPointerException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // 2. Using throws with custom exceptions
        try {
            validateAge(15); // This should throw a custom exception
        } catch (IllegalArgumentException e) {
            System.out.println("Caught custom exception: " + e.getMessage());
        }

        // 3. Exception propagation
        try {
            readFile(); // This will throw IOException if the file does not exist
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
    }

    // Custom method to demonstrate throwing a custom exception
    public void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be at least 18");
        }
        System.out.println("Age is valid: " + age);
    }

    public static void main(String[] args) {
        ExceptionThrowingExamples examples = new ExceptionThrowingExamples();

        System.out.println("Throw Example:");
        examples.throwExample();

        System.out.println("\nEdge Cases Example:");
        examples.edgeCases();
    }
}
