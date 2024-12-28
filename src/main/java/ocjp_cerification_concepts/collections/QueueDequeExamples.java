package ocjp_cerification_concepts.collections;

import java.util.PriorityQueue;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;

public class QueueDequeExamples {

    // Key qualities of the Queue interface
    // 1. Represents a collection designed for holding elements prior to processing.
    // 2. Follows FIFO (First In, First Out) order.
    // 3. Allows null elements (depending on the implementation).

    // Key qualities of the Deque interface
    // 1. Represents a double-ended queue that allows insertion and removal of elements from both ends.
    // 2. Can be used as a stack or a queue.
    // 3. Allows null elements.

    public static void main(String[] args) {
        QueueDequeExamples examples = new QueueDequeExamples();
        examples.priorityQueueExample();
        examples.arrayDequeExample();
        examples.linkedListExample();
    }

    // 1. PriorityQueue
    public void priorityQueueExample() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(5);
        priorityQueue.add(1);
        priorityQueue.add(3);
        System.out.println("PriorityQueue: " + priorityQueue);

        // Internal Implementation
        // - Uses a binary heap to store elements.
        // - The head of the queue is the least element (for natural ordering).

        // Time Complexity
        // - Add: O(log n)
        // - Remove (poll): O(log n)
        // - Peek: O(1)

        // When to use
        // - Use PriorityQueue when you need to process elements based on priority rather than FIFO order.

        // Trade-offs
        // - Does not allow null elements.
        // - Elements are not stored in the order they are added; they are ordered based on their priority.
    }

    // 2. ArrayDeque
    public void arrayDequeExample() {
        Deque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(1);
        arrayDeque.add(2);
        arrayDeque.add(3);
        System.out.println("ArrayDeque: " + arrayDeque);

        // Internal Implementation
        // - Uses a resizable array to store elements.
        // - Allows adding and removing elements from both ends.

        // Time Complexity
        // - Add (to either end): O(1) (amortized)
        // - Remove (from either end): O(1)
        // - Peek: O(1)

        // When to use
        // - Use ArrayDeque when you need a resizable array that can be used as a queue or stack.

        // Trade-offs
        // - Faster than LinkedList for most operations due to better cache locality.
        // - Does not have capacity restrictions like ArrayList.
    }

    // 3. LinkedList
    public void linkedListExample() {
        Deque<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println("LinkedList: " + linkedList);

        // Internal Implementation
        // - Uses a doubly linked list to store elements.
        // - Each element (node) contains references to the next and previous nodes.

        // Time Complexity
        // - Add (to either end): O(1)
        // - Remove (from either end): O(1)
        // - Peek: O(1)
        // - Access: O(n)

        // When to use
        // - Use LinkedList when you need a queue or stack with frequent insertions and deletions.

        // Trade-offs
        // - More memory overhead due to storing references for each node.
        // - Slower access time compared to ArrayDeque for indexed access.
    }
}
