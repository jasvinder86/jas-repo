package com.datastructures.gtci.pattern2.twoPointers;

/*
Given a string, s, return TRUE if it is a palindrome; otherwise, return FALSE.
A phrase is considered a palindrome if it reads the same backward as forward after converting all uppercase letters to lowercase
and removing any characters that are not letters or numbers. Only alphanumeric characters (letters and digits) are taken into account.
*/


public class ValidPalindrome {
    public static void main(String[] args) {

        System.out.println(ValidPalindrome.isPalindrome("A man, a plan, a canal: Panama")); // expected = true
        System.out.println(ValidPalindrome.isPalindrome("0P")); // expected = false
        System.out.println(ValidPalindrome.isPalindrome(".,")); // expected = true
        System.out.println(ValidPalindrome.isPalindrome(":::a----a;;;")); // expected = true
    }

    /*
     * The time complexity of the isPalindrome function using the Two Pointers pattern is O(N),
     * where N is the length of the input string s. This is because we only iterate through the string once
     *  using two pointers (left and right) that traverse the string simultaneously.
     * The built-in Java functions Character.isLetterOrDigit and Character.toLowerCase have constant time
     * complexity and do not affect the overall time complexity of the function.
     * */
    public static boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }

        int leftPointer = 0, rightPointer = s.length() - 1;

        while (leftPointer < rightPointer) {
            while (leftPointer < rightPointer && !Character.isLetterOrDigit(s.charAt(leftPointer))) {
                leftPointer++;
            }

            while (leftPointer < rightPointer && !Character.isLetterOrDigit(s.charAt(rightPointer))) {
                rightPointer--;
            }

            if (Character.toLowerCase(s.charAt(leftPointer)) != Character.toLowerCase(s.charAt(rightPointer))) {
                return false;
            }
            leftPointer++;
            rightPointer--;
        }
        return true;
    }
}
