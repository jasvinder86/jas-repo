package com.datastructures.gtci.pattern11.bitwise.xor;

public class MissingNumber {

    /*
     * LeetCode #268 https://leetcode.com/problems/missing-number/description/
     * Given an array nums containing n distinct numbers in the range [0, n],
     * return the only number in the range that is missing from the array.
     * */
    public static int missingNumber(int[] nums) {
        int result = 0;

//        1. Get the XOR of all the numbers from 0 to length+1 of nums (+1 since 1 number is less in the input array).
        for (int i = 0; i < nums.length + 1; i++) {
            result ^= i;
        }

//        2. Now XOR the result with the input array's elements
        for (int x : nums) {
            result ^= x;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(MissingNumber.missingNumber(new int[]{3, 0, 1}));
        System.out.println(MissingNumber.missingNumber(new int[]{1, 0, 2, 5, 4}));
    }
}

