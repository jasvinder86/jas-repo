package com.datastructures.gtci.pattern2.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 *
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 * Explanation: There are four unique triplets whose sum is equal to zero.
 */

public class TripletSumToZero {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();

//        1. First, sort this array
        Arrays.sort(arr);
//        Now this array will be in ascending order, all negatives on the LHS and positives on RHS
//        2. Traverse a pivot from 0 to < length-2 since the last two numbers will get accounted by left and right pointers
//        3. If sum of pivot, lth and rth index = 0, that is one eligible triplet.

        for (int pivot = 0; pivot < arr.length - 2; pivot++) {
            int leftPointer = pivot + 1, rightPointer = arr.length - 1;

            while (leftPointer < rightPointer) {
                int sumOfPointers = arr[pivot] + arr[leftPointer] + arr[rightPointer];
                if (sumOfPointers == 0) {
                    triplets.add(Arrays.asList(arr[pivot], arr[leftPointer], arr[rightPointer]));
                    leftPointer++;
                    rightPointer--;
                } else if (sumOfPointers > 0) {
                    rightPointer--;
                } else {
                    leftPointer++;
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println(TripletSumToZero.searchTriplets(new int[]{-5, 2, -1, -2, 3}));
    }
}
