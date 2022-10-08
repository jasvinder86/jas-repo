package com.datastructures.gtci.dp;

/*
 * https://leetcode.com/problems/longest-common-subsequence/
 * Leetcode 1143
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 * A subsequence of a string is a new string generated from the original string with some
 * characters (can be none) deleted without changing the relative order of the remaining characters.
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * */

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

//         Traverse each row and find out if a char[row][col] of text1 matches that from text2
        for (int row = 1; row <= text1.length(); row++) {

            for (int col = 1; col <= text2.length(); col++) {

                if (text1.charAt(row - 1) == text2.charAt(col - 1)) {     // char matches in the two strings
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                } else {
                    dp[row][col] = Math.max(dp[row][col - 1], dp[row - 1][col]);
                }

            }
        }

        return dp[text1.length()][text2.length()];

    }

    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abc", "abcd")); // exp = 3, actual = 3
    }
}
