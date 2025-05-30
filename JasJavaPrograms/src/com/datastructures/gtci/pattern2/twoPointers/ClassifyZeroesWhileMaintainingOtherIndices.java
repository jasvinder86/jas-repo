package com.datastructures.gtci.pattern2.twoPointers;

public class ClassifyZeroesWhileMaintainingOtherIndices {

    /*Move all the zeroes at the end while also maintaining the order of the other digits*/

//        {1,4,5,0,5,0,5,0} -> {1,4,5,5,5,0,0,0}
//        {1,0,1} --> {1,1,0}
//        {1,1,1} -> {1,1,1}
//        {0,0} -> as it is
//        {0,0,1}  -> {1,0,0}
//        1 1 0 2 3 -> 11230

    public static void main(String[] args) {

        printTheClassifiedArray(classifyZeroes(new int[]{1, 4, 5, 0, 5, 0, 5, 0})); //14555000
        printTheClassifiedArray(classifyZeroes(new int[]{1, 0, 0, 1})); //1100
        printTheClassifiedArray(classifyZeroes(new int[]{1, 0, 0, 0})); //1000
        printTheClassifiedArray(classifyZeroes(new int[]{0, 0, 1, 1})); //1100
        printTheClassifiedArray(classifyZeroes(new int[]{0, 0, 0, 0, 0, 0, 1, 4, 5, 0, 5, 0, 5, 0, 1, 1, 1, 1})); //145551111000000000
        printTheClassifiedArray(classifyZeroes(new int[]{1, 1, 0, 4, 5})); //11450


    }

    public static int[] classifyZeroes(int[] nums) {
        int leftPointer = 0, rightPointer = nums.length - 1, center = leftPointer + 1;
        while (center <= rightPointer) {
            if (nums[leftPointer] == 0 && nums[center] != 0) {
//                swap l and c
                int temp = nums[center];
                nums[center] = nums[leftPointer];
                nums[leftPointer] = temp;
                leftPointer++;
                center++;
            } else if (nums[leftPointer] == 0 && nums[center] == 0) {
                center++;
            } else {
                leftPointer++;
                center++;
            }
        }
        return nums;
    }

    public static void printTheClassifiedArray(int[] output) {
        for (int i : output) {
            System.out.print(i);
        }
        System.out.println();
    }
}