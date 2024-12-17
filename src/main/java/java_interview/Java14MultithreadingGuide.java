package java_interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Comprehensive Java Multithreading and Concurrency Guide
 *
 * Covers:
 * 1. Thread Creation and Execution
 * 2. Thread Lifecycle and Interaction
 * 3. Synchronization Mechanisms
 * 4. Concurrency Challenges
 * 5. Executor Frameworks
 * 6. Advanced Concurrency Patterns
 * 7. Thread-Safe Collections
 * 8. Parallel Processing
 */
public class Java14MultithreadingGuide {

    // 1. Thread Creation Techniques
    public static void demonstrateThreadCreation() {
        System.out.println("\n--- Thread Creation Techniques ---");

        // Method 1: Extending Thread Class
        class WorkerThread extends Thread {
            public void run() {
                System.out.println("Worker Thread Running");
            }
        }

        // Method 2: Implementing Runnable Interface
        class RunnableWorker implements Runnable {
            public void run() {
                System.out.println("Runnable Worker Running");
            }
        }

        // Method 3: Anonymous Inner Class
        Runnable anonymousWorker = new Runnable() {
            public void run() {
                System.out.println("Anonymous Worker Running");
            }
        };

        // Method 4: Lambda Expression
        Runnable lambdaWorker = () -> {
            System.out.println("Lambda Worker Running");
        };

        // Executing Threads
        new WorkerThread().start();
        new Thread(new RunnableWorker()).start();
        new Thread(anonymousWorker).start();
        new Thread(lambdaWorker).start();
    }

