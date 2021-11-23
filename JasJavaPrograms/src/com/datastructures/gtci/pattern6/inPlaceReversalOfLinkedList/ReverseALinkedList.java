package com.datastructures.gtci.pattern6.inPlaceReversalOfLinkedList;

class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }
}

// Confirm my solution with theirs

public class ReverseALinkedList {

    public static ListNode reverse(ListNode head) {
        ListNode previousNode = null;
        ListNode currentNode;

        while (head.next != null) {
            currentNode = head;
            head = head.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
        }
        head.next = previousNode;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);

        ListNode result = ReverseALinkedList.reverse(head);
        System.out.print("Nodes are ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
