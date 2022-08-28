package com.datastructures.lc.nc.dp;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {

        int largest = 0;

        int rows = matrix.length;
        int columns = matrix[0].length;
        if (rows == 0 && columns == 0)
            return 0;
        int dp[][] = new int[rows + 1][columns + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    largest = Math.max(largest, dp[i][j]);
                }
            }
        }
        return largest * largest;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        MaximalSquare maximalSquare = new MaximalSquare();
        System.out.println(maximalSquare.maximalSquare(matrix));
    }

}
