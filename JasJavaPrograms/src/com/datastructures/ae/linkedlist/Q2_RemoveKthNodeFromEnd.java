package com.datastructures.ae.linkedlist;

import java.util.*;

public class Q2_RemoveKthNodeFromEnd {

    static LinkedList head;

    public static void appendToLinkedList(int data) {
        LinkedList newNode = new LinkedList(data);

        if (null == head) {
            head = newNode;
        } else {
            LinkedList currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }

    }


    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        // Write your code here.

//        1. find length of the list
        LinkedList currentNode = head;
        int length = 0;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }

//        2. find the kth node to remove
        int nodeNumberToRemove = length - k;

        if (nodeNumberToRemove == 0) {
//            => head has to be removed

//              doesn't work
//            head = head.next;

//              doesn't work
//            currentNode = head;
//            currentNode = currentNode.next;xm
//            head = currentNode;
//            head.next = currentNode.next;

//            Below solution works well. It copies value of head+1 into head and then makes head point to its next.next,
//            thereby removing the head.next. Although the right value gets removed, but in actual its not the head that was
//            removed but a copy of the next node was passed to head and then the head.next was removed
            head.value = head.next.value;
            head.next = head.next.next;


//            This solution will also work but this uses a new list and the constraint is to mutate the existing list.
//            Hence this solution will not be apt.
//            LinkedList tempNode = head.next;
//            head = null;
//            head = tempNode;
//            head.next = tempNode.next;


        } else {
//            => some other node has to be removed
            currentNode = head;
            int nodeCounter = 1;
            while (nodeCounter != nodeNumberToRemove) {
                currentNode = currentNode.next;
                nodeCounter++;
            }
//            while loop breaks when we reach 1 before the target node to remove
            currentNode.next = currentNode.next.next;

        }

    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Q2_RemoveKthNodeFromEnd.appendToLinkedList(1);
        Q2_RemoveKthNodeFromEnd.appendToLinkedList(2);
        Q2_RemoveKthNodeFromEnd.appendToLinkedList(3);
        Q2_RemoveKthNodeFromEnd.appendToLinkedList(4);

        Q2_RemoveKthNodeFromEnd.removeKthNodeFromEnd(head, 4);

    }

}

