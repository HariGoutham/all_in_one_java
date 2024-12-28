package ocjp_cerification_concepts.Abstraction;

// Define an interface
interface Animal {
    void makeSound(); // Method signature
    void eat(); // Another method signature

//    Not allowed
//    public void makeSound() {
//        System.out.println("Bark");
//    }
}

// Implement the interface in a class
class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }

    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }
}

// Another class implementing the same interface
class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }

    @Override
    public void eat() {
        System.out.println("Cat is eating");
    }
}

public class InterfaceMain {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.makeSound(); // Outputs: Bark
        myDog.eat(); // Outputs: Dog is eating

        Animal myCat = new Cat();
        myCat.makeSound(); // Outputs: Meow
        myCat.eat(); // Outputs: Cat is eating
    }
}
