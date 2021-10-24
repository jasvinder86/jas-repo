package com.datastructures.gtci.pattern3.fastSlowPointers;

//Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the square of all of its digits,
// leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’. Instead, they will be stuck in a cycle of numbers which does not include ‘1’.
/*        Example 1:
                Input: 23
                Output: true (23 is a happy number)
                Explanations: Here are the steps to find out that 23 is a happy number:
 23 >> 4+9 >> 13 >> 1+9 >> 10 >> 1+0 >> 1
 */

public class HappyNumber {
    public boolean find(int num) {
        int slowPointer = num;
        int fastPointer = num;

        slowPointer = getSquareSum(slowPointer);
        fastPointer = getSquareSum(getSquareSum(fastPointer));

        while (slowPointer != fastPointer) {
            slowPointer = getSquareSum(slowPointer);
            fastPointer = getSquareSum(getSquareSum(fastPointer));
        }

//        1. If (slowPointer == fastPointer) => either both have reached 1 or some other number of an infinite loop.
//        2. If 1 has been reached => number is a happy number else not.
//        3. Since both are pointing to the same number now, compare either fat or slow pointer with 1 and return accordingly

        return slowPointer == 1;
    }

    //    Find sum of squares of digits of the given number.
    public int getSquareSum(int num) {
        int squareSum = 0;
        while (num > 0) {
            int remainder = num % 10;
            squareSum = squareSum + (remainder * remainder);
            num = num / 10;
        }
        return squareSum;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.find(23));
        System.out.println(happyNumber.find(12));
        System.out.println(happyNumber.find(678));
    }
}
