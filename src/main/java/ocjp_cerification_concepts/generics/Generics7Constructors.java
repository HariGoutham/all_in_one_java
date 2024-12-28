package ocjp_cerification_concepts.generics;


class GenericClass<T> {
    GenericClass(T item) {
        System.out.println("Item: " + item);
    }
}

// Non-generic class with a generic constructor
class NonGenericClass {
    <T> NonGenericClass(T item) {
        System.out.println("Item: " + item);
    }
}

public class Generics7Constructors {

    public static void main(String[] args) {
        // Using the generic class
        GenericClass<String> genericInstance = new GenericClass<>("Hello");

        // Using the non-generic class with a generic constructor
        NonGenericClass nonGenericInstance = new NonGenericClass(123);
    }
}
