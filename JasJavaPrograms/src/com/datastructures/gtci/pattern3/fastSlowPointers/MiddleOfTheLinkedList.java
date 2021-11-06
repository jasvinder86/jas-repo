package com.datastructures.gtci.pattern3.fastSlowPointers;

public class MiddleOfTheLinkedList {

    //    ListNode has been defined in the StartOfLinkedListCycle. Reusing that here.
    public static ListNode getMiddleNode(ListNode head) {

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Middle node is " + MiddleOfTheLinkedList.getMiddleNode(head).data);

        head.next.next.next.next.next = new ListNode(6);
        System.out.println("Middle node is " + MiddleOfTheLinkedList.getMiddleNode(head).data);

        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println("Middle node is " + MiddleOfTheLinkedList.getMiddleNode(head).data);
    }
}
