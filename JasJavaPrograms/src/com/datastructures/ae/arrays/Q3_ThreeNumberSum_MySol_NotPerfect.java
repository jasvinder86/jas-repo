package com.datastructures.ae.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Q3_ThreeNumberSum_MySol_NotPerfect {

    public static void main(String[] args) {
        List<Integer[]> outputList = Q3_ThreeNumberSum_MySol_NotPerfect.threeNumberSum(new int[]{6, 3, 4, 1, -2}, 8);
        for (Integer[] x : outputList) {
            for (int y: x){
                System.out.print(y);
            }

        }
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.

//find the inner target such that targetSum = innerTarget + a pair of 2 numbers - n1 and n2
//in the inner loop we'll find that pair

        List<Integer[]> resultList = new ArrayList<Integer[]>();
        Set<Integer> integerSet = new TreeSet<Integer>();
        for (int i = 0; i < array.length; i++) {
            int innerSum = targetSum - array[i];

            for (int j = 0; j < array.length; j++) {

//                avoid comparing a number to itself
                if (array[i] != array[j]) {
                    int n1 = array[j];
                    int n2 = innerSum - n1;
                    if (integerSet.contains(n2)) {
//                        System.out.println(array[i] + " " + n1 + " " + n2);
//                        Array of numbers adding upto the main target sum

//                        integerSet.add(n1);
//                        integerSet.add(n2);
//                        integerSet.add(array[i]);

                        Integer[] finalArray = new Integer[]{n1, n2, array[i]};

                        resultList.add(finalArray);
                    } else {
                        integerSet.add(n1);
                    }
                }
            }
        }
        return resultList;
//        return new ArrayList<Integer[]>();
    }
}

