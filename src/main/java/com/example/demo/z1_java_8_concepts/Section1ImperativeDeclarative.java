package com.example.demo.z1_java_8_concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Section1ImperativeDeclarative {

    public static void main(String[] args) {
        sumBeforeJava8Example();
        sumUsingJava8();

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 4, 5, 5, 6, 7, 7, 8, 9, 9);

        removeDuplicatesFromListBeforeJava8(integerList);
        removeDuplicatesFromListInJava8(integerList);
    }

    private static void sumBeforeJava8Example() {
        // sum of integers for the range from 0 to 100
        /*
          Imperative Style - how style of programming
         */
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
            // shared mutable state and its sequential, and it will go step by step,
            // and it will have issues if we try to run the code in multithreaded environment
        }
        System.out.println("Sum is : " + sum);
    }

    private static void sumUsingJava8() {
        /*
          Declarative style. (Functional programming uses the same style)
          what style of programming.
          You let the system do the job for you and get the result.
         */
        //.parallel()
        int sum1 = IntStream.rangeClosed(0, 100)
                .sum();

        System.out.println("sum1 : " + sum1);
    }
    private static void removeDuplicatesFromListBeforeJava8(List<Integer> integerList) {
        /*
          Imperative Style
         */
        List<Integer> uniqueList = new ArrayList<>();
        for (Integer i : integerList)
            if (!uniqueList.contains(i)) {
                uniqueList.add(i);
            }
        System.out.println("unique List : " + uniqueList);
    }

    private static void removeDuplicatesFromListInJava8(List<Integer> integerList) {
        /*
          Declarative Style
         */

        List<Integer> uniqueList1 = integerList.stream()
                .distinct()
                .collect(toList());
        System.out.println("uniqueList1 : " + uniqueList1);
    }
}
