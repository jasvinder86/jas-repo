package com.datastructures.gtci.pattern2.twoPointers;

/*
 * Triplets with Smaller Sum
 *
 * Given an array arr of unsorted numbers and a target sum, count all triplets in it such that
 * arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices.
 * Write a function to return the count of such triplets.
 */

import java.util.Arrays;

public class TripletWithSmallerSum {
    public static int searchTriplets(int[] arr, int target) {
        int tripletCounter = 0;

//        1. First sort the array
        Arrays.sort(arr);

//        2. Keep the first index as pivot and keep increasing. Keep the right index at length-1 and the left index to traverse.
//        3. When left < right and pivot + left + right < Target, then sum of pivot, left and all numbers till right will be < target since right is the maximum number
//        4. Then increase the left pointer when all numbers at point 3 get exhausted

        for (int pivot = 0; pivot < arr.length - 2; pivot++) {
            int leftPointer = pivot + 1, rightPointer = arr.length - 1;

            while (leftPointer < rightPointer) {
                if (arr[pivot] + arr[leftPointer] + arr[rightPointer] < target) {
                    tripletCounter = tripletCounter + (rightPointer - leftPointer);
                    leftPointer++;
                } else
                    rightPointer--;
            }
        }
        return tripletCounter;
    }
}

// TC will be
// Sorting the array will take O(n*logn)
// for and while loops will take O(n^2)
// Overall O(n*logn + n^2) = O(n^2)
