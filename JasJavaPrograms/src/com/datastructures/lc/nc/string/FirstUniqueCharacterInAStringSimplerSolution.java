package com.datastructures.lc.nc.string;

public class FirstUniqueCharacterInAStringSimplerSolution {
    public static int firstUniqChar(String s) {

        for (char ch : s.toCharArray()) {
            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                return s.indexOf(ch);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(FirstUniqueCharacterInAStringSimplerSolution.firstUniqChar("loveleetcode"));
    }
}
