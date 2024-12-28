package ocjp_cerification_concepts.concurrency.inter_thread_communication;

public class WithoutSynchronizationDemo {

    private static int counter = 0;  // Shared resource

    // Thread that increments the counter
    static class IncrementThread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter++;
            }
            System.out.println("Counter after incrementing: " + counter);
        }
    }

    // Thread that decrements the counter
    static class IncrementThread2 extends Thread {
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter++;
            }
            System.out.println("Counter after incrementing: " + counter);
        }
    }

    public static void main(String[] args) {
        // Create and start threads
        IncrementThread1 incrementThread = new IncrementThread1();
        IncrementThread2 decrementThread = new IncrementThread2();

        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print final counter value (this may be inconsistent)
        System.out.println("Final counter value (without synchronization): " + counter);
    }
}
