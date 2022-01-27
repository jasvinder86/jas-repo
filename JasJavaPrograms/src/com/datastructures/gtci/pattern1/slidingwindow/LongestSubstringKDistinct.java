package com.datastructures.gtci.pattern1.slidingwindow;

/*
 *Longest Substring with maximum K Distinct Characters (medium)
 *
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

    public static int findLength(String str, int k) {
        int lengthOfLongestSubstring = 0, windowStart = 0;
        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            characterIntegerMap.put(str.charAt(windowEnd), characterIntegerMap.getOrDefault(str.charAt(windowEnd), 0) + 1);
            while (characterIntegerMap.size() > k) {  // start the slider
                characterIntegerMap.put(str.charAt(windowStart), characterIntegerMap.get(str.charAt(windowStart)) - 1);
                if (characterIntegerMap.get(str.charAt(windowStart)) == 0) {
                    characterIntegerMap.remove(str.charAt(windowStart));
                }
                windowStart++;
            }
            lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, windowEnd - windowStart + 1);
        }
        return lengthOfLongestSubstring;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));    // expected output = 4 "araa"
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));    // expected output = 2 "aa"
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));    // expected output = 5 "cbbeb" and "bbebi"
    }

}
