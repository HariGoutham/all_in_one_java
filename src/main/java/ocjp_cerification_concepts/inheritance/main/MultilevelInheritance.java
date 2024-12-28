package ocjp_cerification_concepts.inheritance.main;

class Animal1 {
    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog1 extends Animal1 {
    void bark() {
        System.out.println("Dog barks");
    }
}

class Puppy1 extends Dog1 {
    void weep() {
        System.out.println("Puppy weeps");
    }
}

// Explanation: In this example, Puppy inherits from Dog, which in turn inherits from Animal. Thus, Puppy has access to methods from both Dog and Animal.
public class MultilevelInheritance {
    public static void main(String[] args) {
        Puppy1 puppy = new Puppy1();
        puppy.eat(); // Inherited from Animal
        puppy.bark(); // Inherited from Dog
        puppy.weep(); // Puppy’s own method
    }
}
