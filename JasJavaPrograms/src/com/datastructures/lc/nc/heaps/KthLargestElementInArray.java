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
        System.out.println(kthLargestElementInArray.KthLargest(2, new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}));
    }
}
