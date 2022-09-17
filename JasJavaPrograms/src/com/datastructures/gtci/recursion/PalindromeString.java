package com.datastructures.gtci.recursion;

public class PalindromeString {
    public static boolean isPalindrome(String text) {

//        Base case that covers strings of both odd and even lengths
        if (text.length() == 0 || text.length() == 1)
            return true;

        if (text.charAt(0) == text.charAt(text.length() - 1))
            return isPalindrome(text.substring(1, text.length() - 1));

        return false;
    }

    public static void main(String[] args) {
        System.out.println(PalindromeString.isPalindrome("ABCBA"));
        System.out.println(PalindromeString.isPalindrome("nitin"));
        System.out.println(PalindromeString.isPalindrome("Nini"));
        System.out.println(PalindromeString.isPalindrome("ABCBAA"));
    }
}
