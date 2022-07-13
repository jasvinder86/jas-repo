package com.datastructures.lc.nc.twopointers;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {

//        1. Take two pointers - leftExtreme and rightExtreme.
//        2. The maximum water this container can hold is the min (left, right) *horizontal distance b/w the two.
//        3. Now reduce the width of this container by shifting the one of the left and the right extremes.
//        e.g. if height[leftExtreme] < height[rightExtreme], shift in the leftExtreme else the rightExtreme
//        4. Also reduce the horizontal distance 's values since one of the extremes has been shifted.
//        5. Return the maximum value from all such containers.

        int leftExtreme = 0, rightExtreme = height.length - 1;
        int horizontalDifference = rightExtreme - leftExtreme; // initial floor area

        int maxWater = 0;

        while (leftExtreme < rightExtreme) {
            maxWater = Math.max(Math.min(height[rightExtreme], height[leftExtreme]) * horizontalDifference, maxWater);

            if (height[leftExtreme] < height[rightExtreme]) {
                leftExtreme++;
            } else {
                rightExtreme--;
            }
            horizontalDifference--;
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // expected output = 49
        System.out.println(containerWithMostWater.maxArea(new int[]{1, 1})); // expected output = 1
        System.out.println(containerWithMostWater.maxArea(new int[]{0, 0})); // expected output = 0
    }

}
