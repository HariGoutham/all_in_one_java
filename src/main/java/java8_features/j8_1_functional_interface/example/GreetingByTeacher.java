package java8_features.j8_1_functional_interface.example;

public class GreetingByTeacher {

    public static void main(String[] args) {
        Greeting grt = (message) -> System.out.println("Thanks And "+message);
        grt.greet("Good morning Students");
        grt.greet("Hello Students");
    }
}
