package java8_features.j8_2_streams.streams_factory_methods;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamFactoryMethods {

    public static void main(String[] args) {

        // 1. Using Stream.of() - Creates a stream with specified elements.
        // Example:
        Stream<String> stringStream = Stream.of("adam", "dan", "julie");
        stringStream.forEach(System.out::println); // Output: adam, dan, julie

        // 2. Using Stream.iterate() - Generates an infinite stream based on a seed and a unary operator.
        // Example:
        Stream<Integer> iterateStream = Stream.iterate(1, x -> x * 2);
        iterateStream.limit(5).forEach(System.out::println); // Output: 1, 2, 4, 8, 16
        // Explanation:
        // - The seed is 1 (starting value).
        // - The unary operator x -> x * 2 is applied repeatedly to generate the next element.
        // - We use .limit(5) to restrict the infinite stream to 5 elements.

        // 3. Using Stream.generate() - Creates an infinite stream using a Supplier.
        // Example:
        Supplier<Double> randomSupplier = Math::random; // Supplier providing random values.
        Stream<Double> generateStream = Stream.generate(randomSupplier);
        generateStream.limit(5).forEach(System.out::println); // Output: 5 random numbers
        // Explanation:
        // - The Supplier provides a new value for each element in the stream.
        // - We use .limit(5) to restrict the infinite stream to 5 elements.

        // Additional Example: Stream.generate() with custom Supplier
        Stream<String> helloStream = Stream.generate(() -> "Hello, World!");
        helloStream.limit(3).forEach(System.out::println); // Output: Hello, World! (3 times)
    }
}
