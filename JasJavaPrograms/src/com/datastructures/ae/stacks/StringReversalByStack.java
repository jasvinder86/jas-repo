package com.datastructures.ae.stacks;

import java.util.EmptyStackException;
import java.util.Stack;

public class StringReversalByStack {

    Node top;
    int length;


    public StringReversalByStack() {
        Node top = null;
    }

    class Node {
        char data;
        Node next;

        public Node(char inputChar) {
            this.data = inputChar;
        }
    }

    public void push(char inputChar) {
        Node charNode = new Node(inputChar);
        charNode.next = top;
        top = charNode;
        length++;
    }

    public char pop() {
        if (length == 0) {
            throw new EmptyStackException();
        }
        char outputChar = top.data;
        top = top.next;
        length--;
        return outputChar;
    }

    public String reverseTheString(String inputString) {
        int length = inputString.length();
        Stack<Character> myStack = new Stack<>();
        char[] charArray = inputString.toCharArray();
        for (char c : charArray) {
            myStack.push(c);
        }

        for (int i = 0; i < length; i++) {
            charArray[i] = myStack.pop();
        }

        return new String(charArray);
    }

    public static void main(String[] args) {
        StringReversalByStack stringReversalByStack = new StringReversalByStack();
        System.out.println(stringReversalByStack.reverseTheString("Kulveen Kaur"));
        System.out.println(stringReversalByStack.reverseTheString("jasvinder"));


    }

}
