package java8_features.j8_1_functional_interface.example;

public class GreetingByStudent {

    public static void main(String[] args) {
        // Syntax for Lambda Expression in Java
        // (parameters) -> expression
        Greeting grt = (message) -> System.out.println(message); //This can also be written as System.out::println by method reference

        grt.greet("Hi Sir");
        grt.greet("Good morning");
    }

}
