package ocjp_cerification_concepts.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Hashtable;
import java.util.Map;

public class MapInterfaceExamples {

    // Key qualities of the Map interface
    // 1. Stores key-value pairs.
    // 2. Keys are unique; values can be duplicated.
    // 3. Allows null values (but only one null key in HashMap and LinkedHashMap).
    // 4. Provides methods for insertion, deletion, and retrieval of key-value pairs.

    public static void main(String[] args) {
        MapInterfaceExamples examples = new MapInterfaceExamples();
        examples.hashMapExample();
        examples.linkedHashMapExample();
        examples.treeMapExample();
        examples.hashtableExample();
    }

    // 1. HashMap
    public void hashMapExample() {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(3, "Three");
        hashMap.put(2, "Two Updated"); // Updates the value for key 2
        System.out.println("HashMap: " + hashMap);

        // Internal Implementation
        // - Uses a hash table to store key-value pairs.
        // - Keys are hashed to determine their storage location.

        // Time Complexity
        // - Put: O(1) (average case)
        // - Get: O(1) (average case)
        // - Remove: O(1) (average case)

        // When to use
        // - Use HashMap when you need a fast, unordered collection of key-value pairs.

        // Trade-offs
        // - Fast performance for basic operations.
        // - No guarantee of the order of elements.
    }

    // 2. LinkedHashMap
    public void linkedHashMapExample() {
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "One");
        linkedHashMap.put(2, "Two");
        linkedHashMap.put(3, "Three");
        linkedHashMap.put(2, "Two Updated"); // Updates the value for key 2
        System.out.println("LinkedHashMap: " + linkedHashMap);

        // Internal Implementation
        // - Uses a hash table and a linked list to maintain insertion order.
        // - Each entry is stored in a hash table and linked to the previous and next entries.

        // Time Complexity
        // - Put: O(1)
        // - Get: O(1)
        // - Remove: O(1)

        // When to use
        // - Use LinkedHashMap when you need a collection of key-value pairs that maintains insertion order.

        // Trade-offs
        // - Slightly slower than HashMap due to the overhead of maintaining the linked list.
        // - Retains the order of elements.
    }

    // 3. TreeMap
    public void treeMapExample() {
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        System.out.println("TreeMap: " + treeMap);

        // Internal Implementation
        // - Uses a Red-Black tree (a self-balancing binary search tree) to store key-value pairs.
        // - Keys are stored in a sorted order.

        // Time Complexity
        // - Put: O(log n)
        // - Get: O(log n)
        // - Remove: O(log n)

        // When to use
        // - Use TreeMap when you need a collection of key-value pairs that are sorted by keys.

        // Trade-offs
        // - Slower than HashMap and LinkedHashMap for basic operations due to the overhead of maintaining the tree structure.
        // - Provides sorted order of keys.
    }

    // 4. Hashtable
    public void hashtableExample() {
        Map<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(1, "One");
        hashtable.put(2, "Two");
        hashtable.put(3, "Three");
        hashtable.put(2, "Two Updated"); // Updates the value for key 2
        System.out.println("Hashtable: " + hashtable);

        // Internal Implementation
        // - Similar to HashMap, but it is synchronized (thread-safe).
        // - Uses a hash table to store key-value pairs.

        // Time Complexity
        // - Put: O(1) (average case)
        // - Get: O(1) (average case)
        // - Remove: O(1) (average case)

        // When to use
        // - Use Hashtable when you need a thread-safe collection of key-value pairs.

        // Trade-offs
        // - Synchronized, which makes it slower than HashMap and LinkedHashMap for single-threaded applications.
        // - Does not allow null keys or values.
    }
}
