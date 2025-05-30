package com.datastructures.gtci.pattern2.twoPointers;

/*
i/p = 101010
o/p = 000111
*/

public class ClassifyZeroAndOne {

    public static void main(String[] args) {
//        int[] nums = ClassifyZeroAndOne.sortZeroesAndOnes(new int[]{1, 0, 1});
        int[] nums = ClassifyZeroAndOne.sortZeroesAndOnes1(new int[]{1, 0, 1, 0});
        printTheClassifiedArray(nums);

        int[] nums1 = ClassifyZeroAndOne.sortZeroesAndOnes1(new int[]{0, 1, 0, 1});
        printTheClassifiedArray(nums1);

        int[] nums2 = ClassifyZeroAndOne.sortZeroesAndOnes1(new int[]{1, 0, 1, 1, 0, 1});
        printTheClassifiedArray(nums2);

        int[] nums3 = ClassifyZeroAndOne.sortZeroesAndOnes1(new int[]{1, 1, 1, 1, 1, 0, 0, 0, 0});
        printTheClassifiedArray(nums3);


    }

    public static void printTheClassifiedArray(int[] nums) {
        System.out.print("Elements are :: ");
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

    //    Gives wrong o/p
    public static int[] sortZeroesAndOnes(int[] nums) {
        if (nums.length <= 1) return nums;

        int lp = 0, rp = nums.length - 1;

        while (lp < rp) {
            if (nums[lp] < nums[rp]) {
                lp++;
                rp--;
            } else if (nums[lp] > nums[rp]) {
//                swap the lp and rp
                int temp = nums[lp];
                nums[rp] = nums[lp];
                nums[rp] = temp;
                lp++;
                rp--;
            } else {
//                if lp == rp
                lp++;
            }
        }

        return nums;
    }

    // Works well
    public static int[] sortZeroesAndOnes1(int[] nums) {
        int start = 0, end = nums.length - 1, current = 0;

        while (start < end) {
            if (nums[current] == 0) {
                start++;
                current++;
            } else { // it means current is 1, so move it to the end.
//                swap current with the end
                int temp = nums[end];
                nums[end] = nums[current];
                nums[current] = temp;
                end--;
            }
        }

        return nums;
    }


}
