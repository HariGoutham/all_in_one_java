package ocjp_cerification_concepts.concurrency.inter_thread_communication;

public class SynchronisationDemo {

    private static int counter = 0;  // Shared resource

    // Thread that increments the counter
    static class IncrementThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                synchronized (SynchronisationDemo.class) {  // Synchronizing the block
                    counter++;
                }
            }
            System.out.println("Counter after incrementing: " + counter);
        }
    }

    // Thread that decrements the counter
    static class DecrementThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                synchronized (SynchronisationDemo.class) {  // Synchronizing the block
                    counter++;
                }
            }
            System.out.println("Counter after decrementing: " + counter);
        }
    }

    public static void main(String[] args) {
        // Create and start threads
        IncrementThread incrementThread = new IncrementThread();
        DecrementThread decrementThread = new DecrementThread();

        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print final counter value (this will now be consistent)
        System.out.println("Final counter value (with synchronization): " + counter);
    }
}

