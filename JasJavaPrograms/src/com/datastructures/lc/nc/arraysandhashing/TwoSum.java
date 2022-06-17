package com.datastructures.lc.nc.arraysandhashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

//         Approach 1 = Two for loops >> O(n2)
//         Approach 2 =
        // 1. Sort the array
        // 2. Pick the first element and the last element and add.
        // 3. If the sum > target, lastElement --, if sum < target, firstElement++, else if equal, return the incides of the current elements.

//        BUG in this approach = after sorting the array, indices will all jumble up and the expected indices
//        of the original array won't match the out indices.

        Arrays.sort(nums); // gives a sorted array

        int firstElement = 0;
        int lastElement = nums.length - 1;

        while (firstElement < lastElement) {

            if (nums[firstElement] + nums[lastElement] == target)
                return new int[]{firstElement, lastElement};
            else if (nums[firstElement] + nums[lastElement] < target) {
                firstElement++;
            } else if (nums[firstElement] + nums[lastElement] > target) {
                lastElement--;
            }

        }
        return new int[]{};
    }

    public int[] twoSum_1(int[] nums, int target) {

        // Approach 3 - Keep saving complement of the incoming number in a set. If current number is in the set,
        // it means it was saved as a result of a previously seen number.

        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (list.contains(target - nums[i]))
                return new int[]{i, list.indexOf(target - nums[i])};

            else
                list.add(nums[i]);
            i++;
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int resultArray[] = new int[]{};
        resultArray = twoSum.twoSum_1(new int[]{3, 2, 4}, 6);
        System.out.println(resultArray[0] + " " + resultArray[1]);
    }


}
