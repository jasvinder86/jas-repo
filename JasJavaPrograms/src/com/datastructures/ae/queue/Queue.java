package com.datastructures.ae.queue;

import java.util.NoSuchElementException;

public class Queue {
    //    Needs a front and rear node for tracking.
    //    Insertion at rear and deletion at front ie FIFO
    Node front;
    Node rear;

    //    length of the queue
    int length;

    Queue() {
        this.front = null;
        this.rear = null;
        this.length = 0;

    }

    //    Queue will be implemented as a singly linked list but tracked with two pointers
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }


    public void enqueue(int data) {
        Node nodeToInsert = new Node(data);
        if (front == null) {
//            Special case when Queue is empty => insert at the front
            front = nodeToInsert;
        } else {
//            Insert new nodes from the rear end
            rear.next = nodeToInsert;
        }
        rear = nodeToInsert;
        length++;
    }

    public int dequeue() {
//        Remove the nodes from the start i.e. the front node
//        Special case when Queue is empty
        if (length == 0) {
            throw new NoSuchElementException("Queue got empty");
        }

        int nodeToRemove = front.data;
        front = front.next;

//        if front now points to null, make the rear node as well point to null else it won't be GCed
        if (front == null) {
            rear = null;
        }
        length--;
        return nodeToRemove;
    }

    public void printAllElementsOfQueue() {

        if (length == 0)
            return;
//        Initialize a pointer node to front to traverse the entire queue
        Node pointerNode = front;
        while (pointerNode != null) {
            System.out.print(pointerNode.data + "-->");
            pointerNode = pointerNode.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        System.out.println("length : " + queue.length);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.printAllElementsOfQueue();
        System.out.println("length : " + queue.length);
        System.out.println(queue.dequeue());
        queue.printAllElementsOfQueue();
        System.out.println("length : " + queue.length);
        System.out.println(queue.dequeue());
        queue.printAllElementsOfQueue();
        System.out.println("length : " + queue.length);
        System.out.println(queue.dequeue());
        queue.printAllElementsOfQueue();
        System.out.println("length : " + queue.length);
        System.out.println(queue.dequeue());
        queue.printAllElementsOfQueue();
        System.out.println("length : " + queue.length);
    }

}
