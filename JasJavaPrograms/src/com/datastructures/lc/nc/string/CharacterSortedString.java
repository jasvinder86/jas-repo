package com.datastructures.lc.nc.string;

import java.util.*;
import java.util.stream.Collectors;

/*

🔹 Question Prompt 1: Basic Alphabetical Sort (Ignore case, only letters)
Q:
Write a Java program that takes a string as input and returns the characters sorted alphabetically. Ignore case sensitivity and exclude non-alphabetic characters.

Example Input: "zebra123APPLE!"
Expected Output: "AABEELPPRZ"

🔹 Question Prompt 2: Preserve original case and include all characters
Q:
Write a Java program that takes a string and returns a new string with all characters sorted by their ASCII values. Preserve the case and include digits, punctuation, and spaces.

Example Input: "zebra123APPLE!"
Expected Output: "!123AAPELPRZabe" (sorted by ASCII)

🔹 Question Prompt 3: Custom sort - vowels first, then consonants, then digits
Q:
Given a string, sort and return the characters such that all vowels come first (in order), then consonants, and finally digits. Ignore special characters.

Example Input: "zebra123APPLE!"
Expected Output: "AEaePPLLbrz123" (vowels → consonants → digits)

*/
public class CharacterSortedString {
    public static void main(String[] args) {
        System.out.println("Return alphabets only");
        System.out.println(CharacterSortedString.createStringWithAlphabetsOnly("9876541ng23008"));
        System.out.println(CharacterSortedString.createStringWithAlphabetsOnly("ac12456jedc"));
        System.out.println(CharacterSortedString.createStringWithAlphabetsOnly("n a a b"));
        System.out.println(CharacterSortedString.createStringWithAlphabetsOnly("zebra123APPLE!"));

        System.out.println("\nReturn all alphabets in sorted order");
        System.out.println(CharacterSortedString.returnSortedAlphabetsUsingSortOfCollections("9876541ng23008"));
        System.out.println(CharacterSortedString.returnSortedAlphabetsUsingSortOfCollections("ac12456jedc"));
        System.out.println(CharacterSortedString.returnSortedAlphabetsUsingSortOfCollections("n a a b"));
        System.out.println(CharacterSortedString.returnSortedAlphabetsUsingSortOfCollections("zebra123APPLE!"));

        System.out.println("\nReturn all characters in sorted order");
        System.out.println(CharacterSortedString.returnSortedString("9876541ng23008"));
        System.out.println(CharacterSortedString.returnSortedString("ac12456jedc"));
        System.out.println(CharacterSortedString.returnSortedString("n a a b"));
        System.out.println(CharacterSortedString.returnSortedString("zebra123APPLE!"));

        System.out.println("\nCustom sort - vowels first, then consonants, then digits, and finally special characters");
        System.out.println("zebra123APPLE! -> " + CharacterSortedString.customOrder("zebra123APPLE!"));


//        System.out.println(CharacterSortedString.returnSortedStringWithStreams("987654123008"));
//        System.out.println(CharacterSortedString.returnSortedStringWithStreams("ac12456jedc"));
//        System.out.println(CharacterSortedString.returnSortedStringWithStreams(""));

    }

    //    Brute Force
//    Simplest problem: create a string that contains only alphabets, then sort it
    public static String createStringWithAlphabetsOnly(String input) {
        StringBuilder bufferString = new StringBuilder();
        for (int index = 0; index < input.length(); index++) {
            char currentChar = input.charAt(index);
            if ((currentChar >= 'a' && currentChar <= 'z') || (currentChar >= 'A' && currentChar <= 'Z'))
                bufferString.append(currentChar);
        }
        return bufferString.toString();
    }

    public static String returnSortedString(String inputString) {
//        Convert the string to an array and then apply Arrays.sort()
        char[] charArray = inputString.toCharArray();
        Arrays.sort(charArray);
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static String returnSortedAlphabetsUsingSortOfCollections(String inputString) {

        List<Character> charList = new ArrayList<>();

        for (char ch : inputString.toCharArray()) {
            if (Character.isLetter(ch)) {
                charList.add(ch);
            }
        }
        Collections.sort(charList);
        StringBuilder sb = new StringBuilder();
        for (char ch : charList) {
            sb.append(ch);
        }

        return sb.toString();
    }

    //    Custom sort - vowels first, then consonants, then digits and special characters at the end
    public static String customOrder(String inputString) {

        List<Character> vowelPart = new ArrayList<>();
        List<Character> consonantPart = new ArrayList<>();
        List<Character> digitPart = new ArrayList<>();
        List<Character> specialCharactersPart = new ArrayList<>();
        String vowels = "aeiouAEIOU";

        char[] charArray = inputString.toCharArray();
        for (char c : charArray) {
            if (Character.isDigit(c)) {
                digitPart.add(c);
            } else if (vowels.contains(String.valueOf(c))) {
                vowelPart.add(c);
            } else if (Character.isLetter(c)) { // so far, digits and vowels have been captured, so only consonants and special characters would have remained.
                consonantPart.add(c);
            } else specialCharactersPart.add(c);
        }

        Comparator<Character> characterComparatorComparator = (c1, c2) -> {
            return c1.compareTo(c2);
        };

//        Collections.sort(vowelPart, characterComparatorComparator);
        Collections.sort(vowelPart);
        consonantPart.sort(characterComparatorComparator);
        digitPart.sort(characterComparatorComparator);
        Collections.sort(specialCharactersPart, characterComparatorComparator);

        StringBuilder outputString = new StringBuilder();

        for (char c : vowelPart) {
            outputString.append(c);
        }
        for (char c : consonantPart) {
            outputString.append(c);
        }
        for (char c : digitPart) {
            outputString.append(c);
        }
        for (char c : specialCharactersPart) {
            outputString.append(c);
        }
        return outputString.toString();
    }


    //    Not working as expected. Scope of improvement is there.
    public static String returnSortedStringWithStreams(String inputString) {
//        Convert the string to an array / list to stream it.

        char[] charArray = inputString.toCharArray();
        StringBuilder sb = new StringBuilder();

        Arrays.asList(charArray).stream().sorted().collect(Collectors.toList());
        return sb.toString();
    }
}
