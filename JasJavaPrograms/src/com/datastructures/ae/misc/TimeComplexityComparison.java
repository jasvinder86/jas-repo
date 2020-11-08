package com.datastructures.ae.misc;

public class TimeComplexityComparison {

    public static void main(String[] args) {


        int[] inputArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TimeComplexityComparison timeComplexityComparison = new TimeComplexityComparison();
        timeComplexityComparison.addConstant(inputArray);
        timeComplexityComparison.sumAll(inputArray);
        timeComplexityComparison.pairAll(inputArray);
    }


    public void addConstant(int[] inputArray) {

        int result = 0;
        long startTime = System.nanoTime();
        result = 1 + inputArray[0];
        long endTime = System.nanoTime();
        System.out.println("addConstant : " + result);
        System.out.println("time taken : " + (endTime - startTime));
    }

    public void sumAll(int[] inputArray) {
        int result = 0;
        long startTime = System.nanoTime();
        for (int x : inputArray) {
            result = result + x;
        }
        long endTime = System.nanoTime();
        System.out.println("sumAll : " + result);
        System.out.println("time taken : " + (endTime - startTime));
    }

    public void pairAll(int[] inputArray) {
        System.out.println("pairAll");
        long startTime = System.nanoTime();
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray.length; j++) {
                System.out.println(inputArray[i] + "," + inputArray[j]);
            }
        }
        long endTime = System.nanoTime();
        System.out.println("time taken : " + (endTime - startTime));
    }
}
