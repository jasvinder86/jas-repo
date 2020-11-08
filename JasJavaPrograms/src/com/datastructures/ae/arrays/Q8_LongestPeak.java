package com.datastructures.ae.arrays;

public class Q8_LongestPeak {

    public static void main(String[] args) {
        System.out.println(Q8_LongestPeak.longestPeak(new int[]{1, 2, 3, 1}));
        System.out.println(Q8_LongestPeak.longestPeak(new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3}));

    }

//    1. Find a probable peak by iterating the array
//    2. Compare peak with numbers on the LHS and RHS
//    3. Because of nested loops, TC = O(n^2)
//    4. SC = O(1)


    public static int longestPeak(int[] array) {

        int longestPeak = 0;

        if (array.length <= 2)
            return 0;

        for (int pointer = 0; pointer < array.length; pointer++) {

            int countOnLeft = 0, countOnRight = 0;
            int currentPeak = 0;
            int localLongestPeak = 0;
            if ((pointer + 2) < array.length && array[pointer + 1] > array[pointer] && array[pointer + 1] > array[pointer + 2]) {
                currentPeak = array[pointer + 1];

                for (int leftPointer = pointer + 1; leftPointer > 0; leftPointer--) {
                    if (currentPeak > array[leftPointer - 1] && array[leftPointer] > array[leftPointer - 1])
                        countOnLeft++;
                    else
                        break;
                }

                for (int rightPointer = pointer + 1; rightPointer < array.length - 1; rightPointer++) {
                    if (currentPeak > array[rightPointer + 1] && array[rightPointer] > array[rightPointer + 1])
                        countOnRight++;
                    else break;

                }
                localLongestPeak = countOnLeft + countOnRight + 1;
                if (localLongestPeak > longestPeak)
                    longestPeak = localLongestPeak;
            }


        }
        return longestPeak;

    }

}