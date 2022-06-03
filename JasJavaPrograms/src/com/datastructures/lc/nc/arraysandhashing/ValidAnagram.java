package com.datastructures.lc.nc.arraysandhashing;

import java.util.*;

/*
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

//         Approach 1: Add both strings in maps. Compare the entry set and key set, if same, the Strings are anagrams of each other
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();


//         Error Case= if lengths don't match return false;
        if (s.length() - t.length() != 0)
            return false;

        for (int i = 0; i < s.length(); i++) {
            if (map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), map1.get(s.charAt(i)) + 1);
            } else {
                map1.put(s.charAt(i), 1);
            }

        }

        for (int i = 0; i < t.length(); i++) {
            if (map2.containsKey(t.charAt(i))) {
                map2.put(t.charAt(i), map2.get(t.charAt(i)) + 1);
            } else {
                map2.put(t.charAt(i), 1);
            }
        }

        if (map1.equals(map2))
            return true;

        return false;

    }

    public boolean isAnagram1(String s, String t) {

        //         Approach 2 - Create an arrayList for each of the given strings.
        //         Traverse over list1 and keep removing the current element from the list2.
        //         At the end, list2 will have 0 entries.

//         Error case
        if (s.length() - t.length() != 0)
            return false;

//         1. Convert both the strings into arrayList

        List<Character> sList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            sList.add(c);
        }

        List<Character> tList = new ArrayList<>();
        for (char c : t.toCharArray()) {
            tList.add(c);
        }

        for (char c : sList) {
            try {
                tList.remove(tList.indexOf(c));
            } catch (Exception e) {
                return false;
            }
        }

        return tList.size() == 0;

    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram1("aacc", "ccac"));             // expected = false

        System.out.println(validAnagram.isAnagram("aacc", "ccac"));             // expected = false
        System.out.println(validAnagram.isAnagram("Tubelight", "aaa"));         // expected = false
        System.out.println(validAnagram.isAnagram("Tubelight", "lightTube"));   // expected = true
        System.out.println(validAnagram.isAnagram("Tubelight", "lighttube"));   // expected = false
        System.out.println(validAnagram.isAnagram("Tubeligh", "lightube"));   // expected = false, since T != t


    }
}
