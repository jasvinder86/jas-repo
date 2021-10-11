package com.datastructures.ae.linkedlist;

public class Q6_ReverseLinkedList {
    public static LinkedList reverseLinkedList(LinkedList head) {
        // Write your code here.

        LinkedList leftNode = null;
        LinkedList middleNode = head;
        LinkedList rightNode = head.next;

        while (rightNode != null) {
            middleNode.next = leftNode;
            leftNode = middleNode;
            middleNode = rightNode;
            rightNode = rightNode.next;
        }
        middleNode.next = leftNode;

        return middleNode;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
