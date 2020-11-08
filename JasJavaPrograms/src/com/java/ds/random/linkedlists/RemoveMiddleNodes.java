package com.java.ds.random.linkedlists;

public class RemoveMiddleNodes {

//	public static Node head;
	public Node head1 = null;

	public static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void display(Node node) {
		Node pointer = node;

		System.out.println("list is ");
		while (pointer != null) {
			System.out.print(pointer.data + " >> ");
			pointer = pointer.next;
		}
		System.out.print(pointer);
		System.out.println("");
	}

//	public void removeMiddles(Node head) {
//		Node doublePointer = head;
//		Node singlePointer = head;
//
//		while (doublePointer.next != null) {
//			this.addNodeToNewList(singlePointer.data);
//			singlePointer = singlePointer.next;
//			doublePointer = doublePointer.next.next;
//		}
//
//		singlePointer = singlePointer.next;
//		while (singlePointer != null) {
//			this.addNodeToNewList(singlePointer.data);
//			singlePointer = singlePointer.next;
//		}
//	}
	
	public static Node removeMiddles(Node head) {
		Node doublePointer = head;
		Node singlePointer = head;
		Node deletePointer = null;

		while (doublePointer.next != null && doublePointer.next.next != null ) {
//		while (doublePointer.next != null && doublePointer != null ) {
			deletePointer = singlePointer;
			singlePointer = singlePointer.next;
			doublePointer = doublePointer.next.next;
		}

		deletePointer.next = singlePointer.next;
//		singlePointer= singlePointer.next;
		
//		singlePointer= deletePointer.next;
//		while (singlePointer != null) {
////			this.addNodeToNewList(singlePointer.data);
//			singlePointer = singlePointer.next;
//		}
		
		display(head);
		return head;
	}

	public void addNodeToNewList(int data) {
		Node currentNewNode = new Node(data);
		if (head1 == null) {
			head1 = currentNewNode;
		} else {
			Node pointerNode = head1;
			while (pointerNode.next != null) {
				pointerNode = pointerNode.next;
			}
			pointerNode = currentNewNode;
		}

	}

	public static void main(String[] args) {
//		RemoveMiddleNodes object = new RemoveMiddleNodes();
		Node head = new Node(10);
//		Node head1;
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
//		Node n5 = new Node(50);

		head.next = n2;
		n2.next = n3;
		n3.next = n4;
//		n4.next = n5;
		
//		object.display(head);
		display(head);
		
//		head = object.removeMiddles(head);
		head = removeMiddles(head);
//		object.display(head);
		display(head);
	}
}
