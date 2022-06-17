package com.datastructures.lc.nc.arraysandhashing;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

//         1. Take the first string, sort it and add it as key in a
        // HashMap<String, List<String>> if it is not already present
//         2. Add the original string as a value against this key in the HashMap
//         3. Finally all the mapValues constitute the output.

//         output is a list of list of Strings
        List<List<String>> finalList = new ArrayList<>();

        List<String> stringList = new ArrayList<>();

        Map<String, List<String>> mapOfStrings = new HashMap<>();
        // List<String> mapValueList = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {

            String inputString = strs[i];
//             sort this string and insert it in the map as a key, if its not already present
            char[] strArray = inputString.toCharArray();
            Arrays.sort(strArray); // this is still a char array, so convert it back to a string

            String key = String.valueOf(strArray);

            if (!mapOfStrings.containsKey(key)) {
                List<String> listOfString = new ArrayList<>();
                listOfString.add(inputString);
                mapOfStrings.put(key, listOfString);
            } else {

//                 get the existing String list against this key
                stringList = mapOfStrings.get(key);
                stringList.add(inputString);
                mapOfStrings.put(key, stringList);
            }
        }
//         get all the values from the map and insert into a list which will be the output
        return new ArrayList<>(mapOfStrings.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}

