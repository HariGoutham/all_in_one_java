package java8_features.j8_1_functional_interface.inbuilt;

import java.util.function.Consumer;

/*
Advantages of Effectively Final:
1. Easy to perform concurrency operations.
2. Promotes Functional Programming and demotes Imperative style programming.
3. Lambdas are allowed to use local variables but are not allowed to modify them, even if they are not explicitly declared as final. This concept is called "Effectively Final."
*/

public class LambdaLocalVariablesDemo {

    // Instance variable: No restrictions when accessed in Lambdas
    private int instanceVariable = 10;

    public static void main(String[] args) {
        LambdaLocalVariablesDemo demo = new LambdaLocalVariablesDemo();
        demo.demoLocalVariablesWithLambdas();
    }

    public void demoLocalVariablesWithLambdas() {
        // Local Variable: A variable declared inside a method. It is scoped to the method.
        int localVariable = 5; // This is effectively final (value cannot change once assigned).

        // Example of using a local variable in a Lambda
        Consumer<Integer> consumer = (a) -> {
            // Accessing the local variable is allowed as long as it is effectively final.
            System.out.println("Lambda accessing local variable: " + (a + localVariable));

            // Uncommenting the line below will cause a compilation error:
            // localVariable = 10; // Error: Local variable used in lambda should be effectively final.
        };

        consumer.accept(10); // Invokes the lambda, output: "Lambda accessing local variable: 15"

        // Demonstrating instance variables: These can be modified freely.
        Consumer<Integer> instanceConsumer = (a) -> {
            instanceVariable += a;
            System.out.println("Instance variable after modification: " + instanceVariable);
        };

        instanceConsumer.accept(5); // Modifies instanceVariable, output: "Instance variable after modification: 15"

        // Compilation error example: Re-assigning a local variable used in a lambda
        // Uncomment the following lines to see the error:
        // Consumer<Integer> errorConsumer = (a) -> {
        //     localVariable = 20; // Error: Cannot assign a value to localVariable
        //     System.out.println(a);
        // };

        // Prior to Java 8, variables used in anonymous classes had to be explicitly final:
         final int finalVariable = 5;
         Runnable runnable = new Runnable() {
             @Override
             public void run() {
                 System.out.println(finalVariable); // Allowed since it's final
             }
         };
    }
}
