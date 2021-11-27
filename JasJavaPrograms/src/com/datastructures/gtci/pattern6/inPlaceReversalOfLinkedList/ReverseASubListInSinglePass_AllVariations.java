package com.datastructures.gtci.pattern6.inPlaceReversalOfLinkedList;

public class ReverseASubListInSinglePass_AllVariations {

//    All variations seem to be working fine
    /*
    Q:1 p = 2, q = 4
    Input = 1 -> 2 -> 3 -> 4 -> 5
    Output = 1 -> 4 -> 3 -> 2 -> 5

    Input = 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
    Output = 1 -> 2 -> 6 -> 5 -> 4 -> 3 -> 7

    p = 1, q = 5
    Input = 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
    Output = 5 -> 4 -> 3 -> 2 -> 1 -> 6 -> 7

    p = 3, q = 7
    Input = 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
    Output = 1 -> 2 -> 7 -> 6 -> 5 -> 4 -> 3
    */


    public static ListNode reverse(ListNode head, int p, int q) {

//        1. Start with a for loop to reach p-1, p-1 will be the last node after which the sub-list will be reversed
        ListNode currentNode = head, previousNode = null, nextNode = null;
        for (int i = 0; i < p - 1; i++) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

//        2. Make a note of the p-1 th node. If p=1 ie first node, p-1th will remain null.
//        Else p-1 will point to the node prior to the start of the sublist which has to be reversed.
        ListNode lastNodeBeforeP = previousNode;
        ListNode firstNodeOfOriginalSubList = currentNode;

//        3. Start the sublist reversal here and go till you reach q. In other words, the for loop runs q-p+1 times.
        for (int i = 0; i < q - p + 1; i++) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

//        4. Now previousNode be the first node of the reversed sub list referenced by firstNodeOfReversedSubList
        ListNode firstNodeOfReversedSubList = previousNode;
        firstNodeOfOriginalSubList.next = nextNode; // first node of original sub list will be the last node of the reversed list.
        // Its next will be the node after q ie the node after the sublist

//        5. If original node previous to the pth node was null => reversed sub-list's first node will the new head of the final list.
//        Else, the previous' next will the reversed sub-list's first node.
        if (lastNodeBeforeP != null) {
            lastNodeBeforeP.next = firstNodeOfReversedSubList;
        } else
            head = firstNodeOfReversedSubList;

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

//        Reverse a sub-list between p and q where p=1 -- WORKS
        ListNode result = ReverseASubListInSinglePass_AllVariations.reverse(head, 1, 5);

        System.out.print("Nodes of the reversed sublist are ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);

        //        Reverse a sub-list between p and q where p= any node and q=last node -- WORKS
        ListNode result1 = ReverseASubListInSinglePass_AllVariations.reverse(head1, 3, 7);

        System.out.print("\nNodes of the reversed sublist are ");
        while (result1 != null) {
            System.out.print(result1.value + " ");
            result1 = result1.next;
        }

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = new ListNode(6);
        head2.next.next.next.next.next.next = new ListNode(7);

        //        Reverse a sub-list between p and q where p= 1 and q=last node -- WORKS
        ListNode result2 = ReverseASubListInSinglePass_AllVariations.reverse(head2, 1, 7);

        System.out.print("\nNodes of the reversed sublist are ");
        while (result2 != null) {
            System.out.print(result2.value + " ");
            result2 = result2.next;
        }
    }

}
