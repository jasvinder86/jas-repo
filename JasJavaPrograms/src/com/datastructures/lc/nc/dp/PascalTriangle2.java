package com.datastructures.lc.nc.dp;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> finalList = new ArrayList<>();

        List<Integer> previousRow = new ArrayList<>();

        previousRow.add(1);
        finalList.add(previousRow);

        for (int i = 1; i < rowIndex + 1; i++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            for (int j = 1; j < i; j++) {
                currentRow.add(previousRow.get(j) + previousRow.get(j - 1));
            }
            currentRow.add(1);
            finalList.add(currentRow);
            previousRow = currentRow;
        }

        return finalList.get(rowIndex);
    }

    public static void main(String[] args) {
        PascalTriangle2 pascalTriangle2 = new PascalTriangle2();
        List<Integer> list = pascalTriangle2.getRow(0);
        System.out.println(list);
        List<Integer> list1 = pascalTriangle2.getRow(1);
        System.out.println(list1);
        List<Integer> list2 = pascalTriangle2.getRow(2);
        System.out.println(list2);
        List<Integer> list3 = pascalTriangle2.getRow(3);
        System.out.println(list3);
        List<Integer> list4 = pascalTriangle2.getRow(4);
        System.out.println(list4);
    }
}
