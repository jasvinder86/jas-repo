package com.datastructures.lc.nc.mathandgeometry;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        //         Traverse the whole matrix and set top row's and first col's element to zero
        //         when matrix[row][col] == 0. Later again traverse this array and set entire row
        //         and column to zero wherever top row and first column == 0.

        boolean firstRow = false, firstColumn = false;

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (matrix[row][col] == 0) {
                    // set that row's and col's first element = 0
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;

                    if (row == 0) firstRow = true;

                    if (col == 0) firstColumn = true;
                }
            }
        }
        // At this stage, traverse the matrix barring the first row and first column
        // i.e. starting from [1][1] and keep setting the current element = 0 based on
        //         their top row's or first column's element.

        for (int row = 1; row < rowLength; row++) {
            for (int col = 1; col < colLength; col++) {
                if (matrix[0][col] == 0 || matrix[row][0] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        //         if any element was 0 in the first row, mark the entire row as 0.
        if (firstRow) {
            for (int col = 0; col < colLength; col++) matrix[0][col] = 0;
        }

        //         if any element was 0 in the first column, mark the column row as 0.
        if (firstColumn) {
            for (int row = 0; row < rowLength; row++) matrix[row][0] = 0;
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        setMatrixZeroes.setZeroes(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});
    }

}
