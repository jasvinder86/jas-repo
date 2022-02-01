package com.datastructures.gtci.pattern2.twoPointers;

/*
 * Remove Duplicates
 * Given an array of sorted numbers, remove all duplicates from it.
 * You should not use any extra space; after removing the duplicates in-place return the length of the subarray that has no duplicate in it.
 */

public class RemoveDuplicates {

    public static int remove(int[] arr) {
        int j = 0, counter = 0;
        if (arr.length > 0)
            counter = 1;

//            traverse i from 0 to < length-1 and j from 1 to < length, so that j is always at i+1
        for (int i = 0; i < arr.length - 1; i++) {
            j = i + 1;
            if (arr[i] != arr[j]) {
                counter++;
            }
            j++;
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 3, 3, 6, 9, 9};         // expected output = 4
        System.out.println(RemoveDuplicates.remove(arr));

        arr = new int[]{2, 2, 2, 11};                       // expected output = 2
        System.out.println(RemoveDuplicates.remove(arr));
    }
}
