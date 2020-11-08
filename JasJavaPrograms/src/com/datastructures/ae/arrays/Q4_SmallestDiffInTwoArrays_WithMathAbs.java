package com.datastructures.ae.arrays;

import java.util.Arrays;

public class Q4_SmallestDiffInTwoArrays_WithMathAbs {

    public static void main(String[] args) {
        int[] output = Q4_SmallestDiffInTwoArrays_WithMathAbs.smallestDifference(new int[]{-1, 5, 10, 20, 28, 3}, new int[]{26, 134, 135, 15, 17});
        for(int x: output)
            System.out.println(x);
    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int leastDiff = Math.abs(arrayOne[0] - arrayTwo[0]);

        int i = 0, j = 0;

        int[] outputArray = new int[2];

        while (i < arrayOne.length && j < arrayTwo.length) {

            int newDiff = Math.abs(arrayOne[i] - arrayTwo[j]);

            if (newDiff == 0) {
                return new int[]{arrayOne[i], arrayTwo[j]};
            } else {
                if (leastDiff >= newDiff) {
                    leastDiff = newDiff;
                    outputArray[0] = arrayOne[i];
                    outputArray[1] = arrayTwo[j];
                }

                if (arrayOne[i] > arrayTwo[j]) {
                    j++;
                } else {
                    i++;
                }
            }
        }

        return outputArray;
//        return new int[]{};
    }


}
