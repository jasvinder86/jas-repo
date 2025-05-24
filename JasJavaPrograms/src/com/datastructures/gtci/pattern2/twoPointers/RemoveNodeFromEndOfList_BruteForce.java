package com.datastructures.gtci.pattern2.twoPointers;

/* Given the head of a singly linked list and an integer n, remove the nth node from the end of the list and return the head of the modified list. */

//Works fine but is brute force.

class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveNodeFromEndOfList_BruteForce {


    public static void main(String[] args) {
        RemoveNodeFromEndOfList_BruteForce object = new RemoveNodeFromEndOfList_BruteForce();

        Node head = new Node(0);
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);
        Node n6 = new Node(60);
        Node n7 = new Node(70);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        System.out.println(object.getTheHeadNodeAfterRemovalOfNthNodeBruteForce(head, 8).data);
        System.out.println(object.getTheHeadNodeAfterRemovalOfNthNodeBruteForce(head, 2).data);
        System.out.println(object.getTheHeadNodeAfterRemovalOfNthNodeBruteForce(head, 1).data);
        System.out.println(object.getTheHeadNodeAfterRemovalOfNthNodeBruteForce(head, 4).data);

    }

    public Node getTheHeadNodeAfterRemovalOfNthNodeBruteForce(Node head, int n) {

//        1. Traverse till the end of the list to know its length 'l'
//        2. Case1: If l == n, it means it's the head node. simply move the head to its next; head = head.next
//        3. Case2: Else if, n == 1, means it's the last node of this list
//        left pointer (LP) = l-n; traverse till LP, make it point to null.
//        e.g. if l = 7, n = 1, remove the 6th from the head, so LP = 7-1 = 6
//        4. Else, LP = l-n and RP = l-n+2, then make LP point to RP.

//        Drawback = first iteration for finding the length of the list, actual operation happens in the next iteration.
//        TC -> O(n+n) = O(n)

//        Case0:
        int listLength = 1;
//        find the length
        Node tempNode = head;
        while (tempNode.next != null) {
            listLength++;
            tempNode = tempNode.next;
        }

//        Case1:
        if (listLength == n) {
            head = head.next;
        } else if (n == 1) {
            int counter = 1;
            Node leftPointer = head;
            while (counter != listLength - 1) {
                leftPointer = leftPointer.next;
                counter++;
            }
            leftPointer.next = null;
        } else {
            int counter = 1;
            Node leftPointer = head;
            Node rightPointer = head;

            while (counter != listLength - n) {
                leftPointer = leftPointer.next;
                rightPointer = rightPointer.next;
                counter++;
            }
            rightPointer = rightPointer.next.next;
            leftPointer.next = rightPointer;

        }

        return head;

    }

}

