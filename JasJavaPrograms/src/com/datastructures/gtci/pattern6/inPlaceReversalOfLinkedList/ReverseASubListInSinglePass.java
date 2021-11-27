package com.datastructures.gtci.pattern6.inPlaceReversalOfLinkedList;

public class ReverseASubListInSinglePass {

    /*
    Q:1 p = 2, q = 4
    Input = 1 -> 2 -> 3 -> 4 -> 5
    Output = 1 -> 4 -> 3 -> 2 -> 5

    Input = 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
    Output = 1 -> 2 -> 6 -> 5 -> 4 -> 3 -> 7
    */

//    Works fine. Discuss and compare.

    public static ListNode reverse(ListNode head, int p, int q) {

//        1. Start with a for loop to reach p-1, p-1 will be the last node after which the sub-list will be reversed
        ListNode currentNode = head;
        for (int i = 1; i < p - 1; i++) {
            currentNode = currentNode.next;
        }
        ListNode firstNode = currentNode;
        ListNode previousNode = currentNode;
        currentNode = currentNode.next;
        ListNode lastNodeOfSubList = currentNode;
        ListNode nextNode = null;
        for (int i = 0; i < q - p + 1; i++) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        firstNode.next = previousNode;
        lastNodeOfSubList.next = nextNode;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

//        Reverse a sub-list between p and q
        ListNode result = ReverseASubListInSinglePass.reverse(head, 3, 6);

//        Alternate Question : Reverse the first ‘k’ elements of a given LinkedList
//        Doesn't work correctly when p=1 ie first node also has ot be reversed
//        ListNode result = ReverseASubListInSinglePass.reverse(head, 1, 3);

        System.out.print("Nodes of the reversed sublist are ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

}
