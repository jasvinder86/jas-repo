package com.datastructures.gtci.pattern2.twoPointers;

/*
Statement
Given an array, colors, which contains a combination of the following three elements:
        0 (Representing red)
        1 (Representing white)
        2 (Representing blue)
Sort the array in place so that the elements of the same color are adjacent, and the final order is: red (0), then white (1), and then blue (2).
Note: You are not allowed to use any built-in sorting functions. The goal is to solve this efficiently without extra space.

Sample:
 i/p: 102122
 o/p: 011222
*/


public class SortColors {
    public static int[] sortColors(int[] colors) {
        int start = 0, pivot = 0, end = colors.length - 1;

//        Core idea: Keep moving all the 0s to the starting index, all the 2s at the last index. Middle ones will automatically be all the 1s.

        while (pivot <= end) {

//        Check the value of the current and the perform further operations.
            if (colors[pivot] == 0) { // swap with the element at the starting index.
                int temp = colors[pivot];
                colors[pivot] = colors[start];
                colors[start] = temp;

                start++;
                pivot++;

            } else if (colors[pivot] == 1) {
                pivot++;
            } else { // swap with the element at the last index.
                int temp = colors[pivot];
                colors[pivot] = colors[end];
                colors[end] = temp;

                end--;
            }

        }

        return colors;
    }
}
