package com.example.demo.z3_problems;

public class Problems1 {

    public static void main(String[] args) {
        // Question 1 : given a string find position of each alphabet in string
        findPositionOfCharactersInString();
        findPositionOfCharactersInStringJava8();
        
        // Question 2 :
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
}
