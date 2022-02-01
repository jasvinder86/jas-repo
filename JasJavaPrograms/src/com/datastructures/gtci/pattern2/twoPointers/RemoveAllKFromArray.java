package com.datastructures.gtci.pattern2.twoPointers;

/*
 * Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and return the new length of the array.
 * */

public class RemoveAllKFromArray {

    public static int remove(int[] array, int k) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != k)
                counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(RemoveAllKFromArray.remove(new int[]{3, 2, 3, 6, 3, 10, 9, 3}, 3));
        System.out.println(RemoveAllKFromArray.remove(new int[]{2, 11, 2, 2, 1}, 2));
    }

}
