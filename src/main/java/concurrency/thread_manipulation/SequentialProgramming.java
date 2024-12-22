package concurrency.thread_manipulation;

public class SequentialProgramming {

    public static void main(String[] args) {
        System.out.println("Using Basic For Loop:");
        printNumbers1();

        System.out.println("\nUsing Enhanced Logic For Loop:");
        printNumbers2();
    }

    public static void printNumbers1() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }

    public static void printNumbers2() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
        }
    }
}
