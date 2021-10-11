package com.datastructures.ae.linkedlist;

public class Q1_LinkedListConstruction {

    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            // Write your code here.
            Node currentNode = head;

            while (currentNode != null && currentNode != node) {
                currentNode = currentNode.next;
            }
            if (currentNode != null && currentNode != head) {
//                A  Node has been found in the list which should be made the head
                currentNode.prev.next = currentNode.next;
                currentNode.next.prev = currentNode.prev;
                currentNode.next = head;
                head.prev = currentNode;
                head = currentNode;
            } else if (currentNode == null) {
//                A new node has been given which should be made the new head
                node.next = head;
//                head.prev = node;
                head = node;
            }
        }

        public void setTail(Node node) {
            // Write your code here.

            Node currentNode = tail;

            while (currentNode != null && currentNode != node) {
                currentNode = currentNode.prev;
            }
            if (currentNode != null) {
//                A  Node has been found in the list which should be made the tail
                currentNode.prev.next = currentNode.next;
                currentNode.next.prev = currentNode.prev;
                currentNode.prev = tail;
                tail.next = currentNode;
                tail = currentNode;
            } else {
//                A new node has been given which should be made the new tail
                node.prev = tail;
                tail.next = node;
                tail = node;
            }
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            // Write your code here.
            Node currentNode = head;

            while (currentNode.next != node) {
                currentNode = currentNode.next;
            }
            currentNode.next.prev = nodeToInsert;
            nodeToInsert.next = currentNode.next;
            currentNode.next = nodeToInsert;
            nodeToInsert.prev = currentNode;
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            // Write your code here.
            Node currentNode = head;

            while (currentNode != node) {
                currentNode = currentNode.next;
            }
            currentNode.next.prev = nodeToInsert;
            nodeToInsert.next = currentNode.next;
            currentNode.next = nodeToInsert;
            nodeToInsert.prev = currentNode;
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            // Write your code here.
            Node currentNode = head;

            if (position == 1) {
                nodeToInsert.next = head;
                head.prev = nodeToInsert;
                head = nodeToInsert;
            }

            while (position > 1) {
                currentNode = currentNode.next;
                position--;
            }
            currentNode.prev.next = nodeToInsert;
            nodeToInsert.prev = currentNode.prev;

            nodeToInsert.next = currentNode;
            currentNode.prev = nodeToInsert;

        }

        public void removeNodesWithValue(int value) {
            // Write your code here.
            Node currentNode = head;
            while (currentNode.value == value) {
                currentNode = currentNode.next;
            }
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
        }

        public void remove(Node node) {
            // Write your code here.
            Node currentNode = head;
            while (currentNode != node) {
                currentNode = currentNode.next;
            }
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
        }

        public boolean containsNodeWithValue(int value) {
            // Write your code here.
            Node currentNode = head;
            while (currentNode.value != value && currentNode != null) {
                currentNode = currentNode.next;
            }
            if (currentNode == null) {
                return false;
            }
            return true;
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
