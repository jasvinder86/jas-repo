package com.java.ds.random.linkedlists;

import java.util.HashSet;

public class DeDuplicateAList {

	Node head;

	public static class Node {
		int data;
		Node nextNode;

		public Node(int data) {
			this.data = data;
			this.nextNode = null;
		}
	}

	public void displayList(Node head) {
		Node current = head;

		System.out.println("list is ");
		while (current != null) {
			System.out.print(current.data + " >> ");
			current = current.nextNode;
		}
		System.out.print(current);
	}

	public static void main(String[] args) {
		DeDuplicateAList list = new DeDuplicateAList();
		list.head = new Node(10);

		Node n2 = new Node(5);
		Node n3 = new Node(6);
		Node n4 = new Node(8);
		Node n5 = new Node(7);
		Node n6 = new Node(5);
		Node n7 = new Node(9);

		list.head.nextNode = n2;
		n2.nextNode = n3;
		n3.nextNode = n4;
		n4.nextNode = n5;
		n5.nextNode = n6;
		n6.nextNode = n7;

		list.displayList(list.head);

//		Hashtable<Object, Object> listInMap = new Hashtable<Object, Object>();
		HashSet<Object> listInMap = new HashSet<Object>();
		listInMap.add(list.head.data);
		listInMap.add( n2.data);
		listInMap.add(n3.data);
		listInMap.add(n4.data);
		listInMap.add(n5.data);
		listInMap.add(n6.data);
		listInMap.add(n7.data);

		System.out.println("\nvalues are : " + listInMap);

	}

}
