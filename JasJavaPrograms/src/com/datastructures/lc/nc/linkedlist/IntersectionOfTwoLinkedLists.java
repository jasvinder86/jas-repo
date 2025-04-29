package com.datastructures.lc.nc.linkedlist;

/*
 * LeetCode #160 https://leetcode.com/problems/intersection-of-two-linked-lists/
 * */

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
    }
}

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        1. Base Case - if either of the lists is null, return null
        if (headA == null || headB == null)
            return null;

//        2. If the two lists were of equal size, the node which is common in both would have been the answer.
//        So, in this case when they're unequal, traverse list 1 fully and then start traversing list 2.
//        Similarly, traverse list 2 fully and then list 1. When the pointer of both lists are equal, that
//        is the intersection point of the lists.

//        How to ideate?
//        Think about the easiest way i.e. when both the lists had the same length and then try to equate the
//        lengths of these lists.

//        Keep the heads at their original positions and take two pointers to the heads; traverse using
//        these pointers.

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        while (pointerA != pointerB) {

            if (pointerA != null) {
                pointerA = pointerA.next;
            } else {
                pointerA = headB;
            }

            if (pointerB != null) {
                pointerB = pointerB.next;
            } else {
                pointerB = headA;
            }
        }
        return pointerA;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists intersectionOfTwoLinkedLists = new IntersectionOfTwoLinkedLists();
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(9);
        headA.next.next = new ListNode(1);
        headA.next.next.next = new ListNode(2);
        headA.next.next.next.next = new ListNode(4);

        ListNode headB = new ListNode(3);
        headB.next = headA.next.next.next;
        headB.next.next = headA.next.next.next.next;

        System.out.println(intersectionOfTwoLinkedLists.getIntersectionNode(headA, headB).data);
    }
}
