package java8_features.j8_2_streams.parallel_processing;

// Introduction to Parallel Streams - Examples and Explanations

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class ParallelStreamsExample {

    public static void main(String[] args) {

        // Example: Sequential Stream vs Parallel Stream

        // Sequential Stream: Sum of integers from 1 to 1000
        int sequentialSum = IntStream.rangeClosed(1, 1000)
                .sum(); // Processes data sequentially
        System.out.println("Sequential Sum: " + sequentialSum);

        // Parallel Stream: Sum of integers from 1 to 1000
        int parallelSum = IntStream.rangeClosed(1, 1000)
                .parallel() // Processes data in parallel using Fork/Join framework
                .sum();
        System.out.println("Parallel Sum: " + parallelSum);

        // Demonstrating Parallel Stream Splitting and Combining

        // List of numbers from 1 to 20
        List<Integer> numbers = IntStream.rangeClosed(1, 20)
                .boxed()
                .collect(Collectors.toList());

        // Process using Sequential Stream
        System.out.println("Processing Sequentially:");
        numbers.stream()
                .map(num -> {
                    System.out.println("Sequential: Processing number " + num + " in thread " + Thread.currentThread().getName());
                    return num * 2;
                })
                .collect(Collectors.toList());

        // Process using Parallel Stream
        System.out.println("Processing Parallelly:");
        numbers.parallelStream()
                .map(num -> {
                    System.out.println("Parallel: Processing number " + num + " in thread " + Thread.currentThread().getName());
                    return num * 2;
                })
                .collect(Collectors.toList());

        // Impact of Parallelism: Performance Comparison
        long sequentialStartTime = System.currentTimeMillis();
        IntStream.rangeClosed(1, 1000000).sum();
        long sequentialEndTime = System.currentTimeMillis();
        System.out.println("Time taken by Sequential Stream: " + (sequentialEndTime - sequentialStartTime) + "ms");

        long parallelStartTime = System.currentTimeMillis();
        IntStream.rangeClosed(1, 1000000).parallel().sum();
        long parallelEndTime = System.currentTimeMillis();
        System.out.println("Time taken by Parallel Stream: " + (parallelEndTime - parallelStartTime) + "ms");

        // Using Fork/Join Framework Behind Parallel Stream
        // Parallel streams internally split tasks and use Fork/Join framework to execute subtasks concurrently

        System.out.println("Number of threads used: " + Runtime.getRuntime().availableProcessors());

        // Example: Parallel Processing with collect()
        List<Integer> doubledNumbers = numbers.parallelStream()
                .map(num -> num * 2)
                .collect(Collectors.toList());
        System.out.println("Doubled Numbers: " + doubledNumbers);

        // Ensure Proper Use of Parallel Streams (Avoid Shared Mutable State)
        // Example: Incorrect use of shared mutable state (DO NOT DO THIS)
        final int[] sum = {0};
        numbers.parallelStream().forEach(num -> sum[0] += num); // This may result in unpredictable behavior
        System.out.println("Sum with shared mutable state (Incorrect): " + sum[0]);

        // Example: Correct use of parallel streams
        int correctParallelSum = numbers.parallelStream().reduce(0, Integer::sum);
        System.out.println("Sum with reduce (Correct): " + correctParallelSum);
    }
}

