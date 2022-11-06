package com.datastructures.gtci.pattern11.bitwise.xor;

public class TestXor {

    //    XOR of a char with 0
    public static void xorWithAsciiValues(char input) {
        System.out.println(input ^ 0);
    }

    //    XOR of two chars
    public static void xorWithAsciiValues(char input1, char input2) {
        System.out.println(input1 ^ input2);
    }

    //    XOR of three chars
    public static void xorWithAsciiValues(char input1, char input2, char input3) {
        System.out.println(input1 ^ input2 ^ input3);
    }

    public static void main(String[] args) {
        int i0 = 0, i1 = 1, i2 = 2;
        System.out.println(i0 ^ i1);
        System.out.println(i0 ^ i0);
        System.out.println(i1 ^ i2);
        System.out.println(i2 ^ i2); // E = 0
        System.out.println(10 ^ 11); // E = 1
        System.out.println(12 ^ 11); // E = 3
        System.out.println(14 ^ 11); // E = 5

        TestXor.xorWithAsciiValues('a');        // expected = 97; actual = 97
        TestXor.xorWithAsciiValues('b');        // expected = 98; actual = 98
        TestXor.xorWithAsciiValues('c');        // expected = 99; actual = 99

        TestXor.xorWithAsciiValues('a', 'b');           // expected = 3; actual = 3
        TestXor.xorWithAsciiValues('a', 'c');           // expected = 2; actual = 2

        TestXor.xorWithAsciiValues('a', 'b', 'c');      // expected = 96; actual = 96

    }
}
