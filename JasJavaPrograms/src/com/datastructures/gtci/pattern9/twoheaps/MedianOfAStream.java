package com.datastructures.gtci.pattern9.twoheaps;

import java.util.PriorityQueue;

public class MedianOfAStream {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

    public void insertNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);

        if (maxHeap.size() - 1 > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());

    }

    public double findMedian() {
        return (maxHeap.size() > minHeap.size()) ? maxHeap.peek() : (maxHeap.peek() + minHeap.peek()) / 2.0;
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();

        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("Median is : " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("Median is : " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("Median is : " + medianOfAStream.findMedian());
    }

}
