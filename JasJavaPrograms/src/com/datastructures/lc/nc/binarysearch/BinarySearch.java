package com.datastructures.lc.nc.binarysearch;

public class BinarySearch {

    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1, pivot = 0;

        while (left <= right) {
            pivot = (left + right) / 2;

            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[pivot] > target) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(binarySearch.search(new int[]{0, 0, 0, 0, 0, 0, 0, 0}, 9));
    }

}
