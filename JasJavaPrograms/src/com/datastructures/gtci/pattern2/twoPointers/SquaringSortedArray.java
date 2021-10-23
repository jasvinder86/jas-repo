package com.datastructures.gtci.pattern2.twoPointers;

public class SquaringSortedArray {

    public static int[] squareASortedArray(int[] arr) {
        int[] squaredArray = new int[arr.length];

        int length = arr.length;
        int leftPointer = 0, rightPointer = arr.length - 1;
        int leftSquare = 0, rightSquare = 0;
        while (leftPointer <= rightPointer) {
            leftSquare = arr[leftPointer] * arr[leftPointer];
            rightSquare = arr[rightPointer] * arr[rightPointer];
            if (leftSquare < rightSquare) {
                squaredArray[length - 1] = rightSquare;
                rightPointer--;
            } else {
                squaredArray[length - 1] = leftSquare;
                leftPointer++;
            }
            length--;

        }
        return squaredArray;
    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{1, 2, 3};
        int[] outputArray = SquaringSortedArray.squareASortedArray(inputArray);
        System.out.println("Squared array 1");
        for (int number : outputArray) {
            System.out.print(number + " ");
        }
        System.out.println();
        System.out.println("Squared array 2");
        inputArray = new int[]{-4, -2, 1, 2, 3};
        outputArray = SquaringSortedArray.squareASortedArray(inputArray);
        for (int number : outputArray) {
            System.out.print(number + " ");
        }
    }

}
