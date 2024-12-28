package ocjp_cerification_concepts.polymorphism.compile_and_runtime;

import java.util.ArrayList;
import java.util.List;

// Base class
class Animal6 {
    public void sound() {
        System.out.println("Some generic Animal6 sound");
    }
}

// Subclasses
class Dog6 extends Animal6 {
    @Override
    public void sound() {
        System.out.println("Bark");
    }

    public void fetch() {
        System.out.println("Dog6 fetching the ball!");
    }
}

class Cat6 extends Animal6 {
    @Override
    public void sound() {
        System.out.println("Meow");
    }

    public void scratch() {
        System.out.println("Cat6 scratching the furniture!");
    }
}

public class PolymorphismWithGenerics {
    public static void main(String[] args) {
        // 1. Polymorphism with Generics
        // Generic List that can hold any type of Animal6
        List<Animal6> Animal6s = new ArrayList<>();
        Animal6s.add(new Dog6()); // Add a Dog6 object
        Animal6s.add(new Cat6()); // Add a Cat6 object

        // Iterate through the list and call the sound() method
        for (Animal6 Animal6 : Animal6s) {
            Animal6.sound(); // Polymorphic behavior
        }

        // Note: The specific methods of Dog6 or Cat6 are not directly accessible
        // e.g., Animal6s.get(0).fetch(); // Compile-time error

        // 2. Wildcards in Generics
        // Use ? extends Animal6 to work with a list of any subclass of Animal6
        List<? extends Animal6> wildcardList = new ArrayList<>();
        // Cannot add elements because the exact type is unknown
        // wildcardList.add(new Dog6()); // Compile-time error
        // wildcardList.add(new Animal6()); // Compile-time error

        // Example with an existing list
        List<Dog6> Dog6s = new ArrayList<>();
        Dog6s.add(new Dog6());
        processAnimal6s(Dog6s); // Can pass List<Dog6> due to ? extends Animal6

        // Use ? super Dog6 to allow adding Dog6 or its subclasses
        List<? super Dog6> superList = new ArrayList<>();
        superList.add(new Dog6()); // Can add Dog6
        // superList.add(new Animal6()); // Compile-time error: Only Dog6 or subclasses are allowed
    }

    // Method to process any list of objects extending Animal6
    public static void processAnimal6s(List<? extends Animal6> list) {
        for (Animal6 Animal6 : list) {
            Animal6.sound(); // Polymorphic behavior
        }
    }
}

