package com.datastructures.gtci.pattern1.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithMaximumKDistinctCharacters {

    public int getLengthOfMaximumSubstring(String str, int k) {

        int windowStart = 0, windowEnd = 0, maxLength = 0;
        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        for (windowEnd = 0; windowEnd < str.length(); windowEnd++) {
//            1. Keep adding elements from the left of the String
            characterIntegerMap.put(str.charAt(windowEnd),
                    characterIntegerMap.getOrDefault(str.charAt(windowEnd), 0) + 1);

//            2. If k has been reached, reduce the window from the start i.e. remove elements from the start
            while (characterIntegerMap.keySet().size() > k) {
                characterIntegerMap.put(str.charAt(windowStart),
                        characterIntegerMap.get(str.charAt(windowStart)) - 1);
                if (characterIntegerMap.get(str.charAt(windowStart)) == 0) {
                    characterIntegerMap.remove(str.charAt(windowStart));
                }
//                3. Keep reducing the window
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithMaximumKDistinctCharacters substring = new LongestSubstringWithMaximumKDistinctCharacters();
        System.out.println(substring.getLengthOfMaximumSubstring("aaaabcde", 3));
        System.out.println(substring.getLengthOfMaximumSubstring("abcdd", 2));
        System.out.println(substring.getLengthOfMaximumSubstring("abcdd", 5));

    }

}