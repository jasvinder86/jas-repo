package com.datastructures.ae.arrays;

public class Q1_TwoNumberSum_Solution1 {

    public static void main(String[] args) {
        int[] output = Q1_TwoNumberSum_Solution1.twoNumberSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10, -9}, 1);
        for (int x : output) {
            System.out.println(x);
        }

    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == targetSum) {
//                    int[] resultArray = new int[2];
//                    resultArray[0] = array[i];
//                    resultArray[1] = array[j];
//
//                    return resultArray;
                    return new int[]{array[i], array[j]};
                }
            }
        }
        return new int[0];
    }
}

// Although this solution works, it has n^2 time complexity and I am still figuring out how to calculate the space complexity
// Two for loops cause the n^2 TComp.