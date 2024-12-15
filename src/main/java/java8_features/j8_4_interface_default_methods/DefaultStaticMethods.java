package java8_features.j8_4_interface_default_methods;

// Default and Static Methods in Interfaces - Complex Examples and Explanations

import java.util.Arrays;
import java.util.Comparator;

interface CustomList {

    // Abstract method: must be implemented by the implementing class
    void add(String element);

    // Default method: provides a default implementation
    default void sortList() {
        System.out.println("Sorting using default method in CustomList interface...");
    }

    // Static method: belongs to the interface, cannot be overridden
    static void printDescription() {
        System.out.println("CustomList Interface - Static Method");
    }
}

// Implementing class for CustomList interface
class MyList implements CustomList {

    private java.util.List<String> elements = new java.util.ArrayList<>();

    @Override
    public void add(String element) {
        elements.add(element);
        System.out.println("Added: " + element);
    }

    // Overriding the default method
    @Override
    public void sortList() {
        System.out.println("Sorting using overridden method in MyList class...");
        elements.sort(Comparator.naturalOrder());
        System.out.println("Sorted Elements: " + elements);
    }

    public void displayElements() {
        System.out.println("Elements: " + elements);
    }
}

// Abstract class to compare with interfaces
abstract class AbstractExample {

    // Abstract method
    abstract void abstractMethod();

    // Concrete method
    void concreteMethod() {
        System.out.println("Concrete method in AbstractExample class");
    }
}

public class DefaultStaticMethods {

    public static void main(String[] args) {

        // Example 1: Using the CustomList interface
        CustomList myList = new MyList();
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Cherry");
        myList.sortList(); // Calls overridden method in MyList

        // Calling static method from the interface
        CustomList.printDescription();

        // Example 2: Demonstrating Abstract Class
        AbstractExample abstractExample = new AbstractExample() {
            @Override
            void abstractMethod() {
                System.out.println("Implemented abstract method in AbstractExample");
            }
        };
        abstractExample.abstractMethod();
        abstractExample.concreteMethod();

        // Example 3: Does this enable multiple inheritance?
        MultiInheritanceExample example = new MultiInheritanceExample();
        example.defaultMethodFromInterface1();
        example.defaultMethodFromInterface2();
    }
}

// Example of multiple inheritance using interfaces
interface Interface1 {
    default void defaultMethod() {
        System.out.println("Default method in Interface1");
    }
}

interface Interface2 {
    default void defaultMethod() {
        System.out.println("Default method in Interface2");
    }
}

class MultiInheritanceExample implements Interface1, Interface2 {

    @Override
    public void defaultMethod() {
        // Resolving conflict in multiple default methods
        Interface1.super.defaultMethod();
        Interface2.super.defaultMethod();
        System.out.println("Custom implementation in MultiInheritanceExample");
    }

    public void defaultMethodFromInterface1() {
        Interface1.super.defaultMethod();
    }

    public void defaultMethodFromInterface2() {
        Interface2.super.defaultMethod();
    }
}

