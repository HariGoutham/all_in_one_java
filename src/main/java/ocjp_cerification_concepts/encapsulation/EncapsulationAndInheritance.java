package ocjp_cerification_concepts.encapsulation;

// Key Points

// Private Fields:
//        Private fields of a parent class are not inherited.
//        Subclasses cannot access them directly, even though they are part of the parent class.

//  Access Through Methods:
//        Getter and setter methods of the parent class provide controlled access to these private fields.

// Parent class demonstrating encapsulation
class Parent {
    // Private field (encapsulated)
    private int age;

    // Public getter method to access the private field
    public int getAge() {
        return age;
    }

    // Public setter method to modify the private field
    public void setAge(int age) {
        // Adding validation to ensure valid data
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }
}

// Child class inheriting from the Parent class
class Child extends Parent {
    // Method to display the age using the getter from the parent class
    public void displayAge() {
        System.out.println("Age from Parent class: " + getAge());
    }

    // Additional method to demonstrate setting age using the setter
    public void updateAge(int newAge) {
        setAge(newAge); // Accessing parent's setter
        System.out.println("Age has been updated to: " + getAge());
    }
}

// Concepts Illustrated
//Encapsulation:
//        The field age in the Parent class is private, ensuring it cannot be directly accessed or modified.
//        Getter and setter methods provide controlled access to this field.

//Inheritance:
//        The Child class inherits the getAge() and setAge() methods from the Parent class but cannot directly access the private age field.
//        The Child class uses these methods to interact with the encapsulated data.

//Validation:
//        The setter method in the Parent class includes validation logic, ensuring the integrity of the data (e.g., no negative ages).

// Main class to demonstrate encapsulation and inheritance
public class EncapsulationAndInheritance {
    public static void main(String[] args) {
        // Creating an object of the Child class
        Child child = new Child();

        // Trying to set and get the private field via public methods
        child.updateAge(25); // Setting age through the parent class method
        child.displayAge();  // Displaying age through the parent class method

        // Demonstrating validation in the setter method
        try {
            child.updateAge(-5); // Invalid age, exception will be thrown
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
