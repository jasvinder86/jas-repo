package com.datastructures.gtci.pattern1.slidingwindow;

/*
Problem Statement
        Given an array of characters where each character represents a fruit tree,
        you are given two baskets, and your goal is to put maximum number of fruits in each basket.
        The only restriction is that each basket can have only one type of fruit.
        You can start with any tree, but you can't skip a tree once you have started.
        You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
        Write a function to return the maximum number of fruits in both baskets.
*/

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {

    public static int findLength(char[] arr) {
        int maxFruitCount = 0;
        int windowStart = 0;
        Map<Character, Integer> fruitMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            fruitMap.put(arr[windowEnd],
                    fruitMap.getOrDefault(arr[windowEnd], 0) + 1);

            while (fruitMap.size() > 2) {
                fruitMap.put(arr[windowStart],
                        fruitMap.get(arr[windowStart]) - 1);
                if (fruitMap.get(arr[windowStart]) == 0) {
                    fruitMap.remove(arr[windowStart]);
                }
                windowStart++;
            }
            maxFruitCount = Math.max(maxFruitCount, windowEnd - windowStart + 1);
        }
        return maxFruitCount;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));         // expected output = 3, {'C', 'A', 'C'}
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));    // expected output = 5, {'B', 'C', 'B', 'B', 'C'}
    }

}
