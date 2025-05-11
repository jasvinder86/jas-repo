package com.datastructures.lc.nc.string;

public class StringOperations {
    public static void main(String[] args) {
        System.out.println("String reversal");
        System.out.println("abcd" + " --> " + StringOperations.reverseTheString("abcd"));
        System.out.println("a b c d" + " --> " + StringOperations.reverseTheString("a b c d"));
        System.out.println("   a b c d   " + " --> " + StringOperations.reverseTheString("   a b c d   "));

        System.out.println("\nSentence reversal");
        System.out.println("Hello to the world!" + "-->" + StringOperations.reverseTheSentence("Hello to the world!"));
        System.out.println("  Hello to the world with leading and trailing spaces!  " + "-->" + StringOperations.reverseTheSentence("  Hello to the world with leading and trailing spaces!  "));

        System.out.println("\nWord order reversal");
        System.out.println("Hello to the world" + "-->" + StringOperations.reverseTheWordOrder("Hello to the world"));

    }

    //    abcd -> dcba
    public static String reverseTheString(String inputString) {
        StringBuilder reversedString = new StringBuilder("");

        for (int index = inputString.length() - 1; index >= 0; index--) {
            reversedString.append(inputString.charAt(index));
        }
//        return reversedString.toString().trim(); // removes all leading and trailing spaces.
        return reversedString.toString();
    }

    //    Hello to the world!-->!dlrow eht ot olleH
    //      Hello to the world with leading and trailing spaces!  -->  !secaps gniliart dna gnidael htiw dlrow eht ot olleH
    public static String reverseTheSentence(String inputString) {
        StringBuilder reversedSentence = new StringBuilder("");
        for (int index = inputString.length() - 1; index >= 0; index--) {
            reversedSentence.append(inputString.charAt(index));
        }
        return reversedSentence.toString();
    }

    //    Hello to the world --> world the to Hello
    public static String reverseTheWordOrder(String inputString) {
        String[] words = inputString.split(" ");
        StringBuilder reversedWords = new StringBuilder();
        for (int index = words.length - 1; index >= 0; index--) {
            reversedWords.append(words[index]).append(" ");
        }
        return reversedWords.toString().trim();
    }
}
