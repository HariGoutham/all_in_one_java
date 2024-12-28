package ocjp_cerification_concepts.generics;

import java.util.ArrayList;
import java.util.List;

public class Generics5WildCards {

    public static void main(String[] args) {

        // Unbounded Wildcard (?)
        // Represents an unknown type.
        List<?> unboundedList = new ArrayList<>();
        // You can add null to an unbounded wildcard list
        unboundedList.add(null); // Allowed
        // unboundedList.add("Hello"); // Compilation error: cannot add any specific type

        // Bounded Wildcard (? extends T)
        // Represents any type that is a subclass of T or T itself.
        List<? extends Number> boundedList = new ArrayList<Integer>();
        // You can read elements as Number, but cannot add elements (except null)
        Number number = boundedList.get(0); // Allowed, but we cannot add to this list
        // boundedList.add(1); // Compilation error: cannot add any specific type

        // Lower Bounded Wildcard (? super T)
        // Represents any type that is a superclass of T or T itself.
        List<? super Integer> lowerBoundedList = new ArrayList<Number>();
        // You can add Integer elements to this list
        lowerBoundedList.add(1); // Allowed
        lowerBoundedList.add(2); // Allowed
        // You can read elements as Object, but not as Integer
        // Integer intValue = lowerBoundedList.get(0); // Compilation error: cannot read as Integer

        // Print the contents of the lower bounded list
        System.out.println("Lower Bounded List Contents:");
        for (Object obj : lowerBoundedList) {
            System.out.println(obj); // Allowed, can treat elements as Object
        }
    }

}
