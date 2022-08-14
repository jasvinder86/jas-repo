package com.datastructures.gtci.misc;

public class BuildNumberFromDigits {

    public static int getNumber(int[] digit) {
        int sum = 0;
        double count = 0;
        for (int i : digit) {
            sum = (int) Math.pow(10.0, count) * i + sum;
            count++;
        }

        return sum;
    }

    public static void main(String[] args) {
        int sum = BuildNumberFromDigits.getNumber(new int[]{3, 2, 1});
        System.out.println(sum);
    }
}
