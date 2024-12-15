package java8_features.j8_1_functional_interface.inbuilt;

import java.util.Arrays;
import java.util.Comparator;

public class RunnableComparator {

    public static void main(String[] args) {
        // Example 1: Using Runnable (an inbuilt functional interface)
        // Runnable is a functional interface that represents a task that can be run.
        // Before Java 8: Implementing Runnable using an anonymous class
        // This creates a new thread that prints a message when run.
        Runnable runnableBeforeJava8 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running in a thread using an anonymous class. Before Java 8 ");
            }
        };

        // Creating a thread with the Runnable implementation
        Thread threadBeforeJava8 = new Thread(runnableBeforeJava8);
        threadBeforeJava8.start(); // Start the thread
//---------------------------------------------------------------------------------------------
        // After Java 8: Implementing Runnable using a lambda expression
        // This achieves the same functionality in a more concise way.
        Runnable runnableAfterJava8 = () -> System.out.println("Running in a thread using a lambda expression. After java 8 ");

        // Creating a thread with the lambda implementation
        Thread threadAfterJava8 = new Thread(runnableAfterJava8);
        threadAfterJava8.start(); // Start the thread
//------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Example 2: Using Comparator (an inbuilt functional interface)
        // Comparator is a functional interface that defines a method for comparing two objects.
        // Array of names to be sorted
        String[] names = {"Alice", "Bob", "Charlie"};

        // Before Java 8: Implementing Comparator using an anonymous class
        // This sorts the array of names by their length.
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length(); // Compare by length of names
            }
        });

        // Output the sorted names
        System.out.println("Sorted names (before Java 8): " + Arrays.toString(names)); // Output: [Bob, Alice, Charlie]

        // Resetting the names array for the next example
        names = new String[]{"Alice", "Bob", "Charlie"};
//---------------------------------------------------------------------------------------------
        // After Java 8: Implementing Comparator using a lambda expression
        // This achieves the same sorting functionality in a more concise way.
        Arrays.sort(names, (s1, s2) -> s1.length() - s2.length()); // Sort by length of names

        // Output the sorted names
        System.out.println("Sorted names (after Java 8): " + Arrays.toString(names)); // Output: [Bob, Alice, Charlie]
//------------------------------------------------------------------------------------------------------------------------------------------------------------
    }
}
