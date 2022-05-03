package com.datastructures.gtci.pattern16.dynamicprogramming;

/*
 * Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack
 * with a capacity ‘C.’ The goal is to get the maximum profit out of the knapsack items.
 * Each item can only be selected once, as we don’t have multiple quantities of any item.
 *
 * Example:
 * Items: { Apple, Orange, Banana, Melon }
 * Weights: { 2, 3, 1, 4 }
 * Profits: { 4, 5, 3, 7 }
 * Knapsack capacity: 5
 */

public class Knapsack {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

//        0. Erroneous Case
        if (capacity == 0 || profits.length == 0 || profits.length != weights.length)
            return 0;

//        1. Fill the first column with 0 since the initial capacity = 0
        for (int i = 0; i < n; i++)
            dp[i][0] = 0;

//        2. Fill the first row with the first weight provided w[0] <= capacity at that column index
        for (int i = 1; i <= capacity; i++) {
            if (weights[0] <= capacity)
                dp[0][capacity] = weights[0];
        }

//        3. Now fill rest of the matrix

        for (int i = 1; i < n; i++) {

            for (int j = 1; j <= capacity; j++) {
                int profit1 = 0, profit2;

                if (weights[i] <= j) {
                    profit1 = profits[i] + dp[i - 1][j - weights[i]];
                }
                profit2 = dp[i - 1][j];

                dp[i][j] = Math.max(profit1, profit2);
            }
        }
//        4. Max profit achievable will be at the lastRow-lastColumn.
        return dp[n - 1][capacity];
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        //        Expected = 22; Actual = 22

        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        //        Expected = 16; Actual = 16

        /*
         * Time and Space complexity
         * The above solution has the time and space complexity of O(N*C)
         * where ‘N’ represents total items, and ‘C’ is the maximum capacity.
         * */

    }
}
