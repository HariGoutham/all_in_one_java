package ocjp_cerification_concepts.polymorphism.down_up_casting;

// Base class
class Animal {
    public void sound() {
        System.out.println("Some generic animal sound");
    }
}

// Subclass
class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Bark");
    }

    // Additional method specific to Dog
    public void fetch() {
        System.out.println("Fetching the ball!");
    }
}

public class PolymorphismCastingInstanceOf {
    public static void main(String[] args) {
        // 1. Upcasting: Casting a subclass (Dog) object to a superclass (Animal) reference
        Animal animal = new Dog(); // Implicit upcasting
        animal.sound(); // Calls the overridden method in Dog (polymorphism)

        // Note: Even though `animal` refers to a Dog object, we cannot call Dog-specific methods directly
        // animal.fetch(); // Compile-time error: fetch() is not available in Animal

        // 2. Downcasting: Casting the superclass (Animal) reference back to the subclass (Dog)
        // Before downcasting, it's good practice to use the `instanceof` operator to avoid runtime errors
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal; // Explicit downcasting
            dog.sound(); // Calls the overridden method in Dog
            dog.fetch(); // Access Dog-specific method
        }

        // 3. Invalid Downcasting Example
        // Let's create another instance of Animal that is not a Dog
        Animal anotherAnimal = new Animal();
        if (anotherAnimal instanceof Dog) {
            // This block will NOT execute because anotherAnimal is not an instance of Dog
            Dog invalidDog = (Dog) anotherAnimal; // This would throw a ClassCastException at runtime if not checked
        } else {
            System.out.println("Cannot downcast: anotherAnimal is not a Dog.");
        }
    }
}
