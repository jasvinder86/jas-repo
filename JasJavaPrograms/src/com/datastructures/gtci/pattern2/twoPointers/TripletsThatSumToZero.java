package com.datastructures.gtci.pattern2.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
/*      Example 1:
        Input: [-3, 0, 1, 2, -1, 1, -2]
        Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
        Explanation: There are four unique triplets whose sum is equal to zero.

        Example 2:
        Input: [-5, 2, -1, -2, 3]
        Output: [[-5, 2, 3], [-2, -1, 3]]
        Explanation: There are two unique triplets whose sum is equal to zero.
        */

public class TripletsThatSumToZero {

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();

//        1. Sort the given array to follow the 2-pointer approach
        Arrays.sort(arr);

//        2. Iterate till length - 2
        for (int i = 0; i < arr.length - 2; i++) {

//        3. If this element is same as previous, skip it since we need unique triplets
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            int pivot = arr[i];
            int leftPointer = i + 1;
            int rightPointer = arr.length - 1;
            while (leftPointer < rightPointer) {
                int sum = pivot + arr[leftPointer] + arr[rightPointer];
                if (sum == 0) {
                    triplets.add(Arrays.asList(pivot, arr[leftPointer], arr[rightPointer]));

//         4. After adding this triplet, move both the pointers to record a new triplet
                    leftPointer++;
                    rightPointer--;
                } else if (sum > 0) {
                    rightPointer--;
                } else
                    // This implies pivot + arr[leftPointer] + arr[rightPointer] < 0
                    leftPointer++;
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        System.out.println(TripletsThatSumToZero.searchTriplets(new int[]{-3, -3, 0, 1, 2, -1, 1, -2}));
        System.out.println(TripletsThatSumToZero.searchTriplets(new int[]{-5, 2, -1, -2, 3}));
    }

}
