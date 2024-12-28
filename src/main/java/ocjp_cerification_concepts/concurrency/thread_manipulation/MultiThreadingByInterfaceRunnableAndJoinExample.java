package ocjp_cerification_concepts.concurrency.thread_manipulation;/*
Explanation of the Code:

Threads with Different Delays:
- Three threads (Thread-1, Thread-2, and Thread-3) execute different tasks (Task-1, Task-2, Task-3), each with varying delays (100ms, 200ms, 300ms) to simulate tasks of different complexity.

Using join():
- The join() method ensures that the main thread waits for each thread to complete before moving on to the next.
- thread1.join() ensures the main thread only proceeds after Thread-1 finishes.
- This sequential dependency can be used when the output of one thread affects the logic of subsequent operations.

Runnable Task:
- The Task class implements Runnable to define the behavior of each thread.
- The run() method includes a loop to simulate steps in the task and uses Thread.sleep() to mimic time delays.

Output Messages:
- Each thread prints messages showing the progress of its task (Step 1 to Step 5) and completes with a final message.

Key Points About join():

1. Sequential Execution:
   - Despite starting all threads simultaneously, the main thread enforces sequential completion by using join().

2. Synchronization:
   - This approach ensures dependent tasks execute in the correct order, avoiding race conditions or incomplete results.

3. Real-World Use Case:
   - Such a design can be used in scenarios where multiple tasks run concurrently but the main thread must wait for specific tasks to complete before moving forward, such as aggregating data from multiple sources or preparing a report after parallel processing.
*/

public class MultiThreadingByInterfaceRunnableAndJoinExample { // Also contains join

    public static void main(String[] args) {
        // Creating three threads to perform tasks
        Thread thread1 = new Thread(new Task("Task-1", 100), "Thread-1");
        Thread thread2 = new Thread(new Task("Task-2", 200), "Thread-2");
        Thread thread3 = new Thread(new Task("Task-3", 300), "Thread-3");

        try {
            // Start all threads
            thread1.start();
            thread2.start();
            thread3.start();

            // Using join() to ensure main thread waits for each thread to complete before moving to the next
            thread1.join(); // Ensures the main thread only proceeds after Thread-1 finishes
            System.out.println(thread1.getName() + " has completed.");

            thread2.join(); // Ensures the main thread only proceeds after Thread-2 finishes
            System.out.println(thread2.getName() + " has completed.");

            thread3.join(); // Ensures the main thread only proceeds after Thread-3 finishes
            System.out.println(thread3.getName() + " has completed.");
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        // All threads have completed their tasks
        System.out.println("All threads have completed their tasks.");
    }

    // Task class implementing Runnable to define the thread behavior
    static class Task implements Runnable {
        private final String taskName; // Name of the task
        private final int delay;       // Delay to simulate task execution time

        public Task(String taskName, int delay) {
            this.taskName = taskName;
            this.delay = delay;
        }

        @Override
        public void run() {
            try {
                // Simulate task execution with multiple steps
                for (int i = 1; i <= 5; i++) {
                    // Print the current step and thread details
                    System.out.println(Thread.currentThread().getName() + " executing " + taskName + " - Step " + i);
                    Thread.sleep(delay); // Simulate time taken for each step
                }
                // Task completion message
                System.out.println(Thread.currentThread().getName() + " has completed " + taskName);
            } catch (InterruptedException e) {
                // Handle thread interruption
                System.out.println(Thread.currentThread().getName() + " interrupted while executing " + taskName);
            }
        }
    }
}


