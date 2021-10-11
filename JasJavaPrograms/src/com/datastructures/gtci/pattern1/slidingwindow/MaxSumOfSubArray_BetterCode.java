package com.datastructures.gtci.pattern1.slidingwindow;

public class MaxSumOfSubArray_BetterCode {

    public int getMaximumSum(int[] inputArray, int k) {
        int windowStart = 0, windowEnd = 0, sliderLength = 0, sum = 0, maxSum = 0;

        for (windowEnd = 0; windowEnd < inputArray.length; windowEnd++) {

//          1.  traverse the entire slider for the first time ie create a slider of the length k

            sum = sum + inputArray[windowEnd];

            if (windowEnd >= k-1) {
//            2. Slider has been created.
//            3. Now windowEnd would have reached Kth index and windowStart is still at 0th index
//
                maxSum = maxSum > sum ? maxSum : sum;

                sum = sum - inputArray[windowStart];

//            4. Keep moving windowStart by 1.
                windowStart++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] givenArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 2;
        MaxSumOfSubArray_BetterCode maxSumOfSubArray = new MaxSumOfSubArray_BetterCode();
        System.out.println(maxSumOfSubArray.getMaximumSum(givenArray, k));
    }
}
