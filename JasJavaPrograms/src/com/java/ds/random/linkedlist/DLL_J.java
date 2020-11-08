package linkedlist;

public class DLL_J {

	Node head;

	public static class Node {
		int data;
		Node nextNode;
		Node prevNode;

		public Node(int data) {
			this.data = data;
			this.nextNode = null;
			this.prevNode = null;
		}

	}

	// Pushes a new node before the head and becomes the head node itself
	public void pushNewNode(int data) {
		Node newNode = new Node(data);
		newNode.prevNode = null;
		newNode.nextNode = head;

		if (head != null)
			head.prevNode = newNode;

		head = newNode;
	}

	public void insertAfterGivenNode(int data, Node givenNode) {

		if (givenNode == null) {
			System.out.println("given node should not be null");
			return;
		}

		Node newNode = new Node(data);

		Node tempNode = givenNode;

		// wrong o/p code
		// tempNode.nextNode = newNode; // done
		//
		// newNode.prevNode = tempNode; // done
		//
		// newNode.nextNode = tempNode.nextNode; // done
		//
		// if (newNode.nextNode != null) // why this if loop?? suggested by GFG
		// tempNode.nextNode.prevNode = newNode; // I wrote only this line

		// new code
		
		System.out.println("start insertAfterGivenNode");
		newNode.prevNode = givenNode;
		newNode.nextNode = givenNode.nextNode;

		if (givenNode.nextNode != null)
			givenNode.nextNode.prevNode = newNode;

		givenNode.nextNode = newNode;

	}
	
	public void appendNewNode(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			return;
		}

		Node pointerNode = head;
		while (pointerNode.nextNode != null) {
			pointerNode = pointerNode.nextNode;
		}
		pointerNode.nextNode = newNode;
		newNode.prevNode = pointerNode;

	}

	public void displayList() {
		Node pointerNode;
		pointerNode = head;
		System.out.println("List is ");

		System.out.print(pointerNode.prevNode + " > ");
		while (pointerNode != null) {
			System.out.print(pointerNode.data + " > ");
			pointerNode = pointerNode.nextNode;
		}
		System.out.print(pointerNode);
		System.out.println("");
	}

	public static void main(String[] args) {
		DLL_J doublyLinkedList = new DLL_J();
		doublyLinkedList.appendNewNode(10);
		doublyLinkedList.appendNewNode(20);
		doublyLinkedList.appendNewNode(30);

		doublyLinkedList.displayList();

		doublyLinkedList.insertAfterGivenNode(25, doublyLinkedList.head.nextNode);
		doublyLinkedList.displayList();
		
		doublyLinkedList.pushNewNode(5);
		doublyLinkedList.displayList();
		
		
	}
}
