package com.datastructures.gtci.dp;

import java.util.HashMap;
import java.util.Map;

public class CanSumBeReached {

    int recursionCount = 0;
    int memoizationCount = 0;

    public boolean canSumWithRecursion(int[] inputArray, int desiredSum) {
        System.out.println("recursionCount : " + ++recursionCount);

//        Base Case 1: if desiredSum is 0, return true.
        if (desiredSum == 0)
            return true;

//        Base Case 2: if desiredSum is negative, return false.
        if (desiredSum < 0)
            return false;

        for (int i = 0; i < inputArray.length; i++) {
            int currentDifference = desiredSum - inputArray[i];

//            If the previous recursive call returns true, return true from here as well. This
//            will bubble up to the top without any further computation.

            if (canSumWithRecursion(inputArray, currentDifference) == true)
                return true;
        }

        return false;
//        TC = Since at max, a call goes till the height of tree (m), and no of calls are the number of branches i.e. length of the inputArray (n), TC = O(n*n*n*n*n*n*... m times) = O(n^m)
//        SC = O(m) since at max only m calls can be at the stack at any given instance
    }


    public boolean canSumWithMemoization(int[] inputArray, int desiredSum) {
        Map<Integer, Boolean> desiredSumMap = new HashMap<>();
        return canSumWithMemoizationImpl(inputArray, desiredSum, desiredSumMap);
    }


    public boolean canSumWithMemoizationImpl(int[] inputArray, int desiredSum, Map desiredSumMap) {
        System.out.println("memoizationCount : " + ++memoizationCount);

        if (desiredSumMap.containsKey(desiredSum))
            return (boolean) desiredSumMap.get(desiredSum);

//        Base Case 1: if desiredSum is 0, return true.
        if (desiredSum == 0)
            return true;

//        Base Case 2: if desiredSum is negative, return false.
        if (desiredSum < 0)
            return false;

        for (int i = 0; i < inputArray.length; i++) {
            int currentDifference = desiredSum - inputArray[i];

//            If the previous recursive call returns true, return true from here as well. This
//            will bubble up to the top without any further computation.

            if (canSumWithMemoizationImpl(inputArray, currentDifference, desiredSumMap) == true) {

                //            Implement memoization at the base cases. #1
                desiredSumMap.put(currentDifference, true);
                return true;
            }
        }

        //            Implement memoization at the base cases. #2
        desiredSumMap.put(desiredSum, false);
        return false;

//        TC = In the worst case if the sum is reduced by 1 => first call will go till the height of the
//        tree i.e. m + 1 (+1 for the call when the sum becomes 0). However, all subsequent calls will now
//        make use of the memo object or the map to get their corresponding output value.
//        Now since each input will call the memo object once, => TC = O(m*n)

//        SC = O(m) since at max only m calls can be at the stack at any given instance

    }

    public static void main(String[] args) {
        System.out.println(new CanSumBeReached().canSumWithMemoization(new int[]{1}, 3));            // false    //  memoizationCount : 9

        System.out.println(new CanSumBeReached().canSumWithMemoization(new int[]{7, 14}, 20));          // false    //  memoizationCount : 7
        System.out.println(new CanSumBeReached().canSumWithMemoization(new int[]{2, 4}, 7));            // false    //  memoizationCount : 9
//        System.out.println(new CanSumBeReached().canSumWithMemoization(new int[]{5, 3, 4, 7}, 7));      // true     //  memoizationCount : 14
//        System.out.println(new CanSumBeReached().canSumWithMemoization(new int[]{2, 3, 5}, 8));         // true     //  memoizationCount : 5
//        System.out.println(new CanSumBeReached().canSumWithMemoization(new int[]{7, 14}, 56));          // true    //  memoizationCount : 9
//        System.out.println(new CanSumBeReached().canSumWithMemoization(new int[]{7, 14}, 900));         // false    // memoizationCount : 259
//        System.out.println(new CanSumBeReached().canSumWithMemoization(new int[]{7, 14}, 903));         // true     //  memoizationCount : 130


        System.out.println(new CanSumBeReached().canSumWithRecursion(new int[]{7, 14}, 20));      // false   // recursionCount : 9
        System.out.println(new CanSumBeReached().canSumWithRecursion(new int[]{2, 4}, 7));      // false    // recursionCount : 15
//        System.out.println(new CanSumBeReached().canSumWithRecursion(new int[]{5, 3, 4, 7}, 7));// true     // recursionCount : 14
//        System.out.println(new CanSumBeReached().canSumWithRecursion(new int[]{2, 3, 5}, 8));   // true     // recursionCount : 5
//        System.out.println(new CanSumBeReached().canSumWithRecursion(new int[]{7, 14}, 56));    // true     // recursionCount : 9
//        System.out.println(new CanSumBeReached().canSumWithRecursion(new int[]{7, 14}, 900));   // false    // had to kill at recursionCount : 10753520
//        System.out.println(new CanSumBeReached().canSumWithRecursion(new int[]{7, 14}, 903));    // true   // recursionCount : 130
    }

}
