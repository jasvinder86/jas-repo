package com.datastructures.agoda;

import java.util.PriorityQueue;

/*
 * LeetCode 973 https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
 * return the k closest points to the origin (0, 0).
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 *
 * */
public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {

//         1. Create a minHeap because closest distance has to be at the top.
//         2. Find the distance and keep inserting it in the minHeap
//         3. All k elements of the minHeap are the answers.

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);

        for (int[] inputPoint : points) {
            minHeap.offer(inputPoint);
        }

        int[][] outputArray = new int[k][2];
        for (int i = 0; i < k; i++) {
            outputArray[i] = minHeap.poll();
        }
        return outputArray;
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        int[][] op = kClosestPointsToOrigin.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);
        for (int[] x : op) {
            System.out.println(x[0] + " " + x[1]);
        }
        op = kClosestPointsToOrigin.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
        for (int[] x : op) {
            System.out.println(x[0] + " " + x[1]);
        }
    }

}
