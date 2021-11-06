package com.datastructures.gtci.pattern3.fastSlowPointers;

// Given the head of a Singly LinkedList that contains a cycle,
// write a function to find the starting node of the cycle.

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
    }
}

public class StartOfLinkedListCycle {

//    My analysis
//    1. First find if the cycle exists by using slow and fast pointers.
//    2. When the 2 pointers in step 1 meet, call it the meeting point.
//    3. Find length of the cycle by moving the slow pointer till it reaches the meeting point.
//    4. Start P1 and P2 at the head and then move P2 forward by the length of the cycle.
//    5. Now keep moving both the pointers by 1. Where they meet will be the start of the cycle.

    public static ListNode findCycleStart(ListNode head) {
        ListNode slowPointer = head, fastPointer = head;

        //        1. First find if the cycle exists by using slow and fast pointers.
        do {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        } while (slowPointer != fastPointer);

        //        2. When the 2 pointers in step 1 meet, call it the meeting point.
        ListNode meetingPoint = slowPointer;

        //    3. Find length of the cycle by moving the slow pointer till it reaches the meeting point.
        int cycleLength = 0;
        do {
            slowPointer = slowPointer.next;
            cycleLength++;
        } while (slowPointer != meetingPoint);

        //    4. Start P1 and P2 at the head and then move P2 forward by the length of the cycle.
        ListNode pointer1 = head, pointer2 = head;
        for (int i = 0; i < cycleLength; i++) {
            pointer2 = pointer2.next;
        }

        //    5. Now keep moving both the pointers by 1. Where they meet will be the start of the cycle.
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        //     6. Now when these 2 meet, marks the starts of the cycle.
        return pointer1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("Start of the cycle is " + StartOfLinkedListCycle.findCycleStart(head).data);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("Start of the cycle is " + StartOfLinkedListCycle.findCycleStart(head).data);

        head.next.next.next.next.next.next = head;
        System.out.println("Start of the cycle is " + StartOfLinkedListCycle.findCycleStart(head).data);
    }

}
