package com.datastructures.gtci.pattern3.fastSlowPointers;

/* Rearrange a LinkedList
 * Given the head of a Singly LinkedList, write a method to modify the LinkedList such that the nodes from the
 * second half of the LinkedList are inserted alternately to the nodes from the first half in reverse order.
 * So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
 * */
public class RearrangeList {

    public static void reorder(ListNode head) {
//        1. Find the middle node
        ListNode slowNode = head, fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
//        2. Now slow node will be at the middle node, mark it
        ListNode middleNode = slowNode;

//        3. Take a new list and put in it all the nodes after the middle node as a reversed linked list.
        ListNode head2 = reverseTheList(middleNode.next);

//        4. Since the second half will be inserted in the main list, its middle will be the last element now.
        middleNode.next = null;

        ListNode originalHead = head;
//        5. Now iterate over the latter half list and insert its nodes in the main list
        while (head2 != null) {

            ListNode headNext = head.next;
            ListNode head2Next = head2.next;

            head.next = head2;
            head2.next = headNext;

            head2 = head2Next;
            head = headNext;
        }
    }

    private static ListNode reverseTheList(ListNode head) {
        ListNode previousNode = null;
        ListNode nextNode;
        while (head != null) {
            nextNode = head.next;
            head.next = previousNode;
            previousNode = head;
            head = nextNode;
        }
        return previousNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        RearrangeList.reorder(head);                            // expected = 2 10 4 8 6, actual = 2 10 4 8 6
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.println();

        head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeList.reorder(head);                            // expected = 2 12 4 10 6 8, actual = 2 12 4 10 6 8
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

}
