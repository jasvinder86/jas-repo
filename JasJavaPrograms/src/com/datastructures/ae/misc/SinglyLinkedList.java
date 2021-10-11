package com.datastructures.ae.misc;

public class SinglyLinkedList {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

//    Node head;

    private static Node head;

    public static void appendNode(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = new Node(data);
        }
    }

    public static void prependNode(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node newHeadNode = new Node(data);
            newHeadNode.next = head;
            head = newHeadNode;
        }
    }

    public static void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currentNode = head;
        System.out.println("List is");

        while (currentNode != null) {
            System.out.print(currentNode.data + " --> ");
            currentNode = currentNode.next;
        }
        System.out.println(currentNode);
    }

    public static void getLengthOfTheListWhenHeadIsGiven(Node head) {
        int length = 0;
        if (head == null)
//            return length;
            System.out.println("length is " + length);

        Node currentNode = head;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }
//        return length;
        System.out.println("length is " + length);

    }


    public static void main(String[] args) {
        SinglyLinkedList.appendNode(5);
        SinglyLinkedList.appendNode(6);
        SinglyLinkedList.prependNode(7);
        SinglyLinkedList.printList();
        SinglyLinkedList.getLengthOfTheListWhenHeadIsGiven(head);
    }


}