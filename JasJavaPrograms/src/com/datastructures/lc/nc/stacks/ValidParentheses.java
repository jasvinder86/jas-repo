package com.datastructures.lc.nc.stacks;

import java.util.Stack;

public class ValidParentheses {


    public boolean isValid(String s) {

//         1. If incoming string is of odd length, return false.
        if (s.length() % 2 != 0)
            return false;

//         2. Else, keep pushing the opening brackets onto a stack.
//         3. If its a closing bracket, peek the stack to verify if the peek element corresponds to the incoming. If yes, pop it.
//         4. After the entire string's travsersal, stack should get empty if its a valid string.

        char[] charArray = s.toCharArray();

        Stack<Character> stack = new Stack();

        for (int i = 0; i < charArray.length; i++) {

            if (charArray[i] == '(' || charArray[i] == '[' || charArray[i] == '{') // push the elements
                stack.push(charArray[i]);

            else if (!stack.isEmpty() && charArray[i] == ')' && stack.peek() == '(')
                stack.pop();

            else if (!stack.isEmpty() && charArray[i] == ']' && stack.peek() == '[')
                stack.pop();

            else if (!stack.isEmpty() && charArray[i] == '}' && stack.peek() == '{')
                stack.pop();

//              If the peek and the incoming don't match e.g. s = "})]", since they haven't been pushed in the first place, they
//              won't be compared and the stack will remain empty. Counter this by returning false in rest of the cases.
            else
                return false;

        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("([}}])")); // Expected = false, Actual = false
        System.out.println(validParentheses.isValid("(())")); // Expected = true, Actual = true
        System.out.println(validParentheses.isValid("({[]})")); // Expected = true, Actual = true
        System.out.println(validParentheses.isValid("({[}{]})")); // Expected = false, Actual = false
        System.out.println(validParentheses.isValid("()[]{}")); // Expected = true, Actual = true
        System.out.println(validParentheses.isValid("(")); // Expected = false, Actual = false
        System.out.println(validParentheses.isValid("")); // Expected = true, Actual = true
    }


}
