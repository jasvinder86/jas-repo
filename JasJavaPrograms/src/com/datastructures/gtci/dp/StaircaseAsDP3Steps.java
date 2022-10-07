package com.datastructures.gtci.dp;

// Given a stair with ‘n’ steps, implement a method to count how many possible
// ways are there to reach the top of the staircase, given that, at every step
// you can either take 1 step, 2 steps, or 3 steps.

public class StaircaseAsDP3Steps {

    public int countWays(int n) {

        if (n < 2)
            return 1;
        else if (n == 2)
            return 2;


        int n0 = 1;
        int n1 = 1;
        int n2 = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = n0 + n1 + n2;
            n0 = n1;
            n1 = n2;
            n2 = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        StaircaseAsDP3Steps staircaseAsDP3Steps = new StaircaseAsDP3Steps();
        System.out.println(staircaseAsDP3Steps.countWays(3));
        System.out.println(staircaseAsDP3Steps.countWays(4));
        System.out.println(staircaseAsDP3Steps.countWays(5));
        System.out.println(staircaseAsDP3Steps.countWays(6));
    }

}
