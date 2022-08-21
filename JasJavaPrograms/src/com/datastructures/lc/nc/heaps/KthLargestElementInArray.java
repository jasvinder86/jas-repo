package com.datastructures.lc.nc.heaps;

import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public int KthLargest(int k, int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i : nums) {
            minHeap.add(i);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        return minHeap.remove();
    }

    public static void main(String[] args) {
        KthLargestElementInArray kthLargestElementInArray = new KthLargestElementInArray();
        System.out.println(kthLargestElementInArray.KthLargest(2, new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}));   // Exp = 8, Actual = 8
        System.out.println(kthLargestElementInArray.KthLargest(2, new int[]{3, 2, 1, 5, 6, 4}));            // Exp = 5, Actual = 5
        System.out.println(kthLargestElementInArray.KthLargest(4, new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}));   // Exp = 4, Actual = 4
    }
}
