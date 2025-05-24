package com.datastructures.gtci.misc;

public class Tester {
    public static void main(String[] args) {
        int y = 0;
        for (int i = 0; i <= 6; i += 2) {
            y += i;
            System.out.println("in the loop");
            System.out.println("i : " + i + " y : " + y);
        }
        System.out.println(y);

        printArray(new int[]{5, 6, 7, 8});



    }

    public static void printArray(int... arr) {
        for(int a : arr)
            System.out.println(a);
    }
}
