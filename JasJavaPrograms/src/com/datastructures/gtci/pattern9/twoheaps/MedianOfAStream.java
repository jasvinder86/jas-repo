package com.datastructures.gtci.pattern9.twoheaps;

import java.util.PriorityQueue;

/*
 * Find the Median of a Number Stream
 *
 * */
public class MedianOfAStream {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

    public void insertNum(int num) {

//        1. Start by inserting elements in the maxHeap so that its root can be extracted to get the median.
//        So, maxHeap can be equal to minHeap or at max 1 more than the minHeap.
        if (maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);

//        2. Now if the size of minHeap is > that of maxHeap, remove its root and insert into the maxHeap,
//        and vice versa while maintaining that maxHeap can be +1 than minHeap.
        if (maxHeap.size() - 1 > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
//        3. If count of elements added so far is even, median will be the average of roots of max and min heaps
//        else it'll be the root of them maxHeap since its maintaining one element extra than the minHeap

//        4. Dividing by 2.0 else it'll return an integer with floor value
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
