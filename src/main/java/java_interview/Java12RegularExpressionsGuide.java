package java_interview;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

/**
 * Comprehensive Regular Expressions Demonstration
 *
 * Topics Covered:
 * 1. What is a Regular Expression?
 * 2. Parts of a Regular Expression
 * 3. Methods That Use Regular Expressions
 * 4. Pattern and Matcher Classes
 * 5. Matcher Methods (find, group)
 * 6. Grouping and Capturing
 * 7. Matcher Methods for Replacing Text
 * 8. Regular Expressions for Specific Use Cases
 *    - Phone Number Validation
 *    - Email Validation
 *    - HTML Tag Extraction
 *    - Password Strength Checking
 */
public class Java12RegularExpressionsGuide {
    public static void main(String[] args) {
        // Call all demonstration methods
        demonstrateBasicRegexConcepts();
        demonstratePatternAndMatcher();
        demonstrateGroupingAndCapturing();
        demonstrateReplacementMethods();
        demonstrateSpecificUseCases();
        demonstrateTokenization();
        demonstrateRegexPerformance();
        demonstrateAssertions();
        demonstrateUnicodeSupport();

        // Demonstrate escape method
        String specialText = "Hello. How are you?";
        String escapedText = escapeRegexSpecialChars(specialText);
        System.out.println("\nEscaped Special Chars: " + escapedText);
    }

    // Basic Regex Concepts Demonstration
    public static void demonstrateBasicRegexConcepts() {
        System.out.println("--- Basic Regex Concepts ---");

        // Regex Metacharacters and Character Classes
        String[] regexPatterns = {
                "\\d",      // Single digit
                "\\d+",     // One or more digits
                "\\w+",     // One or more word characters
                "[aeiou]",  // Single vowel
                "[^0-9]",   // Not a digit
                "\\s",      // Whitespace
                "."         // Any character
        };

        String[] testStrings = {
                "123",
                "Hello World",
                "a",
                "ABC123",
                " "
        };

        // Demonstrate pattern matching
        for (String pattern : regexPatterns) {
            for (String test : testStrings) {
                boolean matches = Pattern.matches(pattern, test);
                System.out.printf("Pattern '%s' matches '%s': %b%n",
                        pattern, test, matches);
            }
        }
    }

    // Pattern and Matcher Demonstration
    public static void demonstratePatternAndMatcher() {
        System.out.println("\n--- Pattern and Matcher ---");

        String text = "The quick brown fox jumps over the lazy dog";

        // Create Pattern
        Pattern wordPattern = Pattern.compile("\\w+");

        // Create Matcher
        Matcher matcher = wordPattern.matcher(text);

        // Find and Print Matches
        System.out.println("Words in the text:");
        while (matcher.find()) {
            System.out.println("Found word: " + matcher.group());
            System.out.println("Start index: " + matcher.start());
            System.out.println("End index: " + matcher.end());
        }

        // Reset and Count Matches
        matcher.reset();
        long wordCount = matcher.results().count();
        System.out.println("Total words: " + wordCount);
    }

    // Grouping and Capturing Demonstration
    public static void demonstrateGroupingAndCapturing() {
        System.out.println("\n--- Grouping and Capturing ---");

        // Email Validation with Capturing Groups
        String emailRegex = "([\\w.-]+)@([\\w.-]+)\\.([a-z]{2,})";
        String email = "john.doe@example.com";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(email);

        if (emailMatcher.matches()) {
            System.out.println("Full Email: " + emailMatcher.group(0));
            System.out.println("Username: " + emailMatcher.group(1));
            System.out.println("Domain: " + emailMatcher.group(2));
            System.out.println("TLD: " + emailMatcher.group(3));
        }

        // Date Parsing with Groups
        String dateRegex = "(\\d{4})-(\\d{2})-(\\d{2})";
        String date = "2023-06-15";

        Pattern datePattern = Pattern.compile(dateRegex);
        Matcher dateMatcher = datePattern.matcher(date);

        if (dateMatcher.matches()) {
            System.out.println("Year: " + dateMatcher.group(1));
            System.out.println("Month: " + dateMatcher.group(2));
            System.out.println("Day: " + dateMatcher.group(3));
        }
    }

    // Text Replacement Methods Demonstration
    public static void demonstrateReplacementMethods() {
        System.out.println("\n--- Replacement Methods ---");

        String text = "The quick brown fox";

        // Simple Replacement
        String replaced = text.replaceAll("quick", "slow");
        System.out.println("Replaced text: " + replaced);

        // Complex Replacement with Groups
        String phoneNumber = "123-456-7890";
        String formattedPhone = phoneNumber.replaceAll(
                "(\\d{3})-(\\d{3})-(\\d{4})",
                "($1) $2-$3"
        );
        System.out.println("Formatted Phone: " + formattedPhone);

        // Conditional Replacement
        String data = "apple,banana,cherry";
        String replacedData = data.replaceAll(
                "(\\w+)",
                "fruit: $1"
        );
        System.out.println("Replaced Data: " + replacedData);
    }

