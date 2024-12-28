package ocjp_cerification_concepts.encapsulation;

// A Java Bean is a reusable software component that adheres to specific conventions and encapsulates data.
// Java Beans are extensively used in frameworks like Java EE, Spring, and Hibernate to ensure uniformity in how data is accessed and modified.

//Key Features of a Java Bean

// Encapsulation:
//        Fields are private, ensuring controlled access.

//No-Argument Constructor:
//        A public no-argument constructor allows easy instantiation of the object.

// Getter and Setter Methods:
//        Public methods to get and set the values of private fields.

//Serializable:
//        Java Beans are often serializable to allow object persistence (optional).


import java.io.Serializable;

// A simple Java Bean class
public class JavaBeanEncapsulation implements Serializable {
    // Private fields (Encapsulation)
    private String property;
    private int count;

    // Public no-argument constructor
    public JavaBeanEncapsulation() {
        // Default values for fields (optional)
        this.property = "Default Value";
        this.count = 0;
    }

    // Getter method for 'property'
    public String getProperty() {
        return property;
    }

    // Setter method for 'property'
    public void setProperty(String property) {
        // Validating data before assignment
        if (property == null || property.isEmpty()) {
            throw new IllegalArgumentException("Property cannot be null or empty");
        }
        this.property = property;
    }

    // Getter method for 'count'
    public int getCount() {
        return count;
    }

    // Setter method for 'count'
    public void setCount(int count) {
        // Ensuring only valid data is assigned
        if (count < 0) {
            throw new IllegalArgumentException("Count cannot be negative");
        }
        this.count = count;
    }

    // Overriding toString() for a clear object representation
    @Override
    public String toString() {
        return "JavaBeanEncapsulation{property='" + property + "', count=" + count + "}";
    }
}

//    Explanation of Concepts:

//        Encapsulation:
//        Fields property and count are private, ensuring they can only be accessed and modified through controlled methods.
//        Validation logic in setter methods enforces data integrity.

//        No-Argument Constructor:
//        A no-argument constructor initializes the object with default values. This is critical for frameworks that rely on reflection to create objects (e.g., Spring, Hibernate).

//        Getter and Setter Methods:
//        Provide access to the private fields.
//        Allow validation or transformation of data before assignment or retrieval.

//        toString() Method:
//        Overridden to provide a meaningful string representation of the object.

// Main class to demonstrate Java Bean usage
class JavaBeanDemo {
    public static void main(String[] args) {
        // Creating a Java Bean instance
        JavaBeanEncapsulation bean = new JavaBeanEncapsulation();

        // Displaying default values
        System.out.println("Default Bean: " + bean);

        // Setting values using setter methods
        bean.setProperty("Hello World");
        bean.setCount(42);

        // Accessing values using getter methods
        System.out.println("Property: " + bean.getProperty());
        System.out.println("Count: " + bean.getCount());

        // Displaying updated values
        System.out.println("Updated Bean: " + bean);

        // Invalid input demonstration
        try {
            bean.setCount(-1); // This will throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

