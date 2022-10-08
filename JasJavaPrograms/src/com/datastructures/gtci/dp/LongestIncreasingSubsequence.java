package com.datastructures.gtci.dp;

/*
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * Leetcode 300
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

//         initialize the dp array with initial value of 1
        for (int i = 0; i < dp.length; i++)
            dp[i] = 1;

        for (int i = 1; i < nums.length; i++) {
            int j = 0;

            while (j < i) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                j++;
            }
        }

        int maxLength = 0;
        for (int i = 0; i < dp.length; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));    // expected = 4, actual =4
    }
}
