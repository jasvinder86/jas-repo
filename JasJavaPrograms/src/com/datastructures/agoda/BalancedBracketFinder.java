package com.datastructures.agoda;

import java.util.Stack;

/*
 * {{}}, {[()]} are balanced, whereas, [}, {), ][, )(, }{ are not. Find if a given bracket sequence is balanced or not.
 * */
public class BalancedBracketFinder {

    public boolean areTheBracketsBalanced(String s) {

//        Base check 1: if length == 0, return true.
        if (s.length() == 0)
            return true;

//        Base check 2: if length of the input is odd, return false.
        if (s.length() % 2 != 0)
            return false;


//        1. If an open bracket is found, push it to a stack.
//        2. If closed is found, the peek value should correspond to its corresponding open bracket.

        Stack<Character> bracketStack = new Stack<>();

        for (char i : s.toCharArray()) {

            if (i == '(' || i == '{' || i == '[') {
                bracketStack.push(i);
            } else if (i == ']' && !bracketStack.isEmpty() && bracketStack.peek() == '[')
                bracketStack.pop();
            else if (i == '}' && !bracketStack.isEmpty() && bracketStack.peek() == '{')
                bracketStack.pop();
            else if (i == ')' && !bracketStack.isEmpty() && bracketStack.peek() == '(')
                bracketStack.pop();
            else
                return false;
        }
        return bracketStack.isEmpty();
    }

    public static void main(String[] args) {
        BalancedBracketFinder balancedBracketFinder = new BalancedBracketFinder();
        System.out.println(balancedBracketFinder.areTheBracketsBalanced("([}}])"));     // Expected = false; Actual = false
        System.out.println(balancedBracketFinder.areTheBracketsBalanced("{}[]()"));     // Expected = true; Actual = true
        System.out.println(balancedBracketFinder.areTheBracketsBalanced("{[()]}{[()]}{[()]}{[()]}"));   // Expected = true; Actual = true
        System.out.println(balancedBracketFinder.areTheBracketsBalanced("{{{{[[[[(((("));   // Expected = false; Actual = false
        System.out.println(balancedBracketFinder.areTheBracketsBalanced("}]){[("));   // Expected = false; Actual = false
        System.out.println(balancedBracketFinder.areTheBracketsBalanced("{{(([[]]))}}"));   // Expected = true; Actual = true
        System.out.println(balancedBracketFinder.areTheBracketsBalanced("abc"));    // Expected = false; Actual = false
        System.out.println(balancedBracketFinder.areTheBracketsBalanced(""));   // Expected = true; Actual = true
    }

}
