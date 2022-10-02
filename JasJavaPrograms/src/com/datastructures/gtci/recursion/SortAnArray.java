package com.datastructures.gtci.recursion;

public class SortAnArray {
    public static void sortArray(int[] array, int n) {

        if (n == 1)
            return;

        for (int i = 0; i < n - 1; i++) {
//            If the current number is greater than the next one, swap their indices
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
        sortArray(array, n - 1);

        System.out.print("Sorted Array:");
    }

    public static void main(String[] args) {
        SortAnArray.sortArray(new int[]{6, 5, 4, 3, 2, 1}, 6);
    }

}
