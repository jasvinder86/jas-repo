package com.datastructures.lc.nc.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outputList = new ArrayList<>();

//         1. First sort the input array
        Arrays.sort(nums);

//         2. Keep first pointer constant and add rest two become left and right pointers
//         3. Add all 3 to verify == 0

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                int leftPointer = i + 1, rightPointer = nums.length - 1;

                while (leftPointer < rightPointer) {

                    if (nums[i] + nums[leftPointer] + nums[rightPointer] == 0) {

//                 triplet found, add it in the list
                        outputList.add(Arrays.asList(nums[i], nums[leftPointer], nums[rightPointer]));

                        while (leftPointer < rightPointer && nums[leftPointer] == nums[leftPointer + 1]) {
                            leftPointer++;
                        }


                        while (leftPointer < rightPointer && nums[rightPointer] == nums[rightPointer - 1]) {
                            rightPointer--;
                        }


                        leftPointer++;
                        rightPointer--;
                    } else if (nums[i] + nums[leftPointer] + nums[rightPointer] > 0)
                        rightPointer--;

                    else
                        leftPointer++;

                }
            }
        }
        return outputList;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{0, 0, 0}));
        System.out.println(threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, 4}));

    }

}
