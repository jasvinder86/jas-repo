package com.datastructures.gtci.dp.prefixSum;

public class SumOfSubarrayRanges {

    public long subArrayRanges(int[] nums) {
        //         Contiguous subarrays from [4,-2,-3,4,1] and difference of
        //         largest and smallest element in the subarray are:
        //
        //         [4,-2,-3,4,1]                    >> 4- (-3) = 7
        //         [4,-2,-3,4], [-2,-3,4,1]         >> 4- (-3) + 4- (-3) = 7 + 7
        //         [4,-2,-3], [-2,-3,4], [-3,4,1]   >> 4- (-3) + 4- (-3) + 4- (-3) = 7 + 7 + 7
        //         [4,-2], [-2,-3], [-3,4], [4,1]   >> 4- (-2) + (-2) - (-3) + 4- (-3) + 4-1 = 6 + 1 + 7 + 3
        //         [4], [-2], [-3], [4] , [1]       >> 4-4 + (-2) - (-2) + (-3) - (-3) + 4-4 + 1-1 = 0
        //         Total Sum = 7 + 14 + 21 + 17 + 0 = 59

        //         Solution: Traverse the array and keep summing difference of the max and min element.

        //        TC = O(n^2)

        long sum = 0; // for total sum

        for (int outerCounter = 0; outerCounter < nums.length; outerCounter++) {
            int max = nums[outerCounter];
            int min = nums[outerCounter];

            for (int innerCounter = outerCounter; innerCounter < nums.length; innerCounter++) {
                max = Math.max(max, nums[innerCounter]);
                min = Math.min(min, nums[innerCounter]);

                sum += (max - min);
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        SumOfSubarrayRanges sumOfSubarrayRanges = new SumOfSubarrayRanges();
        System.out.println(sumOfSubarrayRanges.subArrayRanges(new int[]{4, -2, -3, 4, 1})); // expected = 59; actual = 59

    }

}
