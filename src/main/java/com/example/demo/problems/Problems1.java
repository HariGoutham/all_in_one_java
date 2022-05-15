package com.example.demo.problems;

public class Problems1 {

    public static void main(String[] args) {
        // Question 1 : given a string find position of each alphabet in string
        findPositionOfCharactersInString();
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
}
