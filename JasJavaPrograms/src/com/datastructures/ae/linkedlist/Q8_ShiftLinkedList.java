package com.datastructures.ae.linkedlist;

public class Q8_ShiftLinkedList {


    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        // Write your code here.

//        1. find length of the list
        int length = 0;
        LinkedList currentNode = head;
        LinkedList newHead = null;
        int traverseCount;
        LinkedList newCurrentNode;

        while (currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }

        if (k > 0) {
//            shift the list forward or towards left
            traverseCount = length - k;

            currentNode = head;
            while (traverseCount > 1) {
                currentNode = currentNode.next;
                traverseCount--;
            }
            newHead = currentNode.next;
            currentNode.next = null;

//            traverse the new list till its null
            newCurrentNode = newHead;
            while (newCurrentNode.next != null) {
                newCurrentNode = newCurrentNode.next;
            }
            newCurrentNode.next = head;
        } else {
//            k < 0 => shift backwards or left
            traverseCount = -k;
            currentNode = head;
            while (traverseCount > 1) {
                currentNode = currentNode.next;
                traverseCount--;
            }
            newHead = currentNode.next;
            currentNode.next = null;

//            traverse the new list till its null
            newCurrentNode = newHead;
            while (newCurrentNode.next != null) {
                newCurrentNode = newCurrentNode.next;
            }
            newCurrentNode.next = head;

        }

        return newHead;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }


}
