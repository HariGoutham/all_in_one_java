package java_interview;

public class Java1Basics {

    public static void main(String[] args) {
        // Hello World
        System.out.println("Hello, World!");

        // Variables
        int age = 25; // Integer variable
        double salary = 50000.50; // Double variable
        char initial = 'J'; // Char variable
        boolean isEmployed = true; // Boolean variable

        // Starting out with Expressions
        int sum = age + 5; // Simple expression
        System.out.println("Sum: " + sum);

        // Primitive Types
        byte smallNumber = 100; // Byte type
        short mediumNumber = 10000; // Short type
        long largeNumber = 100000L; // Long type

        // Casting in Java
        double pi = 3.14;
        int intPi = (int) pi; // Explicit casting from double to int
        System.out.println("Casted Pi: " + intPi);

        // Implicit Casting (Widening)
        int intValue = 100;
        long longValue = intValue; // int to long
        float floatValue = longValue; // long to float
        double doubleValue = floatValue; // float to double

        System.out.println("Implicit Casting:");
        System.out.println("Integer Value: " + intValue);
        System.out.println("Long Value: " + longValue);
        System.out.println("Float Value: " + floatValue);
        System.out.println("Double Value: " + doubleValue);

        // Explicit Casting (Narrowing)
        double anotherDoubleValue = 9.78;
        int anotherIntValue = (int) anotherDoubleValue; // double to int (data loss)
        float anotherFloatValue = (float) anotherDoubleValue; // double to float

        System.out.println("\nExplicit Casting:");
        System.out.println("Double Value: " + anotherDoubleValue);
        System.out.println("Integer Value after casting: " + anotherIntValue);
        System.out.println("Float Value after casting: " + anotherFloatValue);

        // Casting between numeric types
        float someFloatValue = 3.14f;
        int someIntValue = (int) someFloatValue; // float to int (data loss)
        System.out.println("\nCasting between numeric types:");
        System.out.println("Float Value: " + someFloatValue);
        System.out.println("Integer Value after casting: " + someIntValue);

        // Casting char to int
        char charValue = 'A';
        int charAsInt = (int) charValue; // char to int
        System.out.println("\nCharacter Value: " + charValue);
        System.out.println("Character as Integer: " + charAsInt);

        // Object Casting
        Animal myAnimal = new Dog(); // Upcasting (implicit)
        myAnimal.sound(); // Calls Dog's sound method

        Dog myDog = (Dog) myAnimal; // Downcasting (explicit)
        myDog.sound(); // Calls Dog's sound method

        // Primitive Types Challenge
        // Example of using different primitive types
        System.out.println("\nPrimitive Types Challenge:");
        System.out.println("Byte: " + smallNumber);
        System.out.println("Short: " + mediumNumber);
        System.out.println("Long: " + largeNumber);

        // Float and Double Primitives
        System.out.println("\nFloat and Double Primitives:");
        System.out.println("Float Number: " + floatValue);
        System.out.println("Double Number: " + salary);

        // Floating Point Precision and a Challenge
        double preciseValue = 0.1 + 0.2; // Precision issue
        System.out.println("\nFloating Point Precision:");
        System.out.println("0.1 + 0.2 = " + preciseValue); // May not equal 0.3

        // The char and boolean Primitive Data Types
        System.out.println("\nChar and Boolean Primitive Data Types:");
        System.out.println("Initial: " + initial);
        System.out.println("Is Employed: " + isEmployed);

        // Primitive Types Recap and the StringStringBuilderStringBuffer Data Type
        String name = "John Doe"; // StringStringBuilderStringBuffer type
        System.out.println("\nName: " + name);

        // Operators, Operands and Expressions
        int a = 10;
        int b = 20;
        int result = a + b; // Using operators
        System.out.println("\nOperators, Operands and Expressions:");
        System.out.println("Result of a + b: " + result);

        // Abbreviating Operators
        int count = 5;
        count += 2 ; // Equivalent to count = count + 2
        System.out.println("Count after += 2: " + count);

        // Comparison Operators
        boolean isEqual = (a == b);
        System.out.println("Is a equal to b? " + isEqual);

        // Logical Operators
        boolean isTrue = (a < b) && (count > 5);
        System.out.println("Is a less than b AND count greater than 5? " + isTrue);

        // Ternary Operator
        String resultMessage = (a > b) ? "a is greater" : "b is greater";
        System.out.println("Ternary Operator Result: " + resultMessage);
    }
}

class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}
