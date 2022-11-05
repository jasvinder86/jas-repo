package com.datastructures.agoda;

/*
 * Add two numbers when carry is not allowed.
 * */
public class SumWithoutCarry {

//    x = 66, y = 55, sum = 121
//    x = 9766, y = 55, sum = 9821

    int carry = 0;
    int sum = 0;
    int interimSum = 0;

    int power = 0;

    public int add(int x, int y) {
        while (x > 0 || y > 0) {
            interimSum = x % 10 + y % 10 + carry;
            carry = interimSum / 10;

            x = x / 10;
            y = y / 10;

            sum = (int) (Math.pow(10, power) * (interimSum % 10) + sum);
            power++;
        }
        sum = (int) ((Math.pow(10, power)) * carry + sum);

        return sum;
//        TC = since the while loops goes till the length of the bigger input number, TC = O(n) where 'n' is the length of the larger number.
//        SC = O(1) since no extra space has been used in this operation.
    }

    public static void main(String[] args) {
        System.out.println("Original sum is : " + (99990879 + 654) + " and by this method is " + new SumWithoutCarry().add(99990879, 654));
        System.out.println("Original sum is : " + (879 + 654) + " and by this method is " + new SumWithoutCarry().add(879, 654));
        System.out.println("Original sum is : " + (76 + 654) + " and by this method is " + new SumWithoutCarry().add(76, 654));
        System.out.println("Original sum is : " + (1 + 9) + " and by this method is " + new SumWithoutCarry().add(1, 9));
        System.out.println("Original sum is : " + (1111 + 9999) + " and by this method is " + new SumWithoutCarry().add(1111, 9999));
        System.out.println("Original sum is : " + (66 + 55) + " and by this method is " + new SumWithoutCarry().add(66, 55));
        System.out.println("Original sum is : " + (9766 + 55) + " and by this method is " + new SumWithoutCarry().add(9766, 55));
    }

}
