package ocjp_cerification_concepts.encapsulation;

// A class demonstrating immutability principles
// An immutable class is a special type of encapsulated class where its state cannot be changed once the object is created.
// This is especially useful in scenarios where consistent state and thread safety are important.

//Explanation of Concepts

//  1. Encapsulation:
//        Fields are private: The fields name and age are hidden from external access.
//        Controlled access: Only read access is provided via public getter methods.

//  2. Immutability:
//        Final fields: final ensures that fields cannot be reassigned after initialization.
//        No setters: Absence of setters ensures that fields cannot be modified post-object creation.
//        Validation in constructor: Ensures that the object is created in a valid state and remains so throughout its lifecycle.

//  3. Advantages of Immutability:
//        Thread-Safety: Immutable objects are inherently thread-safe as their state cannot be modified.
//        Cache Efficiency: Immutable objects can be safely shared or reused.
//        Reliable Hashing: Consistent hash codes for immutable objects make them ideal for use in collections like HashMap or HashSet.
final class ImmutableStudent {
    // Private and final fields: Cannot be modified after initialization
    private final String name;
    private final int age;

    // Constructor to initialize the fields
    public ImmutableStudent(String name, int age) {
        // Ensuring valid data during object creation
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be greater than zero");
        }
        this.name = name;
        this.age = age; // Fields are set once and cannot be modified later
    }

    // Getter methods for accessing fields
    public String getName() {
        return name; // Provides read-only access
    }

    public int getAge() {
        return age; // Provides read-only access
    }

    // No setter methods: State cannot be modified after creation

    // Overriding toString() for a better string representation of the object
    @Override
    public String toString() {
        return "ImmutableStudent{name='" + name + "', age=" + age + "}";
    }
}

// Main class to test immutability
public class ImmutableClass {
    public static void main(String[] args) {
        // Creating an immutable object
        ImmutableStudent student = new ImmutableStudent("Alice", 20);

        // Displaying student details
        System.out.println(student);

        // Attempting to modify fields is impossible
        // student.name = "Bob"; // Error: name has private access
        // student.setAge(25);  // Error: No setter method provided

        // Showing that the object's state remains consistent
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Age: " + student.getAge());
    }
}

