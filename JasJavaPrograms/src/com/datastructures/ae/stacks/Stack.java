package com.datastructures.ae.stacks;

public class Stack {

    private int length;
    private List top;

    class List {
        int data;
        List next;

        List(int data) {
            this.data = data;
        }

    }

    public void push(int data) {
        List newNode = new List(data);
        newNode.next = top;
        top = newNode;
        length++;
    }

    public int peek() {
//        if (length == 0)
        return top.data;
    }

    public int pop() {
        int poppedData = top.data;
        top = top.next;
        length--;
        return poppedData;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
//        System.out.println(stack.peek());
        stack.push(1);

        stack.push(2);

        stack.push(3);

        stack.push(4);
        stack.pop();
        stack.push(5);
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }

}
