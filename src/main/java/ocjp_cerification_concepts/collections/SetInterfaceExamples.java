package ocjp_cerification_concepts.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Set;

public class SetInterfaceExamples {

    // Key qualities of the Set interface
    // 1. Does not allow duplicate elements.
    // 2. Does not guarantee the order of elements (except for LinkedHashSet and TreeSet).
    // 3. Allows null elements (only one null is allowed).

    public static void main(String[] args) {
        SetInterfaceExamples examples = new SetInterfaceExamples();
        examples.hashSetExample();
        examples.linkedHashSetExample();
        examples.treeSetExample();
    }

    // 1. HashSet
    public void hashSetExample() {
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(2); // Duplicate, will not be added
        System.out.println("HashSet: " + hashSet);

        // Internal Implementation
        // - Uses a hash table (backed by an array) to store elements.
        // - Elements are stored based on their hash code.

        // Time Complexity
        // - Add: O(1) (average case)
        // - Remove: O(1) (average case)
        // - Contains: O(1) (average case)

        // When to use
        // - Use HashSet when you need a collection that does not allow duplicates and does not require ordering.

        // Trade-offs
        // - Fast performance for basic operations.
        // - No guarantee of the order of elements.
    }

    // 2. LinkedHashSet
    public void linkedHashSetExample() {
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        linkedHashSet.add(3);
        linkedHashSet.add(2); // Duplicate, will not be added
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // Internal Implementation
        // - Uses a hash table and a linked list to maintain insertion order.
        // - Each element is stored in a hash table and linked to the previous and next elements.

        // Time Complexity
        // - Add: O(1)
        // - Remove: O(1)
        // - Contains: O(1)

        // When to use
        // - Use LinkedHashSet when you need a collection that does not allow duplicates and maintains insertion order.

        // Trade-offs
        // - Slightly slower than HashSet due to the overhead of maintaining the linked list.
        // - Retains the order of elements.
    }

    // 3. TreeSet
    public void treeSetExample() {
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(2);
        System.out.println("TreeSet: " + treeSet);

        // Internal Implementation
        // - Uses a Red-Black tree (a self-balancing binary search tree) to store elements.
        // - Elements are stored in a sorted order.

        // Time Complexity
        // - Add: O(log n)
        // - Remove: O(log n)
        // - Contains: O(log n)

        // When to use
        // - Use TreeSet when you need a collection that does not allow duplicates and requires sorted order.

        // Trade-offs
        // - Slower than HashSet and LinkedHashSet for basic operations due to the overhead of maintaining the tree structure.
        // - Provides sorted order of elements.
    }
}
