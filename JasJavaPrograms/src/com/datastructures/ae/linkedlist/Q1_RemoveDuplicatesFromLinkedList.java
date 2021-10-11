package com.datastructures.ae.linkedlist;

import com.datastructures.ae.misc.SinglyLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1_RemoveDuplicatesFromLinkedList {

    public static void main(String[] args) {
        Q1_RemoveDuplicatesFromLinkedList object = new Q1_RemoveDuplicatesFromLinkedList();

    }

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

//    Attempt - didnt work
//    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
//        // Write your code here.
////        LinkedList headNode = null;
//        LinkedList currentNode = null;
//        LinkedList nextNode = null;
//        currentNode = linkedList;
//
//        while (currentNode != null) {
//            while (currentNode.value == currentNode.next.value) {
//                currentNode = currentNode.next;
//            }
//            nextNode = currentNode;
//        }
//        return linkedList;
//    }

    //    Attempt
    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        // Write your code here.

        LinkedList currentNode = linkedList;
        LinkedList nextDistinctNode;

        while (currentNode != null) {
            nextDistinctNode = currentNode.next;

            while (nextDistinctNode != null && currentNode.value == nextDistinctNode.value) {
                nextDistinctNode = nextDistinctNode.next;
            }

            currentNode.next = nextDistinctNode;
            currentNode = nextDistinctNode;
        }

        return linkedList;
    }
}

