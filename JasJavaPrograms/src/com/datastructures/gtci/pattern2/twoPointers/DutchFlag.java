package com.datastructures.gtci.pattern2.twoPointers;


/*
 * Dutch National Flag Problem
 *
 * Given an array containing 0s, 1s and 2s, sort the array in-place.
 * You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
 * The flag of the Netherlands consists of three colors: red, white and blue; and since our input array also consists of three different
 * numbers that is why it is called Dutch National Flag problem.
 *
 * Example 1:
 * Input: [1, 0, 2, 1, 0]
 * Output: [0, 0, 1, 1, 2]
 *
 * Example 2:
 * Input: [2, 2, 0, 1, 2, 0]
 * Output: [0, 0, 1, 2, 2, 2,]
 */

import java.util.Arrays;

public class DutchFlag {
    public static void sort(int[] arr) {

//        1. Maintain two pointers for 0 and 2. Objective is to get the 0s at the lowest index by swapping the upcoming 0 with the low index and
//        then incrementing this index so that the next 0 encountered gets a position at (low+1)th index to be placed at.
//        Similarly, all the 2s should be moved to the high index by swapping the upcoming 2 with the high index and then this index be decremented
//        so that the next upcoming 2 gets to be placed at high--.
//        After the end of the above operation, all 0s will be shifted to the LHS, 2s to be at RHS making all 1s to be in the middle.

        int low = 0;
        int high = arr.length - 1;

        for (int i = 0; i <= high; ) {
            if (arr[i] == 0) {
                swap(arr, i, low);
                i++;
                low++;
            } else if (arr[i] == 1) {
                i++;
            } else { // arr[i] == 2
                swap(arr, i, high);
                high--;
            }
        }
    }

    public static void swap(int[] arr, int currentIndex, int lowHighIndex) {
        int temp = arr[currentIndex];
        arr[currentIndex] = arr[lowHighIndex];
        arr[lowHighIndex] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 1, 0};
        DutchFlag.sort(arr);
        System.out.print(Arrays.toString(arr));

        System.out.println();

        arr = new int[]{2, 2, 0, 1, 2, 0};
        DutchFlag.sort(arr);
        System.out.print(Arrays.toString(arr));
    }

}
