package com.datastructures.ae.arrays;

public class Q8_LongestPeak {

    public static void main(String[] args) {
        System.out.println(Q8_LongestPeak.longestPeak(new int[]{1, 2, 3, 1}));
        System.out.println(Q8_LongestPeak.longestPeak(new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3}));
        System.out.println(Q8_LongestPeak.longestPeak(new int[]{1, 3, 2, -1, 0, 10, 4, 6, 5}));
        System.out.println(Q8_LongestPeak.longestPeak(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));


    }

//    1. Find a probable peak by iterating the array
//    2. Compare peak with numbers on the LHS and RHS
//    3. Because of nested loops, TC = O(n^2)
//    4. SC = O(1)


    public static int longestPeak(int[] array) {

        int longestPeak = 0;
        int traversals = 0;

        if (array.length <= 2)
            return 0;

        for (int pointer = 0; pointer < array.length; pointer++) {

            traversals++;

            int countOnLeft = 0, countOnRight = 0;
            int currentPeak = 0;
            int localLongestPeak = 0;
            if ((pointer + 2) < array.length && array[pointer + 1] > array[pointer] && array[pointer + 1] > array[pointer + 2]) {
                currentPeak = array[pointer + 1];
                int rightPointer;
                for (int leftPointer = pointer + 1; leftPointer > 0; leftPointer--) {
                    if (currentPeak > array[leftPointer - 1] && array[leftPointer] > array[leftPointer - 1]) {

                        countOnLeft++;
                        traversals++;
                    } else
                        break;
                }

                for (rightPointer = pointer + 1; rightPointer < array.length - 1; rightPointer++) {
                    if (currentPeak > array[rightPointer + 1] && array[rightPointer] > array[rightPointer + 1]) {
                        countOnRight++;
                        traversals++;

                    } else {
                        break;
                    }

                }

//                Since the right pointer is the end of a peak, it can't be a part of the next peak since the order so far was decreasing.
//                Hence the next peak should, if exists, start from current+1 th element.
//                This could have been implemented by making the currentPointer as the peak's last pointer+1.
//                pointer = rightPointer;
//                But this is going incorrect output for the input #2. Debug later

                localLongestPeak = countOnLeft + countOnRight + 1;
                if (localLongestPeak > longestPeak) {
                    longestPeak = localLongestPeak;
                }




            }


        }
        System.out.println("traversal count is " + traversals);
        return longestPeak;

    }

}