package ocjp_cerification_concepts.polymorphism.default_method_behaviour_interfaces_java8;


//Static Context: Default methods cannot be static. They are meant to be called on instances of the implementing classes.

// Define an interface with a default method
// If you try to declare a default method as static in the interface, you will get a compilation error.
// Static methods in interfaces are not meant to be overridden or called on instances of implementing classes.
// They belong to the interface itself, not to instances of classes that implement the interface.
interface MyInterface {

// This will cause a compilation error
//    default static void staticDisplay() {
//        System.out.println("Static display method in MyInterface");
//    }

}

// Implementing the interface in a class