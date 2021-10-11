package com.datastructures.ae.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3_ThreeNumberSum_SolWithPtrs {

    public static void main(String[] args) {
        List<Integer[]> outputList = Q3_ThreeNumberSum_SolWithPtrs.threeNumberSum(new int[]{6, 3, 4, 1, -2}, 8);
        for (Integer[] x : outputList) {
            for (int y : x) {
                System.out.print(y);
            }
            System.out.println();
        }
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {

        Arrays.sort(array);

        List<Integer[]> resultList = new ArrayList<Integer[]>();
        for (int outerPointer = 0; outerPointer < array.length; outerPointer++) {

            int leftPointer = outerPointer + 1;
            int rightPointer = array.length - 1;
            while (leftPointer < rightPointer) {
                if (array[outerPointer] + array[leftPointer] + array[rightPointer] > targetSum) {
                    rightPointer--;
                } else if (array[outerPointer] + array[leftPointer] + array[rightPointer] < targetSum) {
                    leftPointer++;
                } else if (array[outerPointer] + array[leftPointer] + array[rightPointer] == targetSum) {
                    resultList.add(new Integer[]{array[outerPointer], array[leftPointer], array[rightPointer]});
                    leftPointer++;
                }
            }
        }
        return resultList;
    }
}

