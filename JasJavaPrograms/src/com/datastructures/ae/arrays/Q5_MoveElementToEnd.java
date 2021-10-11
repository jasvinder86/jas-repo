package com.datastructures.ae.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q5_MoveElementToEnd {

    public static void main(String[] args) {

        List<Integer> outputList = Q5_MoveElementToEnd.moveElementToEnd(new ArrayList<Integer>(Arrays.asList(2, 1, 2, 5, 6, 3, 2, 2, 2, 2, 5)), 2);
        System.out.println(outputList);
    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int temp = 0;
        int i = 0, j = array.size() - 1;
        while (i < j) {
            if (array.get(i) == toMove) {
                if (array.get(j) == toMove) {
//                    no need to replace since both are equal. Reduce j by 1 to compare the previous value
                    j--;
                } else {
//                    replace values at i & j. i++ and j-- since j now has the toMove and i doesn't have the toMove
                    temp = array.get(i);
                    array.set(i, array.get(j));
                    array.set(j, temp);

                    j--;
                    i++;
                }
            } else {
//                Since we don't have to move the current value, simply increment the i by 1
                i++;
            }
        }


        return array;
    }

}
