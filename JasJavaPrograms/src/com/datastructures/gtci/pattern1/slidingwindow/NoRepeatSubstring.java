package com.datastructures.gtci.pattern1.slidingwindow;

/*
 * Given a string, find the length of the longest substring, which has all distinct characters
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NoRepeatSubstring {


    //    Not the best approach since this solution runs in O(n^2)
    public static int findLength(String str) {
        int lengthOfLongestSubstring = 0;
        int windowStart = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {

            while (charMap.containsKey(str.charAt(windowEnd))) {
//                start the slider
                charMap.put(str.charAt(windowStart), charMap.get(str.charAt(windowStart)) - 1);
                if (charMap.get(str.charAt(windowStart)) == 0) {
                    charMap.remove(str.charAt(windowStart));
                }
                windowStart++;
            }

            charMap.put(str.charAt(windowEnd), charMap.getOrDefault(windowEnd, 0) + 1);
            lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, windowEnd - windowStart + 1);
        }
        return lengthOfLongestSubstring;
    }

    //    Better solution in O(n) TC
    public static int findLength_1(String str) {

        int right = 0;
        int left = 0;
        int maxLength = 0;

        Set<Character> set = new HashSet<>();

        while (right < str.length()) {

            if (!set.contains(str.charAt(right))) {
                set.add(str.charAt(right));
                maxLength = Math.max(maxLength, set.size());
                right++;
            } else {
                set.remove(str.charAt(left));
                left++;
            }

        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));  // expected output = 3 (abc)
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));    // expected output = 2 (ab)
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));   // expected output = 3 (abc, cde)
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccdef"));   // expected output = 4 (cdef)


        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength_1("aabccbb"));  // expected output = 3 (abc)
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength_1("abbbb"));    // expected output = 2 (ab)
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength_1("abccde"));   // expected output = 3 (abc, cde)
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength_1("abccdef"));   // expected output = 4 (cdef)

    }
}
