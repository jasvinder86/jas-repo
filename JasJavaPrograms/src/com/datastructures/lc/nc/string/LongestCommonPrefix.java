package com.datastructures.lc.nc.string;

/*
 * 14. Longest Common Prefix https://leetcode.com/problems/longest-common-prefix/
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * */

import java.util.Arrays;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
//    1. sort the entire strs array to the get the smallest string at the beginning and the largest at the last.
        Arrays.sort(strs);
        String str1 = strs[0];
        String strLast = strs[strs.length - 1];
        StringBuffer output = new StringBuffer();

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == strLast.charAt(i))
                output.append(str1.charAt(i));
            else
                break;
        }
        return output.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flowery"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"a", "b", "c"}));
    }
}
