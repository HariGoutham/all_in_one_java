package com.example.demo.handy;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        String s = "harihariharihhehOm";
        s.chars().forEach(a-> {
                    extracted((char) a);
                }
        );
    }

    private static void extracted(char a) {
        int i = 1;
        System.out.println(a + " position is "+ i++);
    }
}
