package com.datastructures.gtci.misc;

/*
 * 13abd32def22 -> 67
 * 8j9i2o3 -> 22
 *  */
public class FilterAndAddNumerals {

    public static void main(String[] args) {
        System.out.println(getSum("A1B2C33D444")); // expected o/p = 480
        System.out.println(getSum("A11B22C33D44")); // expected o/p = 110
        System.out.println(getSum("1234567")); // expected o/p = 1234567

        System.out.println(sumNumbersFromString("A1B2C33D444")); // expected o/p = 480
        System.out.println(sumNumbersFromString("A11B22C33D44")); // expected o/p = 110
        System.out.println(sumNumbersFromString("1234567")); // expected o/p = 1234567

    }

    public static int getSum(String input) {
        double interimSum = 0;
        StringBuffer interimSB = new StringBuffer();
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isDigit(charArray[i])) {
                interimSB.append(charArray[i]);
                while (i + 1 < charArray.length && Character.isDigit(charArray[i + 1])) {
                    interimSB.append(charArray[i + 1]);
                    i++;
                }
                interimSum += Integer.valueOf(interimSB.toString());
                interimSB.setLength(0);
            }
        }
        return (int) interimSum;
    }

    //    Better code from ChatGPT but the solution approach is the same as mine.
    public static int sumNumbersFromString(String input) {
        int sum = 0;
        StringBuilder number = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                number.append(c);
            } else {
                if (number.length() > 0) {
                    sum += Integer.parseInt(number.toString());
                    number.setLength(0); // clear the buffer
                }
            }
        }

        // If the string ends with a number
        if (number.length() > 0) {
            sum += Integer.parseInt(number.toString());
        }

        return sum;
    }

}
