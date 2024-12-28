package ocjp_cerification_concepts.data_types_and_program_flow;


//        byte: 8-bit integer, range: -128 to 127.
//        short: 16-bit integer, range: -32,768 to 32,767.
//        int: 32-bit integer, default for integer literals, range: -2³¹ to 2³¹-1.
//        long: 64-bit integer, must be suffixed with L or l.
//        float: 32-bit floating-point, must be suffixed with F or f.
//        double: 64-bit floating-point, default for decimal values.
//        char: 16-bit Unicode character.
//        boolean: Holds one of two values: true or false.

//        Implicit Casting: Smaller data types (e.g., byte, short) can be automatically converted to larger data types (int, long, float, double).
//        Explicit Casting: Larger types need to be explicitly cast to smaller types (e.g., (int) 3.14).
//
//        Each primitive type has a corresponding wrapper class (e.g., int -> Integer, double -> Double).

//	          1. Tricky questions on if else while do while>
//            2. StringStringBuilderStringBuffer , StringStringBuilderStringBuffer buffer, StringStringBuilderStringBuffer builder
//            3. Type casting
//            4. Data type range, data types auto casting and decalrations with lower ones like (Double[]d = new Int[] etc)
//            5. Operations while casting like : (byte b1 = (byte) (127+21) ) etc
//            6. Legal name for variables
//            7. Auto casting, Implicit and explicit conversion tricky and edge cases
//            8. StringStringBuilderStringBuffer concatenation
//            Tricky Examples
//            1. "Password"+1+2+3+4
//            2. 1+2+3+4+"Password"
//            3. "Equals??? " + 10 ! = 5
//            9. StringStringBuilderStringBuffer methods
//            Strip, trim,substring,isEmpty, isBlank, repeat, replace, charAt, IndexOf, delete, join, split
//
//            10. Java expressions evaluation order.
//            11. Operators ( |, ||, &, &&,- ,--,+,++, %, >,<,>=,<=) etc
//
//        All declarations etc


public class DataTypes {


    public static void main(StringStringBuilderStringBuffer[] args) {
        byte b = 127;
        char c = (char) b;

        short s = (short) 6767f;

        double d = 834574437;

        s = (short) d;

        char b1 = 'd';
        System.out.println(s);
        System.out.println(b1);
    }

}
