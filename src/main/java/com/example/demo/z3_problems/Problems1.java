package com.example.demo.z3_problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problems1 {

    public static void main(String[] args) {
        // Question 1 : given a string find position of each alphabet in string
        findPositionOfCharactersInString();
        findPositionOfCharactersInStringJava8();
        
        // Question 2 : remove duplicates and sort in descending order from list
        removeDuplicatesAndSortInDescendingFromList();

        // Question 3 : reverse a string
        extracted();

    }

    private static void extracted() {
        List<Integer> v = Arrays.asList(22,3,5,6,22,67,34,3,5,12,22,32,12);
        String s = "Hari";
        System.out.println(new StringBuilder(s).reverse().toString());

        char[] v1 = s.toCharArray();

        for(int i=0,j = (v1.length-1); i < v1.length/2;  i++,j--){
            char temp = v1[i];
            v1[i] = v1[j];
            v1[j] = temp;
        }
        System.out.println(String.valueOf(v1));
    }

    private static void findPositionOfCharactersInString() {
        String str = "demo";
        String strUpper = str.toUpperCase();
        char[] ch = strUpper.toCharArray();
        for(int i=0; i< ch.length ;i++){
            int j = i+1;
            System.out.println(ch[i]+"= "+"positioned at "+j);
        }
    }

    private static void findPositionOfCharactersInStringJava8() {
        String str = "demo";
        final int[] j = {1};
        //TODO enhance the below without using array
        str.toUpperCase().chars().forEach( i -> {
            System.out.println((char) i +"= "+"positioned at "+j[0]++);
        });
    }
    private static void removeDuplicatesAndSortInDescendingFromList() {
        List<Integer> v = Arrays.asList(22,3,5,6,22,67,34,3,5,12,22,32,12);
        System.out.println(v.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
    }
}
