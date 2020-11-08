package com.java.ds.random.linkedlist;

public class SinglyLinkedList_Operations {

	ListNode head;

	public static class ListNode {
		int data;
		ListNode nextNode;

		public ListNode(int data) {
			this.data = data;
			this.nextNode = null;
		}

	}

	public void displayList(ListNode node) {
		if (node == null)
			System.out.println("list is empty");

		else {
			ListNode currentNode = node;
			while (currentNode != null) {
				System.out.print(currentNode.data + " > ");
				currentNode = currentNode.nextNode;
			}
			System.out.print(currentNode);
		}
		System.out.println("");
	}

	public void insertNodeAtHead(int data) {
		ListNode newHeadNode = new ListNode(data);
		newHeadNode.data = data;
		newHeadNode.nextNode = head;
		head = newHeadNode;
	}
	
	public void insertNodeAtGivenPosition(int position, int data) {
		ListNode newNode = new ListNode(data);
		int p = 0;
		ListNode currentNode = head;

		while (p < position - 1) {
			currentNode = currentNode.nextNode;
			p++;
		}
		System.out.println("insert after " + currentNode + " with data " + currentNode.data);
		newNode.nextNode = currentNode.nextNode;
		currentNode.nextNode = newNode;
	}
	
	public void insertNodeAfterGivenNode(ListNode givenNode, int data) {
		if (givenNode == null) {
			System.out.println("Given node should not be null");
		}
		System.out.println("insert after the given node " + givenNode + " with new node of data " + data);
		ListNode newNode = new ListNode(data);
		newNode.nextNode = givenNode.nextNode;
		givenNode.nextNode = newNode;

	}
	
//	ask Pulkit about my implementation v/s GFG's
	public void insertNodeAtTheEnd(int data) {
		System.out.println("insertNodeAtTheEnd");
		ListNode newNode = new ListNode(data);
		
		if(head == null) {
			
//			this step is not reqd since head is anyway null and new node's next is also null as per the constructor
//			newNode.nextNode = head;
			head = newNode;
		}
//		1 2 3 null
		else {
			ListNode pointerNode = null;
			pointerNode = head.nextNode;
			System.out.println("head.data : " + head.data + " >> ");
			while (pointerNode.nextNode != null) {
				System.out.print(pointerNode.data + " > ");
				pointerNode = pointerNode.nextNode;
			}
			System.out.println();
			System.out.println("pointerNode.data (tail) : " + pointerNode.data + " >> ");
			System.out.println("we have reached the tail node now");
//			insert new node b/w tail(i.e. null) and the second but null node
			pointerNode.nextNode = newNode;
			
//			pointerNode = newNode;
		}

	}

	public static void main(String[] args) {
		SinglyLinkedList_Operations operations = new SinglyLinkedList_Operations();

		// ListNode headNode = new ListNode(10);
		operations.head = new ListNode(10);
		ListNode secondNode = new ListNode(20);
		ListNode thirdNode = new ListNode(30);
		ListNode fourthNode = new ListNode(40);

		operations.head.nextNode = secondNode;
		secondNode.nextNode = thirdNode;
		thirdNode.nextNode = fourthNode;

		operations.displayList(operations.head);
		operations.insertNodeAtHead(50);
		operations.displayList(operations.head);
		
		operations.insertNodeAtGivenPosition(3, 90);
		operations.displayList(operations.head);
		
		operations.insertNodeAfterGivenNode(fourthNode, 25);
		operations.displayList(operations.head);
		
		operations.insertNodeAtTheEnd(100);
		operations.displayList(operations.head);
		
	}

}
