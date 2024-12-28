package ocjp_cerification_concepts.inheritance.main;

class Animal2 {
    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog2 extends Animal2 {
    void bark() {
        System.out.println("Dog barks");
    }
}

class Cat2 extends Animal2 {
    void meow() {
        System.out.println("Cat meows");
    }
}

// Explanation: Here, both Dog and Cat inherit from the Animal class. They can both use the eat method from Animal, but they also have their own specific methods.

public class HierarchicalInheritance {
    public static void main(String[] args) {
        Dog2 dog = new Dog2();
        dog.eat(); // Inherited from Animal
        dog.bark(); // Dog's own method

        Cat2 cat = new Cat2();
        cat.eat(); // Inherited from Animal
        cat.meow(); // Cat's own method
    }
}