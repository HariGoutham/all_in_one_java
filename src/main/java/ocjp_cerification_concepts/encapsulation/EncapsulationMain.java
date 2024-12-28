package ocjp_cerification_concepts.encapsulation;

// Encapsulation is the process of wrapping data (fields) and methods (functions) into a single unit (class).
// It restricts direct access to some of an object’s components, which maintains control over the data.
// Improves modularity and code maintainability.
// Enhances data security by controlling access and modification.

// A class demonstrating encapsulation principles
class Student {
    // Private fields: Restricted access
    private String name;
    private int age;

    // Constructor to initialize fields
    // Constructor and Encapsulation: Use constructors to set initial values for fields while maintaining encapsulation.
    public Student(String name, int age) {
        this.name = name; // Using 'this' to avoid ambiguity
        this.age = age;
    }

    // Public getter for 'name' field
    public String getName() {
        return this.name; // Allows controlled read access
    }

    // Public setter for 'name' field
    public void setName(String name) {
        if (name != null && !name.isEmpty()) { // Validating data before assignment
            this.name = name;
        } else {
            System.out.println("Invalid name. Name cannot be empty.");
        }
    }

    // Public getter for 'age' field
    public int getAge() {
        return this.age; // Allows controlled read access
    }

    // Public setter for 'age' field
    // Use meaningful names for getter/setter methods.
    // Add validation logic to ensure data integrity.
    public void setAge(int age) {
        if (age > 0) { // Validation: Age cannot be negative or zero
            this.age = age;
        } else {
            System.out.println("Invalid age. Age must be greater than zero.");
        }
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
    }
}

// Main class to test encapsulation
public class EncapsulationMain {
    public static void main(String[] args) {
        // Creating a Student object
        Student student = new Student("Alice", 20);

        // Displaying initial details
        System.out.println("Initial Details:");
        student.displayStudentDetails();

        // Modifying fields using setters
        System.out.println("\nUpdating Details:");
        student.setName("Bob");
        student.setAge(25);

        // Attempting invalid updates
        student.setName(""); // Invalid name
        student.setAge(-5);  // Invalid age

        // Displaying updated details
        System.out.println("\nUpdated Details:");
        student.displayStudentDetails();
    }
}

