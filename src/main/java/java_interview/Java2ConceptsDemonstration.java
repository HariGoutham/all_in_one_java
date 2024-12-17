package java_interview;

import java.util.Scanner; // For input handling

public class Java2ConceptsDemonstration {
    // Static field (belongs to the class)
    private static int staticCounter = 0;

    // Instance field (belongs to each object)
    private int instanceCounter = 0;

    // Method demonstrating method overloading
    public void displayMessage() {
        System.out.println("Default message");
    }

    public void displayMessage(String customMessage) {
        System.out.println(customMessage);
    }

    // Method demonstrating local variables and scope
    public void scopeAndVariableDemo() {
        int localVariable = 10; // Local variable

        if (localVariable > 5) {
            int blockScopedVariable = 20; // Block-scoped variable
            System.out.println("Local variable: " + localVariable);
            System.out.println("Block scoped variable: " + blockScopedVariable);
        }
        // blockScopedVariable is not accessible here
    }

    // Method demonstrating control statements
    public void controlStatementsDemo() {
        // If-else statement
        int x = 10;
        if (x > 5) {
            System.out.println("x is greater than 5");
        } else {
            System.out.println("x is not greater than 5");
        }

        // Switch statement
        switch (x) {
            case 10:
                System.out.println("x is 10");
                break;
            case 20:
                System.out.println("x is 20");
                break;
            default:
                System.out.println("x is neither 10 nor 20");
        }

        // For loop
        for (int i = 0; i < 5; i++) {
            System.out.println("For loop iteration: " + i);
        }

        // While loop
        int counter = 0;
        while (counter < 3) {
            System.out.println("While loop iteration: " + counter);
            counter++;
        }

        // Do-while loop
        do {
            System.out.println("Do-while loop executed");
            counter++;
        } while (counter < 5);
    }

    // Method demonstrating exception handling
    public void exceptionHandlingDemo() {
        try {
            // Potential exception-throwing code
            int result = 10 / 0; // This will throw an ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Caught an arithmetic exception: " + e.getMessage());
        } finally {
            System.out.println("This block always executes");
        }
    }

    // Method demonstrating input parsing
    public void inputParsingDemo() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter an integer: ");
            int parsedInt = scanner.nextInt();

            System.out.print("Enter a double: ");
            double parsedDouble = scanner.nextDouble();

            System.out.println("Parsed Integer: " + parsedInt);
            System.out.println("Parsed Double: " + parsedDouble);
        } catch (Exception e) {
            System.out.println("Error parsing input: " + e.getMessage());
        }
    }

    // Main method - entry point of the program
    public static void main(String[] args) {
        // Creating an object
        Java2ConceptsDemonstration demo = new Java2ConceptsDemonstration();

        // Demonstrating method calls
        demo.displayMessage();
        demo.displayMessage("Custom message");

        demo.scopeAndVariableDemo();
        demo.controlStatementsDemo();
        demo.exceptionHandlingDemo();

        // Uncomment to test input parsing
        // demo.inputParsingDemo();
    }
}