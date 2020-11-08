package com.java.ds.linkedlists;

public class AddLinkedLists {

	public static Node newNode = null, newHeadNode = null, currentHeadNode = null;
	public static int carry = 0;
	public static Node pointerNode = null;

	public static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

	}

	public static void display(Node node) {
		Node currentNode = node;
		System.out.println("list is : ");
		while (currentNode != null) {
			System.out.print(currentNode.data + " >> ");
			currentNode = currentNode.next;
		}
		System.out.print(currentNode);
		System.out.println();
	}

	public static void addNodesToFinalList(int data) {
		Node newNode = new Node(data);

		if (newHeadNode == null) {
			newHeadNode = newNode;
		} else {
			// newHeadNode.next = currentHeadNode;
			// currentHeadNode = newNode;
			// while (currentHeadNode != null) {
			// currentHeadNode = currentHeadNode.next;
			// }
			// currentHeadNode = newNode;

			
			pointerNode = newHeadNode;

			while (pointerNode.next != null) {
				pointerNode = pointerNode.next;
			}
			pointerNode.next = newNode;
		}

		// return newHeadNode;
	}

	public static void displayFinalList(Node node) {
		System.out.println("added list is");
		while (newHeadNode != null) {
			System.out.print(newHeadNode.data + " >> ");
			newHeadNode = newHeadNode.next;
		}
		System.out.print(newHeadNode);
	}

	public static void addLists(Node node1, Node node2) {
		int x = 0;
		Node current1 = null, current2 = null;
		current1 = node1;
		current2 = node2;

		while (node1 != null) {

			x = node1.data + node2.data + carry;

			if (x > 9) {
				x = x % 10;
				carry = 1;
			} else
				carry = 0;

			addNodesToFinalList(x);
			node1 = node1.next;
			node2 = node2.next;
		}

	}

	public static void main(String[] args) {
		Node n11 = new Node(9);
		Node n12 = new Node(7);
		Node n13 = new Node(8);
		n11.next = n12;
		n12.next = n13;

		Node n21 = new Node(6);
		Node n22 = new Node(9);
		Node n23 = new Node(5);
		n21.next = n22;
		n22.next = n23;

		display(n11);
		display(n21);

		addLists(n11, n21);

		displayFinalList(newHeadNode);

	}

}
