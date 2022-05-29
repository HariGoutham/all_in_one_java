package com.example.demo.y1_handy;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 2, 5, 4, 9, 7, 6, 6, 8, 3, 7, 4, 5, 66, 43, 34, 334, 3244, 8300};
        System.out.println(Arrays.stream(integers)
                .distinct()
                .filter(i -> i%2 == 0  && i > 100)
                .sorted()
                .collect(Collectors.toList()));

        System.out.println("-------------------");

        System.out.println(Stream.of(integers).distinct()
                .filter(i -> i%2 != 0  && i > 100)
                .sorted()
                .collect(Collectors.toList()));
    }
}
