package com.datastructures.gtci.recursion;

public class PrimeNumberChecker {
    public static boolean isPrime(int num, int i) {
        // Write your code here
        // Modify the return statement according to "true"
        // or "false" according to your code

//        1. Base Case 1: For inputs < 2, return false
        if (num < 2)
            return false;

//        2. Base Case 2: Since the num has to be divided from n/2 to 1, on reaching 1, return true
        else if (i == 1)
            return true;

//        3. Base Case 3: If num % 2 == 0, return false
        else if (num % i == 0)
            return false;

//        3. Case 4: Keep reducing i and keep dividing num by 2 recursively
        else
            return isPrime(num, --i);
    }

    public static void main(String[] args) {
        int inputNumber = 11;
        boolean flag = PrimeNumberChecker.isPrime(inputNumber, inputNumber / 2);

        if (flag)
            System.out.println("Is prime");
        else
            System.out.println("Is Not prime");
    }
}
