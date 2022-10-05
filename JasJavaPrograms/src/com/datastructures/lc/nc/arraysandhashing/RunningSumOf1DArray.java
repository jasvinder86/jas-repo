package com.datastructures.lc.nc.arraysandhashing;

public class RunningSumOf1DArray {
    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        int output[] = RunningSumOf1DArray.runningSum(new int[]{4, 3, 2, 1});
        for (int i : output) {
            System.out.print(i + " ");
        }
    }
}
