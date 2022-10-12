package com.example.demo.leetcode_75;

import java.util.Arrays;

public class LC1_TwoSum {

    //Solution 1 - Complexity(O(n2))
    public static int[] twoSum(int[] nums, int target) {

        int[] solution = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length && j != i; j++) {
                 if(nums[i] + nums[j] == target){
                     solution[0] = i;
                     solution[1] = j;
                     return solution;
                 }
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        Arrays.stream(twoSum(new int[]{ 1,2,3,4,5,6,7,8,9,10 }, 9)).forEach(a-> System.out.println(a));
    }
}
