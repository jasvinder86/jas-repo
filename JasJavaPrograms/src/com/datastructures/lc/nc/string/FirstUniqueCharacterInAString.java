package com.datastructures.lc.nc.string;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public static int firstUniqChar(String s) {

        Map<Character, Integer> map = new HashMap<>();

//        populates the map with all the characters in the string
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(FirstUniqueCharacterInAString.firstUniqChar("loveleetcode"));
    }
}
