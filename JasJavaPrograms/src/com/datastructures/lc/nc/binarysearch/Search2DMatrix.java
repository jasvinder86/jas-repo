package com.datastructures.lc.nc.binarysearch;

/*
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * */

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0)
            return false;

        int rows = matrix.length;
        int columns = matrix[0].length;

        int left = 0;
        int right = rows * columns - 1;

        int pivot;

        while (left <= right) {
            pivot = left + (right - left) / 2;
            int pivotElement = matrix[pivot / columns][pivot % columns];

            if (target == pivotElement)
                return true;

            else if (target > pivotElement)
                left = pivot + 1;

            else
                right = pivot - 1;
        }

        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix search2DMatrix = new Search2DMatrix();
        System.out.println(search2DMatrix.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
    }
}
