package ocjp_cerification_concepts.polymorphism.compile_and_runtime;

// Key Characteristics:
// Resolved at runtime.
// Requires inheritance (subclass and superclass relationship).
// The method in the subclass must have the same name, return type, and parameters as the method in the superclass.

class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class RuntimePolymorphism {
    public static void main(String[] args) {
        Animal myAnimal = new Dog(); // Upcasting
        myAnimal.sound(); // Calls Dog's sound method

        myAnimal = new Cat(); // Upcasting to Cat
        myAnimal.sound(); // Calls Cat's sound method
    }
}
