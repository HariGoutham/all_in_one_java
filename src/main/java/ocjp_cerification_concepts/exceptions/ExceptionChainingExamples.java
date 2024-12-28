package ocjp_cerification_concepts.exceptions;

public class ExceptionChainingExamples {

    // Custom Exception Class
    public static class CustomException extends Exception {
        public CustomException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    // 1. Using Constructor with Cause
    public void causeExample() throws CustomException {
        try {
            // Simulate an exception
            throw new NullPointerException("Original exception");
        } catch (NullPointerException e) {
            // Throwing a custom exception with the original exception as the cause
            throw new CustomException("Custom exception occurred", e);
        }
    }

    // 2. Accessing Causes
    public void accessCauseExample() {
        try {
            causeExample(); // This will throw CustomException
        } catch (CustomException e) {
            System.out.println("Caught exception: " + e.getMessage());
            // Accessing the cause of the exception
            Throwable cause = e.getCause();
            if (cause != null) {
                System.out.println("Original cause: " + cause.getMessage());
            }
        }
    }

    // Edge Cases and Critical Scenarios
    public void edgeCases() {
        // 1. Chaining multiple exceptions
        try {
            methodA(); // This will throw a custom exception
        } catch (CustomException e) {
            System.out.println("Caught exception: " + e.getMessage());
            Throwable cause = e.getCause();
            if (cause != null) {
                System.out.println("Original cause: " + cause.getMessage());
            }
        }

        // 2. Handling exceptions without a cause
        try {
            throw new Exception("General exception without cause");
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
            // Accessing the cause, which will be null
            Throwable cause = e.getCause();
            if (cause == null) {
                System.out.println("No cause available.");
            }
        }
    }

    // Method to demonstrate chaining multiple exceptions
    public void methodA() throws CustomException {
        try {
            methodB(); // This will throw an ArithmeticException
        } catch (ArithmeticException e) {
            // Throwing a custom exception with the original exception as the cause
            throw new CustomException("Error in methodA", e);
        }
    }

    // Method that throws an ArithmeticException
    public void methodB() {
        int result = 10 / 0; // This will throw ArithmeticException
    }

    public static void main(String[] args) {
        ExceptionChainingExamples examples = new ExceptionChainingExamples();

        System.out.println("Access Cause Example:");
        examples.accessCauseExample();

        System.out.println("\nEdge Cases Example:");
        examples.edgeCases();
    }
}