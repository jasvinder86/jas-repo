package com.datastructures.gtci.pattern2.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeDigitsThatSumToZero {
    public static void main(String[] args) {
        List<List<Integer>> lists = ThreeDigitsThatSumToZero.getTriplets(-1, 0, 1, 2, -1, -4);
        System.out.println(lists);
        List<List<Integer>> lists1 = ThreeDigitsThatSumToZero.getTriplets(new int[]{-2, -1, -1, 0, 0, 1, 1});
        System.out.println(lists1);
        List<List<Integer>> lists2 = ThreeDigitsThatSumToZero.getTriplets(new int[]{-1, -1, 0, 0, 1, 1});
        System.out.println(lists2);
    }

    public static List<List<Integer>> getTriplets(int... nums) {

        Arrays.sort(nums);

        List<List<Integer>> returnedList = new ArrayList<>();

        for (int pivot = 0; pivot < nums.length - 2; pivot++) {

//            pivot == 0 covers the first case when the for loop just starts.
//            second comparison is to avoid dealing with duplicate pivots and skipping then early on even before entering the for loop.
            if (pivot == 0 || nums[pivot] != nums[pivot - 1]) {

                int lp = pivot + 1;
                int rp = nums.length - 1;

                while (lp < rp) {
                    int sum = nums[pivot] + nums[lp] + nums[rp];
//                If the sum of the three numbers is zero, add them to a list to be returned.
                    if (sum == 0) {
                        returnedList.add(Arrays.asList(nums[pivot], nums[lp], nums[rp]));
                        lp++;
                        rp--;

//                        it can n happen that the new lp is same as the previous lp, and same for the rp
//                        {-1, 0, 0, 1, 1}
//                        Case 1: pivot -> index 0 = -1, lp -> index 1 = 0, rp -> index 4; sum = 0, o/p = -1, 0, 1
//                        Case 2: pivot -> index 0 = -1, lp -> index 2 = 0, rp -> index 3; sum = 0, o/p = -1, 0, 1
//                        This will make duplicate entries which are not allowed. So, maintain uniqueness for lp and rp as well.

                        while (lp < rp && nums[lp] == nums[lp - 1])
                            lp++;
                        while (lp < rp && nums[rp] == nums[rp + 1])
                            rp--;

                    } else if (sum > 0) {
                        rp--;
                    } else {
                        lp++;
                    }
                }
            }
        }
        return returnedList;
    }
}
