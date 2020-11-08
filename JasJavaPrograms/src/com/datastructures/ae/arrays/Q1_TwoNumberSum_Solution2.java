package com.datastructures.ae.arrays;

import java.util.HashSet;
import java.util.Set;

public class Q1_TwoNumberSum_Solution2 {

    public static void main(String[] args) {
        int[] output = Q1_TwoNumberSum_Solution2.twoNumberSum(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 4);
        for (int x : output) {
            System.out.println(x);
        }
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        int secondNumber;
        Set<Integer> numberSet = new HashSet<Integer>();
        for (int i = 0; i < array.length; i++) {
            secondNumber = targetSum - array[i];
            if (!numberSet.contains(secondNumber))
                numberSet.add(array[i]);
            else
                return new int[]{secondNumber, array[i]};
        }
        return new int[0];
    }
}

