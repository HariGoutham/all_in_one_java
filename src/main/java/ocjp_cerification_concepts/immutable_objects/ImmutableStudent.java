package ocjp_cerification_concepts.immutable_objects;


// Immutable class example with critical rules, scenarios, and edge cases explained
public final class ImmutableStudent {

    // Rule 1: Fields must be private to ensure encapsulation
    private final String name;
    private final int age;

    // Example of a mutable field
    private final int[] marks;

    // Rule 2: Constructor initializes all fields (no default constructor)
    // Avoids uninitialized fields and ensures immutability
    public ImmutableStudent(String name, int age, int[] marks) {
        // Strings are immutable, so no defensive copy is needed for "name"
        this.name = name;

        // Primitive types like "int" are inherently immutable
        this.age = age;

        // Defensive copy for mutable objects like arrays
        // Defensive Copy Explanation:
        // - Copies the original array to ensure the caller's changes to the original array
        //   do not affect the internal state of the object.
        // - Ensures that no external reference can modify the state of the object.
        this.marks = marks.clone();
    }

    // Rule 3: No Setter Methods
    // Providing only getters for accessing fields

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int[] getMarks() {
        // Defensive Copy Explanation (Output):
        // - Returns a copy of the internal array to ensure the internal state is not exposed.
        // - Prevents external modification of the internal `marks` array.
        return marks.clone();
    }

    // Rule 4: Prevent Subclassing
    // By declaring the class final, no subclass can introduce mutability
}


/*
Example Scenarios Without Defensive Copies:

int[] originalMarks = {90, 80, 70};
ImmutableStudent student = new ImmutableStudent("Alice", 22, originalMarks);
// Modifying the original array affects the internal state of the object
originalMarks[0] = 100;
System.out.println(student.getMarks()[0]); // Would print 100 (breaks immutability)
 */

// Demonstrating Defensive Copies and Edge Cases
class TestImmutable {
    public static void main(String[] args) {
        // Validating Immutability and Defensive Copies

        int[] originalMarks = {90, 80, 70};
        ImmutableStudent student = new ImmutableStudent("Alice", 22, originalMarks);

        // Modifying the original array after object creation
        originalMarks[0] = 100; // Changes the original array but not the internal state of the object

        // The object maintains its original marks due to the defensive copy
        System.out.println(student.getMarks()[0]); // Prints 90, not 100

        // Attempting to modify the returned array
        int[] marksFromGetter = student.getMarks();
        marksFromGetter[1] = 85; // Changes this copy, but the internal state remains unaffected

        // ImmutableStudent's internal state remains unchanged
        System.out.println(student.getMarks()[1]); // Prints 80, not 85
    }
}

