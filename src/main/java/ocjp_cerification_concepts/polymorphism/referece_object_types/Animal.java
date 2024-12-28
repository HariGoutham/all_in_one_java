package ocjp_cerification_concepts.polymorphism.referece_object_types;

class Animal {
    void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Bark");
    }

    void fetch() {
        System.out.println("Fetching...");
    }
}
