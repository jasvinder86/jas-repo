package com.datastructures.gtci.pattern11.bitwise.xor;

public class TestXor {
    public static void main(String[] args) {
        int  i0 = 0, i1 = 1,  i2 = 2;
        System.out.println(i0 ^ i1);
        System.out.println(i0 ^ i0);
        System.out.println(i1 ^ i2);
        System.out.println(i2 ^ i2); // E = 0
        System.out.println(10 ^ 11); // E = 1
        System.out.println(12 ^ 11); // E = 3
        System.out.println(14 ^ 11); // E = 5
    }
}
