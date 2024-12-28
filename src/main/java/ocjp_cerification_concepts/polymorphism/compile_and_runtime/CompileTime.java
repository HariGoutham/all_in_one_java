package ocjp_cerification_concepts.polymorphism.compile_and_runtime;

// Key Characteristics:

// Resolved at compile time.
// Methods can have the same name but must differ in parameter types or number. The method to be invoked is determined at compile time based on the method signature
// Can occur within the same class or in subclasses.

import java.util.List;

class Example {
    int method() { return 1; }
    // This will cause a compilation error, Cannot overload methods solely based on return type. The method signature must differ in parameter types or number.
    // double method() { return 2.0; }

    // Constructors can be overloaded in the same way as methods.
    Example(int a) { }
    Example(String b) { } // Valid constructor overload


    // At runtime, both List<String> and List<Integer> are treated as List<Object> due to type erasure. This means that the Java compiler sees both methods as having the same
    // In Java, method overloading is based on the method signature, which includes the method name and the parameter types.
    // However, due to type erasure, generic types are removed at runtime, which can lead to conflicts when overloading methods that differ only by their generic type parameters.

//    void method(List<String> list) {
//        System.out.println(list);
//    }
//    void method(List<Integer> list) {
//        System.out.println(list);
//    }
}

class Parent4 {
    public void display() { }
}

class Child4 extends Parent4 {
    // The access modifier in the subclass method cannot be more restrictive than the superclass method.
    // For example, if the superclass method is public, the overriding method in the subclass cannot be protected or private.
    // This will cause a compile-time error
    // private void display() { }
}
class MathOperations {
    // Method to add two integers
    int add(int a, int b) {
        return a + b;
    }

    // Method to add three integers
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method to add two doubles
    double add(double a, double b) {
        return a + b;
    }

    //Static methods can be overloaded just like instance methods.
    static int add1(int a, int b) {
        return a + b;
    }

    // Method to add three integers
    static int add1(int a, int b, int c) {
        return a + b + c;
    }

    // Method to add two doubles
    static double add1(double a, double b) {
        return a + b;
    }
}

public class CompileTime {
    public static void main(String[] args) {
        MathOperations math = new MathOperations();
        System.out.println(math.add(5, 10)); // Calls add(int, int)
        System.out.println(math.add(5, 10, 15)); // Calls add(int, int, int)
        System.out.println(math.add(5.5, 10.5)); // Calls add(double, double)
        System.out.println(MathOperations.add1(5, 10)); // Calls static add1(int, int)
        System.out.println(MathOperations.add1(5, 10, 15)); // Calls static add1(int, int, int)
        System.out.println(MathOperations.add1(5.5, 10.5)); // Calls static add1(double, double)
    }
}
