package com.example.demo.zz1_handy;

import java.util.LinkedHashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        int[] a = {9, 8, 6, 7, 8, 1, 10, 15, 18};
        int sum = 16;
        Map<Integer, Integer> d = new LinkedHashMap<>();
        int j = 0;
        for (int i : a) {
            d.put(i, j);
            j++;
        }
        for (int i = 0; i < a.length; i++) {
            int r = sum - a[i];
            if (d.containsKey(r) && i != d.get(r) && a[i] <= a[d.get(r)]) {
                System.out.println(a[i] + " " + a[d.get(r)]);
            }
        }
    }
}
