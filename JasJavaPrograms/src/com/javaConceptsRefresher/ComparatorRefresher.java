package com.javaConceptsRefresher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorRefresher {
    public static void main(String[] args) {

        List<Integer> numList = new ArrayList<>();
        numList.add(19);
        numList.add(28);
        numList.add(37);
        numList.add(46);

//  natural sorting order is by ascending order
        System.out.println(numList); // [19, 28, 37, 46]

//        Change it to sort by the unit digit of each number, i.e. 46, 37, 28, 19

//        Comparator<Integer> comparator = new Comparator<Integer>() {
//            public int compare(Integer a, Integer b) {
//
//                if (a % 10 > b % 10) // if 9 of 19 > 8 of 28, return 1 which is swap them
//                    return 1;
//                else
//                    return -1;
//            }
//        };

//        Lambda equivalent of the above code
        Comparator<Integer> comparator = (a, b) -> {
            if (a % 10 > b % 10) // if 9 of 19 > 8 of 28, return 1 which is swap them
                return 1;
            else
                return -1;
        };

//        Even shorter version
        Comparator<Integer> comparator1 = (i, j) -> i % 10 > j % 10 ? 1 : -1;

        Collections.sort(numList, comparator);
        System.out.println(numList);

        Collections.sort(numList, comparator1);
        System.out.println(numList);
    }


}
