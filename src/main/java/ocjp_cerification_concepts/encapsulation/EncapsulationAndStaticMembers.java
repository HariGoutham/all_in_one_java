package ocjp_cerification_concepts.encapsulation;

//Key Concepts

//Static Fields and Methods:
//        A static field is shared among all instances of the class.
//        A static method can access only static fields and methods.

//Encapsulation with Static Members:
//        Use private access modifiers for static fields.
//        Provide public static methods to safely access and modify these fields.

//Benefits:
//        Controlled access to shared data.
//        Prevents unintended modifications.

// Class demonstrating encapsulation with static members
public class EncapsulationAndStaticMembers {
    // Private static field to store the count (encapsulation)
    private static int count = 0;

    // Public static method to get the current count (getter for encapsulated static field)
    public static int getCount() {
        return count;
    }

    // Public static method to increment the count (encapsulated access)
    public static void incrementCount() {
        count++; // Increment the shared static field
    }

    // Public static method to reset the count (additional encapsulated control)
    public static void resetCount() {
        count = 0; // Reset the shared static field
    }

    // Main method to demonstrate encapsulation with static members
    public static void main(String[] args) {
        // Increment the count using the static method
        EncapsulationAndStaticMembers.incrementCount();
        EncapsulationAndStaticMembers.incrementCount();

        // Access the count using the static getter method
        System.out.println("Current Count: " + EncapsulationAndStaticMembers.getCount()); // Output: 2

        // Reset the count using the static reset method
        EncapsulationAndStaticMembers.resetCount();

        // Verify the reset value
        System.out.println("Count after reset: " + EncapsulationAndStaticMembers.getCount()); // Output: 0
    }
}
