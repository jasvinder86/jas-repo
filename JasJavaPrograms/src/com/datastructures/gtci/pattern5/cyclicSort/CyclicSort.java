package com.datastructures.gtci.pattern5;

public class CyclicSort {

    public static void sort(int[] nums) {

//        Using a for and a while
        /*
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - 1 != i) {
                int j = nums[i];
                int temp = nums[j - 1];
                nums[i] = temp;
                nums[j - 1] = j;
            }
        }
        */

//        Using just a single while loop
//        Worst Case Scenario can be a reversed list like 6 5 4 3 2 1
//        1. Verify if index 1 == position 1, else swap
//        2. If above is true, index++ till < length
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[j] != nums[i]) {
//                swap the numbers
                swap(nums, i, j);
            } else
                i++;
        }

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        CyclicSort.sort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        arr = new int[]{3, 1, 5, 4, 2};
        CyclicSort.sort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        arr = new int[]{2, 6, 4, 3, 1, 5};
        CyclicSort.sort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        arr = new int[]{1, 5, 6, 4, 3, 2};
        CyclicSort.sort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
