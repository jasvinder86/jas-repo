package com.datastructures.ae.linkedlist;

public class Q5_FindLoop {

    public static LinkedList findLoop(LinkedList head) {
        // Write your code here.
        LinkedList fastNode, slowNode;

        fastNode = head.next.next;
        slowNode = head.next;

        while (fastNode != slowNode) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        slowNode = head;
        while (slowNode != fastNode) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }

        return slowNode;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
