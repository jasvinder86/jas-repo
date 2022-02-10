package com.datastructures.gtci.pattern2.twoPointers;

/*
 * Comparing Strings containing Backspaces
 * Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
 */
public class BackspaceCompare {

    public static boolean compare(String str1, String str2) {

        if (getValidString(str1).equals(getValidString(str2)))
            return true;

        return false;
    }

    public static String getValidString(String str) {
        int backspaceCount = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '#') {
                backspaceCount++;
            } else if (backspaceCount > 0) {
                backspaceCount--;
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(BackspaceCompare.compare("xy#z", "xyz#"));
        System.out.println(BackspaceCompare.compare("xy#z", "xzz#"));
        System.out.println(BackspaceCompare.compare("xp#", "xyz##"));
        System.out.println(BackspaceCompare.compare("xywrrmp", "xywrrmu#p"));
    }
}
