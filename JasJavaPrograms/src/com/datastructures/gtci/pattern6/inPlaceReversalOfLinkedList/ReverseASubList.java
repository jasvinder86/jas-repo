package com.datastructures.gtci.pattern6.inPlaceReversalOfLinkedList;

public class ReverseASubList {

    /*
    Q:1 p = 2, q = 4
    Input = 1 -> 2 -> 3 -> 4 -> 5
    Output = 1 -> 4 -> 3 -> 2 -> 5
    */
    // Discuss the comparison between my solution and their solution.


    /*
    Q:2 p = 1, q = 3
    Input = 1 -> 2 -> 3 -> 4 ->  5
    Output = 3 -> 2 -> 1 -> 4 ->  5
    */
    // Q:1 works fine but the Q:2 doesn't work with the same logic as implemented below.


    public static ListNode reverse(ListNode head, int p, int q) {

        ListNode initialNode = null;
        ListNode finalNode;

//        Traverse till the qth node to get both (p-1)th and (q+1)th node
        ListNode currentNode = head;
        while (currentNode.value != q) {
            if (currentNode.next.value == p) {
//                This will be the (p-1)th node
                initialNode = currentNode;
            }
            currentNode = currentNode.next;
        }

//       This will be the (q+1)th node
        finalNode = currentNode.next;

//        Now again start from head and traverse till the pth Node
        currentNode = head;
        while (currentNode.value != p) {
            currentNode = currentNode.next;
        }

//        Assign the currentNode to a new variable aka newHead
        ListNode newHead = currentNode;
        while (newHead.value != q) {
            newHead = newHead.next;
            currentNode.next = finalNode;
            finalNode = currentNode;
            currentNode = newHead;
        }
        newHead.next = finalNode;
        initialNode.next = newHead;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

//        Reverse a sub-list between p and q
//        This one works fine but the alternate question doesn't work with the same logic as implemented above.
        ListNode result = ReverseASubList.reverse(head, 2, 4);

//        Alternate Question : Reverse the first ‘k’ elements of a given LinkedList
//        ListNode result = ReverseASubList.reverse(head, 1, 3);

        System.out.print("Nodes of the reversed sublist are ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

}
