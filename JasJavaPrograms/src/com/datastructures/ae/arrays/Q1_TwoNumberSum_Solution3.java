package com.datastructures.ae.arrays;

import java.util.Arrays;

public class Q1_TwoNumberSum_Solution3 {

    public static void main(String[] args) {

        int[] inputArray = new int[]{3, 5, -4, 8, 11, 1, -1, 6};

        Arrays.sort(inputArray);

        int[] output = Q1_TwoNumberSum_Solution3.twoNumberSum(inputArray, 11);
        for (int x : output) {
            System.out.println(x);
        }
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        int leftPtr = 0;
        int rightPtr = array.length - 1;

        while (leftPtr < rightPtr) {
            if (array[leftPtr] + array[rightPtr] == targetSum)
                return new int[]{array[leftPtr], array[rightPtr]};

            else if (array[leftPtr] + array[rightPtr] > targetSum)
                rightPtr--;

            else if (array[leftPtr] + array[rightPtr] < targetSum)
                leftPtr++;
        }
        return new int[0];
    }
}

// This solution first sorts the input array and then perform the sum check. Because of sorting in 'n log(n)' the entire program runs in n log(n)
// Q:1 I think the TC would be nlogn + n which is > nlogn
// Q:2 Revise space complexity
