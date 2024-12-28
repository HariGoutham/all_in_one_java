package ocjp_cerification_concepts.inheritance.main;

class Animal {
    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

// Explanation: Here, Dog is a subclass of Animal. The Dog class inherits the eat method from the Animal class.
public class SingleInheritance {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat(); // Inherited method
        dog.bark(); // Dog's own method
    }
}
