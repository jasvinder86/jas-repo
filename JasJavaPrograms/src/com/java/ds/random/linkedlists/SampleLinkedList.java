package com.java.ds.linkedlists;

public class SampleLinkedList {

	Node head;

	public void displayListNodes(Node head) {
		Node current;
		current = head;
		if (head == null) {
			System.out.println("list is empty");
		} else {
			System.out.print(current.prev + " <> ");
			while (current != null) {
				System.out.print(current.data + " <> ");
				current = current.next;
			}
		}
		// System.out.print("null");
		System.out.println(current);
	}

	public void appendNodeAtEnd(int data) {
		Node newNode = new Node(data);
		Node current = this.head;

		if (head == null) {
			System.out.println("since list is empty, new node becomes the head");
			head = newNode;
		} else
			while (current.next != null) {
				// traverse the entire list till you hit the tail (current node == null)
				current = current.next;
			}
		// loop breaks when current.next = null which means that current is the last
		// non-null node; insert the new node after this current node
		System.out.println("current node after the entire list has been traversed is : " + current.data);

		current.next = newNode;

	}

	public static class Node {
		int data;
		Node next;
		Node prev;

		public Node(int data) {
			this.data = data;
			next = null;
			prev = null;
		}

	}

	public static void main(String[] args) {

		SampleLinkedList linkedList = new SampleLinkedList();
		linkedList.head = new Node(10);
		Node node2 = new Node(20);
		Node node3 = new Node(30);

		linkedList.head.next = node2;
		node2.next = node3;

		node2.prev = linkedList.head;
		node3.prev = node2;

		// System.out.println(head.data + " :: " + head.next.data);
		// System.out.println(node2.data + " :: " + node2.next.data);
		// System.out.println(node3.data + " :: " + node3.next.data);

		// linkedList.addNode(node1);

		linkedList.displayListNodes(linkedList.head);
		linkedList.appendNodeAtEnd(50);
		linkedList.displayListNodes(linkedList.head);

	}

}
