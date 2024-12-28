package ocjp_cerification_concepts.generics;

public class Generics2ClassUsage {
    public static void main(String[] args) {
        Generics2Class<String> stringBox = new Generics2Class<>();
        stringBox.set("Hello");
        System.out.println(stringBox.get()); // Output: Hello

        Generics2Class<Integer> integerBox = new Generics2Class<>();
        integerBox.set(5222);
        System.out.println(integerBox.get()); // Output: 5222


        Generics2Class rawBox = new Generics2Class();
        rawBox.set("String");
        rawBox.set(123); // Allowed, but unsafe


    }
}
