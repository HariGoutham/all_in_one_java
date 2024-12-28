package ocjp_cerification_concepts.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionHandlingExamples {

    // 1. Exception Handling
    // 1.1 try-catch Block
    public void tryCatchExample() {
        try {
            int result = 10 / 0; // This will throw ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero: " + e.getMessage());
        }
    }

    // 1.2 finally Block
    public void finallyBlockExample() {
        try {
            int result = 10 / 0; // This will throw ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Caught exception: " + e.getMessage());
        } finally {
            System.out.println("This will always execute, regardless of exception.");
        }
    }

    // 1.3 try-with-resources (Java 7+)
    public void tryWithResourcesExample() {
        try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }

    // 2. Throwing Exceptions
    // 2.1 Using throw
    public void throwExample() {
        try {
            throw new IllegalArgumentException("Invalid argument");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    // 2.2 Using throws
    public void throwsExample() throws IOException {
        FileReader fr = new FileReader("file.txt");
        // Additional file reading logic can go here
        fr.close(); // Always close the resource
    }

    // Edge Cases and Critical Scenarios
    public void edgeCases() {
        // 1. Multiple catch blocks
        try {
            String str = null;
            System.out.println(str.length()); // This will throw NullPointerException
            int result = 10 / 0; // This will throw ArithmeticException
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }

        // 2. Finally block with return statement
        try {
            return; // This will cause the finally block to execute before returning
        } finally {
            System.out.println("Finally block executed before return.");
        }

        // 3. Exception in finally block
//        try {
//            String test = null; // This will throw ArithmeticException
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Caught exception: " + e.getMessage());
//        } finally {
//            // This will throw an exception
//            throw new RuntimeException("Exception in finally block");
//        }
    }

    public static void main(String[] args) {
        ExceptionHandlingExamples examples = new ExceptionHandlingExamples();

        System.out.println("Try-Catch Example:");
        examples.tryCatchExample();

        System.out.println("\nFinally Block Example:");
        examples.finallyBlockExample();

        System.out.println("\nTry-With-Resources Example:");
        // Uncomment the following line to test try-with-resources
        // examples.tryWithResourcesExample();

        System.out.println("\nThrow Example:");
        examples.throwExample();

        System.out.println("\nThrows Example:");
        try {
            examples.throwsExample();
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }

        System.out.println("\nEdge Cases Example:");
        examples.edgeCases();
    }
}
