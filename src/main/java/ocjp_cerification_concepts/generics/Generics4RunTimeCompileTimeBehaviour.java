package ocjp_cerification_concepts.generics;

import java.util.ArrayList;
import java.util.List;

public class Generics4RunTimeCompileTimeBehaviour {


    public static void main(String[] args) {

        // Compile-Time Behavior
        List<?> list = new ArrayList<>();

        // Allowed: You can add null to a List<?> because null can be assigned to any reference type
        list.add(null);

        // Compilation Error: You cannot add an Integer (or any specific type) to a List<?>
        // list.add(123); // Compilation error,
        // list.add(123); // Uncommenting this line will cause a compilation error, Modification is not allowed as compiler does not know which type will be added, its similar to raw type (when modification is considered)

        // Run-Time Behavior
        printList(new ArrayList<String>() {{
            add("Hello");
            add("World");
        }});

        printList(new ArrayList<Integer>() {{
            add(1);
            add(2);
        }});
    }

    /**
     * This method accepts a List of any type and prints its elements.
     *
     * @param list A List of unknown type (List<?>)
     */
    public static void printList(List<?> list) {
        // Iterate over the list and print each element
        for (Object element : list) {
            System.out.println(element); // Allowed, because you can treat elements as Object, Reading is allowed
        }
        //list.add("Test");//This will cause error because writing is not allowed, as type is ? , we don't know what can be added.
        //list.add(new Object());// Same, If suppose it is allowed and if we add "Test" earlier and add new Object() now, it will be ambiguity and its like adding raw type.
    }


}
