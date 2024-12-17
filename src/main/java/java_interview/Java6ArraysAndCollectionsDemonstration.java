package java_interview;

/**
 * Comprehensive Java Arrays and Collections Concepts Demonstration
 *
 * Concepts Covered:
 * 1. Arrays
 * 2. java.util.Arrays Methods
 * 3. Array Searching and Manipulation
 * 4. Reference vs Value Types
 * 5. Variable Arguments (Varargs)
 * 6. Two-Dimensional and Multi-dimensional Arrays
 * 7. Lists (ArrayList, LinkedList)
 * 8. Iterators
 * 9. Autoboxing & Unboxing
 * 10. Enums
 */

import java.util.*;

// Enum Demonstration
enum DaysOfWeek {
    MONDAY("Start of the work week"),
    TUESDAY("Second day"),
    WEDNESDAY("Middle of the week"),
    THURSDAY("Almost weekend"),
    FRIDAY("End of work week"),
    SATURDAY("Weekend begins"),
    SUNDAY("Weekend");

    private final String description;

    // Enum constructor
    DaysOfWeek(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

public class Java6ArraysAndCollectionsDemonstration {
    public static void main(String[] args) {
        // 1. Basic Array Operations
        int[] numbers = {5, 2, 8, 1, 9};

        // 2. java.util.Arrays Methods
        System.out.println("Original Array: " + Arrays.toString(numbers));

        // Sorting
        Arrays.sort(numbers);
        System.out.println("Sorted Array: " + Arrays.toString(numbers));

        // Filling an array
        int[] filledArray = new int[5];
        Arrays.fill(filledArray, 42);
        System.out.println("Filled Array: " + Arrays.toString(filledArray));

        // Copying Array
        int[] copiedArray = Arrays.copyOf(numbers, numbers.length);
        System.out.println("Copied Array: " + Arrays.toString(copiedArray));

        // 3. Array Searching and Equality
        System.out.println("Binary Search: " + Arrays.binarySearch(numbers, 8));
        System.out.println("Array Equality: " + Arrays.equals(numbers, copiedArray));

        // 4. Reference vs Value Types
        int[] reference1 = numbers;
        int[] reference2 = Arrays.copyOf(numbers, numbers.length);
        System.out.println("Reference Comparison: " + (reference1 == numbers)); // true
        System.out.println("Value Comparison: " + Arrays.equals(reference1, reference2)); // true

        // 5. Variable Arguments (Varargs)
        printNumbers(1, 2, 3, 4, 5);

        // 6. Two-Dimensional and Multi-dimensional Arrays
        int[][] twoDArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("2D Array:");
        for (int[] row : twoDArray) {
            System.out.println(Arrays.toString(row));
        }

        // 7. Lists and ArrayList
        // Autoboxing demonstration
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10); // Autoboxing int to Integer
        arrayList.add(20);
        arrayList.add(30);

        System.out.println("ArrayList: " + arrayList);

        // 8. LinkedList
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("First");
        linkedList.addFirst("NewFirst");
        linkedList.addLast("Last");

        System.out.println("LinkedList: " + linkedList);

        // 9. Iterators
        Iterator<String> iterator = linkedList.iterator();
        System.out.print("LinkedList via Iterator: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // 10. Enum Demonstration
        demonstrateEnums();
    }

    // Varargs Method
    public static void printNumbers(int... numbers) {
        System.out.print("Varargs Method: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Enum Demonstration Method
    public static void demonstrateEnums() {
        DaysOfWeek today = DaysOfWeek.WEDNESDAY;

        System.out.println("Today is: " + today);
        System.out.println("Description: " + today.getDescription());

        // Enum methods
        System.out.println("Enum Ordinal: " + today.ordinal());

        // Iterating through enum values
        System.out.println("All Days:");
        for (DaysOfWeek day : DaysOfWeek.values()) {
            System.out.println(day + ": " + day.getDescription());
        }
    }

    // Bonus: Minimum Element Challenge
    public static int findMinElement(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        return Arrays.stream(array).min().getAsInt();
    }
}
