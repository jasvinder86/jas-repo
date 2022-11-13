package com.datastructures.lc.nc.mathandgeometry;

import java.util.ArrayList;
import java.util.List;

/*
 * LeetCode # 54 https://leetcode.com/problems/spiral-matrix/description/
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * */

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> outputList = new ArrayList<>();

        int top = 0, left = 0, bottom = matrix.length, right = matrix[0].length;
        int matrixSize = matrix.length * matrix[0].length;

// While size of the outputList < size of the given matrix, iterate.
        while (outputList.size() < matrixSize) {

// Left to right traversal in the top most row.
            for (int col = left; col < right && outputList.size() < matrixSize; col++) {
                outputList.add(matrix[top][col]);
            }
            top++;

// Top to bottom traversal in the right most column.
            for (int row = top; row < bottom && outputList.size() < matrixSize; row++) {
                outputList.add(matrix[row][right - 1]);
            }
            right--;

// Right to left traversal in the bottom most row.
            for (int col = right - 1; col >= left && outputList.size() < matrixSize; col--) {
                outputList.add(matrix[bottom - 1][col]);
            }
            bottom--;

// Bottom to top traversal in the left most column.
            for (int row = bottom - 1; row >= top && outputList.size() < matrixSize; row--) {
                outputList.add(matrix[row][left]);
            }
            left++;
        }
        return outputList;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        System.out.println(spiralMatrix.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}})); // Ex = Actual = [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
    }
}
