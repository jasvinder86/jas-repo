package com.datastructures.gtci.pattern1.slidingwindow;

/*
 * Longest Subarray with Ones after Replacement
 *
 * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
 * find the length of the longest contiguous subarray having all 1s.
 * */

public class ReplacingOnes {
    public static int findLength_Approach1(int[] arr, int k) {

        int leftIndex = 0, countOf1s = 0, countOf0s = 0, longestArrayLength = 0;

        for (int rightIndex = 0; rightIndex < arr.length; rightIndex++) {
            if (arr[rightIndex] == 1) {
                countOf1s++;
            }
            countOf0s = rightIndex - leftIndex + 1 - countOf1s;
            while (countOf0s > k) {
                if (arr[leftIndex] == 0) {
                    countOf0s--;
                } else {
                    countOf1s--;
                }
                leftIndex++;
                countOf0s = rightIndex - leftIndex + 1 - countOf1s;
            }
//            longestArrayLength = Math.max(longestArrayLength, rightIndex - leftIndex + 1);
            longestArrayLength = Math.max(longestArrayLength, countOf0s + countOf1s);
        }
        return longestArrayLength;
    }

    public static int findLength_Approach2(int[] arr, int k) {
        int countOf1s = 0, windowStart = 0, maxLength = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 1) {
                countOf1s++;
            }

//            we can have a maximum window of all 1s and a maximum of k 0s beyond which
//            the window has to be shrunk
            if (windowEnd - windowStart + 1 - countOf1s > k) { // that is if count of 0s > k
                if (arr[windowStart] == 1) {
                    countOf1s--;
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }


    public static void main(String[] args) {
        System.out.println(ReplacingOnes.findLength_Approach1(new int[]{0, 0, 0, 1, 0, 1}, 2));
        System.out.println(ReplacingOnes.findLength_Approach1(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
        System.out.println(ReplacingOnes.findLength_Approach1(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));

        System.out.println(ReplacingOnes.findLength_Approach2(new int[]{0, 0, 0, 1, 0, 1}, 2));
        System.out.println(ReplacingOnes.findLength_Approach2(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
        System.out.println(ReplacingOnes.findLength_Approach2(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
    }
}
