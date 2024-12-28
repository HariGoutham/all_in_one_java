package ocjp_cerification_concepts.inheritance.features;

//        Explanation of Key Concepts:

//        Default Parent (Object):
//        All classes implicitly inherit from java.lang.Object.
//        This means every class in Java has methods like toString(), hashCode(), and equals().

//        Overriding Methods:
//        toString(): Returns a human-readable string representation of the object.
//        equals(): Used for comparing objects logically. Override it to define custom equality logic.
//        hashCode(): Ensures consistent hashing when using objects in hash-based collections like HashMap or HashSet.
//        finalize(): Called by the garbage collector before destroying an object (not frequently used in modern Java).

//        Testing equals() and hashCode():
//        equals() is used to compare logical equality (not reference equality).
//        If equals() is overridden, hashCode() must also be overridden to maintain consistency in hash-based collections.

//        Garbage Collection and finalize():
//        finalize() is invoked by the garbage collector, allowing cleanup before the object is reclaimed.
//        Modern Java discourages using finalize(); instead, prefer try-with-resources or explicit cleanup methods.

class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Overriding toString(): Provides a custom string representation of the object.
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    // Overriding equals(): Compares objects based on name and age.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // If the same reference, they are equal.
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Null or different class type.
        }
        Person other = (Person) obj; // Downcast to compare fields.
        return name.equals(other.name) && age == other.age;
    }

    // Overriding hashCode(): Generates hash code based on name and age.
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age; // Combine hash codes using a prime number.
        return result;
    }

    // finalize(): Called by the garbage collector (not commonly overridden anymore).
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Person object with name " + name + " is being garbage collected.");
    }
}

public class ObjectClassInheritance {
    public static void main(String[] args) {
        // Testing toString()
        Person person1 = new Person("Alice", 25);
        System.out.println(person1); // Output: Person{name='Alice', age=25}

        // Testing equals()
        Person person2 = new Person("Alice", 25);
        Person person3 = new Person("Bob", 30);

        System.out.println("person1 equals person2: " + person1.equals(person2)); // true
        System.out.println("person1 equals person3: " + person1.equals(person3)); // false

        // Testing hashCode()
        System.out.println("person1 hashCode: " + person1.hashCode());
        System.out.println("person2 hashCode: " + person2.hashCode());
        System.out.println("person3 hashCode: " + person3.hashCode());

        // finalize() demonstration
        person1 = null;
        System.gc(); // Request garbage collection (not guaranteed to run finalize immediately).
    }
}
