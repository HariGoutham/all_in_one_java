package ocjp_cerification_concepts.data_types_and_program_flow;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] numbers; // Preferred way
        int numbers1[]; // Valid but less common

        // Static initialization
        int[] numbers3 = {1, 2, 3, 4, 5};

        // Dynamic initialization
        int[] numbers4 = new int[5]; // Creates an array of size 5


        System.out.println(numbers3);
        System.out.println(numbers4);

        int firstElement = numbers3[0]; // Accessing the first element
        System.out.println(firstElement);
        numbers3[1] = 10; // Modifying the second element
        numbers3[2] = 7;
        numbers3[3] = 6;
        System.out.println(numbers3[0]+" "+numbers3[1]+" "+numbers3[2]+" "+numbers3[3]+" "+numbers3[4]);

        Arrays.sort(numbers3); // Sorts the array in ascending order
        System.out.println(numbers3[0]+" "+numbers3[1]+" "+numbers3[2]+" "+numbers3[3]+" "+numbers3[4]);
    }
}
