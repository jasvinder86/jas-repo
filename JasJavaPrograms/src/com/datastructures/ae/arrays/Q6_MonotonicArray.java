package com.datastructures.ae.arrays;

public class Q6_MonotonicArray {

    public static void main(String[] args) {
        System.out.println(Q6_MonotonicArray.isMonotonic(new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001}));
        System.out.println(Q6_MonotonicArray.isMonotonic(new int[]{1, 5, -10, 1100, -1100, 1101, -1102, 9001}));
        System.out.println(Q6_MonotonicArray.isMonotonic(new int[]{1, 5, 10, 1100, 1100, 1101, 1102, 9001}));
        System.out.println(Q6_MonotonicArray.isMonotonic(new int[]{1}));
        System.out.println(Q6_MonotonicArray.isMonotonic(new int[]{}));

    }

//    Array is monotonic if its always increasing or always decreasing (0 difference also holds good in either case)
//    [-1, -5, -10, -1100, -1100, -1101, -1102, -9001]  => true

    public static boolean isMonotonic(int[] array) {

        int leftPointer = 0, rightPointer = 1;
        int countNegatives = 0, countPositives = 0, countZeros = 0;

        if (array.length<1)
            return true;

//        find diff b/w nth and n+1 th element of array.
//        if (countPositives + countZeros) OR (countNegatives + countZeros) == length-1 => array is monotonic else not
        while (rightPointer < array.length) {
            if (array[rightPointer] - array[leftPointer] == 0)
                countZeros++;
            else if (array[rightPointer] - array[leftPointer] > 0)
                countPositives++;
            else
                countNegatives++;

            leftPointer++;
            rightPointer++;
        }

        if (countNegatives + countZeros == array.length - 1 || countPositives + countZeros == array.length - 1)
            return true;

        return false;
    }

}
