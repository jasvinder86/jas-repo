package com.datastructures.gtci.pattern2.twoPointers;

/*
Problem Statement #
Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.

        Input: [1, 2, 3, 4, 6], target=6
        Output: [1, 3]
        Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6

        Input: [2, 5, 9, 11], target=11
        Output: [0, 2]
        Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
*/


public class PairWithTargetSum {

    public int[] searchThePair(int[] arr, int targetSum) {

        int leftPointer = 0, rightPointer = arr.length - 1;
        while (leftPointer < rightPointer) {
            if (arr[leftPointer] + arr[rightPointer] == targetSum) {
                return new int[]{leftPointer, rightPointer};
            } else if (arr[leftPointer] + arr[rightPointer] > targetSum) {
                rightPointer--;
            } else {
                leftPointer++;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        PairWithTargetSum pairWithTargetSum = new PairWithTargetSum();
        int[] outputArray = pairWithTargetSum.searchThePair(new int[]{1, 2, 3, 4, 6}, 6);
        System.out.println("Array indices are " + outputArray[0] + " and " + outputArray[1]);
        outputArray = pairWithTargetSum.searchThePair(new int[]{2, 5, 9, 11}, 11);
        System.out.println("Array indices are " + outputArray[0] + " and " + outputArray[1]);

    }

}
