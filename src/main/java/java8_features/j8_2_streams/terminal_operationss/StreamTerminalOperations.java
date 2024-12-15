package java8_features.j8_2_streams.terminal_operationss;

// Stream Terminal Operations - Examples and Explanations

import java.util.*;
import java.util.stream.Collectors;

public class StreamTerminalOperations {

    public static void main(String[] args) {

        // Sample data for examples
        List<String> names = Arrays.asList("Adam", "Eve", "John", "Jane", "Eve", "Paul");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Terminal Operation: forEach()
        // Performs an action for each element in the stream
        names.stream().forEach(System.out::println);

        // Terminal Operation: min() and max()
        // Find the smallest and largest number using a Comparator
        Optional<String> minName = names.stream().min(String::compareTo);
        minName.ifPresent(name -> System.out.println("Min Name: " + name));

        Optional<String> maxName = names.stream().max(String::compareTo);
        maxName.ifPresent(name -> System.out.println("Max Name: " + name));

        // Terminal Operation: reduce()
        // Accumulate elements to compute a single result
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);

        // Terminal Operation: collect()
        // Collect elements into a List
        List<String> collectedNames = names.stream().collect(Collectors.toList());
        System.out.println("Collected Names: " + collectedNames);

        // Terminal Operation: joining()
        // Concatenate all strings with a delimiter, prefix, and suffix
        String joinedNames = names.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Joined Names: " + joinedNames);

        // Terminal Operation: counting()
        // Count the total number of elements in the stream
        long count = names.stream().collect(Collectors.counting());
        System.out.println("Count: " + count);

        // Terminal Operation: mapping()
        // Transform elements before collecting into a List
        List<String> upperCaseNames = names.stream()
                .collect(Collectors.mapping(String::toUpperCase, Collectors.toList()));
        System.out.println("Uppercase Names: " + upperCaseNames);

        // Terminal Operation: maxBy() and minBy()
        // Find the maximum and minimum using a custom comparator
        Optional<Integer> maxNumber = numbers.stream().collect(Collectors.maxBy(Comparator.naturalOrder()));
        maxNumber.ifPresent(num -> System.out.println("Max Number: " + num));

        Optional<Integer> minNumber = numbers.stream().collect(Collectors.minBy(Comparator.naturalOrder()));
        minNumber.ifPresent(num -> System.out.println("Min Number: " + num));

        // Terminal Operation: summingInt() and averagingInt()
        // Compute sum and average of elements
        int totalSum = numbers.stream().collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Total Sum: " + totalSum);

        double average = numbers.stream().collect(Collectors.averagingInt(Integer::intValue));
        System.out.println("Average: " + average);

        // Terminal Operation: groupingBy()
        // Group elements by a property
        Map<Integer, List<String>> groupedByLength = names.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by Length: " + groupedByLength);

        // groupingBy with downstream collector
        Map<Integer, Long> groupedAndCounted = names.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println("Grouped and Counted: " + groupedAndCounted);

        // Terminal Operation: partitioningBy()
        // Partition elements based on a predicate
        Map<Boolean, List<Integer>> partitioned = numbers.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println("Partitioned (Even/Odd): " + partitioned);

        // partitioningBy with downstream collector
        Map<Boolean, Long> partitionedAndCounted = numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0, Collectors.counting()));
        System.out.println("Partitioned and Counted: " + partitionedAndCounted);
    }
}

