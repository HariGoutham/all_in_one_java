package com.example.demo.y1_handy;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestArchive {

    public static void main(String[] args) {
        collectDistinctEvenNumbers();
    }

    private static void collectDistinctEvenNumbers() {
        Integer[] integers = {1, 2, 3, 2, 5, 4, 9, 7, 6, 6, 8, 3, 7, 4, 5, 66, 43, 34, 334, 3244, 8300};
        System.out.println(Arrays.stream(integers).distinct()
                .filter(evenNumbers()).sorted().collect(Collectors.toList()));
    }

    private static Predicate<Integer> evenNumbers() {
        return i -> i % 2 == 0;
    }
}
