package com.datastructures.gtci.pattern11.bitwise.xor;

/*
 * LeetCode #136 https://leetcode.com/problems/single-number/
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        // Since all numbers are repeating, XOR with itself will make the number that appears twice, zero.
        // We'll be left with the only single occurrence number.

        int result = 0;

        for (int i : nums) {
            result ^= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(SingleNumber.singleNumber(new int[]{2, 2, 1}));  //Expected = 1, Actual = 1
        System.out.println(SingleNumber.singleNumber(new int[]{4, 1, 2, 1, 2}));    //Expected = 4, Actual = 4
    }
}
