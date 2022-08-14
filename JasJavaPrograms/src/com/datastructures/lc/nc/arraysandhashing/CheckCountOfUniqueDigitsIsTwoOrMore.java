package com.datastructures.lc.nc.arraysandhashing;

import java.util.HashSet;

public class CheckCountOfUniqueDigitsIsTwoOrMore {

    public static String isDuoDigit(int number) {
        HashSet<Integer> numSet = new HashSet<Integer>();
        while (number % 10 != number) {
            numSet.add(number % 10);
            number = number / 10;
        }
        numSet.add(number);
        return numSet.size() <= 2 ? "y" : "n";
    }

    public static void main(String[] args) {
        System.out.println(CheckCountOfUniqueDigitsIsTwoOrMore.isDuoDigit(102));
        System.out.println(CheckCountOfUniqueDigitsIsTwoOrMore.isDuoDigit(122));
    }
}
