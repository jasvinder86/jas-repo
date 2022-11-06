package com.datastructures.gtci.pattern11.bitwise.xor;

/*
 * Given two strings, find the index of the extra character that is present in only one of the strings.
 * */
public class FindTheExtraCharacterInTwoStrings {

    public static int extraCharacterIndex(String str1, String str2) {
        int result = 0;

        // Get the XOR of str1 with 0.
        for (char currentChar : str1.toCharArray()) {
            result = result ^ currentChar; // gives xor of entire str1
        }

        // Now get XOR of the above result with str2
        for (char currentChar : str2.toCharArray()) {
            result = result ^ currentChar; // gives xor of entire str2
        }

        // Now result will be left with the ascii value of the extra char
        char extraChar = (char) result;

//        get the index of the extra char
        if (str1.length() > str2.length()) {
            for (int i = 0; i < str1.length(); i++) {
                if (extraChar == str1.charAt(i))
                    return i;
            }
        } else {
            for (int i = 0; i < str2.length(); i++) {
                if (extraChar == str2.charAt(i))
                    return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("The extra character is at index " + FindTheExtraCharacterInTwoStrings.extraCharacterIndex("hello", "helo"));  // Expected = 1; Actual = 1
        System.out.println("The extra character is at index " + FindTheExtraCharacterInTwoStrings.extraCharacterIndex("a", "ab"));  // Expected = 1; Actual = 1
        System.out.println("The extra character is at index " + FindTheExtraCharacterInTwoStrings.extraCharacterIndex("abcdef", "abcdefg")); // Expected = 7; Actual = 7
        System.out.println("The extra character is at index " + FindTheExtraCharacterInTwoStrings.extraCharacterIndex("mango", "goam")); // Expected = 2; Actual = 2
    }
}
