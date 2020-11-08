package com.datastructures.ae.arrays;

import java.util.Arrays;
import java.util.List;

public class Q2_ValidateSubsequence {

    public static void main(String[] args) {
        Integer[] inputArray = new Integer[]{5, 1, 22, 25, 6, -1, 8, 10};
        Integer[] inputSequence = new Integer[]{1, 6, -1, 10};
        System.out.println(Q2_ValidateSubsequence.isValidSubsequence(Arrays.asList(inputArray), Arrays.asList(inputSequence)));
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {

        int count = 0;
        int sequencePointer = 0;

        if (array.size() >= sequence.size()) {

            for (Integer i = 0; i < array.size(); i++) {
                if (array.get(i) - sequence.get(sequencePointer) == 0) {
                    count++;
                    sequencePointer++;
                    if (sequencePointer > sequence.size() - 1)
                        break;
                }
            }
            if (count == sequence.size())
                return true;
        }
        return false;
    }
}

