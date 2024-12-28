package java11_features;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * Java 11 Features Showcase
 *
 * @author Claude AI
 * @version 1.0
 * @since Java 11
 */
public class Java11Features {

    /**
     * 1. StringStringBuilderStringBuffer Methods
     * When to use:
     * - Checking string emptiness with more flexibility
     * - Splitting multiline strings
     * - Creating repeated string patterns
     */
    public void stringMethodsDemo() {
        // isBlank(): Checks if string is empty or whitespace
        String emptyStr = "   ";
        boolean isEmpty = emptyStr.isBlank(); // true

        // lines(): Split multiline strings
        String multiline = "Hello\nWorld\nJava";
        long lineCount = multiline.lines().count(); // 3

        // repeat(): Create repeated string patterns
        String repeated = "ABC".repeat(3); // "ABCABCABC"
    }

    /**
     * 2. Local-Variable Syntax for Lambda
     * When to use:
     * - When you want type inference in lambda parameters
     * - Improving readability with explicit annotations
     */
    public void lambdaVariableSyntaxDemo() {
        // Explicitly specify the functional interface type
        BiFunction<Integer, Integer, Integer> biFunction =
                (var x, var y) -> x + y;

        // Another example with explicit type
        BinaryOperator<Integer> addition =
                (var a, var b) -> a + b;

        // With annotation (requires explicit type)
        BiFunction<String, Integer, String> annotatedLambda =
                (@Deprecated var x, var y) -> x.repeat(y);

        // Usage examples
        int result1 = biFunction.apply(5, 3);  // 8
        int result2 = addition.apply(10, 20);  // 30

        System.out.println(result1);
        System.out.println(result2);
    }

    /**
     * 3. HTTP Client API
     * When to use:
     * - Modern web communication
     * - Async and sync HTTP requests
     * - RESTful API interactions
     */
    public void httpClientDemo() throws IOException, InterruptedException {
        var client = java.net.http.HttpClient.newHttpClient();
        var request = java.net.http.HttpRequest.newBuilder()
                .uri(URI.create("https://api.example.com"))
                .build();

        // Sync request
        var response = client.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());

        // Async request
        client.sendAsync(request, java.net.http.HttpResponse.BodyHandlers.ofString())
                .thenApply(java.net.http.HttpResponse::body)
                .thenAccept(System.out::println);
    }

    /**
     * 4. File Handling Improvements
     * When to use:
     * - Simple file read/write operations
     * - Quick file content manipulation
     */
    public void fileMethodsDemo() throws IOException {
        // Write string to file
        Path tempFile = Files.writeString(Files.createTempFile("example", ".txt"), "Hello Java 11!");

        // Read file as string
        String content = Files.readString(tempFile);
    }

    /**
     * 5. Optional Improvements
     * When to use:
     * - Null-safe operations
     * - Providing alternative values
     * - Checking optional emptiness
     */
    public void optionalImprovementsDemo() {
        Optional<String> optional = Optional.of("Hello");

        // Check if empty
        boolean empty = optional.isEmpty(); // false

        // Provide alternative
        String result = optional.or(() -> Optional.of("Default")).get();
    }

    /**
     * 6. Stream Improvements
     * When to use:
     * - Collection transformations
     * - Simplified stream terminal operations
     */
    public void streamImprovementsDemo() {
        // Collect to immutable list
        List<String> list = Stream.of("a", "b", "c").toList();
    }

    /**
     * 7. Pattern Matching for instanceof (Preview)
     * When to use:
     * - Type checking and casting in one step
     * - Simplifying type-based logic
     */
    public void patternMatchingDemo(Object obj) {
        if (obj instanceof String s) {
            System.out.println(s.toUpperCase());
        }
    }

    /**
     * 8. Records (Preview)
     * When to use:
     * - Immutable data carriers
     * - DTO (Data Transfer Objects)
     * - Simple model classes
     */
    public record Person(String name, int age) {}

    /**
     * 9. Single File Source Code Execution
     * Run directly: java Java11Features.java
     */
    public static void main(String[] args) {
        System.out.println("Java 11 Features Demonstration");
    }
}