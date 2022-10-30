package com.datastructures.gtci.dp;

public class FibonacciByRecursionAndMemoization {

    int recursionCounter = 0;
    int memoizationCounter = 0;

    public long getFibonacciByRecursion(int input) {
        System.out.println("recursionCounter >> " + ++recursionCounter);
//        Simply put, add the previous two's result to get the current input's fibonacci output.
//        input:    1 2 3 4 5 6  7  8
//        output:   1 1 2 3 5 8 13 21

//        Now since we have to add just the last two, the base case comes down to input = 1 and 2
//        which return 1 each.

        if (input <= 2)
            return 1;

        return getFibonacciByRecursion(input - 1) + getFibonacciByRecursion(input - 2);
        //        TC = O(2^n) and SC = O(n)
    }


    public long getFibonacciByMemoization(int input) {
        long[] memoArray = new long[input + 1];
//        Since each number can be calculated by its predecessors,
//        memoize each input's value to avoid re-calculation.

//        Create a new array and keep populating it with each input's output and then pass this array
//        to the next call so that they make use of the previous outputs directly.

        return getFibonacciByMemoizationImpl(input, memoArray);
    }

    public long getFibonacciByMemoizationImpl(int input, long[] memoArray) {
        System.out.println("memoizationCounter >> " + ++memoizationCounter);

        if (memoArray[input] != 0) {
            return memoArray[input];
        }

        if (input <= 2)
            return 1;   // input = 1

        memoArray[input] = getFibonacciByMemoizationImpl(input - 1, memoArray) + getFibonacciByMemoizationImpl(input - 2, memoArray);
        return memoArray[input];
        //        TC = O(n) and SC = O(n)
    }


    public static void main(String[] args) {

        System.out.println("fib of 1 >> " + new FibonacciByRecursionAndMemoization().getFibonacciByMemoization(1));
        System.out.println("fib of 2 >> " + new FibonacciByRecursionAndMemoization().getFibonacciByMemoization(2));
        System.out.println("fib of 3 >> " + new FibonacciByRecursionAndMemoization().getFibonacciByMemoization(3));
        System.out.println("fib of 4 >> " + new FibonacciByRecursionAndMemoization().getFibonacciByMemoization(4));
        System.out.println("fib of 5 >> " + new FibonacciByRecursionAndMemoization().getFibonacciByMemoization(5));
        System.out.println("fib of 6 >> " + new FibonacciByRecursionAndMemoization().getFibonacciByMemoization(6));
        System.out.println("fib of 7 >> " + new FibonacciByRecursionAndMemoization().getFibonacciByMemoization(7));
        System.out.println("fib of 10 >> " + new FibonacciByRecursionAndMemoization().getFibonacciByMemoization(10));
        System.out.println("fib of 50 >> " + new FibonacciByRecursionAndMemoization().getFibonacciByMemoization(50));


        System.out.println("fib of 1 >> " + new FibonacciByRecursionAndMemoization().getFibonacciByRecursion(1));
        System.out.println("fib of 2 >> " + new FibonacciByRecursionAndMemoization().getFibonacciByRecursion(2));
        System.out.println("fib of 3 >> " + new FibonacciByRecursionAndMemoization().getFibonacciByRecursion(3));
        System.out.println("fib of 4 >> " + new FibonacciByRecursionAndMemoization().getFibonacciByRecursion(4));
        System.out.println("fib of 10 >> " + new FibonacciByRecursionAndMemoization().getFibonacciByRecursion(10));
        System.out.println("fib of 50 >> " + new FibonacciByRecursionAndMemoization().getFibonacciByRecursion(50));
    }
}
