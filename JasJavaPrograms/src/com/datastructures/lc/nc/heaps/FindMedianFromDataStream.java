package com.datastructures.lc.nc.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();

    }

    public void addNum(int num) {

        if (!minHeap.isEmpty() && num > minHeap.peek()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }


        if (maxHeap.size() - 1 > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }

        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }

    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size())
            return (maxHeap.peek() / 2.0 + minHeap.peek() / 2.0);
        else
            return maxHeap.peek();
    }

    public static void main(String[] args) {
        FindMedianFromDataStream findMedianFromDataStream = new FindMedianFromDataStream();
        findMedianFromDataStream.addNum(1);
        System.out.println(findMedianFromDataStream.findMedian());      // Expected = 1.0; Actual = 1.0
        findMedianFromDataStream.addNum(2);
        System.out.println(findMedianFromDataStream.findMedian());      // Expected = 1.5; Actual = 1.5
        findMedianFromDataStream.addNum(3);
        System.out.println(findMedianFromDataStream.findMedian());      // Expected = 2.0; Actual = 2.0
    }

}
