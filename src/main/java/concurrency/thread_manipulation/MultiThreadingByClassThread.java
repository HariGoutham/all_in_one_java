package concurrency.thread_manipulation;

public class MultiThreadingByClassThread {

    public static void main(String[] args) {
        // Create custom thread instances
        Thread thread1 = new PrintNumbersThread1();
        Thread thread2 = new PrintNumbersThread2();

        // Set thread names for identification
        thread1.setName("Thread-1");
        thread2.setName("Thread-2");

        // Start the threads
        thread1.start();
        thread2.start();

        System.out.println("Both methods initiated.");
    }

    // Custom thread for printing numbers in printNumbers1
    static class PrintNumbersThread1 extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
            }
        }
    }

    // Custom thread for printing numbers in printNumbers2
    static class PrintNumbersThread2 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + (i + 1));
            }
        }
    }

}
