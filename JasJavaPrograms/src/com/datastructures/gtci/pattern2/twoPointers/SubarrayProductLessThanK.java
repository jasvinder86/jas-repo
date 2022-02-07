package com.datastructures.gtci.pattern2.twoPointers;

/*
 * Subarrays with Product Less than a Target
 *
 * Given an array with positive numbers and a positive target number,
 * find all of its contiguous subarrays whose product is less than the target number.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubarrayProductLessThanK {

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();

        int left = 0, product = 1;
        for (int right = 0; right < arr.length; right++) {

            product = product * arr[right];

//            1. if product >= target, start the window slider from the left pointer and iterate till product < target
            while (product >= target) {
                product = product / arr[left];
                left++;
            }

//            2. if current products is < target, all the numbers in this product
            if (product < target) {

//                3. If an array list is taken, adding at specific locations won't be possible which we want to achieve in order to maintain the
//                sequence as given in the input array. Hence, using a linked list instead which gives the option of adding at specific index
                List<Integer> listOfArrays = new LinkedList<>();
                for (int i = right; i >= left; i--) {

//                From Java docs of Linked List
//                Inserts the specified element at the specified position in this list (optional operation).
//                Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
                    listOfArrays.add(0, arr[i]);

//                    4. Creating a new array list below so that in each iteration, the current list gets added into the subarray.
//                    If we simply add it (not as a new list), the same list will get added twice.
                    subarrays.add(new ArrayList<>(listOfArrays));
                }
            }
        }

        return subarrays;
    }

    public static void main(String[] args) {
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[]{2, 5, 3, 10}, 30));
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[]{8, 2, 6, 5}, 50));
    }

}
