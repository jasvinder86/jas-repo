package com.datastructures.gtci.pattern3.fastSlowPointers;

/* Palindrome LinkedList
 * Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.
 * */

class ListNode1 {
    int value = 0;
    ListNode1 next;

    ListNode1(int value) {
        this.value = value;
    }
}

public class PalindromicLinkedList {

    public static boolean isPalindrome(ListNode1 head) {

//        1. Find middle node of the list
        ListNode1 slowPointer = head, fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
//        2. Slow pointer would have reached the middle node by now

//        3. reverse the rest of the list starting from the middle node which is the slow pointer currently
        ListNode1 head2 = reverseTheList(slowPointer);

//        4. Preserve the slow pointer here
        ListNode1 listToRevert = head2;

//        5. Start comparing the head of the original list with the head of the reversed list (second half)
        while (head != null && head2 != null) {
            if (head.value != head2.value)
//                We can't return from here since the reversed list has to be reverted to its original state
                break;
            head = head.next;
            head2 = head2.next;
        }
//        6. Again before returning, change the list to its original form
        reverseTheList(listToRevert);

//        7. If the list is of odd length, both the heads will be null. Else head will point to head2 and head2 will be null.
        if (head == null || head2 == null)
            return true;

        return false;
    }

    private static ListNode1 reverseTheList(ListNode1 head) {
        ListNode1 previousNode = null, nextNode;
        while (head != null) {
            nextNode = head.next;
            head.next = previousNode;
            previousNode = head;
            head = nextNode;
        }
        return previousNode;
    }


    public static void main(String[] args) {
        ListNode1 head = new ListNode1(2);
        head.next = new ListNode1(4);
        head.next.next = new ListNode1(6);
        head.next.next.next = new ListNode1(4);
        head.next.next.next.next = new ListNode1(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next = new ListNode1(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

//        When list is even
        head = new ListNode1(2);
        head.next = new ListNode1(4);
        head.next.next = new ListNode1(6);
        head.next.next.next = new ListNode1(6);
        head.next.next.next.next = new ListNode1(4);
        head.next.next.next.next.next = new ListNode1(2);

        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next.next = new ListNode1(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }

}
