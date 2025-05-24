package com.datastructures.gtci.pattern2.twoPointers;

/* Given the head of a singly linked list and an integer n, remove the nth node from the end of the list and return the head of the modified list. */

// Optimized approach

public class RemoveNodeFromEndOfList {

    public static void main(String[] args) {
        RemoveNodeFromEndOfList object = new RemoveNodeFromEndOfList();

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

        System.out.println(object.getTheHeadNodeAfterRemovalOfNthNode(head, 8).data);
        System.out.println(object.getTheHeadNodeAfterRemovalOfNthNode(head, 1).data);
        System.out.println(object.getTheHeadNodeAfterRemovalOfNthNode(head, 4).data);
    }

    public Node getTheHeadNodeAfterRemovalOfNthNode(Node head, int n) {

//            1. Take two pointers; keep them at head initially.
//            2. Move the right pointer by n steps for an initial run-up.
//            3. Now when RP is at n steps, start moving both LP and RP until RP is null. At this point, LP would have reached n steps from null.
        Node leftPointer = head, rightPointer = head;
        while (n != 0) {
            rightPointer = rightPointer.next;
            n--;
        }

        if (rightPointer == null) { // This happens when right has moved to the last node and left is still at head because n = length of the list.
            head = head.next;
            return head;
        }

        while (rightPointer.next != null) {
            leftPointer = leftPointer.next;
            rightPointer = rightPointer.next;
        }

        leftPointer.next = (leftPointer.next.next != null) ? leftPointer.next.next : null;

        return head;
    }
}

