package com.java.ds.random.linkedlists;

public class PartitionLL {

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

	public static Node partition(Node node, int pivot) {
		Node head = null;
		Node slowNode = null, fastNode = null;
		slowNode = node;
		fastNode = node.next;
		System.out.println("Data of slowNode is " + slowNode.data);
		System.out.println("Data of fastNode is " + fastNode.data);

		if (slowNode.data > pivot) {
			if (!(fastNode.data > pivot)) {
				slowNode.next = fastNode.next;
				fastNode.next = slowNode;
				head = fastNode;
			}
		}
		return head;
	}

	public static Node partition2(Node node, int pivot) {
		Node head = null, tail = null;
		head = node; tail = node;
		
		Node pointer = node;
		
		while(pointer != null) {
			Node nextNode = pointer.next;
			if(pointer.data >= pivot) {
				tail.next = pointer;
				tail = pointer;
				tail.next = null;
			}
			else {
				head.next = pointer;
				head = pointer;
			}
			pointer = nextNode;
		}	
		
		return head;
	}
	
	public static Node partition3(Node node, int pivot) {
		Node head = null, tail = null;
		head = node; tail = node;
		
		Node pointer = node;
		
		while(pointer != null) {
			Node nextNode = pointer.next;
			if(pointer.data < pivot) {
//				head.next = pointer;
//				head = pointer;
				
				pointer = head.next;
				pointer = head;
			}
			else {
				tail.next = pointer;
				tail = pointer;
				tail.next = null;
			}
			pointer = nextNode;
		}	
		
		return head;
	}

	public static void main(String[] args) {
		Node head = new Node(4);
		Node n2 = new Node(1);
		Node n3 = new Node(2);
		Node n4 = new Node(3);

		head.next = n2;
		n2.next = n3;
		n3.next = n4;

		display(head);
		
//		head = partition(head, 2);
//		PartitionLL.display(head);
		
		head = partition3(head, 2);
		display(head);

	}
}