    // 2. Thread Lifecycle and Interaction
    public static void demonstrateThreadLifecycle() {
        System.out.println("\n--- Thread Lifecycle ---");

        Thread lifecycleThread = new Thread(() -> {
            try {
                System.out.println("Thread Started");
                Thread.sleep(1000); // Simulating work
                System.out.println("Thread Completed");
            } catch (InterruptedException e) {
                System.out.println("Thread Interrupted");
            }
        });

        System.out.println("Thread State Before Start: " + lifecycleThread.getState());
        lifecycleThread.start();

        try {
            lifecycleThread.join(); // Wait for thread to complete
            System.out.println("Thread State After Completion: " + lifecycleThread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 3. Synchronization Mechanisms
    public static class SharedResource {
        private int counter = 0;

        // Synchronized method
        public synchronized void incrementSafely() {
            counter++;
        }

        // Synchronized block
        public void incrementWithBlock() {
            synchronized (this) {
                counter++;
            }
        }

        public int getCounter() {
            return counter;
        }
    }

    public static void demonstrateSynchronization() {
        System.out.println("\n--- Synchronization ---");

        SharedResource resource = new SharedResource();

        // Multiple threads accessing shared resource
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(resource::incrementSafely);
            threads.add(t);
            t.start();
        }

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Final Counter: " + resource.getCounter());
    }

    // 4. Producer-Consumer Pattern
    public static void demonstrateProducerConsumer() {
        System.out.println("\n--- Producer-Consumer ---");

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 50; i++) {
                    queue.put(i);
                    System.out.println("Produced: " + i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 50; i++) {
                    Integer value = queue.take();
                    System.out.println("Consumed: " + value);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 5. Executor Framework
    public static void demonstrateExecutorFramework() {
        System.out.println("\n--- Executor Framework ---");

        // Single Thread Executor
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.submit(() -> System.out.println("Single Thread Task"));

        // Fixed Thread Pool
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        IntStream.range(0, 5).forEach(i ->
                fixedThreadPool.submit(() ->
                        System.out.println("Task " + i + " executed by " +
                                Thread.currentThread().getName())
                )
        );

        // Shutdown executors
        singleThreadExecutor.shutdown();
        fixedThreadPool.shutdown();
    }

    // 6. Parallel Streams
    public static void demonstrateParallelStreams() {
        System.out.println("\n--- Parallel Streams ---");

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) numbers.add(i);

        long startTime = System.nanoTime();
        long sum = numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .mapToLong(Integer::longValue)
                .sum();
        long endTime = System.nanoTime();

        System.out.println("Parallel Stream Sum: " + sum);
        System.out.println("Execution Time: " + (endTime - startTime) + " ns");
    }

    // 7. Thread-Safe Collections
    public static void demonstrateConcurrentCollections() {
        System.out.println("\n--- Concurrent Collections ---");

        // Thread-safe list
        List<String> threadSafeList = new CopyOnWriteArrayList<>();

        // Concurrent operations
        ExecutorService executor = Executors.newFixedThreadPool(5);
        IntStream.range(0, 100).forEach(i ->
                executor.submit(() -> threadSafeList.add("Item " + i))
        );

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("List Size: " + threadSafeList.size());
    }

    // 8. Advanced Concurrency: Fork/Join
    public static void demonstrateForkJoinPool() {
        System.out.println("\n--- Fork/Join Pool ---");

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        long result = forkJoinPool.invoke(new RecursiveTask<Long>() {
            @Override
            protected Long compute() {
                // Recursive computation logic
                return 0L;
            }
        });

        System.out.println("Fork/Join Result: " + result);
    }

    // 9. Atomic Operations
    public static void demonstrateAtomicOperations() {
        System.out.println("\n--- Atomic Operations ---");

        AtomicInteger atomicCounter = new AtomicInteger(0);

        ExecutorService executor = Executors.newFixedThreadPool(10);

        // Concurrent atomic increments
        IntStream.range(0, 1000).forEach(i ->
                executor.submit(atomicCounter::incrementAndGet)
        );

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Atomic Counter Final Value: " + atomicCounter.get());
    }

    // 10. Deadlock Demonstration
    public static void demonstrateDeadlock() {
        System.out.println("\n--- Deadlock Scenario ---");

        Object resource1 = new Object();
        Object resource2 = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Holding resource 1");

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {}

                System.out.println("Thread 1: Waiting for resource 2");
                synchronized (resource2) {
                    System.out.println("Thread 1: Holding resource 1 & 2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Holding resource 2");

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {}

                System.out.println("Thread 2: Waiting for resource 1");
                synchronized (resource1) {
                    System.out.println("Thread 2: Holding resource 2 & 1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    // 11. Condition Variables and Wait/Notify
    public static class SharedBuffer {
        private final int capacity;
        private final List<Integer> buffer;

        public SharedBuffer(int capacity) {
            this.capacity = capacity;
            this.buffer = new ArrayList<>(capacity);
        }

        public synchronized void produce(int item) throws InterruptedException {
            while (buffer.size() == capacity) {
                wait(); // Wait if buffer is full
            }

            buffer.add(item);
            System.out.println("Produced: " + item);
            notify(); // Notify consumer
        }

        public synchronized int consume() throws InterruptedException {
            while (buffer.isEmpty()) {
                wait(); // Wait if buffer is empty
            }

            int item = buffer.remove(0);
            System.out.println("Consumed: " + item);
            notify(); // Notify producer
            return item;
        }
    }

    public static void demonstrateConditionVariables() {
        System.out.println("\n--- Condition Variables ---");

        SharedBuffer buffer = new SharedBuffer(5);

        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    buffer.produce(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    buffer.consume();
                    Thread.sleep(150);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producerThread.start();
        consumerThread.start();
    }

    // 12. Scheduled Thread Pool
    public static void demonstrateScheduledExecutor() {
        System.out.println("\n--- Scheduled Executor ---");

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // Run task every 2 seconds
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Periodic Task: " + System.currentTimeMillis());
        }, 0, 2, TimeUnit.SECONDS);

        // Run task after 5 seconds delay
        scheduler.schedule(() -> {
            System.out.println("Delayed Task Executed");
        }, 5, TimeUnit.SECONDS);

        // Allow some time for tasks to execute
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.shutdown();
    }

    // 13. Work Stealing Pool
    public static void demonstrateWorkStealingPool() {
        System.out.println("\n--- Work Stealing Pool ---");

        ExecutorService workStealingPool = Executors.newWorkStealingPool();

        IntStream.range(0, 10).forEach(i ->
                workStealingPool.submit(() -> {
                    System.out.println("Task " + i + " executed by " +
                            Thread.currentThread().getName());
                })
        );

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        workStealingPool.shutdown();
    }

    public static void main(String[] args) {
        demonstrateThreadCreation();
        demonstrateThreadLifecycle();
        demonstrateSynchronization();
        demonstrateProducerConsumer();
        demonstrateExecutorFramework();
        demonstrateParallelStreams();
        demonstrateConcurrentCollections();
        demonstrateForkJoinPool();
        demonstrateAtomicOperations();
        demonstrateDeadlock();
        demonstrateConditionVariables();
        demonstrateScheduledExecutor();
        demonstrateWorkStealingPool();
    }
}
