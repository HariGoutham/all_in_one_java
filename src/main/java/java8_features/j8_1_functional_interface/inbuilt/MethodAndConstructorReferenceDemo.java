package java8_features.j8_1_functional_interface.inbuilt;

import java.util.function.*; // Import common functional interfaces

public class MethodAndConstructorReferenceDemo {

    public static void main(String[] args) {
        // 1. Static Method Reference
        // Syntax: ClassName::staticMethodName
        Function<Double, Double> staticMethodRef = Math::sqrt;
        System.out.println("Square root of 16: " + staticMethodRef.apply(16.0)); // Output: 4.0

        // 2. Instance Method Reference (Bound)
        // Syntax: instance::instanceMethodName
        String message = "hello";
        Supplier<String> boundInstanceMethodRef = message::toUpperCase;
        System.out.println("Uppercase message: " + boundInstanceMethodRef.get()); // Output: "HELLO"

        // 3. Instance Method Reference (Unbound)
        // Syntax: ClassName::instanceMethodName
        BiFunction<String, String, Boolean> unboundInstanceMethodRef = String::equalsIgnoreCase;
        System.out.println("Strings are equal (ignore case): " + unboundInstanceMethodRef.apply("hello", "HELLO")); // Output: true

        // 4. Constructor Reference (Default Constructor)
        // Syntax: ClassName::new
        Supplier<Student> defaultConstructorRef = Student::new;
        Student defaultStudent = defaultConstructorRef.get();
        System.out.println("Default Student Name: " + defaultStudent.getName()); // Output: "Default Student"

        // 5. Constructor Reference (Parameterized Constructor)
        // Syntax: ClassName::new
        Function<String, Student> paramConstructorRef = Student::new;
        Student paramStudent = paramConstructorRef.apply("John Doe");
        System.out.println("Parameterized Student Name: " + paramStudent.getName()); // Output: "John Doe"
    }
}

// Supporting Student class
class Student {
    private String name;

    // Default Constructor
    public Student() {
        this.name = "Default Student";
    }

    // Parameterized Constructor
    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
