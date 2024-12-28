package ocjp_cerification_concepts.polymorphism.default_method_behaviour_interfaces_java8;

interface Animal {
    // Abstract method
    void makeSound();

    // Default method
    default void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }

    // Optionally override the default method
    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }
}

class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }

    // Use the default implementation
}

public class DefaultMethodsInInterface {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.makeSound(); // Outputs: Bark
        myDog.eat(); // Outputs: Dog is eating

        Animal myCat = new Cat();
        myCat.makeSound(); // Outputs: Meow
        myCat.eat(); // Outputs: Animal is eating (default implementation)
    }
}


