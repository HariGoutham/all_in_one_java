package ocjp_cerification_concepts.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.Stack;
import java.util.List;

public class ListInterfaceExamples {

    // Key qualities of the List interface
    // 1. Ordered collection (elements are stored in the order they are inserted).
    // 2. Allows duplicate elements.
    // 3. Provides indexed access to elements.
    // 4. Can contain null elements.

    public static void main(String[] args) {
        ListInterfaceExamples examples = new ListInterfaceExamples();
        examples.arrayListExample();
        examples.linkedListExample();
        examples.vectorExample();
        examples.stackExample();
    }

    // 1. ArrayList
    public void arrayListExample() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println("ArrayList: " + arrayList);

        // Internal Implementation
        // - Uses a dynamic array to store elements.
        // - When the array is full, it creates a new array with a larger size (usually 1.5 times the old size) and copies the elements.

        // Time Complexity
        // - Access: O(1)
        // - Search: O(n)
        // - Insertion: O(n) (in the worst case, when resizing is needed)
        // - Deletion: O(n)

        // When to use
        // - Use ArrayList when you need fast random access and the size of the list is not frequently changing.

        // Trade-offs
        // - Faster access time compared to LinkedList.
        // - Slower insertion and deletion times when elements are added or removed from the middle of the list.
    }

    // 2. LinkedList
    public void linkedListExample() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println("LinkedList: " + linkedList);

        // Internal Implementation
        // - Uses a doubly linked list to store elements.
        // - Each element (node) contains a reference to the next and previous nodes.

        // Time Complexity
        // - Access: O(n)
        // - Search: O(n)
        // - Insertion: O(1) (at the beginning or end)
        // - Deletion: O(1) (at the beginning or end)

        // When to use
        // - Use LinkedList when you need frequent insertions and deletions from the list.

        // Trade-offs
        // - Slower access time compared to ArrayList.
        // - More memory overhead due to storing references for each node.
    }

    // 3. Vector
    public void vectorExample() {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        System.out.println("Vector: " + vector);

        // Internal Implementation
        // - Similar to ArrayList, but it is synchronized (thread-safe).
        // - When the array is full, it doubles its size.

        // Time Complexity
        // - Access: O(1)
        // - Search: O(n)
        // - Insertion: O(n) (in the worst case, when resizing is needed)
        // - Deletion: O(n)

        // When to use
        // - Use Vector when you need a thread-safe dynamic array.

        // Trade-offs
        // - Slower than ArrayList due to synchronization overhead.
        // - Generally, it is recommended to use ArrayList with external synchronization instead of Vector.
    }

    // 4. Stack
    public void stackExample() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack: " + stack);

        // Internal Implementation
        // - Extends Vector and uses a dynamic array to store elements.
        // - Follows LIFO (Last In, First Out) principle.

        // Time Complexity
        // - Access: O(1) (only the top element is accessible)
        // - Search: O(n)
        // - Insertion: O(1) (push operation)
        // - Deletion: O(1) (pop operation)

        // When to use
        // - Use Stack when you need to manage data in a LIFO manner.

        // Trade-offs
        // - Stack is synchronized, which can lead to performance overhead.
        // - Consider using Deque (ArrayDeque or LinkedList) for stack operations if synchronization is not required.

    }
}
