package ocjp_cerification_concepts.generics;

import java.util.ArrayList;
import java.util.List;

public class Generics6TypeEraser {


    public static void main(String[] args) {
        // Create a List of Strings using generics
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");

        // Demonstrating type erasure
        // The following line will compile, but the type information is erased at runtime
        printList(stringList);

        List stringList1 = stringList;

        stringList1.add(12);//Here the type no longer exists and is erased.

        // Attempting to use instanceof with a generic type
        Object obj = stringList;


        // Uncommenting the following line will cause a compilation error
        // if (obj instanceof List<String>) { } // Compilation error: cannot use instanceof with generic types

        // Instead, we can check if obj is an instance of List, but it does not know at run time, if its list of integer or list of string etc
        if (obj instanceof List) {
            System.out.println("obj is an instance of List");
        }
    }

    /**
     * This method accepts a List of Strings and prints its elements.
     *
     * @param list A List of Strings
     */
    public static void printList(List<String> list) {
        for (String element : list) {
            System.out.println(element); // Allowed, we can safely treat elements as String
        }
    }
}
