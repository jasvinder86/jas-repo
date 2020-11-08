package com.java.ds.linkedlists;

public class ReturnKthElementFromEnd {

	public Node head;

	public class Node {
		int data;
		Node nextNode;

		public Node(int data) {
			this.data = data;
			this.nextNode = null;
		}

	}

	public void displayList(Node node) {

		if (node == null)
			System.out.println("list is empty");

		else {
			Node pointer = node;

			while (pointer != null) {
				System.out.print(pointer.data + " >> ");
				pointer = pointer.nextNode;
			}
			System.out.print(pointer);
		}
	}

	public int getKthNode(int k) {
		Node slowPointer = null, fastPointer = null;

		// move the fastPointer to K steps from beginning. Then move both the pointers
		// together by same speed. When the fast one reaches null, slow one would be at
		// Kth from the end

		slowPointer = fastPointer = head;
		for (int i = 0; i < k; i++) {
			fastPointer = fastPointer.nextNode;
		}

		while (fastPointer != null) {
			fastPointer = fastPointer.nextNode;
			slowPointer = slowPointer.nextNode;
		}

		return slowPointer.data;
	}

	public static void main(String[] args) {
		ReturnKthElementFromEnd object = new ReturnKthElementFromEnd();
		object.head = object.new Node(10);
		Node n2 = object.new Node(20);
		Node n3 = object.new Node(30);
		Node n4 = object.new Node(40);
		Node n5 = object.new Node(50);
		Node n6 = object.new Node(60);

		object.head.nextNode = n2;
		n2.nextNode = n3;
		n3.nextNode = n4;
		n4.nextNode = n5;
		n5.nextNode = n6;

		object.displayList(object.head);

		int k = 1;

		System.out.println("\nData at " + k + "th node from the end is " + object.getKthNode(k));

	}
}
