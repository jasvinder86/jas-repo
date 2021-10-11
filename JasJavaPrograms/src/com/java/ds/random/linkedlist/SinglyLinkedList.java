package com.java.ds.random.linkedlist;

public class SinglyLinkedList {

//	private ListNode head;

	public void display(ListNode head) {
		if (head == null)
			return;
		ListNode current = head;
		
		while (current != null) {
			System.out.print(current.data + " >> ");
			current = current.next;
		}
		System.out.print(current);
		
	}
	
	private static class ListNode {
		private int data;
		private ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		ListNode secondNode = new ListNode(8);
		ListNode thirdNode = new ListNode(1);
		ListNode fourthNode = new ListNode(11);
		
		head.next = secondNode;
		secondNode.next = thirdNode;
		thirdNode.next = fourthNode;
//		fourthNode.next = null;
		
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.display(head);
		
	}

}
