package ocjp_cerification_concepts.polymorphism.instance_static_methods;

class Animal {
    static void staticMethod() {
        System.out.println("Static method in Animal");
    }

    void instanceMethod() {
        System.out.println("Instance method in Animal");
    }
}

class Dog extends Animal {
    static void staticMethod() {
        System.out.println("Static method in Dog");
    }

    @Override
    void instanceMethod() {
        System.out.println("Instance method in Dog");
    }
}

//Overriding: This occurs when a subclass provides a specific implementation of a method that is already defined in its superclass.
//When you call an overridden method on an object, the method that gets executed is determined by the actual object type at runtime.

//Hiding: This occurs with static methods. When a subclass defines a static method with the same name and parameters as a static method in its superclass, the subclass's method hides the superclass's method.
//However, this does not exhibit polymorphic behavior because the method that gets executed is determined by the reference type, not the actual object type.

public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Dog();

        myAnimal.staticMethod(); // Calls Animal's static method
        //When you call myAnimal.staticMethod(), it outputs "Static method in Animal".
        //This is because static methods are resolved at compile time based on the reference type (Animal), not the actual object type (Dog).
        //Therefore, the static method in the Animal class is called, and the Dog class's static method is hidden.

        myAnimal.instanceMethod(); // Calls Dog's instance method
        //When you call myAnimal.instanceMethod(), it outputs "Instance method in Dog".
        //This is because instance methods are resolved at runtime based on the actual object type.
        //Since myAnimal is actually a Dog, the overridden instance method in the Dog class is called.

//       Static methods cannot be overridden: They can only be hidden. The method that gets executed is determined by the reference type, not the actual object type.
//       Instance methods can be overridden: The method that gets executed is determined by the actual object type at runtime, allowing for polymorphic behavior.
//       Static method hiding does not exhibit polymorphism: You cannot achieve dynamic method dispatch with static methods, which limits their flexibility compared to instance methods.
    }
}
