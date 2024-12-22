package concurrency.thread_manipulation;

public class DeamonAndPriorityThreadExamples {

    public static void main(String[] args) {
        // Example of Daemon and User Threads
        Thread daemonThread = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("Daemon thread running...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Daemon thread interrupted.");
                }
            }
        });

        // Setting thread as daemon
        daemonThread.setDaemon(true);

        Thread userThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("User thread executing: " + i);
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    System.out.println("User thread interrupted.");
                }
            }
            System.out.println("User thread completed.");
        });

        // Example of Thread Priority
        Thread lowPriorityThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Low priority thread executing.");
            }
        });

        Thread highPriorityThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("High priority thread executing.");
            }
        });

        // Setting priorities
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY); // Priority 1
        highPriorityThread.setPriority(Thread.MAX_PRIORITY); // Priority 10

        // Start threads
        daemonThread.start();
        userThread.start();
        lowPriorityThread.start();
        highPriorityThread.start();

        // Java Thread Scheduler
        // The thread scheduler decides the order of execution of threads.
        // This behavior is dependent on the underlying OS and JVM implementation.

        System.out.println("Main thread completed.");
    }
}
