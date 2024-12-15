package java8_features.j8_3_optional;

// Introduction to Optional - Examples and Explanations

import java.util.Optional;

public class OptionalExamples {

    public static void main(String[] args) {

        // Example 1: Creating an Optional Object

        // Optional with a non-null value
        Optional<String> nonEmptyOptional = Optional.of("Hello, World!");
        System.out.println("Non-Empty Optional: " + nonEmptyOptional.get()); // Access value safely

        // Optional with a null value using ofNullable
        Optional<String> nullableOptional = Optional.ofNullable(null);
        System.out.println("Nullable Optional is present? " + nullableOptional.isPresent());

        // Empty Optional
        Optional<String> emptyOptional = Optional.empty();
        System.out.println("Empty Optional is present? " + emptyOptional.isPresent());

        // Example 2: Avoiding Null Pointer Exceptions with Optional

        String value = null;

        // Traditional Null Check
        if (value != null) {
            System.out.println("Traditional Check: " + value.toUpperCase());
        } else {
            System.out.println("Traditional Check: Value is null");
        }

        // Using Optional
        Optional<String> optionalValue = Optional.ofNullable(value);
        optionalValue.ifPresent(val -> System.out.println("Using Optional: " + val.toUpperCase()));

        // Providing a Default Value with orElse
        String defaultValue = optionalValue.orElse("Default Value");
        System.out.println("Using orElse: " + defaultValue);

        // Example 3: Optional Chaining and Transformations

        // Transforming values with map()
        Optional<String> transformedValue = nonEmptyOptional.map(String::toUpperCase);
        System.out.println("Transformed Value: " + transformedValue.orElse("No Value"));

        // Chaining Optional operations
        String result = Optional.of(" Java Optional ")
                .map(String::trim)
                .filter(val -> val.length() > 5)
                .orElse("Default Result");
        System.out.println("Chained Result: " + result);

        // Example 4: Dealing with Nulls Safely

        // Using orElseThrow to throw an exception if value is not present
        try {
            String mandatoryValue = emptyOptional.orElseThrow(() -> new IllegalArgumentException("Value is required"));
            System.out.println("Mandatory Value: " + mandatoryValue);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Example 5: Combining Multiple Optionals

        Optional<String> firstName = Optional.of("John");
        Optional<String> lastName = Optional.of("Doe");

        // Combining values if both are present
        String fullName = firstName.flatMap(fName -> lastName.map(lName -> fName + " " + lName))
                .orElse("Name not available");
        System.out.println("Full Name: " + fullName);

        // Example 6: Optional and Streams

        // Filtering and mapping a list with Optional
        Optional<Integer> optionalNumber = Optional.of(42);
        optionalNumber.filter(num -> num > 40)
                .map(num -> "Number is " + num)
                .ifPresent(System.out::println);

        // Example 7: Optional for Configuration/Settings

        Optional<String> configValue = Optional.ofNullable(System.getenv("CONFIG_KEY"));
        String configResult = configValue.orElse("Default Configuration");
        System.out.println("Configuration Value: " + configResult);

    }
}

