package ocjp_cerification_concepts.polymorphism.compile_and_runtime;

class Animal3 {
    Animal3 getAnimal() { return new Animal3(); }
}

class Dog3 extends Animal3 {
    @Override
    Dog3 getAnimal() { return new Dog3(); } // Valid (covariant return type), Cannot return some other un related type
}

public class OverRideChangeReturnType {

    // If the return type is changed to a subtype (covariant return type), it is valid.
    // However, if it is changed to a different type, it will result in a compile-time error.

    public static void main(String[] args) {
        Animal3 animal = new Dog3();
        System.out.println(animal.getAnimal());
    }
}
