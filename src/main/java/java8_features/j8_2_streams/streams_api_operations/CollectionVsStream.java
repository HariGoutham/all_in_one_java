package java8_features.j8_2_streams.streams_api_operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CollectionVsStream {

    public static void main(String[] args) {

        /**
         * 1. Modification:
         *    - Collections: Can add or modify elements.
         *    - Streams: Cannot add or modify elements; they represent a fixed data set.
         */

        // Collections Example
        List<String> list = new ArrayList<>();
        list.add("apple");        // Adds "apple" to the list
        list.set(0, "orange");    // Modifies the first element to "orange"
        System.out.println(list); // Output: [orange]

        // Streams Example
        List<String> names = Arrays.asList("adam", "dan", "jenny");
        names.stream().forEach(System.out::println); // Prints: adam, dan, jenny

//-------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------

        /**
         * 2. Access Order:
         *    - Collections: Can access elements in any order using methods like `get()`.
         *    - Streams: Elements are processed sequentially.
         */

        // Collections Example
        List<String> list2 = Arrays.asList("a", "b", "c", "d");
        System.out.println(list2.get(2)); // Output: c

        // Streams Example
        list2.stream().forEach(System.out::println); // Output: a, b, c, d

//-------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------

        /**
         * 3. Construction:
         *    - Collections: Eagerly constructed.
         *    - Streams: Lazily constructed, populated on demand.
         */

        // Collections Example
        List<String> list3 = Arrays.asList("e", "f", "g", "h"); // Eagerly created

        // Streams Example
        Stream<String> stream = Stream.of("i", "j", "k", "l"); // Lazily created
        stream.forEach(System.out::println); // Output: i, j, k, l

//-------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------
        /**
         * 4. Traversal:
         *    - Collections: Can be traversed multiple times.
         *    - Streams: Can only be traversed once.
         */

        // Collections Example
        List<String> list4 = Arrays.asList("m", "n", "o", "p");
        list4.forEach(System.out::println); // Traversal 1
        list4.forEach(System.out::println); // Traversal 2 (possible)

        // Streams Example
        Stream<String> stream2 = Stream.of("q", "r", "s", "t");
        stream2.forEach(System.out::println); // Traversal 1
        // stream2.forEach(System.out::println); // Throws IllegalStateException
//-------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------
        /**
         * 5. Iteration:
         *    - Collections: Uses external iteration (manual loop).
         *    - Streams: Uses internal iteration (handled internally).
         */

        // Collections Example
        for (String element : list4) {
            System.out.println(element); // Manually iterates over elements
        }

        // Streams Example
        list4.stream().forEach(System.out::println); // Stream handles iteration internally

    }


}
