package java_interview;

// Additional method demonstrating method overriding
public class Java3OverRideAndExtensionDemo extends Java2ConceptsDemonstration{
    @Override
    public void displayMessage() {
        System.out.println("Overridden message from the extended class");
    }

    // Main method - entry point of the program
    public static void main(String[] args) {
        // Creating an object of the extended class
        Java3OverRideAndExtensionDemo extendedDemo = new Java3OverRideAndExtensionDemo();

        // Demonstrating method overriding
        extendedDemo.displayMessage(); // Calls the overridden method

        // Calling methods from the parent class
        extendedDemo.displayMessage("Custom message from extended class");
        extendedDemo.scopeAndVariableDemo();
        extendedDemo.controlStatementsDemo();
        extendedDemo.exceptionHandlingDemo();

        // Uncomment to test input parsing
        // extendedDemo.inputParsingDemo();
    }
}
