package com.datastructures.gtci.dp;

/*
 * Leetcode 516
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 *
 * Given a string s, find the longest palindromic subsequence's length in s.
 * A subsequence is a sequence that can be derived from another sequence by
 * deleting some or no elements without changing the order of the remaining elements.
 * */

public class LongestPalindromeSubsequence {

//    This has been implemented as a variation of https://leetcode.com/problems/longest-common-subsequence/
//    (which has been implemented at com/datastructures/gtci/dp/LongestCommonSubsequence.java)
//    by passing the reverse of the input string as the second input.
//    This is not the same as Tushar Roy's implementation.

    public int longestPalindromeSubseq(String s) {

        StringBuilder revStr = new StringBuilder(s);
        String rev = revStr.reverse().toString();

        int[][] dp = new int[s.length() + 1][s.length() + 1];

//         Traverse each row and find out if a char[row][col] of text1 matches that from text2
        for (int row = 1; row <= s.length(); row++) {

            for (int col = 1; col <= s.length(); col++) {

                if (s.charAt(row - 1) == rev.charAt(col - 1)) {     // char matches in the two strings
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                } else {
                    dp[row][col] = Math.max(dp[row][col - 1], dp[row - 1][col]);
                }

            }
        }
        return dp[s.length()][rev.length()];
    }

    public static void main(String[] args) {
        LongestPalindromeSubsequence longestPalindromeSubsequence = new LongestPalindromeSubsequence();
        System.out.println(longestPalindromeSubsequence.longestPalindromeSubseq("bbbab"));  // expected = 4, actual =4
        System.out.println(longestPalindromeSubsequence.longestPalindromeSubseq("agbdba"));  // expected = 5, actual =5
    }
}
