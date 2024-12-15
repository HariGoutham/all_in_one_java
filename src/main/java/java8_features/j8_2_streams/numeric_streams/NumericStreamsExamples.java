package java8_features.j8_2_streams.numeric_streams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

// Numeric Streams - Examples and Explanations
public class NumericStreamsExamples {

    public static void main(String[] args) {

        // Numeric Streams: IntStream, LongStream, DoubleStream

        // IntStream.range() - Creates an IntStream with a range of values (exclusive upper bound).
        IntStream intRange = IntStream.range(1, 50);
        intRange.forEach(System.out::print); // Output: 123...49

        // IntStream.rangeClosed() - Creates an IntStream with a range of values (inclusive upper bound).
        IntStream intRangeClosed = IntStream.rangeClosed(1, 50);
        intRangeClosed.forEach(System.out::print); // Output: 123...50

        // LongStream.range() - Creates a LongStream with a range of values (exclusive upper bound).
        LongStream longRange = LongStream.range(1, 50);
        longRange.forEach(System.out::print); // Output: 123...49

        // LongStream.rangeClosed() - Creates a LongStream with a range of values (inclusive upper bound).
        LongStream longRangeClosed = LongStream.rangeClosed(1, 50);
        longRangeClosed.forEach(System.out::print); // Output: 123...50

        // DoubleStream does not support range() or rangeClosed(), but you can create a DoubleStream using other means.
        DoubleStream doubleStream = DoubleStream.iterate(1.0, n -> n + 1).limit(10);
        doubleStream.forEach(System.out::println); // Output: 1.0, 2.0, ..., 10.0

        // Numeric Streams - Aggregate Functions

        // sum()
        int sum = IntStream.rangeClosed(1, 10).sum();
        System.out.println("Sum: " + sum); // Output: Sum: 55

        // max()
        OptionalInt max = IntStream.rangeClosed(1, 10).max();
        max.ifPresent(value -> System.out.println("Max: " + value)); // Output: Max: 10

        // min()
        OptionalInt min = IntStream.rangeClosed(1, 10).min();
        min.ifPresent(value -> System.out.println("Min: " + value)); // Output: Min: 1

        // average()
        OptionalDouble average = IntStream.rangeClosed(1, 10).average();
        average.ifPresent(value -> System.out.println("Average: " + value)); // Output: Average: 5.5

        // Numeric Streams: Boxing and Unboxing

        // Boxing - Converting primitive int to Integer (Wrapper Class)
        Stream<Integer> boxedStream = IntStream.rangeClosed(1, 5).boxed();
        boxedStream.forEach(System.out::println); // Output: 1, 2, 3, 4, 5

        // Unboxing - Converting Integer (Wrapper Class) to primitive int
        IntStream unboxedStream = Stream.of(1, 2, 3, 4, 5).mapToInt(Integer::intValue);
        unboxedStream.forEach(System.out::println); // Output: 1, 2, 3, 4, 5

        // Numeric Streams - mapToObj(), mapToLong(), mapToDouble()

        // mapToObj() - Convert each numeric element to an Object
        Stream<String> objStream = IntStream.rangeClosed(1, 5).mapToObj(i -> "Number: " + i);
        objStream.forEach(System.out::println); // Output: Number: 1, Number: 2, ...

        // mapToLong() - Convert an IntStream to a LongStream
        LongStream longMappedStream = IntStream.rangeClosed(1, 5).mapToLong(i -> i * 2L);
        longMappedStream.forEach(System.out::println); // Output: 2, 4, 6, 8, 10

        // mapToDouble() - Convert an IntStream to a DoubleStream
        DoubleStream doubleMappedStream = IntStream.rangeClosed(1, 5).mapToDouble(i -> i * 2.5);
        doubleMappedStream.forEach(System.out::println); // Output: 2.5, 5.0, 7.5, 10.0, 12.5
    }
}
