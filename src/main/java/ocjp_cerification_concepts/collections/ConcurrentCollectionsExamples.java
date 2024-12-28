package ocjp_cerification_concepts.collections;

import java.util.concurrent.*;
import java.util.*;

public class ConcurrentCollectionsExamples {

    public static void main(String[] args) {
        ConcurrentCollectionsExamples examples = new ConcurrentCollectionsExamples();
        examples.latchExample();
        examples.cyclicBarrierExample();
        examples.blockingQueueExample();
        examples.delayQueueExample();
        examples.priorityQueueExample();
        examples.concurrentMapExample();
        examples.exchangerExample();
        examples.copyOnWriteArrayListExample();
    }

    // 1. Latch
    public void latchExample() {
        CountDownLatch latch = new CountDownLatch(1);
        new Thread(() -> {
            try {
                System.out.println("Thread is waiting for the latch.");
                latch.await(); // Wait until the latch is counted down
                System.out.println("Thread has been released.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // Simulate some work
        try {
            Thread.sleep(2000); // Simulate work
            System.out.println("Counting down the latch.");
            latch.countDown(); // Release the waiting thread
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // 2. CyclicBarrier
    public void cyclicBarrierExample() {
        int numberOfThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(numberOfThreads, () -> {
            System.out.println("All threads have reached the barrier.");
        });

        for (int i = 0; i < numberOfThreads; i++) {
            final int threadId = i;
            new Thread(() -> {
                try {
                    System.out.println("Thread " + threadId + " is waiting at the barrier.");
                    barrier.await(); // Wait for other threads
                    System.out.println("Thread " + threadId + " has crossed the barrier.");
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }

    // 3. BlockingQueue
    public void blockingQueueExample() {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);

        // Producer thread
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    blockingQueue.put(i); // Blocks if the queue is full
                    System.out.println("Produced: " + i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // Consumer thread
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    Integer value = blockingQueue.take(); // Blocks if the queue is empty
                    System.out.println("Consumed: " + value);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    // 4. DelayQueue
    public void delayQueueExample() {
        DelayQueue<DelayedItem> delayQueue = new DelayQueue<>();

        // Producer thread
        new Thread(() -> {
            delayQueue.put(new DelayedItem("Item 1", 2000)); // Delay for 2 seconds
            delayQueue.put(new DelayedItem("Item 2", 1000)); // Delay for 1 second
            System.out.println("Items added to DelayQueue.");
        }).start();

        // Consumer thread
        new Thread(() -> {
            try {
                for (int i = 0; i < 2; i++) {
                    DelayedItem item = delayQueue.take(); // Blocks until an item is available
                    System.out.println("Consumed: " + item.getName());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    // 5. PriorityQueue
    public void priorityQueueExample() {
        PriorityBlockingQueue<Integer> priorityQueue = new PriorityBlockingQueue<>();
        priorityQueue.add(5);
        priorityQueue.add(1);
        priorityQueue.add(3);
        System.out.println("PriorityQueue: " + priorityQueue);

        // Internal Implementation
        // - Uses a binary heap to store elements.
        // - The head of the queue is the least element (for natural ordering).

        // Time Complexity
        // - Add: O(log n)
        // - Remove (poll): O(log n // - Peek: O(1)

        // When to use
        // - Use PriorityBlockingQueue when you need a thread-safe priority queue.

        // Trade-offs
        // - Does not allow null elements.
        // - Elements are not stored in the order they are added; they are ordered based on their priority.
    }

    // 6. ConcurrentMap
    public void concurrentMapExample() {
        ConcurrentMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("A", 1);
        concurrentMap.put("B", 2);
        System.out.println("ConcurrentMap: " + concurrentMap);

        // Internal Implementation
        // - Uses a hash table with segmented locking for concurrency.

        // Time Complexity
        // - Put: O(1) (average case)
        // - Get: O(1) (average case)
        // - Remove: O(1) (average case)

        // When to use
        // - Use ConcurrentMap when you need a thread-safe map with high concurrency.

        // Trade-offs
        // - More memory overhead compared to a regular HashMap.
        // - Slightly slower than HashMap due to locking mechanisms.
    }

    // 7. Exchanger
    public void exchangerExample() {
        Exchanger<String> exchanger = new Exchanger<>();

        // Thread 1
        new Thread(() -> {
            try {
                String message = "Hello from Thread 1";
                System.out.println("Thread 1 is exchanging: " + message);
                String response = exchanger.exchange(message);
                System.out.println("Thread 1 received: " + response);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // Thread 2
        new Thread(() -> {
            try {
                String message = "Hello from Thread 2";
                System.out.println("Thread 2 is exchanging: " + message);
                String response = exchanger.exchange(message);
                System.out.println("Thread 2 received: " + response);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    // 8. CopyOnWriteArrayList
    public void copyOnWriteArrayListExample() {
        CopyOnWriteArrayList<Integer> cowArrayList = new CopyOnWriteArrayList<>();
        cowArrayList.add(1);
        cowArrayList.add(2);
        System.out.println("CopyOnWriteArrayList: " + cowArrayList);

        // Internal Implementation
        // - Uses a copy-on-write strategy, creating a new copy of the array on each write operation.

        // Time Complexity
        // - Add: O(n) (due to copying)
        // - Get: O(1)
        // - Remove: O(n) (due to copying)

        // When to use
        // - Use CopyOnWriteArrayList when you have a read-heavy scenario with infrequent writes.

        // Trade-offs
        // - High memory usage due to copying on writes.
        // - Slower write operations compared to regular ArrayList.
    }

    // Helper class for DelayQueue
    static class DelayedItem implements Delayed {
        private final String name;
        private final long delayTime;
        private final long creationTime;

        public DelayedItem(String name, long delayTime) {
            this.name = name;
            this.delayTime = delayTime;
            this.creationTime = System.currentTimeMillis();
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long diff = creationTime + delayTime - System.currentTimeMillis();
            return unit.convert(diff, TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
                return -1;
            }
            if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
                return 1;
            }
            return 0;
        }

        public String getName() {
            return name;
        }
    }
}
