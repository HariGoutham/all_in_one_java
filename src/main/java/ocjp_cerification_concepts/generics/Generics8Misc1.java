package ocjp_cerification_concepts.generics;

import java.util.ArrayList;
import java.util.List;

public class Generics8Misc1 {

    public static void main(String[] args) {
        // 1. Cannot Instantiate Generic Types
        // Uncommenting the following line will cause a compilation error
        // T obj = new T(); // Error: Cannot instantiate the type T

        // 2. Static Members Cannot Use Type Parameters
        // Uncommenting the following code will cause a compilation error
        // class Box<T> {
        //     static T item; // Error: Static members cannot use type parameters
        // }

        // 3. No Primitive Types
        // Generics work only with reference types. Use wrapper classes for primitives.
        List<Integer> integerList = new ArrayList<>(); // Using Integer instead of int
        integerList.add(10);
        integerList.add(20);
        printList(integerList);

        // 4. Cannot Create Arrays of Generic Types
        // Uncommenting the following line will cause a compilation error
        // T[] array = new T[10]; // Error: Cannot create arrays of generic types

        // Example of using a generic method
        String[] stringArray = {"Hello", "Generics", "World"};
        printArray(stringArray); // Calling the generic method

        // 10. Advanced Topics in Generics
        // 1. Multiple Type Parameters
        Pair<String, Integer> pair = new Pair<>("Age", 30);
        System.out.println("Key: " + pair.getKey() + ", Value: " + pair.getValue());

        // 2. Type Inference with the Diamond Operator (<>)
        List<String> list = new ArrayList<>(); // Diamond operator infers the type
        list.add("Java");
        list.add("Generics");
        System.out.println("List: " + list);

        // 3. Using Generics with Inheritance
        B<String> bInstance = new B<>(); // B is a subclass of A
        A<String> bInstance1 = new B<>();
        System.out.println("B instance created.");

        // 4. Wildcard Capture
        List<?> wildcardList = new ArrayList<>();
        // Uncommenting the following line will cause a compilation error
        //helper(wildcardList); // Error: Cannot convert List<?> to List<T>
    }

    // 9. Generic Method
    // A method with its own type parameters independent of the class
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    // 10. Advanced Topics in Generics
    // 1. Multiple Type Parameters
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    // 3. Using Generics with Inheritance
    static class A<T> {
        // Generic class A
    }

    static class B<T> extends A<T> {
        // B is a subclass of A
    }

    // 4. Wildcard Capture
    private static <T> void helper(List<T> list) {
        // Helper method that accepts a List of type T
        System.out.println("Helper method called with list size: " + list.size());
    }

    // Method to print a list of integers
    public static void printList(List<Integer> list) {
        for (Integer number : list) {
            System.out.println("Number: " + number);
        }
    }
}
