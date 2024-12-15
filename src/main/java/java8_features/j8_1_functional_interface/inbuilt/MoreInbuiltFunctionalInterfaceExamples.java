package java8_features.j8_1_functional_interface.inbuilt;

import java.util.function.*;

public class MoreInbuiltFunctionalInterfaceExamples {

    public static void main(String[] args) {

// Example 1: Consumer
        // A Consumer takes a single input and returns no result.
        Consumer<String> printConsumer = s -> System.out.println(s);
        printConsumer.accept("Hello, Consumer!"); // Output: Hello, Consumer!

        // Using default method 'andThen'
        // 'andThen' allows chaining another Consumer after the current one.
        Consumer<String> upperCaseConsumer = s -> System.out.println(s.toUpperCase());
        printConsumer.andThen(upperCaseConsumer).accept("Hello, Consumer!");
        // Output:
        // Hello, Consumer!
        // HELLO, CONSUMER!

        // Example 2: BiConsumer
        // A BiConsumer takes two inputs and returns no result.
        BiConsumer<String, Integer> printWithLength = (s, length) ->
                System.out.println(s + " has length: " + length);
        printWithLength.accept("Hello", 5); // Output: Hello has length: 5

        // Using default method 'andThen'
        // 'andThen' allows chaining another BiConsumer after the current one.
        BiConsumer<String, Integer> printWithLengthAndUpper = (s, length) ->
                System.out.println(s.toUpperCase() + " has length: " + length);
        printWithLength.andThen(printWithLengthAndUpper).accept("Hello", 5);
        // Output:
        // Hello has length: 5
        // HELLO has length: 5

        // Example 3: Predicate
        // A Predicate takes one input and returns a boolean value.
        Predicate<String> isLongerThanFive = s -> s.length() > 5;
        System.out.println(isLongerThanFive.test("Hello")); // Output: false
        System.out.println(isLongerThanFive.test("Hello, World!")); // Output: true

        // Using default method 'and' and 'or'
        // 'and' combines two predicates, returning true only if both are true.
        Predicate<String> isShorterThanTen = s -> s.length() < 10;
        Predicate<String> combinedPredicate = isLongerThanFive.and(isShorterThanTen);
        System.out.println(combinedPredicate.test("Hello, World!")); // Output: false
        System.out.println(combinedPredicate.test("Hello!")); // Output: true

        // Example 4: BiPredicate
        // A BiPredicate takes two inputs and returns a boolean value.
        BiPredicate<String, Integer> isLengthEqual = (s, length) -> s.length() == length;
        System.out.println(isLengthEqual.test("Hello", 5)); // Output: true
        System.out.println(isLengthEqual.test("Hello", 4)); // Output: false

        // Using default method 'and'
        // 'and' combines two BiPredicates, returning true only if both are true.
        BiPredicate<String, Integer> isLengthGreaterThan = (s, length) -> s.length() > length;
        BiPredicate<String, Integer> combinedBiPredicate = isLengthEqual.and(isLengthGreaterThan);
        System.out.println(combinedBiPredicate.test("Hello", 5)); // Output: false
        System.out.println(combinedBiPredicate.test("Hello, World!", 5)); // Output: true

        // Example 5: Function
        // A Function takes one input and produces a result.
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println(stringLength.apply("Hello")); // Output: 5

        // Using default method 'andThen'
        // 'andThen' allows chaining another function after the current one.
        Function<Integer, String> lengthAsString = length -> "Length: " + length;
        Function<String, String> combinedFunction = stringLength.andThen(lengthAsString);
        System.out.println(combinedFunction.apply("Hello")); // Output: Length: 5

        // Example 6: BiFunction
        // A BiFunction takes two inputs and produces a result.
        BiFunction<String, String, String> concatenate = (s1, s2) -> s1 + s2;
        System.out.println(concatenate.apply("Hello, ", "World!")); // Output: Hello, World!

        // Using default method 'andThen'
        // 'andThen' allows chaining another function after the current one.
        BiFunction<String, String, Integer> lengthOfConcatenation = concatenate.andThen(String::length);
        System.out.println(lengthOfConcatenation.apply("Hello, ", "World!")); // Output: 13

        // Example 7: UnaryOperator
        // A UnaryOperator is a special case of Function that takes one argument and returns the same type.
        UnaryOperator<Integer> square = x -> x * x;
        System.out.println(square.apply(5)); // Output: 25

        // Using default method 'andThen'
        // 'andThen' allows chaining another UnaryOperator after the current one.
        UnaryOperator<Integer> increment = x -> x + 1;
//        UnaryOperator<Integer> combinedUnaryOperator = (UnaryOperator<Integer>) square.andThen(increment);
//        System.out.println(combinedUnaryOperator.apply(5)); // Output: 26 (25 + 1)

        // Example 8: BinaryOperator
        // A BinaryOperator is a special case of BiFunction that takes two arguments of the same type.
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(5, 10)); // Output: 15

        // Using default method 'andThen'
        // 'andThen' allows chaining another BinaryOperator after the current one.
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        //BinaryOperator<Integer> combinedBinaryOperator = (BinaryOperator<Integer>) add.andThen(multiply);
        //System.out.println(combinedBinaryOperator.apply(5, 10)); // Output: 75 (15 * 5)

        // Example 9: Supplier
        // A Supplier provides a result without taking any input.
        Supplier<String> helloSupplier = () -> "Hello, Supplier!";
        System.out.println(helloSupplier.get()); // Output: Hello, Supplier!
    }
}
