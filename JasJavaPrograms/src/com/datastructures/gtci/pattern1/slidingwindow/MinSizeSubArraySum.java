package com.datastructures.gtci.pattern1.slidingwindow;

/*
 * Given an array of positive numbers and a positive number ‘S’,
 * find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
 * Return 0 if no such subarray exists.
 */
public class MinSizeSubArraySum {

    public static int findMinSubArray(int S, int[] arr) {
        int minimumLength = Integer.MAX_VALUE;
        int windowStart = 0;
        int windowSum = 0;


        int counter = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // keep adding to window sum
            counter++;
            while (windowSum >= S) { // current window meets the condition
                minimumLength = Math.min(minimumLength, counter);
                windowSum -= arr[windowStart];
                counter--;
                windowStart++;
            }
        }
        return minimumLength;
    }

    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2});
        System.out.println("Smallest subarray length: " + result);      // output = 2
        result = MinSizeSubArraySum.findMinSubArray(7, new int[]{2, 1, 5, 2, 8});
        System.out.println("Smallest subarray length: " + result);      // output = 1
        result = MinSizeSubArraySum.findMinSubArray(8, new int[]{3, 4, 1, 1, 6});
        System.out.println("Smallest subarray length: " + result);      // output = 3
    }

}
