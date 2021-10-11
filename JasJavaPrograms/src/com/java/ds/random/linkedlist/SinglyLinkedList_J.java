package com.java.ds.random.linkedlist;

public class SinglyLinkedList_J {

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

	}

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		
		node1.node = node2;
		node2.node = node3;

		SinglyLinkedList_J singlyLinkedList_J = new SinglyLinkedList_J();
		singlyLinkedList_J.displayData(node1);

	}

}
