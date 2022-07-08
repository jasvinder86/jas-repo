package com.datastructures.lc.nc.twopointers;

/*
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        if (i == j)
            return true;

        s = s.toLowerCase();
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i)))
                i++;

            else if (!Character.isLetterOrDigit(s.charAt(j)))
                j--;

            else if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama")); // expected = true
        System.out.println(validPalindrome.isPalindrome("0P")); // expected = false
        System.out.println(validPalindrome.isPalindrome(".,")); // expected = true
        System.out.println(validPalindrome.isPalindrome(":::a----a;;;")); // expected = true

    }

}
