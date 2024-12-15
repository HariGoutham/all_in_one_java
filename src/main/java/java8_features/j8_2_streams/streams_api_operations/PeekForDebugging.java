package java8_features.j8_2_streams.streams_api_operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The .peek() method in Java 8 is part of the Streams API.
 * It is primarily used for debugging or for performing a
 * non-interfering action on each element of the stream as it is being processed.
 *
 * Key Points:
 * 1. Intermediate Operation:
 *    - .peek() is an intermediate operation, meaning it allows
 *      further stream operations to be chained after it.
 *
 * 2. Non-Interfering:
 *    - It does not modify the elements of the stream or change
 *      the result of the stream pipeline.
 *
 * 3. Use Case:
 *    - Commonly used to inspect elements of a stream during
 *      its processing, often for debugging or logging.
 */
public class PeekForDebugging {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Stream pipeline with .peek() for debugging
        List<String> filteredNames = names.stream()
                .peek(name -> System.out.println("Original name: " + name)) // Debugging original elements
                .filter(name -> name.startsWith("A"))                      // Filter names starting with 'A'
                .peek(name -> System.out.println("Filtered name: " + name)) // Debugging filtered elements
                .map(String::toUpperCase)                                   // Transform to uppercase
                .peek(name -> System.out.println("Transformed name: " + name)) // Debugging transformed elements
                .collect(Collectors.toList());                              // Collect into a list

        System.out.println("Final List: " + filteredNames); // Output: [ALICE]
    }
}
