package ocjp_cerification_concepts.inheritance.main;

//Hybrid inheritance is a combination of two or more types of inheritance. Java does not support hybrid inheritance directly due to the diamond problem, but it can be achieved using interfaces.

interface CanBark {
    void bark();
}

interface CanMeow {
    void meow();
}

class Animal4 {
    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog4 extends Animal4 implements CanBark {
    public void bark() {
        System.out.println("Dog barks");
    }
}

class Cat4 extends Animal4 implements CanMeow {
    public void meow() {
        System.out.println("Cat meows");
    }
}

class Puppy4 extends Dog4 {
    void weep() {
        System.out.println("Puppy weeps");
    }
}

// Explanation: In this example, Dog and Cat implement different interfaces (CanBark and CanMeow, respectively) while both inheriting from Animal. Puppy extends Dog, demonstrating a hybrid structure.
public class HybridInheritance {
    public static void main(String[] args) {
        Puppy4 puppy = new Puppy4();
        puppy.eat(); // Inherited from Animal
        puppy.bark(); // Inherited from Dog
        puppy.weep(); // Puppy’s own method

        Cat4 cat = new Cat4();
        cat.eat(); // Inherited from Animal
        cat.meow(); // Cat's own method
    }
}
