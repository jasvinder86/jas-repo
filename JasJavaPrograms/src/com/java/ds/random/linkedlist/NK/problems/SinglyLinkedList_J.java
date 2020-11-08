package com.java.ds.random.linkedlist.NK.problems;

public class SinglyLinkedList_J {

	Node head;

	public static class Node {
		int data;
		Node node;

		public Node(int data) {
			this.data = data;
			node = null;
		}
	}

	public void displayData(Node node) {
		Node currentNode = null;

		currentNode = node;

		while (currentNode != null) {
			System.out.print(currentNode.data + " >> ");
			currentNode = currentNode.node;
		}
		System.out.print(currentNode);
		System.out.println("");

	}

	// ask Pulkit about my implementation v/s GFG's
	public void insertNodeAtTheEnd(int data) {
		System.out.println("insertNodeAtTheEnd");
		Node newNode = new Node(data);

		if (head == null) {

			// this step is not reqd since head is anyway null and new node's next is also
			// null as per the constructor
			// newNode.nextNode = head;
			head = newNode;
		}
		// 1 2 3 null
		else {
			Node pointerNode = null;
			pointerNode = head.node;
			System.out.println("head.data : " + head.data + " >> ");
			while (pointerNode.node != null) {
				System.out.print(pointerNode.data + " > ");
				pointerNode = pointerNode.node;
			}
			System.out.println();
			System.out.println("pointerNode.data (tail) : " + pointerNode.data + " >> ");
			System.out.println("we have reached the tail node now");
			// insert new node b/w tail(i.e. null) and the second but null node
			pointerNode.node = newNode;

			// pointerNode = newNode;
		}

	}

	public void findNthNodeFromEnd(int n, Node node) {
		Node head = node;
		int length = findLengthOfList(head);
		Node pointerNode = null;
		pointerNode = head;
		while (length - n > 0) {
			pointerNode = pointerNode.node;
			length--;
		}
		System.out.println("l-n has been reached");
		System.out.println("data is " + pointerNode.data);

	}

	public int findLengthOfList(Node head) {
		Node pointerNode = null;
		pointerNode = head;
		int length = 0;

		while (pointerNode != null) {
			length++;
			pointerNode = pointerNode.node;
		}
		System.out.println("length is " + length);
		return length;
	}

	public static void main(String[] args) {
		SinglyLinkedList_J operations = new SinglyLinkedList_J();

		// see why this is failing with NPE
		// operations.insertNodeAtTheEnd(100);
		// operations.insertNodeAtTheEnd(90);
		// operations.insertNodeAtTheEnd(80);
		// operations.displayData(operations.head);

		Node head = new Node(1);
		Node secondNode = new Node(2);
		Node thirdNode = new Node(3);
		Node fourthNode = new Node(4);

		head.node = secondNode;
		secondNode.node = thirdNode;
		thirdNode.node = fourthNode;
		// fourthNode.next = null;

		operations.findLengthOfList(head);
		operations.displayData(head);
		
		operations.findNthNodeFromEnd(3, head);
	}

}
