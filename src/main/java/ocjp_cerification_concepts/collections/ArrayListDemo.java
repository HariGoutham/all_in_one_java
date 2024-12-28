package ocjp_cerification_concepts.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        // Adding elements
        list.add("Apple");
        list.add("Banana");
        list.add("Apple");
        list.add("Banana");
        list.add(1, "Orange"); // Insert "Orange" at index 1

        System.out.println("1: " + list);

        // Removing elements
        list.remove("Banana"); // Removes "Banana"

        System.out.println("2: " + list);

        // Accessing elements
        String fruit = list.get(0); // Retrieves "Apple"
        System.out.println("3: " + list);
        list.set(0, "Grapes"); // Replaces "Apple" with "Grapes"
        System.out.println("4: " + list);

        // Other operations
        list.add("Apple");
        int index = list.indexOf("Apple"); // index is 0
        int lastIndex = list.lastIndexOf("Apple"); // lastIndex is 1
        List<String> subList = list.subList(0, 2); // subList contains ["Grapes"]

        // Output the final list
        System.out.println("Final List: " + list);
        System.out.println("SubList: " + subList);
    }

}
