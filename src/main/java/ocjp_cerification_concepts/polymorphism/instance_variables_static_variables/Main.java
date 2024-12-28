package ocjp_cerification_concepts.polymorphism.instance_variables_static_variables;

class Animal {
    // Instance variable
    String name = "Animal";
    // Static variable
    static String species = "Generic Animal";
    void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    // Instance variable (hides the instance variable in Animal)
    String name = "Dog";
    // Static variable (hides the static variable in Animal)
    static String species = "Dog";
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an Animal reference pointing to a Dog object
        Animal myAnimal = new Dog();
        // Accessing instance variable
        System.out.println("Instance variable (name): " + myAnimal.name); // Outputs "Animal"
        // Accessing static variable
        System.out.println("Static variable (species): " + myAnimal.species); // Outputs "Generic Animal"
        // Calling the overridden method
        myAnimal.makeSound(); // Outputs "Bark"
        // Create a Dog reference
        Dog myDog = new Dog();
        // Accessing instance variable
        System.out.println("Instance variable (name): " + myDog.name); // Outputs "Dog"
        // Accessing static variable
        System.out.println("Static variable (species): " + myDog.species); // Outputs "Dog"
        // Calling the overridden method
        myDog.makeSound(); // Outputs "Bark"
    }
}

//        Explanation of the Example

//        Instance Variables:
//        The Animal class has an instance variable name initialized to "Animal".
//        The Dog class has its own instance variable name initialized to "Dog". This variable hides the name variable in the Animal class.

//        Static Variables:
//        The Animal class has a static variable species initialized to "Generic Animal".
//        The Dog class has its own static variable species initialized to "Dog". This variable hides the species variable in the Animal class.

//        Method Overriding:
//        The Dog class overrides the makeSound() method from the Animal class to provide its own implementation.

//        Accessing Variables:
//        When accessing myAnimal.name, it outputs "Animal" because instance variables are resolved based on the reference type (Animal).
//        When accessing myAnimal.species, it outputs "Generic Animal" because static variables are resolved based on the reference type, not the actual object type.
//        When calling myAnimal.makeSound(), it outputs "Bark" because methods are resolved based on the actual object type at runtime.

//        Using a Dog Reference:
//        When we create a Dog reference (myDog), accessing myDog.name outputs "Dog" because it accesses the instance variable in the Dog class.
//        Accessing myDog.species outputs "Dog" because it accesses the static variable in the Dog class.
