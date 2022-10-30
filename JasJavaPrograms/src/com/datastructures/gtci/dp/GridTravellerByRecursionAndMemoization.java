package com.datastructures.gtci.dp;

/*
 * Given a grid, find number of ways one reach from top left to bottom right corner of the grid.
 * A step can be taken either in down or right direction only.
 * */
public class GridTravellerByRecursionAndMemoization {

    int recursiveCount = 0;
    int memoizationCount = 0;

    public int getNumberOfWaysByRecursion(int row, int column) {
//        System.out.println("recursiveCount is : " + ++recursiveCount);

//        Base Case 1: if either of row/ column == 0, return 0 since that is an invalid cell
        if (row == 0 || column == 0)
            return 0;

//        Base Case 2: if the last cell i.e. 1,1 is reached, return 1;
        if (row == 1 && column == 1)
            return 1;

        return getNumberOfWaysByRecursion(row - 1, column) + getNumberOfWaysByRecursion(row, column - 1);
//        TC = O(2^(row+column)); SC = O(row+column)
    }


    public int getNumberOfWaysByMemoization(int row, int column) {

        int[][] dp = new int[row + 1][column + 1];

        return getNumberOfWaysByWithMemoization(row - 1, column, dp) + getNumberOfWaysByWithMemoization(row, column - 1, dp);
        //        TC = O(2*row*column - 2) = O(row*column); SC = O(row+column)
    }

    public int getNumberOfWaysByWithMemoization(int row, int column, int[][] dpArray) {
        System.out.println("memoizationCount is : " + ++memoizationCount);

//      See if the dpArray already has the required value, if yes return it to avoid another computation.
        if (dpArray[row][column] != 0)
            return dpArray[row][column];

//        Base Case 1: if either of row/ column == 0, return 0 since that is an invalid cell
        if (row == 0 || column == 0)
            return 0;

//        Base Case 2: if the last cell i.e. 1,1 is reached, return 1;
        if (row == 1 && column == 1)
            return 1;

        dpArray[row][column] = getNumberOfWaysByWithMemoization(row - 1, column, dpArray) + getNumberOfWaysByWithMemoization(row, column - 1, dpArray);

        return dpArray[row][column];
    }


    public static void main(String[] args) {

        System.out.println("Number of ways for 2X2 is " + new GridTravellerByRecursionAndMemoization().getNumberOfWaysByMemoization(2, 2));
        System.out.println("Number of ways for 3X3 is " + new GridTravellerByRecursionAndMemoization().getNumberOfWaysByMemoization(3, 3));
        System.out.println("Number of ways for 4X4 is " + new GridTravellerByRecursionAndMemoization().getNumberOfWaysByMemoization(4, 4));
        System.out.println("Number of ways for 5X5 is " + new GridTravellerByRecursionAndMemoization().getNumberOfWaysByMemoization(5, 5));
        System.out.println("Number of ways for 18X18 is " + new GridTravellerByRecursionAndMemoization().getNumberOfWaysByMemoization(18, 18));
        System.out.println("Number of ways for 20X20 is " + new GridTravellerByRecursionAndMemoization().getNumberOfWaysByMemoization(20, 20));

        System.out.println("Number of ways for 2X2 is " + new GridTravellerByRecursionAndMemoization().getNumberOfWaysByRecursion(2, 2));
        System.out.println("Number of ways for 3X3 is " + new GridTravellerByRecursionAndMemoization().getNumberOfWaysByRecursion(3, 3));
        System.out.println("Number of ways for 4X4 is " + new GridTravellerByRecursionAndMemoization().getNumberOfWaysByRecursion(4, 4));
        System.out.println("Number of ways for 5X5 is " + new GridTravellerByRecursionAndMemoization().getNumberOfWaysByRecursion(5, 5));
        System.out.println("Number of ways for 18X18 is " + new GridTravellerByRecursionAndMemoization().getNumberOfWaysByRecursion(18, 18));
    }

}
