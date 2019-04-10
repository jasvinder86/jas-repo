package linkedlist;

public class ReverseLinkedListByIteration {

	public static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void display(Node node) {
		Node current = node;
		System.out.println("list is");
		while (current != null) {
			System.out.print(current.data + " > ");
			current = current.next;
		}
		System.out.print(current);
	}

	public static Node reverseTheList(Node node) {
		Node head = node;
		Node previous = null;
		Node current = node;
		Node currentNext = current.next;

		while (current.next != null) {
			current.next = previous;
			previous = current;
			current = currentNext;
			currentNext = current.next;
			head = current;
		}
		current.next=previous;
		head = current;
		return head;
	}

	public static void main(String[] args) {
		Node head = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);

		head.next = n2;
		n2.next = n3;
		n3.next = n4;

		display(head);
		head = reverseTheList(head);
		display(head);

	}

}
