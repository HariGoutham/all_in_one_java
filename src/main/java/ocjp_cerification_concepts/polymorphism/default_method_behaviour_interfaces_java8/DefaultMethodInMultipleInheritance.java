package ocjp_cerification_concepts.polymorphism.default_method_behaviour_interfaces_java8;

// Multiple Inheritance: If a class implements multiple interfaces that have the same default method,
// the class must override the method to resolve the ambiguity.
interface Animal1 {
    default String eat() {
        return "Animal is eating";
    }
}

interface Pet {
    default String eat() {
        return "Pet is eating";
    }
}

class Dog1 implements Animal1, Pet {
    @Override
    public String eat() {
        // Resolve ambiguity by providing a specific implementation, If this is removed there will compilation error
        return "Dog is eating";
    }
}

public class DefaultMethodInMultipleInheritance {
    public static void main(String[] args) {

        Animal1 animal = new Dog1();
        System.out.println(animal.eat());
        Pet pet = new Dog1();
        System.out.println(pet.eat());
        Dog1 dog = new Dog1();
        System.out.println(dog.eat());

        //Dog1 dog1 = new Animal1();//'Animal1' is abstract; cannot be instantiated
        //Dog1 dog2 = new Pet();//'Pet' is abstract; cannot be instantiated

    }
}