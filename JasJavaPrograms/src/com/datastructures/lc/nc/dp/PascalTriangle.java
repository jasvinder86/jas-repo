package com.datastructures.lc.nc.dp;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> finalList = new ArrayList<>();

        List<Integer> previousRow = new ArrayList<>();

        previousRow.add(1);
        finalList.add(previousRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            for (int j = 1; j < i; j++) {
                currentRow.add(previousRow.get(j) + previousRow.get(j - 1));
            }
            currentRow.add(1);
            finalList.add(currentRow);
            previousRow = currentRow;
        }

        return finalList;
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        List<List<Integer>> list = pascalTriangle.generate(5);
        System.out.println(list);
    }
}
