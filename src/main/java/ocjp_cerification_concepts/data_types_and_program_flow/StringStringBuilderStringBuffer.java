package ocjp_cerification_concepts.data_types_and_program_flow;


//In Java, StringStringBuilderStringBuffer, StringBuffer, and StringBuilder are three classes used to handle strings, but they have different characteristics and use cases. Here’s a detailed overview of each, along with their differences and when to use each one.

//        1. StringStringBuilderStringBuffer
//        Definition: StringStringBuilderStringBuffer is an immutable sequence of characters. Once a StringStringBuilderStringBuffer object is created, its value cannot be changed.
//        Characteristics:
//        Immutability: Any modification to a StringStringBuilderStringBuffer results in the creation of a new StringStringBuilderStringBuffer object.
//        Thread-Safety: Since StringStringBuilderStringBuffer objects are immutable, they are inherently thread-safe.
//        Usage: Use StringStringBuilderStringBuffer when you have a fixed set of characters that do not need to be modified. It is suitable for constants or when you are not performing many modifications.

//        2. StringBuffer
//        Definition: StringBuffer is a mutable sequence of characters. It allows for the modification of the string without creating a new object.
//        Characteristics:
//        Mutability: You can change the contents of a StringBuffer object without creating a new object.
//        Thread-Safety: StringBuffer is synchronized, making it thread-safe. This means that multiple threads can safely use a StringBuffer instance.
//        Usage: Use StringBuffer when you need to modify strings frequently in a multi-threaded environment.

//        3. StringBuilder
//        Definition: StringBuilder is similar to StringBuffer, but it is not synchronized, which means it is not thread-safe.
//        Characteristics:
//        Mutability: Like StringBuffer, StringBuilder allows for modification of the string without creating a new object.
//        Performance: StringBuilder is generally faster than StringBuffer because it does not have the overhead of synchronization.
//        Usage: Use StringBuilder when you need to modify strings frequently in a single-threaded environment or when thread safety is not a concern.

public class StringStringBuilderStringBuffer {

    public static void main(String[] args) {

        //String : Immutable and can be safely used in multithreaded environment
        String str1 = "Hello";
        str1 = str1 + " World"; // Creates a new String object

        //Synchronised and thread safe but slow and mutable
        StringBuffer sBuffer = new StringBuffer("Hello");
        sBuffer.append(" World"); // Modifies the existing StringBuffer object

        //Not thread safe but fast and mutable
        StringBuilder sBuilder = new StringBuilder("Hello");
        sBuilder.append(" World"); // Modifies the existing StringBuilder object

        // String examples
        String str = "Hello, World!";
        System.out.println("Original String: " + str);

        // Length
        System.out.println("Length: " + str.length());

        // Character access
        System.out.println("Character at index 7: " + str.charAt(7));

        // Index of
        System.out.println("Index of 'World': " + str.indexOf("World"));

        // Substring
        System.out.println("Substring (7, 12): " + str.substring(7, 12));

        // Replace
        System.out.println("Replace 'World' with 'Java': " + str.replace("World", "Java"));

        // Convert to lower and upper case
        System.out.println("Lowercase: " + str.toLowerCase());
        System.out.println("Uppercase: " + str.toUpperCase());

        // Trim
        String strWithSpaces = "   Hello, World!   ";
        System.out.println("Trimmed String: '" + strWithSpaces.trim() + "'");

        // Split
        String[] words = str.split(", ");
        System.out.println("Split String: ");
        for (String word : words) {
            System.out.println(word);
        }

        // StringBuffer examples
        StringBuffer stringBuffer = new StringBuffer("Hello");
        System.out.println("\nOriginal StringBuffer: " + stringBuffer);

        // Append
        stringBuffer.append(", World!");
        System.out.println("After Append: " + stringBuffer);

        // Insert
        stringBuffer.insert(5, " Java");
        System.out.println("After Insert: " + stringBuffer);

        // Delete
        stringBuffer.delete(5, 10);
        System.out.println("After Delete: " + stringBuffer);

        // Replace
        stringBuffer.replace(0, 5, "Hi");
        System.out.println("After Replace: " + stringBuffer);

        // Reverse
        stringBuffer.reverse();
        System.out.println("After Reverse: " + stringBuffer);

        // Convert to String
        String bufferAsString = stringBuffer.toString();
        System.out.println("String from StringBuffer: " + bufferAsString);

        // StringBuilder examples
        StringBuilder stringBuilder = new StringBuilder("Hello");
        System.out.println("\nOriginal StringBuilder: " + stringBuilder);

        // Append
        stringBuilder.append(", World!");
        System.out.println("After Append: " + stringBuilder);

        // Insert
        stringBuilder.insert(5, " Java");
        System.out.println("After Insert: " + stringBuilder);

        // Delete
        stringBuilder.delete(5, 10);
        System.out.println("After Delete: " + stringBuilder);

        // Replace
        stringBuilder.replace(0, 5, "Hi");
        System.out.println("After Replace: " + stringBuilder);

        // Reverse
        stringBuilder.reverse();
        System.out.println("After Reverse: " + stringBuilder);

        // Convert to String
        String builderAsString = stringBuilder.toString();
        System.out.println("String from StringBuilder: " + builderAsString);
    }

}
