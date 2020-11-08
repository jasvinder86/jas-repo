package linkedlist;

public class PrintListByRecursion {

	public static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

	}

	public static void print(Node node) {
		if (node == null) {
			System.out.println("");
			return;
		}
		
			print(node.next);
			System.out.print(node.data + " >> ");
	}

	public static void main(String[] args) {
		Node head = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);

		head.next = n2;
		n2.next = n3;
		n3.next = n4;

		print(head);

	}

}
