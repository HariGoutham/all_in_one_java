package ocjp_cerification_concepts.polymorphism.referece_object_types;

public class Run {

    public static void main(String[] args) {

        Animal myAnimal = new Dog();
        //In this case:
        //The reference type is Animal.
        //The object type is Dog.
        //The type of the reference variable determines which methods can be called.
        //For example, if you have a reference of type Animal, you can only call methods defined in Animal, even if the actual object is of type Dog. Above one.

        myAnimal.makeSound(); // The call to myAnimal.makeSound() works because makeSound() is defined in the Animal class, and the Dog class overrides it.
        //myAnimal.fetch(); // The call to myAnimal.fetch() fails because fetch() is not defined in the Animal class, even though myAnimal is actually a Dog object.

// Why This Matters
// This distinction is important for several reasons:
// Encapsulation: It allows you to write code that works with the base class (Animal) without needing to know the specifics of derived classes (Dog, Cat, etc.). This promotes code reusability and flexibility.
// Polymorphism: You can treat different derived classes uniformly through a common base class reference.
// This is useful in scenarios like collections of objects, where you might want to store different types of animals in a single list.
// Method Overriding: It allows derived classes to provide specific implementations of methods defined in the base class, enabling dynamic behavior based on the actual object type at runtime.

        //Dog dog = new Animal();//fails because of a fundamental principle in object-oriented programming known as type compatibility and inheritance.

// Type Compatibility: In Java (and many other object-oriented languages), a variable can only hold a reference to an object of its own type or a subtype.
// In this case, Dog is a subclass of Animal, but Animal is not a subclass of Dog. Therefore, you cannot assign an Animal reference to a Dog variable.
// Object Creation: When you create an object with new Animal(), you are creating an instance of the Animal class.
// This instance does not have the properties or methods specific to the Dog class.
// Therefore, trying to assign it to a variable of type Dog is not valid because the variable expects a reference to a Dog object,
// which has additional behaviors and properties that an Animal object does not have.
    }
}
