package com.datastructures.gtci.pattern2.twoPointers;

import java.util.Stack;

/*
 * Comparing Strings containing Backspaces
 * Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
 */
public class BackspaceCompareUsingStack {

    public static boolean compare(String str1, String str2) {

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == '#' && !stack1.isEmpty()) {
                stack1.pop();
            } else {
                stack1.push(str1.charAt(i));
            }
        }

        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == '#' && !stack2.isEmpty()) {
                stack2.pop();
            } else {
                stack2.push(str2.charAt(i));
            }
        }

        while (!stack1.isEmpty()) {
            char c1 = stack1.pop();
            if (stack2.isEmpty() || stack2.pop() != c1) {
                return false;
            }
        }

        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(BackspaceCompareUsingStack.compare("xy#z", "xyz#"));
        System.out.println(BackspaceCompareUsingStack.compare("xy#z", "xzz#"));
        System.out.println(BackspaceCompareUsingStack.compare("xp#", "xyz##"));
        System.out.println(BackspaceCompareUsingStack.compare("xywrrmp", "xywrrmu#p"));
    }

}