    // Specific Use Cases Demonstration
    public static void demonstrateSpecificUseCases() {
        System.out.println("\n--- Specific Regex Use Cases ---");

        // Phone Number Validation
        String[] phoneNumbers = {
                "123-456-7890",
                "(123) 456-7890",
                "1234567890",
                "invalid-number"
        };
        String phoneRegex = "^(\\(\\d{3}\\)|\\d{3})[-.]?\\d{3}[-.]?\\d{4}$";

        System.out.println("Phone Number Validation:");
        for (String phone : phoneNumbers) {
            boolean isValid = phone.matches(phoneRegex);
            System.out.printf("'%s' is valid: %b%n", phone, isValid);
        }

        // Email Validation
        String[] emails = {
                "user@example.com",
                "invalid.email",
                "user.name@domain.co.uk"
        };
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        System.out.println("\nEmail Validation:");
        for (String email : emails) {
            boolean isValid = email.matches(emailRegex);
            System.out.printf("'%s' is valid: %b%n", email, isValid);
        }

        // HTML Tag Extraction
        String htmlText = "<p>Hello <b>World</b> of <i>Regex</i></p>";
        String tagRegex = "<[^>]+>";

        Pattern tagPattern = Pattern.compile(tagRegex);
        Matcher tagMatcher = tagPattern.matcher(htmlText);

        System.out.println("\nHTML Tag Extraction:");
        while (tagMatcher.find()) {
            System.out.println("Found Tag: " + tagMatcher.group());
        }

        // Password Strength Validation
        String[] passwords = {
                "weak",
                "StrongPass123!",
                "NoSpecialChar123"
        };
        String passwordRegex =
                "^(?=.*[A-Z])" +   // At least one uppercase
                        "(?=.*[a-z])" +    // At least one lowercase
                        "(?=.*\\d)" +      // At least
                        "(?=.*[!@#$%^&*])" + // At least one special char
                        ".{8,}$";          // Minimum 8 characters

        System.out.println("\nPassword Strength Validation:");
        for (String password : passwords) {
            boolean isStrong = password.matches(passwordRegex);
            System.out.printf("'%s' is strong: %b%n", password, isStrong);
        }
    }

    // Advanced Regex Utility Methods
    public static List<String> findAllMatches(String text, String regex) {
        List<String> matches = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            matches.add(matcher.group());
        }

        return matches;
    }

    // Regex-based StringStringBuilderStringBuffer Tokenization
    public static void demonstrateTokenization() {
        System.out.println("\n--- Regex Tokenization ---");

        String csvData = "John,Doe,30,Engineer,New York";
        String[] tokens = csvData.split(",");

        System.out.println("CSV Tokenization:");
        for (int i = 0; i < tokens.length; i++) {
            System.out.printf("Token %d: %s%n", i, tokens[i]);
        }

        // Advanced Tokenization with Regex Limits
        String complexText = "apple:banana;cherry,grape";
        String[] complexTokens = complexText.split("[,:;]");

        System.out.println("\nComplex Tokenization:");
        for (int i = 0; i < complexTokens.length; i++) {
            System.out.printf("Token %d: %s%n", i, complexTokens[i]);
        }
    }

    // Regex Performance Considerations
    public static void demonstrateRegexPerformance() {
        System.out.println("\n--- Regex Performance ---");

        // Compile Pattern Once for Repeated Use
        Pattern emailPattern = Pattern.compile(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
        );

        String[] emails = {
                "user1@example.com",
                "user2@test.org",
                "user3@domain.net"
        };

        long startTime = System.nanoTime();

        for (String email : emails) {
            Matcher matcher = emailPattern.matcher(email);
            boolean isValid = matcher.matches();
        }

        long endTime = System.nanoTime();

        System.out.printf(
                "Validation Time: %.6f milliseconds%n",
                (endTime - startTime) / 1_000_000.0
        );
    }

    // Lookahead and Lookbehind Assertions
    public static void demonstrateAssertions() {
        System.out.println("\n--- Regex Assertions ---");

        // Positive Lookahead: Match only if followed by
        String passwordWithDigit = "^(?=.*\\d)\\w+$";
        String[] passwords = {"hello", "hello123", "123hello"};

        System.out.println("Passwords with digit:");
        for (String password : passwords) {
            boolean hasDigit = password.matches(passwordWithDigit);
            System.out.printf("'%s' has digit: %b%n", password, hasDigit);
        }

        // Negative Lookahead: Match only if NOT followed by
        String noNumberStart = "^(?!\\d)\\w+$";
        String[] strings = {"hello", "123hello", "hello123"};

        System.out.println("\nStrings not starting with number:");
        for (String str : strings) {
            boolean valid = str.matches(noNumberStart);
            System.out.printf("'%s' is valid: %b%n", str, valid);
        }
    }

    // Unicode and Internationalization Support
    public static void demonstrateUnicodeSupport() {
        System.out.println("\n--- Unicode Regex Support ---");

        // Unicode Character Classes
        String unicodeText = "Hello, こんにちは, Привет!";

        // Match Unicode letters
        Pattern unicodePattern = Pattern.compile("\\p{L}+");
        Matcher unicodeMatcher = unicodePattern.matcher(unicodeText);

        System.out.println("Unicode Words:");
        while (unicodeMatcher.find()) {
            System.out.println(unicodeMatcher.group());
        }
    }

    // Escape Special Characters
    public static String escapeRegexSpecialChars(String input) {
        return input.replaceAll(
                "[.^$*+?()[{\\\\|]]",
                "\\\\$0"
        );
    }


}