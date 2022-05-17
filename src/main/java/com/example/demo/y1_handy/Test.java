package com.example.demo.y1_handy;

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
