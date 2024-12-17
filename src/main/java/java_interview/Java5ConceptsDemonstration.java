
/**
 * Comprehensive Java Concepts Demonstration
 *
 * Concepts Covered:
 * 1. Classes and Objects
 * 2. Getter and Setter Methods
 * 3. Constructors
 * 4. Reference vs Object vs Instance vs Class
 * 5. Static vs Instance Variables and Methods
 * 6. POJO and Record
 * 7. java.lang.Object
 * 8. this vs super
 * 9. Method Overloading vs Overriding
 * 10. String Manipulation
 * 11. Type Casting and instanceof
 * 12. Packages and Import Statements
 */

// Package declaration (conceptual organization)
package java_interview;

// Import statements
import java.util.ArrayList;
import java.util.List;

// POJO (Plain Old Java Object) Class
class Person {
    // Instance variables (private for encapsulation)
    private String name;
    private int age;

    // Static variable (shared across all instances)
    private static int personCount = 0;

    // Default Constructor
    public Person() {
        this("Unknown", 0);
    }

    // Parameterized Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        personCount++; // Increment static counter
    }

    // Getter Methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Setter Methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Static Method
    public static int getPersonCount() {
        return personCount;
    }

    // Method Overloading
    public void introduce() {
        System.out.println("Hello, I'm a person.");
    }

    public void introduce(String greeting) {
        System.out.println(greeting + ", I'm " + name);
    }

    // Override toString from java.lang.Object
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

// Java Record (Immutable POJO alternative)
record Student(String name, int studentId) {
    // Compact constructor
    public Student {
        if (studentId < 0) {
            throw new IllegalArgumentException("Student ID must be positive");
        }
    }
}

// Inheritance Demonstration for Method Overriding
class Employee extends Person {
    private String department;

    // Constructor using super
    public Employee(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    // Method Overriding
    @Override
    public void introduce() {
        System.out.println("Hello, I'm an employee in " + department);
    }
}

// Main Class Demonstrating Concepts
public class Java5ConceptsDemonstration {
    public static void main(String[] args) {
        // Object Creation and Constructor Usage
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person();

        // Getter and Setter Demonstration
        person2.setName("Bob");
        person2.setAge(25);

        // Static Method Call
        System.out.println("Total Persons: " + Person.getPersonCount());

        // Method Overloading
        person1.introduce();
        person1.introduce("Hi there");

        // String Manipulation
        String fullName = person1.getName() + " Doe";
        System.out.println("Full Name: " + fullName.toUpperCase());

        // StringBuilder Demonstration
        StringBuilder sb = new StringBuilder();
        sb.append("Hello ")
                .append(person1.getName())
                .append("!");
        System.out.println(sb.toString());

        // Record Usage
        Student student = new Student("Charlie", 12345);
        System.out.println("Student: " + student);

        // Inheritance and Method Overriding
        Employee employee = new Employee("David", 35, "Engineering");
        employee.introduce();

        // Casting and instanceof
        Object obj = new Person("Eve", 28);
        if (obj instanceof Person p) {
            System.out.println("Casted Person: " + p);
        }

        // Type Casting and var Reference
        var genericObject = (Person) obj;
        System.out.println("Generic Object: " + genericObject);

        // List with Generics and var
        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
    }
}
