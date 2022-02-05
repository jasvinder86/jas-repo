package com.datastructures.gtci.pattern2.twoPointers;

/*
 * Quadruple Sum to Target
 * Given an array of unsorted numbers and a target number,
 * find all unique quadruplets in it, whose sum is equal to the target number.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrupleSumToTarget {

    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();

        Arrays.sort(arr);
//        1. First start with pivot fixed @ the 0th index.
        int pivot = 0;

//        2. Traverse the pivot till 4th last index
        while (pivot < arr.length - 3) {

//            3. Keep left pointer @ pivot+1 th index.
            int left = pivot + 1;

//            4. Traverse the left pointer till 3rd last index.
            while (left < arr.length - 2) {

//                5. Now in the remaining array, the problem gets simplified to finding a pair of indices with sum == target
                int center = left + 1, right = arr.length - 1;
                while (center < right) {
                    int sum = arr[pivot] + arr[left] + arr[center] + arr[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(arr[pivot], arr[left], arr[center], arr[right]));
                        center++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        center++;
                    }
                }
//                6. After keeping pivot and right pointers fixed, now increment the left pointer. Again center and right pointers will be traversed based on the new index of the left pointer.
                left++;
            }
//            7. Finally, increment the pivot. Now left pointer will be based on the current position of the pivot.
            pivot++;
        }
        return quadruplets;
    }

    public static void main(String[] args) {
        System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[]{4, 1, 2, -1, 1, -3}, 1));
        System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[]{2, 0, -1, 1, -2, 2}, 2));
    }

}
