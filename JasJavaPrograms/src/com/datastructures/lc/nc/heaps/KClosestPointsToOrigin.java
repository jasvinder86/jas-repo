package com.datastructures.lc.nc.heaps;

import java.util.HashMap;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {

//         1. Since closest k elements are required, use a maxHeap of size k to have the lowest elements remaning in the maxHeap.
        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>((x, y) -> y[0] * y[0] + y[1] * y[1] - (x[0] * x[0] + x[1] * x[1]));

        for (int[] point : points) {
            maxHeap.offer(point);

            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        int[][] output = new int[k][2];

        while (k-- > 0) {
            output[k] = maxHeap.poll();
        }
        return output;
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        int[][] op = kClosestPointsToOrigin.kClosest(new int[][]{{0, 1}, {1, 0}}, 2);
        for (int[] x : op) {
            System.out.println(x[0] + " " + x[1]);
        }
    }


}
