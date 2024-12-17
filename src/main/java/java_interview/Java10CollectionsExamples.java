package java_interview;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Java10CollectionsExamples {
    public static void main(String[] args) {
        // 1. HashSet: Stores unique elements, no guaranteed order.
        Set<String> hashSet = new HashSet<>();
        hashSet.add("A");
        hashSet.add("B");
        hashSet.add("A"); // Duplicate, ignored
        System.out.println("HashSet: " + hashSet); // Output: [A, B]
        // Use when you need fast lookups or to ensure uniqueness.
        // Performance: O(1) for add, remove, and contains. O(n) for iteration.

        // 2. LinkedHashSet: Maintains insertion order.
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("C");
        linkedHashSet.add("D");
        linkedHashSet.add("C"); // Duplicate, ignored
        System.out.println("LinkedHashSet: " + linkedHashSet); // Output: [C, D]
        // Use when you need unique elements with predictable iteration order.
        // Performance: O(1) for add, remove, and contains. O(n) for iteration.

        // 3. TreeSet: Stores unique elements in sorted order.
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(3);
        System.out.println("TreeSet: " + treeSet); // Output: [1, 3, 5]
        // Use when you need sorted unique elements.
        // Performance: O(log n) for add, remove, and contains. O(n) for iteration.

        // 4. ArrayList: Resizable array, allows duplicates.
        List<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A");
        System.out.println("ArrayList: " + arrayList); // Output: [A, B, A]
        // Use when random access is required and order matters.
        // Performance: O(1) for get/set, O(n) for add/remove (worst case).

        // 5. LinkedList: Doubly-linked list, allows duplicates.
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.addFirst("Start");
        linkedList.addLast("End");
        System.out.println("LinkedList: " + linkedList); // Output: [Start, A, B, End]
        // Use when frequent insertions/deletions in the middle are needed.
        // Performance: O(1) for add/remove at ends, O(n) for middle operations.

        // 6. PriorityQueue: Elements ordered by priority.
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(10);
        priorityQueue.add(5);
        priorityQueue.add(20);
        System.out.println("PriorityQueue: " + priorityQueue.poll()); // Output: 5 (smallest)
        // Use when you need a priority-based processing queue.
        // Performance: O(log n) for add/remove, O(n) for iteration.

        // 7. HashMap: Key-value pairs, no guaranteed order.
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Alice", 25);
        hashMap.put("Bob", 30);
        hashMap.put("Alice", 28); // Replaces value for "Alice"
        System.out.println("HashMap: " + hashMap); // Output: {Alice=28, Bob=30}
        // Use when fast lookups are needed and order doesn’t matter.
        // Performance: O(1) for put/get, O(n) for iteration.

        // 8. LinkedHashMap: Maintains insertion order of keys.
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Alice", 25);
        linkedHashMap.put("Bob", 30);
        System.out.println("LinkedHashMap: " + linkedHashMap); // Output: {Alice=25, Bob=30}
        // Use when you need predictable iteration order.
        // Performance: O(1) for put/get, O(n) for iteration.

        // 9. TreeMap: Sorted map by keys.
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "C");
        treeMap.put(1, "A");
        treeMap.put(2, "B");
        System.out.println("TreeMap: " + treeMap); // Output: {1=A, 2=B, 3=C}
        // Use when sorted key-value pairs are required.
        // Performance: O(log n) for put/get, O(n) for iteration.

        // 10. ConcurrentHashMap: Thread-safe hash map.
        Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("Thread1", 100);
        concurrentHashMap.put("Thread2", 200);
        System.out.println("ConcurrentHashMap: " + concurrentHashMap); // Output: {Thread1=100, Thread2=200}
        // Use in multi-threaded environments.
        // Performance: O(1) for put/get, slightly slower than HashMap due to locks.

        // 11. CopyOnWriteArrayList: Thread-safe list.
        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("Safe1");
        copyOnWriteArrayList.add("Safe2");
        System.out.println("CopyOnWriteArrayList: " + copyOnWriteArrayList);
        // Use for thread-safe list with frequent reads and rare writes.
        // Performance: O(n) for write operations (copy entire array), O(1) for read.

        // 12. EnumSet: Optimized set for enums.
        EnumSet<Day> enumSet = EnumSet.of(Day.MONDAY, Day.WEDNESDAY);
        System.out.println("EnumSet: " + enumSet); // Output: [MONDAY, WEDNESDAY]
        // Use for collections of enums.
        // Performance: Very fast, uses bitwise operations.

        // 13. Streams with Collections
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even Numbers: " + evenNumbers); // Output: [2, 4]

        // 14. Iterator Example
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println("Iterator: " + iterator.next());
        }
    }

    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
    }
}

