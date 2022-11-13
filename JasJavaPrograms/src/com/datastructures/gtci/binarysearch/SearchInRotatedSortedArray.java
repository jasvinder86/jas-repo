package com.datastructures.gtci.binarysearch;

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == nums[mid])
                return mid;
                //            Check which is the sorted half and try locating the target in it
                //            Check the left half
            else if (nums[mid] >= nums[left]) { // it means left half is sorted
                if (target >= nums[left] && target <= nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if (target >= nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(SearchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

}

