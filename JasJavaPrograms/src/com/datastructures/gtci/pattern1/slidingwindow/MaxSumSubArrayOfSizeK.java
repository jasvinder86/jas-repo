package com.datastructures.gtci.pattern1.slidingwindow;

/*
Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
 */

public class MaxSumSubArrayOfSizeK {

    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = 0;
        int windowSum = 0, windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // keep adding until the window size is reached

            if (windowEnd >= k - 1) { // start the slider when window size reaches the desired window length
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart]; // subtract the first element of the current window since in the next iteration, the incoming element will be added
                windowStart++; // slider for the start of the window
            }

        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}));    // output = 9
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5}));       // output = 7
    }
}
