package com.datastructures.gtci.pattern1.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Longest Substring with Same Letters after Replacement
 *
 * Problem Statement:
 * Given a string with lowercase letters only, if you are allowed to replace no more than k letters with any letter,
 * find the length of the longest substring having the same letters after replacement.
 */
public class CharacterReplacement {

    public static int findLength(String str, int k) {
        int maxLength = 0, windowStart = 0, maxCharacterCount = 0;
        Map<Character, Integer> characterIntegerMap = new HashMap<>();

//        Not the best solution, runs in O(n^2)
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {

//            keep adding the upcoming chars to the map 1 by 1
            characterIntegerMap.put(str.charAt(windowEnd), characterIntegerMap.getOrDefault(str.charAt(windowEnd), 0) + 1);
            maxCharacterCount = Math.max(maxCharacterCount, characterIntegerMap.get(str.charAt(windowEnd)));

//            At any given instant, a window can have repeating and non-repeating characters. And if (size of that window) - (frequency of the maximum repeating character)
//            is <= k it means, we can replace the remaining characters with the same character as the maximum one. Else, we'll have to reduce the window size.
//            e.g. string = aabcd and k = 2, we can go max till aabc after which we'll get a new character in the window. So windowSize-frequency of max character
//            i.e. 4-2 <= k (2), so this combination is permitted and output will be 4.

            while (windowEnd - windowStart + 1 - maxCharacterCount > k) {
                characterIntegerMap.put(str.charAt(windowStart), characterIntegerMap.get(str.charAt(windowStart)) - 1);
                windowStart++;
            }
            maxLength = windowEnd - windowStart + 1;
        }
        return maxLength;
    }

    /* Easier and better solution*/
    public static int findLength_1(String s, int k) {
        int windowStart = 0, windowEnd = 0, maxLength = 0;

        Map<Character, Integer> map = new HashMap<>();
        int mostFrequentCharacterCount = 0;

        while (windowEnd < s.length()) {
            map.put(s.charAt(windowEnd), map.getOrDefault(s.charAt(windowEnd), 0) + 1);

            //  Keep track of count of the most frequent character
            mostFrequentCharacterCount = Math.max(mostFrequentCharacterCount, map.get(s.charAt(windowEnd)));

            if ((windowEnd - windowStart + 1) - mostFrequentCharacterCount > k) {
                map.put(s.charAt(windowStart), map.get(s.charAt(windowStart)) - 1);

                if (map.get(s.charAt(windowStart)) == 0) {
                    map.remove(s.charAt(windowStart));
                }
                windowStart++;
            }

            maxLength = Math.max(windowEnd - windowStart + 1, maxLength);
            windowEnd++;
        }
        return maxLength;
    }


    public static void main(String[] args) {
        System.out.println(CharacterReplacement.findLength("aabccbb", 2));  //expected output = 5
        System.out.println(CharacterReplacement.findLength("abbcb", 1));    //expected output = 4
        System.out.println(CharacterReplacement.findLength("abccde", 1));   //expected output = 3

        System.out.println(CharacterReplacement.findLength_1("aabccbb", 2));  //expected output = 5
        System.out.println(CharacterReplacement.findLength_1("abbcb", 1));    //expected output = 4
        System.out.println(CharacterReplacement.findLength_1("abccde", 1));   //expected output = 3
    }

}
