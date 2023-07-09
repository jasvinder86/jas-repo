package com.datastructures.lc.nc.stacks;

import java.util.Stack;

// Merge two strings picking up alternate characters starting with the longer string.
//    String one = "abc123";
//    String two = "defghi9876";
//    expected output = 6372819cibhagfed

public class CombineTwoStrings {

    //        Approach1: traverse both the strings in the reverse order
    public String combineTheStrings(String one, String two) {
        StringBuffer tempString = new StringBuffer();

        int diff = Math.abs(one.length() - two.length());

        if (one.length() > two.length()) {
            for (int i = one.length() - 1; i > (one.length() - two.length()); i--) {
                tempString = tempString.append(one.charAt(i)).append(two.charAt(i - diff));
            }
        } else {
            for (int i = two.length() - 1; i > (two.length() - one.length()); i--) {
                tempString = tempString.append(two.charAt(i)).append(one.charAt(i - diff));
            }
        }

        if (one.length() > two.length()) {
            for (int i = one.length() - two.length(); i >= 0; i--) {
                tempString = tempString.append(one.charAt(i));
            }
        } else {

            for (int i = two.length() - one.length(); i >= 0; i--) {
                tempString = tempString.append(two.charAt(i));
            }

        }

        return String.valueOf(tempString);
    }

    //        Approach2: put both the strings into two stacks, start picking up from bigger stack and smaller stack alternatively
    public String combineTheStringsUsingStack(String one, String two) {
        StringBuffer tempString = new StringBuffer();

        Stack<Character> stackOne = new Stack<>();
        Stack<Character> stackTwo = new Stack<>();

        for (int i = 0; i < one.length(); i++) {
            stackOne.push(one.charAt(i));
        }

        for (int i = 0; i < two.length(); i++) {
            stackTwo.push(two.charAt(i));
        }

        if (one.length() > two.length()) {
            while (!stackOne.isEmpty() || !stackTwo.isEmpty()) {
                tempString.append(stackOne.pop());
                if (!stackTwo.isEmpty()) {
                    tempString.append(stackTwo.pop());
                }
            }
        } else {
            while (!stackTwo.isEmpty() || !stackOne.isEmpty()) {
                tempString.append(stackTwo.pop());
                if (!stackOne.isEmpty()) {
                    tempString.append(stackOne.pop());
                }
            }
        }
        return String.valueOf(tempString);
    }

    public static void main(String[] args) {
        CombineTwoStrings combineTwoStrings = new CombineTwoStrings();
        System.out.println("output string -- approach 1: " + combineTwoStrings.combineTheStrings("abc123", "defghi9876"));
        System.out.println("output string -- approach 1: " + combineTwoStrings.combineTheStrings("defghi9876", "abc123"));

        System.out.println("output string -- approach 2: " + combineTwoStrings.combineTheStringsUsingStack("abc1234", "defghi98765"));
        System.out.println("output string -- approach 2: " + combineTwoStrings.combineTheStringsUsingStack("defghi98765", "abc1234"));
    }

}
