package com.datastructures.ae.stacks;

import java.util.EmptyStackException;

public class StackImplementation {

    //    Indicates the top of the stack
    Node top;
    int length = 0;

    // Nodes that will reside in stack will be created from here.
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
        length++;
    }

    public int pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        int nodeData = top.data;
        top = top.next;
        length--;
        return nodeData;
    }

    public int getStackLength() {
        return length;
    }

    public int peek() {
        if (getStackLength() == 0) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public static void main(String[] args) {
        StackImplementation stackImplementation = new StackImplementation();
        System.out.println(stackImplementation.getStackLength());
        stackImplementation.push(10);
        stackImplementation.push(20);
        stackImplementation.push(30);
        stackImplementation.push(40);
        System.out.println(stackImplementation.getStackLength());
        System.out.println(stackImplementation.peek());
        stackImplementation.pop();
        System.out.println(stackImplementation.peek());
        System.out.println(stackImplementation.getStackLength());
        stackImplementation.pop();
        System.out.println(stackImplementation.peek());
        System.out.println(stackImplementation.getStackLength());
        stackImplementation.push(50);
        System.out.println(stackImplementation.peek());
        System.out.println(stackImplementation.getStackLength());
        stackImplementation.push(60);
        System.out.println(stackImplementation.peek());
        System.out.println(stackImplementation.getStackLength());
        System.out.println(stackImplementation.peek());
        stackImplementation.pop();
        System.out.println(stackImplementation.peek());

    }

}
