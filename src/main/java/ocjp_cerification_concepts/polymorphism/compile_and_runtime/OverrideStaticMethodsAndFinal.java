package ocjp_cerification_concepts.polymorphism.compile_and_runtime;



class Parent {
    static void staticMethod() {
        System.out.println("Static method in Parent");
    }

    static final void display() {
        System.out.println("Final method in Parent");
    }
}

class Child extends Parent {
    static void staticMethod() {
        System.out.println("Static method in Child");
    }
    // This will cause a compile-time error
    // If a method is declared as final in the superclass, it cannot be overridden in any subclass.
    // Attempting to do so will result in a compile-time error.
    // void display() {
    //     System.out.println("Trying to override final method");
    // }

}

//static methods cannot be overridden. They can be hidden, but this does not exhibit polymorphic behavior.
public class OverrideStaticMethodsAndFinal {

    public static void main(String[] args) {
        Parent.staticMethod();
        Parent.display();
        Child.staticMethod();
    }

}


