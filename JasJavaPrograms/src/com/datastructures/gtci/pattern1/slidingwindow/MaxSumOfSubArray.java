package com.datastructures.gtci.pattern1.slidingwindow;

public class MaxSumOfSubArray {

    public int getMaximumSum(int[] inputArray, int k) {
        int windowStart = 0, windowEnd = 0, sliderLength = 0, sum = 0, maxSum = 0;

        for (windowEnd = 0; windowEnd < inputArray.length; windowEnd++) {

//          1.  traverse the entire slider for the first time ie create a slider of the length k
            if (sliderLength < k) {
                sum = sum + inputArray[windowEnd];
                sliderLength++;
                maxSum = maxSum > sum ? maxSum : sum;
            } else {
//            2. Slider has been created. Now keep moving the start and end by 1 so that slider keeps moving forward.
//            3. Now windowEnd would have reached Kth index and windowStart is still at 0th index
//            4. Subtract windowStart's value and add windowEnd's to get the new sum from index 1 to index k.
                sum = sum - inputArray[windowStart] + inputArray[windowEnd];

                maxSum = maxSum > sum ? maxSum : sum;

//            5. Keep moving windowStart by 1.
                windowStart++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] givenArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 2;
        MaxSumOfSubArray maxSumOfSubArray = new MaxSumOfSubArray();
        System.out.println(maxSumOfSubArray.getMaximumSum(givenArray, k));
    }
}
