package com.datastructures.gtci.pattern11.bitwise.xor;

public class SumOfTwoIntegersWithoutCarry {

    public static int getSumWithoutPlusOperator(int a, int b) {
        int temp = 0;

//        Sum can be calculated by XOR the inputs and the & and moving the bits by 1 position to the left.
//        Repeat this operation till "& <<1" becomes zero.
//        Finally, 'a' is the answer.

        while (b != 0) {
            temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        System.out.println("Output is " + a);
        return a;
    }

    public static void main(String[] args) {
        SumOfTwoIntegersWithoutCarry.getSumWithoutPlusOperator(2, 3);    // expected = 5; actual = 5
        SumOfTwoIntegersWithoutCarry.getSumWithoutPlusOperator(0, 0);    // expected = 0; actual = 0
        SumOfTwoIntegersWithoutCarry.getSumWithoutPlusOperator(-1, -1);    // expected = -2; actual = -2
    }
}
