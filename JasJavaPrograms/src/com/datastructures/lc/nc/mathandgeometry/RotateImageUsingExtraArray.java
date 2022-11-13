package com.datastructures.lc.nc.mathandgeometry;

/*
 * LeetCode 48. Rotate Image https://leetcode.com/problems/rotate-image/
 * Original question asks not to use an extra space, however this is the brute force approach and uses an extra array
 * */

public class RotateImageUsingExtraArray {
    public int[][] rotate(int[][] matrix) {
        int length = matrix[0].length;
        int[][] outputArray = new int[length][length];

        for (int row = 0; row < length; row++) {
            for (int col = 0; col < length; col++) {
                outputArray[col][Math.abs(length - 1 - row)] = matrix[row][col];
            }
        }
        return outputArray;
    }

    public static void main(String[] args) {
        RotateImageUsingExtraArray rotateImageUsingExtraArray = new RotateImageUsingExtraArray();
        int[][] output = rotateImageUsingExtraArray.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});   // Expected = [[7,4,1], [8,5,2], [9,6,3]]
        output = rotateImageUsingExtraArray.rotate(new int[][]{{1, 2}, {3, 4}});    // Expected = [[3,1],[4,2]]
        output = rotateImageUsingExtraArray.rotate(new int[][]{{1}}); // Expected = [[1]]
    }
}
