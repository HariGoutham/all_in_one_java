package ocjp_cerification_concepts.collections;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayExamples {

    // 1. Characteristics of Arrays
    // Fixed size, homogeneous elements, can be single-dimensional or multi-dimensional, indexed access starting at 0.

    // 2. Arrays
    // 2.1 Declaration and Initialization of Arrays
    public void arrayDeclarationAndInitialization() {
        // Declaration
        int[] intArray = new int[5]; // Fixed size array
        // Initialization
        intArray[0] = 1;
        intArray[1] = 2;
        intArray[2] = 3;
        intArray[3] = 4;
        intArray[4] = 5;

        // Alternatively, declaration and initialization in one line
        int[] anotherArray = {1, 2, 3, 4, 5};

        System.out.println("Initialized array: " + Arrays.toString(anotherArray));
    }

    // 2.2 Accessing Array Elements Using Loops
    public void accessArrayElements() {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Element at index " + i + ": " + arr[i]);
        }
    }

    // 2.3 Multi-dimensional and Jagged Arrays
    public void multiDimensionalArrays() {
        // 2D Array
        int[][] twoDArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("2D Array:");
        for (int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < twoDArray[i].length; j++) {
                System.out.print(twoDArray[i][j] + " ");
            }
            System.out.println();
        }

        // Jagged Array
        int[][] jaggedArray = {
                {1, 2},
                {3, 4, 5},
                {6}
        };

        System.out.println("Jagged Array:");
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 2.4 Common Errors
    public void commonErrors() {
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]); // This will throw ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        try {
            int[] arr = null;
            System.out.println(arr.length); // This will throw NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    // 3. Sorting and Searching
    public void sortingAndSearching() {
        int[] arr = {5, 3, 1, 4, 2};

        // Sorting the array
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));

        // Searching for an element
        int index = Arrays.binarySearch(arr, 3); // Returns the index of the element
        System.out.println("Index of 3: " + index);
    }

    // 4. Enhanced For-Loop
    public void enhancedForLoop() {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Using enhanced for-loop:");
        for (int num : arr) {
            System.out.println(num);
        }
    }

    // 5. Comparators and Comparable
    public void comparatorsAndComparable() {
        String[] names = {"John", "Alice", "Bob"};

        // Natural ordering using Comparable
        Arrays.sort(names);
        System.out.println("Sorted names (natural order): " + Arrays.toString(names));

        // Custom sorting using Comparator
        Arrays.sort(names, Comparator.reverseOrder());
        System.out.println("Sorted names (reverse order): " + Arrays.toString(names));
    }

    // 6. Utility Methods in Arrays Class
    public void utilityMethods() {
        int[] arr = {1, 2, 3, 4, 5};

        // Arrays.equals()
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("Arrays are equal: " + Arrays.equals(arr, arr2));

        // Arrays.fill()
        int[] filledArray = new int[5];
        Arrays.fill(filledArray, 10);
        System.out.println("Filled array: " + Arrays.toString(filledArray));

        // Arrays.copyOf()
        int[] copiedArray = Arrays.copyOf(arr, 10); // Copies and extends the array
        System.out.println("Copied array: " + Arrays.toString(copiedArray));

        // Arrays.toString()
        System.out.println("Original array as string: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        ArrayExamples examples = new ArrayExamples();

        System.out.println("Array Declaration and Initialization:");
        examples.arrayDeclarationAndInitialization();

        System.out.println("\nAccessing Array Elements:");
        examples.accessArrayElements();

        System.out.println("\nMulti-dimensional and Jagged Arrays:");
        examples.multiDimensionalArrays();

        System.out.println("\nCommon Errors:");
        examples.commonErrors();

        System.out.println("\nSorting and Searching:");
        examples.sortingAndSearching();

        System.out.println("\nEnhanced For-Loop:");
        examples.enhancedForLoop();

        System.out.println("\nComparators and Comparable:");
        examples.comparatorsAndComparable();

        System.out.println("\nUtility Methods in Arrays Class:");
        examples.utilityMethods();
    }
}