package com.datastructures.gtci.pattern1.slidingwindow;

//  Smallest Subarray with a given sum
public class MinLengthToGetSum {

    public int getMinimumLength(int[] inputArray, int desiredNumber) {

        int windowStart = 0, windowEnd = 0, currentSum = 0, minimumLength = Integer.MAX_VALUE;

//        1. Traverse the entire array
        for (windowEnd = 0; windowEnd < inputArray.length; windowEnd++) {
            currentSum = currentSum + inputArray[windowEnd];

//            2. Start a window slider the moment the desired sum gets reached
            while (currentSum >= desiredNumber) {
                minimumLength = Math.min(windowEnd - windowStart + 1, minimumLength);
                currentSum = currentSum - inputArray[windowStart];

//                3. Keep adding elements from the window start to reduce the window length.
                windowStart++;
            }
        }
        if (minimumLength == Integer.MAX_VALUE)
            return 0;
        return minimumLength;
    }

    public static void main(String[] args) {
        MinLengthToGetSum minLengthToGetSum = new MinLengthToGetSum();
        int[] array = new int[]{2, 4, 5, 1, 3, 6};
        int[] array2 = new int[]{1, 4, 1, 1, 1, 1, 2, 2};
        System.out.println(minLengthToGetSum.getMinimumLength(array, 8));
        System.out.println(minLengthToGetSum.getMinimumLength(array2, 4));
    }

}
