package com.datastructures.gtci.dp;

// Climb either 1 step or 2 steps
public class StaircaseAsDP2Steps {

    public int countWays(int n) {

//        Base Case
        if (n < 2) {
            return 1;
        }

        int n1 = 1, n2 = 1;
        int sum;

        for (int i = 2; i <= n; i++) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
        return n2;
    }

    public static void main(String[] args) {
        StaircaseAsDP2Steps staircaseAsDP = new StaircaseAsDP2Steps();
        System.out.println(staircaseAsDP.countWays(0));
        System.out.println(staircaseAsDP.countWays(1));
        System.out.println(staircaseAsDP.countWays(2));
        System.out.println(staircaseAsDP.countWays(3));
        System.out.println(staircaseAsDP.countWays(4));
        System.out.println(staircaseAsDP.countWays(5));
    }
}
