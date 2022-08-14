package com.datastructures.lc.nc.arraysandhashing;

public class NumberClosestToZero {

    public static int getNumberClosestToZero(int[] inputArray) {
        if (inputArray.length == 0)
            return 0;

        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < inputArray.length; i++) {
            if (Math.abs(temp) > Math.abs(inputArray[i])) {
                temp = inputArray[i];
            } else if (Math.abs(temp) == Math.abs(inputArray[i])) {
                temp = temp > inputArray[i] ? temp : inputArray[i];
            }

        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(NumberClosestToZero.getNumberClosestToZero(new int[]{2, -1, 1}));
        System.out.println(NumberClosestToZero.getNumberClosestToZero(new int[]{-273}));
        System.out.println(NumberClosestToZero.getNumberClosestToZero(new int[]{-15, -10, -7, -9, -14, -12}));
        System.out.println(NumberClosestToZero.getNumberClosestToZero(new int[]{-10, -10}));
        System.out.println(NumberClosestToZero.getNumberClosestToZero(new int[]{1, 0, -1}));

    }

}
