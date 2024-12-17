package java_interview;

/**
 * Comprehensive Java Nested Classes Concepts Demonstration
 *
 * Concepts Covered:
 * 1. Static Nested Classes
 * 2. Inner (Non-static) Classes
 * 3. Local Classes
 * 4. Anonymous Classes
 * 5. Nested Class Interactions
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Java9NestedClassesDemonstration {
    // Static Nested Class
    public static class StaticNestedEmployee {
        private String name;
        private int employeeId;

        public StaticNestedEmployee(String name, int employeeId) {
            this.name = name;
            this.employeeId = employeeId;
        }

        @Override
        public String toString() {
            return "StaticNestedEmployee{" +
                    "name='" + name + '\'' +
                    ", employeeId=" + employeeId +
                    '}';
        }
    }

    // Non-static Inner Class (Instance Inner Class)
    public class InstanceInnerEmployee {
        private String name;
        private double salary;

        public InstanceInnerEmployee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        // Can access outer class members
        public void displayInfo() {
            System.out.println("Outer class reference: " + Java9NestedClassesDemonstration.this);
        }
    }

    // Method with Local Class
    public List<String> createLocalClassExample(String prefix) {
        // Local Class defined inside a method
        class LocalNameProcessor {
            private String processName(String input) {
                return prefix + " " + input;
            }

            public List<String> processNames(List<String> names) {
                List<String> processedNames = new ArrayList<>();
                for (String name : names) {
                    processedNames.add(processName(name));
                }
                return processedNames;
            }
        }

        // Create and use local class
        LocalNameProcessor processor = new LocalNameProcessor();
        List<String> names = List.of("Alice", "Bob", "Charlie");
        return processor.processNames(names);
    }

    // Method demonstrating Anonymous Classes
    public Consumer<String> createGreetingConsumer() {
        // Anonymous class implementing Consumer interface
        return new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println("Hello, " + name + "!");
            }
        };
    }

    // Modern approach with Lambda (functional interface)
    public Consumer<String> createLambdaGreetingConsumer() {
        return name -> System.out.println("Hello, " + name + "!");
    }

    // Nested Class Challenge Demonstration
    public static class DataProcessor {
        // Static nested class with nested logic
        public static class Filter {
            public static boolean isEven(int number) {
                return number % 2 == 0;
            }

            public static boolean isPrime(int number) {
                if (number <= 1) return false;
                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) return false;
                }
                return true;
            }
        }

        public static List<Integer> processNumbers(List<Integer> numbers,
                                                   java.util.function.Predicate<Integer> predicate) {
            List<Integer> result = new ArrayList<>();
            for (Integer num : numbers) {
                if (predicate.test(num)) {
                    result.add(num);
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        // Static Nested Class Demonstration
        StaticNestedEmployee staticEmployee =
                new Java9NestedClassesDemonstration.StaticNestedEmployee("John", 1001);
        System.out.println("Static Nested Employee: " + staticEmployee);

        // Instance Inner Class Demonstration
        Java9NestedClassesDemonstration outerInstance = new Java9NestedClassesDemonstration();
        InstanceInnerEmployee instanceEmployee =
                outerInstance.new InstanceInnerEmployee("Jane", 50000);
        instanceEmployee.displayInfo();

        // Local Class Demonstration
        List<String> processedNames = outerInstance.createLocalClassExample("Mr.");
        System.out.println("Processed Names: " + processedNames);

        // Anonymous Class Demonstration
        Consumer<String> greetingConsumer = outerInstance.createGreetingConsumer();
        greetingConsumer.accept("Alice");

        // Lambda Alternative
        Consumer<String> lambdaGreetingConsumer = outerInstance.createLambdaGreetingConsumer();
        lambdaGreetingConsumer.accept("Bob");

        // Nested Class Challenge
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Using static nested class Filter
        List<Integer> evenNumbers = DataProcessor.processNumbers(
                numbers,
                DataProcessor.Filter::isEven
        );
        System.out.println("Even Numbers: " + evenNumbers);

        List<Integer> primeNumbers = DataProcessor.processNumbers(
                numbers,
                DataProcessor.Filter::isPrime
        );
        System.out.println("Prime Numbers: " + primeNumbers);
    }
}
