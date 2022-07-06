package com.datastructures.lc.nc.arraysandhashing;

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

//         1. Insert all the values of the array in a map.
//         2. Make a  priority queue and put all the entries in it with the maximum value of each key at the front => the queue
//         will have the sorted values in it
//         3. fetch the key against the k values and return them in an array form.

        Map<Integer, Integer> map = new HashMap<>();
        int[] outputList = new int[k];

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry entry : map.entrySet()) {
            maxHeap.add(entry);
        }

        for (int i = 0; i < k; i++) {
            outputList[i] = maxHeap.poll().getKey();
        }

        return outputList;

    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] output = topKFrequentElements.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);

        System.out.print("Elements are ");
        for (int i = 0; i < output.length; i++) {
            System.out.print(i + " ");
        }
    }

}
