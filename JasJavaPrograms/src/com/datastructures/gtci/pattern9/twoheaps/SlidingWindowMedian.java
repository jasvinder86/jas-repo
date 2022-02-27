package com.datastructures.gtci.pattern9.twoheaps;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * Sliding Window Median
 * Given an array of numbers and a number ‘k’, find the median of all the ‘k’ sized sub-arrays (or windows) of the array.
 */

public class SlidingWindowMedian {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];

//        1. Creating two priority queues to hold lower and higher values.
//        ***
//        maxHeap = new PriorityQueue<>((a, b) -> b - a);
//        minHeap = new PriorityQueue<>((a, b) -> a - b);
//        When comparing long integers, this comparator will give erroneous results. Hence the better solution is to use
//        the below line of code with Collections.reverseOrder()
//        Refer this stack overflow answer for more details
//        https://stackoverflow.com/questions/683041/how-do-i-use-a-priorityqueue

        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();

        int windowEnd = 0;

        int i = 0;
        for (int windowStart = 0; windowStart < nums.length; windowStart++) {

//            2. Add the upcoming element to the appropriate heap
            if (maxHeap.isEmpty() || maxHeap.peek() > nums[windowStart]) {
                maxHeap.add(nums[windowStart]);
            } else minHeap.add(nums[windowStart]);

//            3. If maxHeap has more elements than minHeap, balance the heaps
            balanceTheHeaps();

//            4. If window size has been achieved, take into account the current median.
            if (windowStart - windowEnd + 1 >= k) {

//                5. add the current median into the array
                result[i++] = maxHeap.size() > minHeap.size() ? maxHeap.peek() / 1.0 : (maxHeap.peek() / 2.0 + minHeap.peek() / 2.0);

//                6. Maintain just k entries in total in the two heaps. For achieving this, the element at window end should be removed from the appropriate heap.
                if (nums[windowEnd] <= maxHeap.peek()) // it must be present in the maxPeak so remove it
                    maxHeap.remove(nums[windowEnd]);
                else
                    minHeap.remove(nums[windowEnd]);

//                7. Again balance the heaps
                balanceTheHeaps();

//                8. ++ the window end so that the window size of k can be maintained. Next window start will be added by the for loop.
                windowEnd++;
            }

        }

        return result;
    }

    private void balanceTheHeaps() {
        if (maxHeap.size() - 1 > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[]{1, 2, -1, 3, 5}, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[]{1, 2, -1, 3, 5}, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[]{2147483647, 2147483647}, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

//        This test is failing
//        This test has been corrected. Refer *** at line 20
        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[]{-2147483648, -2147483648, 2147483647, -2147483648, -2147483648, -2147483648, 2147483647, 2147483647, 2147483647, 2147483647, -2147483648, 2147483647, -2147483648}, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }

}
