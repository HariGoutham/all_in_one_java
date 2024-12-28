package ocjp_cerification_concepts.polymorphism.default_method_behaviour_interfaces_java8;

//Rules for Static Methods
//Access: Static methods in an interface can only be accessed using the interface name. They cannot be called on instances of implementing classes.
//No Overriding: Static methods in interfaces cannot be overridden by implementing classes.
//If a class implements an interface with a static method, it cannot provide a new implementation for that static method.
//Static Context: Static methods can access only static variables and other static methods in the interface. They cannot access instance variables or instance methods.
interface Animal2 {
    static void info() {
        System.out.println("This is an Animal interface");
    }
}

class Dog2 implements Animal2{

    public void printAnimal(){
        System.out.println("Animal");
    }
}

public class StaticMethods {
    public static void main(String[] args) {
        // Call the static method using the interface name
        Animal2.info(); // Outputs: This is an Animal interface

        Animal2 animal = new Dog2();

        //animal.info(); //Compilation error Static method may be invoked on containing interface class only
    }
}
