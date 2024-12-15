package java8_features.j8_2_streams.streams_api_operations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Introduction to Streams API:
 * - Introduced in Java 8.
 * - Primary purpose: To perform operations on collections.
 * - Enables easy parallel operations without manually managing threads.
 * - Can also be used with arrays or any kind of I/O resources.
 *
 * What is a Stream?
 * - A Stream is a sequence of elements derived from:
 *   - Collections (e.g., List, Set, etc.)
 *   - Arrays
 *   - I/O resources
 *   - Other data sources.
 *
 * Example:
 *   List<String> names = Arrays.asList("adam", "dan", "jenny");
 *   names.stream();          // Creates a sequential stream
 *   names.parallelStream();  // Creates a parallel stream
 *
 * Note:
 * - Stream operations can be performed either sequentially or in parallel.
 */

public class StreamApiDemo {

    // Example of map()
    public static void mapExample() {
        // Convert a list of numbers to their squares
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream()
                .map(n -> n * n) // Transform each number to its square
                .collect(Collectors.toList());
        System.out.println("Squares: " + squares);
    }

    // Example of flatMap()
    public static void flatMapExample() {
        // Flatten a list of lists into a single list
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C", "D"),
                Arrays.asList("E", "F")
        );
        List<String> flatList = nestedList.stream()
                .flatMap(List::stream) // Flatten the nested lists
                .collect(Collectors.toList());
        System.out.println("Flat List: " + flatList);
    }

    // Example of distinct(), count(), and sorted()
    public static void distinctCountSortedExample() {
        List<Integer> numbers = Arrays.asList(5, 2, 3, 5, 3, 1);
        List<Integer> uniqueSortedNumbers = numbers.stream()
                .distinct() // Get unique elements
                .sorted()   // Sort the elements
                .collect(Collectors.toList());
        long count = uniqueSortedNumbers.stream().count(); // Count unique elements
        System.out.println("Unique Sorted Numbers: " + uniqueSortedNumbers);
        System.out.println("Count: " + count);
    }

    // Example of filter()
    public static void filterExample() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A")) // Filter names starting with 'A'
                .collect(Collectors.toList());
        System.out.println("Filtered Names: " + filteredNames);
    }

    // Example of reduce()
    public static void reduceExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .reduce(0, Integer::sum); // Reduce the stream to a sum of its elements
        System.out.println("Sum: " + sum);
    }

    // Example of max() and min() using reduce()
    public static void maxMinExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int max = numbers.stream()
                .reduce(Integer.MIN_VALUE, Integer::max); // Find the maximum element
        int min = numbers.stream()
                .reduce(Integer.MAX_VALUE, Integer::min); // Find the minimum element
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }

    // Example of limit() and skip()
    public static void limitSkipExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> limitedNumbers = numbers.stream()
                .limit(5) // Take the first 5 elements
                .collect(Collectors.toList());
        List<Integer> skippedNumbers = numbers.stream()
                .skip(5) // Skip the first 5 elements
                .collect(Collectors.toList());
        System.out.println("Limited Numbers: " + limitedNumbers);
        System.out.println("Skipped Numbers: " + skippedNumbers);
    }

    // Example of anyMatch(), allMatch(), and noneMatch()
    public static void matchExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean anyMatch = numbers.stream().anyMatch(n -> n > 3); // Check if any element > 3
        boolean allMatch = numbers.stream().allMatch(n -> n > 0); // Check if all elements > 0
        boolean noneMatch = numbers.stream().noneMatch(n -> n < 0); // Check if no element < 0
        System.out.println("Any Match (>3): " + anyMatch);
        System.out.println("All Match (>0): " + allMatch);
        System.out.println("None Match (<0): " + noneMatch);
    }

    // Example of findFirst() and findAny()
    public static void findExample() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        Optional<String> first = names.stream().findFirst(); // Find the first element
        Optional<String> any = names.stream().findAny();     // Find any element
        System.out.println("First: " + first.orElse("No Value"));
        System.out.println("Any: " + any.orElse("No Value"));
    }

    // Example of Short Circuiting
    public static void shortCircuitExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean result = numbers.stream().anyMatch(n -> n > 3); // Short circuits once it finds n > 3
        System.out.println("Short Circuit Result (anyMatch >3): " + result);
    }

    // Example of Stateful vs Stateless functions
    public static void statefulStatelessExample() {
        // Stateful: distinct() and sorted()
        List<Integer> numbers = Arrays.asList(5, 2, 3, 5, 3, 1);
        List<Integer> uniqueSortedNumbers = numbers.stream()
                .distinct() // Stateful operation
                .sorted()   // Stateful operation
                .collect(Collectors.toList());
        System.out.println("Stateful Operations Result: " + uniqueSortedNumbers);

        // Stateless: map()
        List<String> names = Arrays.asList("Alice", "Bob");
        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase) // Stateless operation
                .collect(Collectors.toList());
        System.out.println("Stateless Operations Result: " + upperCaseNames);
    }

    public static void main(String[] args) {
        mapExample();
        flatMapExample();
        distinctCountSortedExample();
        filterExample();
        reduceExample();
        maxMinExample();
        limitSkipExample();
        matchExample();
        findExample();
        shortCircuitExample();
        statefulStatelessExample();
    }
}
