package com.datastructures.ae.misc;

public class DoublyLinkedList {

    static class Node {
        int data;
        Node next;
        Node previous;

        Node(int data) {
            this.data = data;
        }
    }

    private static Node head;
    private static Node tail;
    private int length;

    DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }


    public static boolean isListEmpty() {
        return head == null;
    }

    public static void appendNode(int data) {
        if (isListEmpty()) {
//            List is empty and this node becomes the head
            head = new Node(data);
            tail = head;
        } else {
            Node currentNode = new Node(data);
            tail = currentNode;
        }
    }

    public static void printListInForwardDirection() {
        if (!isListEmpty()) {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " > ");
                temp = temp.next;
            }
        }

        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList.printListInForwardDirection();
        DoublyLinkedList.appendNode(1);
        DoublyLinkedList.appendNode(2);
        DoublyLinkedList.printListInForwardDirection();
    }

}
