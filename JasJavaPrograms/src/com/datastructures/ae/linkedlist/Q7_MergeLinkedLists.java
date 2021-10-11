package com.datastructures.ae.linkedlist;

public class Q7_MergeLinkedLists {

    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }

    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        // Write your code here.

        LinkedList a = null, b = headOne, c = headTwo;
        while (b != null && c != null) {

            if (b.value < c.value) {
                a = b;
                b = b.next;
            } else {
                if (a != null) {
                    a.next = c;
                }
                a = c;
                c = c.next;
                a.next = b;
            }
        }

        if (b == null) {
            a.next = c;
        }

        return headOne.value < headTwo.value ? headOne : headTwo;
    }

    public LinkedList appendToLinkedList(LinkedList list, int data) {
        LinkedList newNode = new LinkedList(data);

        if (list == null) {
            list = newNode;
        } else {
            LinkedList currentNode = list;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        return list;
    }

    public static void main(String[] args) {

        Q7_MergeLinkedLists object = new Q7_MergeLinkedLists();

        LinkedList list1 = new LinkedList(1);
        object.appendToLinkedList(list1, 3);
        object.appendToLinkedList(list1, 5);


        LinkedList list2 = new LinkedList(2);
        object.appendToLinkedList(list2, 4);
        object.appendToLinkedList(list2, 6);


        LinkedList finalHead = mergeLinkedLists(list1, list2);
        System.out.println(finalHead.value);

    }

}
