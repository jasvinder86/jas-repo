package com.datastructures.lc.nc.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {

//         Since we're interested in the highest, we'll go for max heap (priority queue).

//         Base Case 1: array is empty
        if (stones.length == 0)
            return 0;

//         Base Case 2: array has a single element
        if (stones.length == 1)
            return stones[0];

//         1. Add all the elements in a max heap. This will give all the elements arranged in descending order.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : stones) {
            maxHeap.offer(i);
        }

        while (maxHeap.size() > 1 && maxHeap.peek() != 0) {
            int bigger = maxHeap.poll();
            int smaller = maxHeap.poll();

//             2. Find the difference between the top 2 elements and add the result back in the heap
            maxHeap.offer(bigger - smaller);
        }

        return maxHeap.peek();
//        TC = O (n logn)
//        SC = O(n)

    }

    public static void main(String[] args) {
        System.out.println(LastStoneWeight.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }
}
