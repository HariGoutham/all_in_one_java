package ocjp_cerification_concepts.generics;

import java.util.*;

public class Generics9Misc2 {

    public static void main(String[] args) {
        // 1. Comparator<T>: Define custom sorting logic
        String[] names = {"Alice", "Bob", "Charlie", "David"};
        // Define a Comparator to sort strings by their length
        Comparator<String> lengthComparator = (a, b) -> a.length() - b.length();
        // Sort the array using the custom comparator
        Arrays.sort(names, lengthComparator);
        System.out.println("Sorted by length: " + Arrays.toString(names));

        // 2. Comparable<T>: For natural ordering
        Item[] items = {
                new Item("Item1", 10),
                new Item("Item2", 5),
                new Item("Item3", 20)
        };
        // Sort the array using natural ordering defined by compareTo
        Arrays.sort(items);
        System.out.println("Sorted items: " + Arrays.toString(items));

        // 3. Generic Utility Classes (e.g., Collections)
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        // Sort the list using Collections.sort
        Collections.sort(numbers);
        System.out.println("Sorted numbers: " + numbers);

        // 4. Streams and Lambdas with Generics
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        // Use streams to filter and print elements greater than 1
        list.stream()
                .filter(x -> x > 1) // Filter condition
                .forEach(System.out::println); // Print each element

        // 5. Generics with Inheritance
        List<Number> numberList = new ArrayList<>();
        numberList.add(1); // Integer
        numberList.add(2.5); // Double
        // List<Integer> is not a subtype of List<Number>
        // List<Integer> integerList = numberList; // Compilation error
        for (Number number : numberList) {
            System.out.println("Number: " + number);
        }
    }

    // 2. Comparable<T>: Class implementing Comparable for natural ordering
    static class Item implements Comparable<Item> {
        private String name;
        private int value;

        public Item(String name, int value) {
            this.name = name;
            this.value = value;
        }

        @Override
        public int compareTo(Item other) {
            return Integer.compare(this.value, other.value); // Compare by value
        }

        @Override
        public String toString() {
            return name + ": " + value; // String representation of Item
        }
    }
}
